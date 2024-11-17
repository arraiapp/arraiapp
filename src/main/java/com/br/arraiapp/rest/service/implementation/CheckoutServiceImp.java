package com.br.arraiapp.rest.service.implementation;

import com.br.arraiapp.domain.dto.CustomerTicket.CustomerTicketDTO;
import com.br.arraiapp.domain.dto.ticket.TicketQuantityDTO;
import com.br.arraiapp.rest.service.CheckoutService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class CheckoutServiceImp implements CheckoutService {

    public ResponseEntity<String> createCheckout(CustomerTicketDTO checkoutData) {

        String customerName = checkoutData.customer().name();
        String customerEmail = checkoutData.customer().email();
        String customerCpf = checkoutData.customer().cpf();

        String customerPhone = checkoutData.customer().phone();
        String customerPhoneArea = customerPhone.substring(0, 2);
        String customerPhoneNumber = customerPhone.substring(3);

        String ticketJson = "";
        for(TicketQuantityDTO ticket: checkoutData.tickets()) {
            ticketJson = ticketJson + "{" +
                                            "\"reference_id\":\"" + ticket.id() +"\"," +
                                            "\"name\":\"" + ticket.description() + "\"," +
                                            "\"description\":\"" + ticket.description() + "\"," +
                                            "\"quantity\":\"" + ticket.quantity() + "\"," +
                                            "\"unit_amount\":\"" + ticket.value().multiply(BigDecimal.valueOf(100)).toBigInteger() + "\"" +
                                      "}";
            if(checkoutData.tickets().indexOf(ticket) != (checkoutData.tickets().size() - 1)) {
                ticketJson = ticketJson + ",";
            }
        }

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
                    "\"name\":\"" + customerName + "\"," +
                    "\"email\":\"" + customerEmail + "\"," +
                    "\"tax_id\":\"" + customerCpf + "\"," +
                    "\"phone\":{\"country\":\"+55\",\"area\":\"" + customerPhoneArea +
                                         "\",\"number\":\"" + customerPhoneNumber +"\"}" +
                "},";

        //Ticket data

        String ticketData = "\"items\":" +
                "[" +
                    ticketJson
                    +
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
        String paymentNotificationURL = ",\"payment_notification_urls\":[\"http://ec2-3-86-32-26.compute-1.amazonaws.com:8080/api/customer-ticket/get-payment-data\"]";

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
