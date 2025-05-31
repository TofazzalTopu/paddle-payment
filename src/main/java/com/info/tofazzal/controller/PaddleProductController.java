package com.info.tofazzal.controller;

import com.info.tofazzal.dto.product.CreateProductRequestDto;
import com.info.tofazzal.dto.product.CreateProductResponseDto;
import com.info.tofazzal.dto.product.ProductListResponseDto;
import com.info.tofazzal.dto.product.UpdateProductRequestDto;
import com.info.tofazzal.service.PaddleProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/paddle/products")
@Tag(name = "Paddle Product Controller", description = "APIs for handling Paddle Product operations")
public class PaddleProductController {

    private final PaddleProductService productService;

    @GetMapping
    @Operation(summary = "Retrieve a list of all Paddle products.")
    public ResponseEntity<ProductListResponseDto> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping
    @Operation(summary = "Create a new Paddle product.")
    public ResponseEntity<CreateProductResponseDto> createProduct(@RequestBody CreateProductRequestDto productDto) {
        return ResponseEntity.ok(productService.createProduct(productDto));
    }

    @GetMapping("/{productId}")
    @Operation(summary = "Retrieve a Paddle product by its ID.")
    public ResponseEntity<CreateProductResponseDto> getProduct(@PathVariable String productId) {
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    @PatchMapping("/{productId}")
    @Operation(summary = "Update a Paddle product by its ID.")
    public ResponseEntity<CreateProductResponseDto> updateProduct(@PathVariable String productId, @RequestBody UpdateProductRequestDto updateDto) {
        return ResponseEntity.ok(productService.updateProduct(productId, updateDto));
    }

}

