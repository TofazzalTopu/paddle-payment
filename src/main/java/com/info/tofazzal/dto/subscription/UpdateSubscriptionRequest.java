package com.info.tofazzal.dto.subscription;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UpdateSubscriptionRequest {
    private List<SubscriptionItemPriceDto> items;
    private String proration_billing_mode; // e.g., "prorated_immediately"
}
