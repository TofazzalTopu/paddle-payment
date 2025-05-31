package com.info.tofazzal.dto.price;

import lombok.Data;

import java.util.Map;

@Data
public class PriceResponseDTO {
    private Map<String, Object> data;
    private Map<String, Object> meta;
}

