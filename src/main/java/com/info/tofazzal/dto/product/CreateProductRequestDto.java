package com.info.tofazzal.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequestDto {
    private String name;
    private String tax_category;
    private String description;
    private String image_url;
    private CustomDataDto custom_data;
}
