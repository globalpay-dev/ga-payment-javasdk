package com.lianpay.globalpay.reader;

import com.lianpay.globalpay.utils.ISOUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ConnectPropertyReader {
    Properties clientProps = new Properties();
    private int connectionTimeout = 6000;
    private int soTimeout = 30000;
    private int connectionManagerTimeout = 3000;
    private int poolSize = 100;
    private int maxPerRoute = 20;
    private int validateConnMs = 2000;
    private int keepaliveTime = 1800000;
    private String protocol = "TLSv1.2";
    public ConnectPropertyReader() {
    }

    public ConnectPropertyReader(String propertyFilePath) {
        URL url = null;
        try {
            url = ConnectPropertyReader.class.getResource(propertyFilePath);
            this.clientProps.load(url.openStream());
            this.init();
        } catch (Exception var12) {
        } finally {
            try {
                url.openStream().close();
            } catch (IOException var11) {
            }
        }
    }

    public void init() {
        setConnectionTimeout(ISOUtil.changeToInt(getProperty("http.connectionTimeout", "6000")));
        setSoTimeout(ISOUtil.changeToInt(getProperty("http.soTimeout", "30000")));
        setConnectionManagerTimeout(ISOUtil.changeToInt(getProperty("http.connectionManagerTimeout", "3000")));
        setPoolSize(ISOUtil.changeToInt(getProperty("http.poolSize", "100")));
        setMaxPerRoute(ISOUtil.changeToInt(getProperty("http.maxPerRoute", "20")));
        setValidateConnMs(ISOUtil.changeToInt(getProperty("http.validateConnMs", "2000")));
        setKeepaliveTime(ISOUtil.changeToInt(getProperty("http.keepaliveTime", "1800000")));
        setProtocol(getProperty("http.protocol", "TLSv1.2"));
    }

    public String getProperty(String key, String defaultValue) {
        String property = this.clientProps.getProperty(key);
        return ISOUtil.isNullOrEmpty(property) ? defaultValue : property;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getSoTimeout() {
        return soTimeout;
    }

    public void setSoTimeout(int soTimeout) {
        this.soTimeout = soTimeout;
    }

    public int getConnectionManagerTimeout() {
        return connectionManagerTimeout;
    }

    public void setConnectionManagerTimeout(int connectionManagerTimeout) {
        this.connectionManagerTimeout = connectionManagerTimeout;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public int getMaxPerRoute() {
        return maxPerRoute;
    }

    public void setMaxPerRoute(int maxPerRoute) {
        this.maxPerRoute = maxPerRoute;
    }

    public int getValidateConnMs() {
        return validateConnMs;
    }

    public void setValidateConnMs(int validateConnMs) {
        this.validateConnMs = validateConnMs;
    }

    public int getKeepaliveTime() {
        return keepaliveTime;
    }

    public void setKeepaliveTime(int keepaliveTime) {
        this.keepaliveTime = keepaliveTime;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
