package com.info.tofazzal.dto.subscription;

import com.info.tofazzal.dto.product.MetaDto;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class SubscriptionUpdateResponse {
    private SubscriptionDataDTO data;
    private MetaDto meta;

//    @Getter @Setter
//    @NoArgsConstructor @AllArgsConstructor
//    public static class SubscriptionData {
//        private String id;
//        private String status;
//        private String customer_id;
//        private String updated_at;
//        private String next_billed_at;
//    }
}
