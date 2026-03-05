package com.lianpay.globalpay;

import com.lianpay.globalpay.domain.ApiResult;
import com.lianpay.globalpay.domain.request.PaymentQueryByPostRequest;
import com.lianpay.globalpay.domain.response.PaymentsResponse;
import com.lianpay.globalpay.exception.HttpClientException;
import com.lianpay.globalpay.exception.ParamCheckFailException;
import com.lianpay.globalpay.exception.SignException;
import com.lianpay.globalpay.exception.VerifySignFailException;
import com.lianpay.globalpay.reader.MerchantPropertyReader;
import com.lianpay.globalpay.utils.JacksonUtils;

public class LocalTest {

    private PaymentsQueryService paymentsQueryService = new PaymentsQueryService();

    private static String rsa_private_key2 =  "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDQHKcUJ6GdT2IDwP054BowbyHmGHlEah3/jh942MuYlKWsmxt24dJB/hJqtX34febC+0coqQOyp44pC8mUxCOFakZs0leRxtK1MnL408jKtfkQmy/ypPJrs5GjwJiKwjuuw/MglU4JOAYNLOrENsN9nH54/Huw0RwEH/3eaXjSwSwDbbhrE4BKzCoaxboZnhDxepczFW4DQetLYjPf/4TTBLe9XTR8T90knqCqqMiloqX5zNN9BBuh3091JmOJZ4fBL8ofVO41lMC8T55uFsISFTnHlc/DmgINONqK8t1lqT3BJTo8RXpDv0Fu3V1SZR3nWO/1WnHFnmWA198pJUjTAgMBAAECggEBAKx1Igu0r9vxnbKoqe/dAzbh0UChRVTpb0SIXRJC7azaedRokMDab+eaCV7+WY6jnqgznQtXzCWvbkIbb4flZd44bHXfdQvrrE7VqKsErd82H1igkYJNKEsR+n2tq3tJbDXuUbrNn2ZKU9F1SHMjQqsEFVZjPIkRMFtGu5Uk6CgUxeWD1bKeZtHzHhx1NEWKiWg+m90rBq8Gw1sVe5bDCUEjn63yqmwKPFD6Jmj5eM3wUZtXd8zb5NSPbsT8KstJeTKKX+Ikl3oiuvEJ4JbuBW4hzIgQstM4xdYc+u/8Cfj1CVjuMsZ9TaTpv8RGZDUVOzfaaaNCMEeASdlE2YOe6ukCgYEA/pUaJLIL5MqlOaHa8r1yPfJvz1mYYAGpxjRqkaRsY5CCbJzVDXpYM1wexeEmZk4yo/+/+kqceqdoXAIxY3A/O7K0FMNz0aYjxAh7zLDwBrlLU+RGMQCe9RuzlmxBf/zdogWufN1zQdN6mBjV7/5Z/ZzQVOmuP7Vmz1z7iK+A830CgYEA0UVO/B3PQclZCEKPqH7YuIGDsDOe91xtL7+OVGcNM8i5gbW2JvxJ+S0aaZvnd5uu0OwUBt32vE1MZyfrOtMwkBEWVjzC8zBZe+GIcD/oiC7Q8ljZBH/Ptj+U2Eh/1TNKEV6FGDOSbazA4B6NS7i7cEAZXPZNHcgOXOmNhRjJPo8CfyTLZ/vlv9JRd4/c1MhAmUJax84wJNW7Z849xSlHmmLJgBAymphYFmdV6RywbdxbcPZDAHwsTHFtwKeLqZe1oW3/ZgeaOCMU4BZ1I29yIz7ViQ2W8I4kiNTkLBCRlOXqph3EtHNXjlD1P8K71C/bkyYUhAfBvm12ymUuCyy2MO0CgYAMR+r4tK8jBzPoXi+cDcWeHkuiHYVoss3djXpGzb1impb4W7eS1h9pNhJkvDd7N3Gs5Q3P0VrXdhnTu+38B8TDz5zl9q7iIqY9tOCS5c05oLW2YyxpLS79XQHZJ3gJBPeFyWw6HVysfwTaojBcjzzAu6JBaFriMolVPoeFlgzJVQKBgQCqdblarxSItMQjEXm15QeEzhaZMBWb0X1C9dtNsWhAgd6A2YEkpCUGRmNQU7l/pVNxRFcQ8V5pXZuGgW7aQwK7kltFpypF33L6JQ+udC1+l3V18zQqUa311nECbJTJP6oUpBNvE1c/YZuhZhTJaRZA4CMOD5lR7r7Wrwb0KB8qHg==";

    private static String pub_private_key2 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAll2aNq9eqWajWfFnyffjkU39ktaxO8CNrXdWwh/1Ekc/SD18qe9TU6dmZI23ijdDVuiC8B+RpdWMdwkAkHvl0PJcN+6JPXIYs+dQRWDSaDussLBzdVyz5mtPH5tg6/X1yfirawoqlY0mVSMc1tj79CnNvXJT5ke2gyP+u0WDIp23zIPm97Iu/J3A31BXnrCGGvsLp7WWFi4bu435O5u/DxfsjM7QcUAyBAFpdNGvHURX+DLKLMJTIL5ZaVRHSi75mO4wMPOIOIpzJcAY/2UeKAWTPxGfAABJroKjxnY7fhX5jb/gHjJbMBD9dYMioa0P16Mh0rfWmHP5/yUTgUXn0QIDAQAB";

    public static void main(String[] args) throws VerifySignFailException, HttpClientException, ParamCheckFailException, SignException {
       LocalTest localTest = new LocalTest();
       MerchantPropertyReader merchantPropertyReader = new MerchantPropertyReader();
       merchantPropertyReader.setMERCHANT_ID("999000000000000000");
       merchantPropertyReader.setTEST_MODEL("ON");
       merchantPropertyReader.setMERCHANT_SIGN_KEY(rsa_private_key2);
        merchantPropertyReader.setLL_SIGN_KEY(pub_private_key2);
//       ApiResult<PaymentsResponse> apiResult = localTest.paymentsQueryService.sendPaymentQueryRequest("202304181804530810", merchantPropertyReader);
//        System.out.println(JacksonUtils.toJsonString(apiResult));
        PaymentQueryByPostRequest postRequest = new PaymentQueryByPostRequest();
        postRequest.setMerchantTransactionId("17695008566416600");
        postRequest.setMerchantId("999000000000000000");
        //postRequest.setArn("72715923069164178711511");
        ApiResult<PaymentsResponse> result = localTest.paymentsQueryService.sendPaymentQueryByPostRequest(postRequest, merchantPropertyReader,"3.2");
        System.out.println(JacksonUtils.toJsonString(result));

    }
}
