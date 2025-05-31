package com.info.tofazzal.dto.subscription;


import com.info.tofazzal.dto.product.MetaDto;
import lombok.Data;

@Data
public class SubscriptionResponseDTO {
    private SubscriptionDataDTO data;
    private MetaDto meta;
}
