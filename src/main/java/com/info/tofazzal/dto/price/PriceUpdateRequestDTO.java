package com.info.tofazzal.dto.price;

import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Data
public class PriceUpdateRequestDTO {
    @Valid
    private PriceAmountDTO unit_price;
    @Valid
    private List<PriceOverrideDTO> unit_price_overrides;
    @Valid
    private BillingCycleDTO billing_cycle;
}
