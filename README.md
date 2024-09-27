# GlobalPay SDK for International Payment

## Maven Dependencies
```
<dependency>
    <groupId>com.lianpay.globalpay</groupId>
    <artifactId>globalpay-sdk</artifactId>
    <version>0.0.5</version>
</dependency>
<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5.2</version>
</dependency>
```


## groovy

```
compile group: 'com.lianpay.globalpay', name:'globalpay-sdk', version:'0.0.5'
compile group: 'org.apache.httpcomponents', name:'httpclient', version:'4.5.2'
```



Modifying Merchant Parameters
Merchant configuration file information modification: merchant ID, LianLian public key, merchant private key, and environment setting.
Refer to globalpay-merchant.properties in pay-v3-sdk-demo-java.zip
```
# ON / OFF
DEBUGGER_FLAG=ON

# (Test mode) ON / OFF
TEST_MODEL=ON

# Merchant ID provided by LianLian
MERCHANT_ID=

# Sub-merchant ID provided by LianLian (leave blank if not applicable)
SUB_MERCHANT_ID=

# See AlgorithmEnum
SIGN_TYPE=RSA

# Configure merchant secret key
# RSA - Merchant private key - created by merchant
# HMAC - HMAC key provided by LianLian
MERCHANT_SIGN_KEY=

# Configure LianLian secret key
# RSA - LianLian public key - provided by LianLian
# HMAC - HMAC key provided by LianLian
LL_SIGN_KEY=
```
