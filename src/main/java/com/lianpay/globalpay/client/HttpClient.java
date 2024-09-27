package com.lianpay.globalpay.client;

import com.lianpay.globalpay.exception.HttpClientException;
import com.lianpay.globalpay.reader.ConnectPropertyReader;
import com.lianpay.globalpay.utils.ISOUtil;
import com.lianpay.globalpay.utils.JacksonUtils;
import com.lianpay.globalpay.utils.LoggerUtil;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpClient {
    private static final Logger LOGGER = Logger.getLogger(HttpClient.class);
    public static final int HTTP_FAIL_CODE_INT = 999;
    public static final String HTTP_FAIL_CODE = "999";
    //表示请求超时
    public static final int HTTP_CONNECT_TIMEOUT_CODE_INT = 888;
    public static final String HTTP_CONNECT_TIMEOUT_CODE = "888";
    //表示响应超时
    public static final int HTTP_SOCKET_TIMEOUT_CODE_INT = 887;
    public static final String HTTP_SOCKET_TIMEOUT_CODE = "887";
    private static final String JSON_TYPE = "application/json";
    private static final String DEFAULT_CHARSET = "UTF-8";
    private PoolingHttpClientConnectionManager cm;
    private RequestConfig requestConfig;
    private int keepaliveTime;

    public void init(ConnectPropertyReader connectPropertyReader) {
        try {
            SSLContext sslContext = SSLContext.getInstance(connectPropertyReader.getProtocol());
            KeyManager[] keyManagers = null;
            TrustManager[] trustManagers = null;
            trustManagers = new TrustManager[]{new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
            }};
            sslContext.init(keyManagers, trustManagers, null);
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE)).build();
            cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            cm.setMaxTotal(connectPropertyReader.getPoolSize());
            cm.setDefaultMaxPerRoute(connectPropertyReader.getMaxPerRoute());
            cm.setValidateAfterInactivity(connectPropertyReader.getValidateConnMs());
            requestConfig = RequestConfig.custom().setConnectTimeout(connectPropertyReader.getConnectionTimeout())
                    .setConnectionRequestTimeout(connectPropertyReader.getConnectionManagerTimeout())
                    .setSocketTimeout(connectPropertyReader.getSoTimeout()).build();
            keepaliveTime = connectPropertyReader.getKeepaliveTime();
        } catch (IllegalArgumentException e) {
            if (cm != null) {
                cm.close();
            }
        } catch (NoSuchAlgorithmException e) {
            if (cm != null) {
                cm.close();
            }
        } catch (KeyManagementException e) {
            if (cm != null) {
                cm.close();
            }
        }
    }

    private CloseableHttpClient getHttpClient(RequestConfig requestConfig) throws Exception{
        final int finalKeepAlive = keepaliveTime;
        ConnectionKeepAliveStrategy kaStrategy = new DefaultConnectionKeepAliveStrategy() {
            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                long keepAlive = super.getKeepAliveDuration(response, context);
                if (keepAlive == -1) {
                    keepAlive = finalKeepAlive;
                }
                return keepAlive;
            }

        };
        if (cm != null) {
            cm.closeExpiredConnections();
        }
        return HttpClients.custom().setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig)
                .setKeepAliveStrategy(kaStrategy)
                .setHostnameVerifier(new AllowAllHostnameVerifier())
                .build();
    }

    private String generateRequestMessage(String url, String requestBody, Map<String, String> headers) {
        return new StringBuilder("request url:[").append(url).append("],\n")
                .append("request json headers:[").append(JacksonUtils.toJsonString(headers)).append("],\n")
                .append("request params/body:[").append(requestBody).append("]").toString();

    }

    public HttpClientResponse postJsonRequestNew(String url, String jsonBody, Map<String, String> headers, Boolean openLog) throws HttpClientException {
        LoggerUtil.info(LOGGER, openLog, generateRequestMessage(url, jsonBody, headers));
        HttpPost post = null;
        try {
            post = new HttpPost(url);
            StringEntity entity = new StringEntity(jsonBody, ContentType.create(JSON_TYPE, DEFAULT_CHARSET));
            post.setEntity(entity);
            // 请求头设置
            if (headers != null && !headers.isEmpty()) {
                Iterator<Map.Entry<String, String>> it = headers.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> en = it.next();
                    post.setHeader(en.getKey(), en.getValue());
                }
            }
            CloseableHttpClient httpClient = getHttpClient(requestConfig);
            CloseableHttpResponse response = httpClient.execute(post);
            return buildCloseableHttpResponse(response, openLog);
        } catch (Exception e) {
            dealHttpClientException(e, openLog);
            throw new HttpClientException(HTTP_FAIL_CODE, e.getMessage());
        } finally {
            if (post != null) {
                post.releaseConnection();
            }
        }
    }

    private void dealHttpClientException(Exception e, boolean openLog) throws HttpClientException {
        LoggerUtil.error(LOGGER, openLog, e.getMessage(), e);
        if(e instanceof java.net.SocketTimeoutException){
            throw new HttpClientException(HTTP_SOCKET_TIMEOUT_CODE, e.getMessage());
        } else if(e instanceof java.net.ConnectException){
            throw new HttpClientException(HTTP_CONNECT_TIMEOUT_CODE, e.getMessage());
        } else if(e instanceof IOException){
            throw new HttpClientException(HTTP_FAIL_CODE, e.getMessage());
        }
    }

    public HttpClientResponse getJsonRequestResultAll(String url, String queryString, Map<String, String> headers, boolean openLog) throws HttpClientException {
        LoggerUtil.info(LOGGER, openLog, generateRequestMessage(url, queryString, headers));
        HttpGet httpGet = null;
        try {
            if (!ISOUtil.isNullOrEmpty(queryString)) {
                if (url.contains("?")) {
                    url = url + "&" + queryString;
                } else {
                    url = url + "?" + queryString;
                }
            }
            httpGet = new HttpGet(url);
            // 请求头设置
            if (headers != null && !headers.isEmpty()) {
                Iterator<Map.Entry<String, String>> it = headers.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> en = it.next();
                    httpGet.setHeader(en.getKey(), en.getValue());
                }
            }
            CloseableHttpClient httpClient = getHttpClient(requestConfig);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            return buildCloseableHttpResponse(response, openLog);
        } catch (Exception e) {
            dealHttpClientException(e, openLog);
            throw new HttpClientException(HTTP_FAIL_CODE, e.getMessage());
        } finally {
            if (httpGet != null) {
                httpGet.releaseConnection();
            }
        }
    }


    private HttpClientResponse buildCloseableHttpResponse(CloseableHttpResponse response, boolean openLog)
            throws ParseException, IOException {
        HttpClientResponse httpClientResponse = new HttpClientResponse();
        int statusCode = response == null ? -1 : response.getStatusLine().getStatusCode();
        Header[] responseHeaders = response.getAllHeaders();
        if(responseHeaders != null){
            for(Header header : responseHeaders){
                httpClientResponse.addHeader(header.getName(), header.getValue());
            }
        }
        httpClientResponse.setStatusCode(statusCode);
        HttpEntity resEntity = response.getEntity();
        httpClientResponse.setData(resEntity == null ? "" : EntityUtils.toString(resEntity));
        LoggerUtil.info(LOGGER, openLog, generateHttpClientResponseMessage(httpClientResponse));
        return httpClientResponse;
    }

    private String generateHttpClientResponseMessage(HttpClientResponse httpClientResponse) {
        return new StringBuilder("response status code:[").append(httpClientResponse.getStatusCode()).append("],\n")
                .append("response headers:[").append(JacksonUtils.toJsonString(httpClientResponse.headerMap)).append("],\n")
                .append("response body:[").append(httpClientResponse.getData()).append("]").toString();
    }

    public static class HttpClientResponse{
        private int statusCode;
        private String message;
        private String data;
        private Map<String, String> headerMap = new HashMap<String, String>();;
        public HttpClientResponse(){
        }
        public HttpClientResponse(int statusCode, String message){
            this.statusCode = statusCode;
            this.message = message;
        }
        public HttpClientResponse(String data){
            this.statusCode = 200;
            this.data = data;
        }
        public boolean isTimeout(){
            return HTTP_SOCKET_TIMEOUT_CODE_INT == statusCode || HTTP_CONNECT_TIMEOUT_CODE_INT == statusCode;
        }
        public boolean isUnavaliableFail(){
            return HTTP_FAIL_CODE_INT == statusCode;
        }
        public int getStatusCode() {
            return statusCode;
        }
        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
        public boolean isSucessFul(){
            return statusCode == 200;
        }
        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data = data;
        }
        public void addHeader(String key, String value){
            this.headerMap.put(key, value);
        }
        public String getHeader(String key){
            return this.headerMap.get(key);
        }
    }

}
