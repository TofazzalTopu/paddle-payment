package com.info.tofazzal.dto.price;

import lombok.Data;

import java.util.List;

@Data
public class PriceDTO {
    private String id;
    private String product_id;
    private String type;
    private String description;
    private String name;
    private BillingCycleDTO billing_cycle;
    private PriceIntervalDTO trial_period;
    private String tax_mode;
    private PriceAmountDTO unit_price;
    private List<PriceOverrideDTO> unit_price_overrides;
    private String status;
    private Quantity quantity;
    private String created_at;
    private String updated_at;
}