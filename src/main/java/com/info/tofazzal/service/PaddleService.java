package com.info.tofazzal.service;

import com.info.tofazzal.config.PaddleProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaddleService {

    private final PaddleProperties paddleProps;
    private final RestTemplate restTemplate = new RestTemplate();

    private String endpoint(String path) {
        return paddleProps.getApiUrl() + path;
    }

    private MultiValueMap<String, String> baseParams() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("vendor_id", paddleProps.getVendorId());
        map.add("vendor_auth_code", paddleProps.getAuthCode());
        log.info("Base Params: {}", map);
        return map;
    }

    public String generatePayLink(int productId, String email, String passthrough) {
        MultiValueMap<String, String> body = baseParams();
        body.add("product_id", String.valueOf(productId));
        body.add("customer_email", email);
        body.add("passthrough", passthrough);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, new HttpHeaders());
        ResponseEntity<Map> response = restTemplate.postForEntity(endpoint("/product/generate_pay_link"), request, Map.class);
        String getPayLink = (String) ((Map<?, ?>) response.getBody().get("response")).get("url");
        log.info("Generated Pay Link: {}", getPayLink);
        return getPayLink;
    }

    public Map<?, ?> listSubscriptions() {
        MultiValueMap<String, String> body = baseParams();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body);
        ResponseEntity<Map> response = restTemplate.postForEntity(endpoint("/subscription/plans"), request, Map.class);
        log.info("Response: {}", response.getBody());
        return (Map<?, ?>) response.getBody().get("response");
    }

    public Map<?, ?> cancelSubscription(String subscriptionId) {
        MultiValueMap<String, String> body = baseParams();
        body.add("subscription_id", subscriptionId);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body);
        ResponseEntity<Map> response = restTemplate.postForEntity(endpoint("/subscription/users_cancel"), request, Map.class);
        log.info("Cancel Subscription Response: {}", response.getBody());
        return (Map<?, ?>) response.getBody();
    }

    public Map<?, ?> getSubscriptionUsers(String subscriptionId) {
        MultiValueMap<String, String> body = baseParams();
        body.add("subscription_id", subscriptionId);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body);
        ResponseEntity<Map> response = restTemplate.postForEntity(endpoint("/subscription/users"), request, Map.class);
        log.info("Get Subscription Users Response: {}", response.getBody());
        return (Map<?, ?>) response.getBody().get("response");
    }

}

