package com.br.arraiapp.rest.service.implementation;

import com.br.arraiapp.rest.service.CheckoutService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CheckoutServiceImp implements CheckoutService {

    public ResponseEntity<String> createCheckout(){
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://sandbox.api.pagseguro.com/checkouts";

        HttpHeaders headers = new HttpHeaders();
        headers.add("accept","*/*");
        headers.add("Authorization",
                "Bearer f442cbc4-c3ca-4872-8aa4-ef40de9242df5884e08742f5921b617bc64aa21675242d52-d534-41ab-817c-fc35e488f46a");
        headers.add("Content-Type", "application/json");

        //Customer data
        String customerData =  "\"customer\":" +
                "{" +
                    "\"name\":\"João teste\"," +
                    "\"email\":\"joao@teste.com\"," +
                    "\"tax_id\":\"12345678909\"" +
                "},";

        //Ticket data
        String ticketData = "\"items\":" +
                "[" +
                    "{" +
                        "\"reference_id\":\"1\"," +
                        "\"name\":\"ticket\"," +
                        "\"description\":\"ticket desc\"," +
                        "\"quantity\":\"1\"," +
                        "\"unit_amount\":\"500\"" +
                    "}," +
                    "{" +
                        "\"reference_id\":\"2\"," +
                        "\"name\":\"ticket 2\"," +
                        "\"description\":\"ticket 2 desc\"," +
                        "\"quantity\":\"2\"," +
                        "\"unit_amount\":\"500\"" +
                    "}" +
                "],";

        //Payment methods
        String paymentMethods = "\"payment_methods\":" +
                "[" +
                    "{" +
                        "\"type\":\"CREDIT_CARD\"" +
                    "}," +
                    "{" +
                        "\"type\":\"DEBIT_CARD\"" +
                    "}," +
                    "{" +
                        "\"type\":\"PIX\"" +
                    "}" +
                "]";
        //Redirect Url
        //String redirectUrl = ",\"redirect_url\":\"http://arraiapp.dev/api/checkout/notify-checkout\"";

        //Payment Notification Url
        String paymentNotificationURL = ",\"payment_notification_urls\":[\"http://ec2-3-86-32-26.compute-1.amazonaws.com:8080/api/checkout/notify-checkout\"]";

        String requestBody = "{" + customerData + ticketData + paymentMethods + paymentNotificationURL + "}";

        RequestEntity<?> request = RequestEntity
                .post(url)
                .headers(headers)
                .accept(MediaType.APPLICATION_JSON)
                .body(requestBody);

        System.out.println(restTemplate.exchange(request, String.class));
        return restTemplate.exchange(request, String.class);
    }

}
