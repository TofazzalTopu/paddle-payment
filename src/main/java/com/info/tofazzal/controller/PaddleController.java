package com.info.tofazzal.controller;

import com.info.tofazzal.constants.AppConstant;
import com.info.tofazzal.service.PaddleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstant.API_PADDLE)
@Tag(name = "Paddle Controller", description = "APIs for handling Paddle API operations")
public class PaddleController {

    private final PaddleService paddleService;

    @GetMapping("/subscriptions")
    @Operation(summary = "Retrieve a list of all Paddle subscriptions.")
    public ResponseEntity<?> listSubscriptions() {
        return ResponseEntity.ok(paddleService.listSubscriptions());
    }

    @GetMapping("/subscription-users/{subscriptionId}")
    @Operation(summary = "Retrieve users associated with a Paddle subscription by its ID.")
    public ResponseEntity<?> getUsers(@PathVariable String subscriptionId) {
        return ResponseEntity.ok(paddleService.getSubscriptionUsers(subscriptionId));
    }

    @PostMapping("/cancel-subscription/{subscriptionId}")
    @Operation(summary = "Cancel a Paddle subscription by its ID.")
    public ResponseEntity<?> cancel(@PathVariable String subscriptionId) {
        return ResponseEntity.ok(paddleService.cancelSubscription(subscriptionId));
    }

    @GetMapping("/paylink")
    @Operation(summary = "Generate a payment link for a Paddle product.")
    public ResponseEntity<?> generatePayLink(@RequestParam int productId, @RequestParam String email, @RequestParam(required = false) String passthrough) {
        return ResponseEntity.ok(Map.of("url", paddleService.generatePayLink(productId, email, passthrough)));
    }
}
