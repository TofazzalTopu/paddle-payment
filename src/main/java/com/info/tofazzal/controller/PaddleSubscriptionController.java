package com.info.tofazzal.controller;

import com.info.tofazzal.constants.AppConstant;
import com.info.tofazzal.dto.subscription.*;
import com.info.tofazzal.service.PaddleSubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstant.API_PADDLE_SUBSCRIPTIONS)
@Tag(name = "Paddle Subscription Controller", description = "APIs for handling Paddle Subscription operations")
public class PaddleSubscriptionController {

    private final PaddleSubscriptionService subscriptionService;

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve a Paddle subscription by its ID.")
    public SubscriptionResponseDTO getSubscription(@PathVariable("id") String id) {
        return subscriptionService.getSubscriptionById(id);
    }

    @PatchMapping("/{subscriptionId}")
    @Operation(summary = "Update a Paddle subscription by its ID.")
    public ResponseEntity<SubscriptionUpdateResponse> updateSubscription(@PathVariable String subscriptionId, @RequestBody UpdateSubscriptionRequest request) {
        SubscriptionUpdateResponse response = subscriptionService.updateSubscription(subscriptionId, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{subscriptionId}/charge")
    @Operation(summary = "Charge a Paddle subscription by its ID.")
    public ResponseEntity<SubscriptionChargeResponseDTO> chargeSubscription(@PathVariable String subscriptionId, @RequestBody ChargeRequestDTO requestDTO) {
        SubscriptionChargeResponseDTO response = subscriptionService.chargeSubscription(subscriptionId, requestDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{subscriptionId}/cancel")
    @Operation(summary = "Cancel a Paddle subscription by its ID.")
    public ResponseEntity<SubscriptionUpdateResponse> cancelSubscription(@PathVariable String subscriptionId, @RequestBody CancelSubscriptionRequestDTO request) {
        SubscriptionUpdateResponse response = subscriptionService.cancelSubscription(subscriptionId, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{subscriptionId}/pause")
    @Operation(summary = "Pause a Paddle subscription by its ID.")
    public ResponseEntity<SubscriptionUpdateResponse> pauseSubscription(@PathVariable String subscriptionId, @RequestBody PauseSubscriptionRequestDTO request) {
        SubscriptionUpdateResponse response = subscriptionService.pauseSubscription(subscriptionId, request);
        return ResponseEntity.ok(response);
    }

}
