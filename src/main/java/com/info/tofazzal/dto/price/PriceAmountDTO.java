package com.info.tofazzal.dto.price;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PriceAmountDTO {
    @NotBlank
    private String amount;
    @NotBlank
    private String currency_code;
}