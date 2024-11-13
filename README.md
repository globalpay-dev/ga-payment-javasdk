# GlobalPay SDK for International Payment

## Maven Dependencies
```
<dependency>
    <groupId>com.lianpay.globalpay</groupId>
    <artifactId>globalpay-sdk</artifactId>
    <version>1.0.1</version>
</dependency>
<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5.2</version>
</dependency>
```


## groovy

```
compile group: 'com.lianpay.globalpay', name:'globalpay-sdk', version:'1.0.1'
compile group: 'org.apache.httpcomponents', name:'httpclient', version:'4.5.2'
```



## Modifying Merchant Parameters
Merchant configuration file information modification: merchant ID, LianLian public key, merchant private key, and environment setting.
Refer to globalpay-merchant.properties in pay-v3-sdk-demo-java.zip
```properties
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

# ON / OFF
HK_NET_MODEL=OFF
```


## SDK Usage Example Code
LianLianpay SDK integration instructions: The SDK has encapsulated the signature and verification logic. When using the SDK, passing in the merchant public key and other content can directly perform signature and verification automatically through the SDK. Signature method: For details on signature and verification, see https://doc.lianlianpay.com/pay-guide/dev-ready/rule.

### Payment Creation Example
```java
public class PaymentsTest {
    private final MerchantPropertyReader merchant = new MerchantPropertyReader("/globalpay-merchant.properties");
    private final PaymentsService payService = new PaymentsService();

    public void testPaySuccess() {
        // For detailed information on the payment creation interface, see: [https://doc.lianlianpay.com/doc-api/open-api/pay-order](https://doc.lianlianpay.com/doc-api/open-api/pay-order)
        PaymentsRequest payRequest = buildCheckoutPagePayRequest();
        ApiResult<PaymentsResponse> s = payService.sendPaymentRequest(payRequest, merchant);
    }
}
```
Note: For CheckoutPage mode, see the CheckoutPagePaymentsTest test class in the code demo package. For IFrame mode, see the IFramePaymentsTest test class. For Direct Api mode, see the DirectApiPaymentsTest test class.

### Refund Example
```java
public class RefundTest {
    private final MerchantPropertyReader merchant = new MerchantPropertyReader("/globalpay-merchant.properties");
    private final RefundService refundService = new RefundService();

    public void testRefund() {
        // For detailed information on the refund interface, see: [https://doc.lianlianpay.com/doc-api/open-api/pay-result](https://doc.lianlianpay.com/doc-api/open-api/pay-result)
        RefundRequest request = buildRefundRequest();
        // Original transaction order number (required)
        request.setOriginalTransactionId("");
        ApiResult<RefundResponse> refundResponseApiResult = refundService.sendRefundRequest(request, merchant);
    }
}
```

### Payment Result Query Example
```java
public class PaymentsQueryTest {
    private final MerchantPropertyReader merchant = new MerchantPropertyReader("/globalpay-merchant.properties");
    private final PaymentsQueryService paymentsQueryService = new PaymentsQueryService();

    public void testPaymentsQuery() {
        // For detailed information on the payment query interface, see: [https://doc.lianlianpay.com/doc-api/open-api/pay-result](https://doc.lianlianpay.com/doc-api/open-api/pay-result)
        String merchantTransactionId = "";
        ApiResult<PaymentsResponse> payResponseApiResult = paymentsQueryService.sendPaymentQueryRequest(merchantTransactionId, merchant);
    }
}
```

### Refund Result Query Example
```java
public class RefundQueryTest {
    private final MerchantPropertyReader merchant = new MerchantPropertyReader("/globalpay-merchant.properties");
    private final RefundQueryService refundQueryService = new RefundQueryService();

    public void testRefundQuery() {
        // For detailed information on the refund query interface, see: [https://doc.lianlianpay.com/doc-api/open-api/refund-result](https://doc.lianlianpay.com/doc-api/open-api/refund-result)
        String merchantTransactionId = "";
        ApiResult<RefundResponse> refundResponseApiResult = refundQueryService.sendRefundQueryRequest(merchantTransactionId, merchant);
    }
}
```

### Payment Cancellation Example
```java
public class PaymentsCancelTest {
    private final MerchantPropertyReader merchant = new MerchantPropertyReader("/globalpay-merchant.properties");
    private final PaymentsCancelService paymentsCancelService = new PaymentsCancelService();

    public void testPaymentsCancel() {
        // For detailed information on the payment cancellation interface, see: [https://doc.lianlianpay.com/doc-api/open-api/pay-cancel](https://doc.lianlianpay.com/doc-api/open-api/pay-cancel)
        String merchantTransactionId = "";
        ApiResult<CancelPayResponse> cancelPayResponseApiResult = paymentsCancelService.sendPaymentCancelRequest(merchantTransactionId, merchant);
    }
}
```

### Logistics Upload Example
```java
public class ShipmentsUploadTest {
    private final MerchantPropertyReader merchant = new MerchantPropertyReader("/globalpay-merchant.properties");
    private final ShipmentsService shipmentsService = new ShipmentsService();

    public void testShipmentsUpload() {
        // For detailed information on the logistics upload interface, see: [https://doc.lianlianpay.com/doc-api/open-api/logistics](https://doc.lianlianpay.com/doc-api/open-api/logistics)
        ShipmentRequest shipmentRequest = buildShipmentRequest();
        ApiResult<?> apiResult = shipmentsService.sendShipmentsRequest(shipmentRequest, merchant);
    }
}
```

### Getting IFrame Payment Token Example
```java
public class IFrameToken {
    private final MerchantPropertyReader merchant = new MerchantPropertyReader("/globalpay-merchant.properties");
    private final IFrameTokenService iFrameTokenService = new IFrameTokenService();

    public void testGetIframeToken() {
        // For details on getting the IFrame payment token, see: [https://doc.lianlianpay.com/doc-api/open-api/get-token](https://doc.lianlianpay.com/doc-api/open-api/get-token)
        ApiResult<String> iFrameTokenRes = iFrameTokenService.sendIFrameTokenRequest(merchant);
    }
}
```

### Payment Result Notification Example
```java
public class PaymentsNotifyTest {
    private final MerchantPropertyReader merchant = new MerchantPropertyReader("/globalpay-merchant.properties");
    private final PaymentNotifyService paymentNotifyService = new PaymentNotifyService();

    public void testPaymentNotify() {
        System.out.println("For detailed information on payment notification, see: [https://doc.lianlianpay.com/doc-api/open-news/pay-result](https://doc.lianlianpay.com/doc-api/open-news/pay-result)");
        // Notification header information
        Map<String, String> headers;
        // Notification body information
        String requestBody;
        PaymentsNotifyRequest paymentsNotifyRequest = paymentNotifyService.checkNotifySignAndGetPaymentsNotifyRequest(headers, requestBody, merchant);
    }
}
```

### Refund Result Notification Example
```java
public class RefundNotifyTest {
    private final MerchantPropertyReader merchant = new MerchantPropertyReader("/globalpay-merchant.properties");
    private final RefundNotifyService refundNotifyService = new RefundNotifyService();

    public void testRefundNotify() {
        System.out.println("For detailed information on refund notification, see: [https://doc.lianlianpay.com/doc-api/open-news/refund-result](https://doc.lianlianpay.com/doc-api/open-news/refund-result)");
        // Notification header information
        Map<String, String> headers;
        // Notification body information
        String requestBody;
        RefundNotifyRequest refundNotifyRequest = refundNotifyService.checkNotifySignAndGetRefundNotifyRequest(headers, requestBody, merchant);
    }
}
```

### Token Event Result Notification Example
```java
public class testTokenEventNotify {
    private final MerchantPropertyReader merchant = new MerchantPropertyReader("/globalpay-merchant.properties");
    private final CardTokenNotifyService cardTokenNotifyService = new CardTokenNotifyService();

    public void testRefundNotify() {
        System.out.println("For detailed information on token event notification, see: [https://doc.lianlianpay.com/doc-api/open-news/token-event-result](https://doc.lianlianpay.com/doc-api/open-news/token-event-result)");
        // Notification header information
        Map<String, String> headers;
        // Notification body information
        String requestBody;
        CardTokenNotifyRequest cardTokenNotifyRequest = cardTokenNotifyService.checkNotifySignAndGetPaymentsNotifyRequest(headers, requestBody, merchant);
    }
}
```

### IFrame Token Payment Token Example
```java
public class IFrameCardTokenPaymentsTest {
    private final MerchantPropertyReader merchant = new MerchantPropertyReader("/globalpay-merchant.properties");
    private final IFrameCardTokenService iFrameCardTokenService = new IFrameCardTokenService();

    public void postCardTokenTest() {
        CardTokenRequest cardTokenRequest = generateCardTokenRequest();
        // For details on getting the IFrame payment token, see: [https://doc.lianlianpay.com/doc-api/open-api/post-token](https://doc.lianlianpay.com/doc-api/open-api/post-token)
        ApiResult<String> iFrameTokenRes = iFrameCardTokenService.sendCardTokenRequest(cardTokenRequest,merchant);
    }
}
```


### Unbind Card Token Example
```java
public class MerchantCardTokenTest {
    private final MerchantPropertyReader merchant = new MerchantPropertyReader("/globalpay-merchant.properties");
    private MerchantUnbindTokenService merchantUnbindTokenService = new MerchantUnbindTokenService();

    public void postCardTokenTest() {
        CardTokenRequest cardTokenRequest = generateCardTokenRequest();
        // For details on Unbind card token, see: [https://doc.lianlianpay.com/doc-api/open-api/unbind-token](https://doc.lianlianpay.com/doc-api/open-api/unbind-token)
        ApiResult<?> iFrameTokenRes = merchantUnbindTokenService.sendUnbindCardTokenRequest(cardTokenRequest, merchant);
    }
}
```

### Generating Public and Private Keys Example
```java
public class RsaPairKeyTest {
    public static void main(String[] args) throws Exception {
        ImmutablePair<String, String> rsaKeyPair = SignUtil.initRsaKey();
        System.out.println("Get Rsa public key: " + rsaKeyPair.getLeft());
        System.out.println("Get Rsa private key: " + rsaKeyPair.getRight());
    }
}
```


### Query Card Token Example
```java
public class MerchantQueryCardTokenTest {
    private final MerchantPropertyReader merchant = new MerchantPropertyReader("/globalpay-merchant.properties");
    private MerchantQueryTokenService merchantQueryTokenService = new MerchantQueryTokenService();

    public void quertCardTokenTest() {
        CardTokenRequest cardTokenRequest = generateCardTokenRequest();
        // For details on Query card token, see: [https://doc.lianlianpay.com/doc-api/open-api/query-token](https://doc.lianlianpay.com/doc-api/open-api/query-token)
        ApiResult<MerchantTokenResponse> iFrameTokenRes = merchantQueryTokenService.sendQueryCardTokenRequest(cardTokenRequest, merchant);
    }
}
```
