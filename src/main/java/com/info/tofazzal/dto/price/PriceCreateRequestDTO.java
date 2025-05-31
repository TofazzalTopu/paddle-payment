package com.info.tofazzal.dto.price;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PriceCreateRequestDTO {
    @NotBlank
    private String description;
    @NotBlank private String name;
    @NotBlank private String product_id;
    @Valid
    private PriceAmountDTO unit_price;
    @Valid private BillingCycleDTO billing_cycle;
    @Valid private PriceIntervalDTO trial_period;
    @NotBlank private String tax_mode;
}
