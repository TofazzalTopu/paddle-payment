package com.info.tofazzal.dto.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ManagementUrlsDTO {
    private String cancel;
    @JsonProperty("update_payment_method")
    private String updatePaymentMethod;
}
