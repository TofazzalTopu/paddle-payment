package com.info.tofazzal.dto.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class PeriodDTO {
    @JsonProperty("starts_at")
    private ZonedDateTime startsAt;

    @JsonProperty("ends_at")
    private ZonedDateTime endsAt;
}
