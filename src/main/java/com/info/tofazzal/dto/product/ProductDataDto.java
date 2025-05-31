package com.info.tofazzal.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDataDto {
    private String id;
    private String name;
    private String tax_category;
    private String type;
    private String description;
    private String image_url;
    private CustomDataDto custom_data;
    private String status;
    private Object import_meta;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;
}
