package com.info.tofazzal.dto.subscription;

import lombok.Data;
import java.util.List;

@Data
public class ChargeRequestDTO {
    private String effective_from;
    private List<SubscriptionItemPriceDto> items;
}
