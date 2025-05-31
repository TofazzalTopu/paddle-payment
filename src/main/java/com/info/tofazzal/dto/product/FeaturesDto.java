package com.info.tofazzal.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeaturesDto {
    private boolean aircraft_performance;
    private boolean compliance_monitoring;
    private boolean flight_log_management;
    private boolean payment_by_invoice;
    private boolean route_planning;
    private boolean sso;
}

