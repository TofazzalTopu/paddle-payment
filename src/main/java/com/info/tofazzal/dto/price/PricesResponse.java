package com.info.tofazzal.dto.price;

import com.info.tofazzal.dto.product.MetaDto;
import lombok.Data;

import java.util.List;

@Data
public class PricesResponse {
    private List<PriceDTO> data;
    private MetaDto meta;
}

