package com.sharebooks.payments;

import com.braintreegateway.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class PaymentController {

    @Value("${braintree.merchantid}")
    private String merchantId;

    @GetMapping("/payment")
    public String payment(HttpServletRequest request, Model model) {
        return "payment";
    }

    @PostMapping("/payment/validate")
    public String validatePayment(HttpServletRequest request, @RequestParam String cardNo, @RequestParam String cardType, Model model) {

        CustomerRequest customerRequest = new CustomerRequest()
                .firstName("Mark")
                .lastName("Jones")
                .company("Jones Co.")
                .email("mark.jones@example.com")
                .fax("419-555-1234")
                .phone("614-555-1234")
                .website("http://example.com");
        Result<Customer> cresult = BraintreeGatewayFactory.gateway.customer().create(customerRequest);

        String cutomerId = cresult.isSuccess() ? cresult.getTarget().getId() : null;
        System.out.println("cutomerId - " + cutomerId);

        if(cutomerId != null) {
            PaymentMethodRequest paymentRequest = new PaymentMethodRequest()
                    .customerId("the_customer_id")
                    .paymentMethodNonce("fake-valid-nonce")
                    .options()
                    .verifyCard(true)
                    .verificationMerchantAccountId("2ghrdc725tmckv2q")
                    .verificationAmount("1.00")
                    .done();


            Result<? extends PaymentMethod> presult = BraintreeGatewayFactory.gateway.paymentMethod().create(paymentRequest);
            System.out.println(presult.getMessage());
            model.addAttribute("payment_response", presult.getMessage());
            CreditCardVerification verification = presult.getCreditCardVerification();
            if(verification != null) {
                System.out.println("Verification Status - " + verification.getStatus());
                // "PROCESSOR_DECLINED"
                System.out.println("Verification Processor Response Code" + verification.getProcessorResponseCode());
                System.out.println("Verification Processor Response Text" + verification.getProcessorResponseText());
                model.addAttribute("verification_status", presult.isSuccess() ? verification.getStatus() : verification.getGatewayRejectionReason().toString());
            }
        }
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return cresult.isSuccess() ? "redirect:/dashboard" : "payment";
    }
}
