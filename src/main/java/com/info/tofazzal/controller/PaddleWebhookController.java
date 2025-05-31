package com.info.tofazzal.controller;

import com.info.tofazzal.service.PaddleWebhookVerifier;
import com.info.tofazzal.util.PaddleUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/paddle")
@Tag(name = "Paddle Webhook Controller", description = "APIs for handling Paddle Webhook operations")
public class PaddleWebhookController {

    @Autowired
    private PaddleWebhookVerifier verifier;

    @PostMapping("/webhook")
    @Operation(summary = "Handle Paddle Webhook Events")
    public String handlePaddleWebhook(@RequestParam Map<String, String> params) {
        String signature = params.get("p_signature");

        // Remove p_signature before verifying
        String rawData = PaddleUtils.getSortedQueryStringWithoutSignature(params);

        boolean valid = verifier.verify(signature, rawData);
        if (!valid) {
            return "Invalid Signature";
        }

        String alertName = params.get("alert_name");

        // Handle different event types
        switch (alertName) {
            case "payment_succeeded":
                // handle payment
                break;
            case "subscription_created":
                // handle subscription
                break;
            case "subscription_cancelled":
                // handle cancellation
                break;
            default:
                break;
        }

        return "OK";
    }

    @PostMapping("/webhook/test")
    @Operation(summary = "Handle Paddle Webhook Events with Verifier")
    public ResponseEntity<String> handleWebhook(@RequestParam Map<String, String> formData) {
        try {
            boolean valid = verifier.isValid(formData);
            if (!valid) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid signature");
            }

            // Process the webhook event
            String alertName = formData.get("alert_name");
            System.out.println("Received alert: " + alertName);

            return ResponseEntity.ok("Webhook verified");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
