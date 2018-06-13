package com.sharebooks.payments;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Configuration
//@PropertySource("classpath:application.properties")
public class BraintreeGatewayFactory {

//    @Value("${braintree.merchantid}")
//    private String merchantId;
//
//    @Value("${braintree.publickey}")
//    private String publicKey;
//
//    @Value("${braintree.privatekey}")
//    private String privateKey;

    public static BraintreeGateway gateway = new BraintreeGateway(Environment.SANDBOX,
            "2ghrdc725tmckv2q",
            "y8qy8rfy6qhfhr2y",
            "90bb04cdabbc61c31fc35627cc4602f6");

//    public BraintreeGateway getGateway() {
//        return gateway;
//    }
}
