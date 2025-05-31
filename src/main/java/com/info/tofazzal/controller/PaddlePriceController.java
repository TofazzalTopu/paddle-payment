package com.info.tofazzal.controller;

import com.info.tofazzal.constants.AppConstant;
import com.info.tofazzal.dto.price.PriceCreateRequestDTO;
import com.info.tofazzal.dto.price.PriceResponseDTO;
import com.info.tofazzal.dto.price.PriceUpdateRequestDTO;
import com.info.tofazzal.service.PaddlePriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstant.API_PADDLE_PRICES)
@Tag(name = "Paddle Price Controller", description = "APIs for handling Paddle Price operations")
public class PaddlePriceController {

    private final PaddlePriceService paddlePriceService;

    @PostMapping
    @Operation(summary = "Create a new Paddle price.")
    public ResponseEntity<PriceResponseDTO> createPrice(@RequestBody @Valid PriceCreateRequestDTO request) throws URISyntaxException {
        return ResponseEntity.created(new URI(AppConstant.API_PADDLE_PRICES)).body(paddlePriceService.createPrice(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve a Paddle price by its ID.")
    public ResponseEntity<PriceResponseDTO> getPrice(@PathVariable String id) {
        return ResponseEntity.ok(paddlePriceService.getPrice(id));
    }

    @GetMapping
    @Operation(summary = "Retrieve all Paddle prices.")
    public ResponseEntity<PriceResponseDTO> getAllPrices() {
        return ResponseEntity.ok(paddlePriceService.getAllPrices());
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update a Paddle price by its ID.")
    public ResponseEntity<PriceResponseDTO> updatePrice(@PathVariable String id, @RequestBody @Valid PriceUpdateRequestDTO request) {
        return ResponseEntity.ok(paddlePriceService.updatePrice(id, request));
    }
}
