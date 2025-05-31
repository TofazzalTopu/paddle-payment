package com.info.tofazzal.dto.subscription;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionItemPriceDto {
    private String price_id;
    private int quantity;
}
