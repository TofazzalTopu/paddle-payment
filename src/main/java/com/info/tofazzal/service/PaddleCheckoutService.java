package com.info.tofazzal.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaddleCheckoutService {

    public String createCheckoutLink(String productId, String customerEmail) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://vendors.paddle.com/api/2.0/product/generate_pay_link";

        Map<String, Object> body = new HashMap<>();
        body.put("vendor_id", "YOUR_VENDOR_ID");
        body.put("vendor_auth_code", "YOUR_VENDOR_AUTH_CODE");
        body.put("product_id", productId);
        body.put("customer_email", customerEmail);

        Map response = restTemplate.postForObject(url, body, Map.class);
        return (String) ((Map) response.get("response")).get("url");
    }
}
