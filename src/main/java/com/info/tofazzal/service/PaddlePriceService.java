package com.info.tofazzal.service;

import com.info.tofazzal.config.PaddleProperties;
import com.info.tofazzal.dto.price.PriceCreateRequestDTO;
import com.info.tofazzal.dto.price.PriceResponseDTO;
import com.info.tofazzal.dto.price.PriceUpdateRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
@Validated
public class PaddlePriceService {

    private final RestTemplate restTemplate;
    private final PaddleProperties paddleProperties;

    public PaddlePriceService(RestTemplateBuilder builder, PaddleProperties paddleProperties) {
        this.restTemplate = builder.build();
        this.paddleProperties = paddleProperties;
    }

    private String getBaseUrl() {
        return paddleProperties.getApiUrl() + "/prices";
    }

    public PriceResponseDTO createPrice(PriceCreateRequestDTO request) {
        HttpEntity<PriceCreateRequestDTO> entity = new HttpEntity<>(request, buildHeaders());
        ResponseEntity<PriceResponseDTO> response = restTemplate.exchange(
                getBaseUrl(), HttpMethod.POST, entity, PriceResponseDTO.class);
        log.info("Created price with response: {}", response);
        return response.getBody();
    }

    public PriceResponseDTO getPrice(String priceId) {
        ResponseEntity<PriceResponseDTO> response = restTemplate.exchange(
                getBaseUrl() + "/" + priceId, HttpMethod.GET, new HttpEntity<>(buildHeaders()), PriceResponseDTO.class);
        log.info("Fetched price with ID: {}, response: {}", priceId, response);
        return response.getBody();
    }

    public PriceResponseDTO getAllPrices() {
        ResponseEntity<PriceResponseDTO> response = restTemplate.exchange(
                getBaseUrl(), HttpMethod.GET, new HttpEntity<>(buildHeaders()), PriceResponseDTO.class);
        return response.getBody();
    }

    public PriceResponseDTO updatePrice(String priceId, PriceUpdateRequestDTO request) {
        HttpEntity<PriceUpdateRequestDTO> entity = new HttpEntity<>(request, buildHeaders());
        ResponseEntity<PriceResponseDTO> response = restTemplate.exchange(getBaseUrl() + "/" + priceId, HttpMethod.PATCH, entity, PriceResponseDTO.class);
        log.info("Updated price with ID: {}", priceId);
        return response.getBody();
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(paddleProperties.getAuthCode());
        log.info("Built headers for Paddle API: {}", headers);
        return headers;
    }
}
