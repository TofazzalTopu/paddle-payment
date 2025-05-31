package com.info.tofazzal.dto.subscription;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UnitPriceDTO {
    private String amount;
    @JsonProperty("currency_code")
    private String currencyCode;
}
