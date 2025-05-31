package com.info.tofazzal.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomDataDto {
    private FeaturesDto features;
    private List<String> suggested_addons;
    private String upgrade_description; // can be null
}
