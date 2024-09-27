package com.lianpay.globalpay.client;

import com.lianpay.globalpay.reader.ConnectPropertyReader;

public class DefaultHttpClient extends HttpClient {
    public static DefaultHttpClient httpClientHolder;

    static {
        httpClientHolder = new DefaultHttpClient("/globalpay-connect.properties");
    }

    public DefaultHttpClient(String propertyFilePath) {
        ConnectPropertyReader connectPropertyReader = new ConnectPropertyReader(propertyFilePath);
        init(connectPropertyReader);
    }
}
