package com.info.tofazzal.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResponseDto {
    private ProductDataDto data;
    private MetaDto meta;
}
