package com.info.tofazzal.dto.price;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BillingCycleDTO {
    @NotBlank
    private String interval;
    @Min(1)
    private int frequency;
}