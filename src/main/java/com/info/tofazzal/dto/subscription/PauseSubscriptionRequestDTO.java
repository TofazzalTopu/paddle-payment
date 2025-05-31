package com.info.tofazzal.dto.subscription;

import lombok.Data;

@Data
public class PauseSubscriptionRequestDTO {
    private String effective_from;
    private String resume_at;
}
