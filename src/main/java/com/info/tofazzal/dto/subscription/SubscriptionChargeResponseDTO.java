package com.info.tofazzal.dto.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.info.tofazzal.dto.price.PriceDTO;
import com.info.tofazzal.dto.product.MetaDto;
import com.info.tofazzal.dto.product.ProductDataDto;
import lombok.Data;

import java.util.List;

@Data
public class SubscriptionChargeResponseDTO {
    private SubscriptionDataDTO data;
    private MetaDto meta;

//    @Data
//    public static class SubscriptionData {
//        private String id;
//        private String status;
//
//        @JsonProperty("customer_id")
//        private String customerId;
//
//        private List<SubscriptionItem> items;
//
//        @JsonProperty("management_urls")
//        private ManagementUrlsDTO managementUrls;
//    }

    @Data
    public static class SubscriptionItem {
        private String status;
        private int quantity;
        private boolean recurring;

        private PriceDTO price;
        private ProductDataDto product;
    }

    @Data
    public static class Price {
        private String id;
        private String description;
        private String name;

        @JsonProperty("unit_price")
        private UnitPriceDTO unitPrice;
    }


}
