package com.info.tofazzal.dto.price;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class PriceOverrideDTO {
    @NotEmpty
    private List<String> country_codes;
    @Valid
    private PriceAmountDTO unit_price;
}
