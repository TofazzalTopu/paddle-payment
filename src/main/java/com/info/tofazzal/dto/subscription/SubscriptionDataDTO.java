package com.info.tofazzal.dto.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.info.tofazzal.dto.price.BillingCycleDTO;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class SubscriptionDataDTO {
    private String id;
    private String status;
    @JsonProperty("customer_id")
    private String customerId;
    @JsonProperty("address_id")
    private String addressId;
    @JsonProperty("business_id")
    private String businessId;
    @JsonProperty("currency_code")
    private String currencyCode;
    @JsonProperty("created_at")
    private ZonedDateTime createdAt;
    @JsonProperty("updated_at")
    private ZonedDateTime updatedAt;
    @JsonProperty("started_at")
    private ZonedDateTime startedAt;
    @JsonProperty("first_billed_at")
    private ZonedDateTime firstBilledAt;
    @JsonProperty("next_billed_at")
    private ZonedDateTime nextBilledAt;
    @JsonProperty("paused_at")
    private ZonedDateTime pausedAt;
    @JsonProperty("canceled_at")
    private ZonedDateTime canceledAt;
    @JsonProperty("collection_mode")
    private String collectionMode;
    private Object billingDetails;
    @JsonProperty("current_billing_period")
    private PeriodDTO currentBillingPeriod;
    @JsonProperty("billing_cycle")
    private BillingCycleDTO billingCycle;
    @JsonProperty("scheduled_change")
    private Object scheduledChange;
    private List<SubscriptionItemDTO> items;
    @JsonProperty("custom_data")
    private Object customData;
    @JsonProperty("management_urls")
    private ManagementUrlsDTO managementUrls;
    private Object discount;
    @JsonProperty("import_meta")
    private Object importMeta;
}
