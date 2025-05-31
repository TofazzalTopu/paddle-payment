package com.info.tofazzal.dto.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.info.tofazzal.dto.price.PriceDTO;
import com.info.tofazzal.dto.product.ProductDataDto;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class SubscriptionItemDTO {
    private String status;
    private int quantity;
    private boolean recurring;
    @JsonProperty("created_at")
    private ZonedDateTime createdAt;
    @JsonProperty("updated_at")
    private ZonedDateTime updatedAt;
    @JsonProperty("previously_billed_at")
    private ZonedDateTime previouslyBilledAt;
    @JsonProperty("next_billed_at")
    private ZonedDateTime nextBilledAt;
    @JsonProperty("trial_dates")
    private Object trialDates;
    private PriceDTO price;
    private ProductDataDto product;
}
