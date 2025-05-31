package com.info.tofazzal.dto.price;

import com.info.tofazzal.dto.product.MetaDto;
import lombok.Data;


@Data
public class PriceResponse {
    private PriceDTO data;
    private MetaDto meta;
}