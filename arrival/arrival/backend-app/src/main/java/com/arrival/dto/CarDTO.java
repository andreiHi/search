package com.arrival.dto;

import com.arrival.entities.enums.AiScheme;
import com.arrival.entities.enums.Transmission;
import lombok.Data;

/**
 * Class CarDTO.
 * @author Karetko Victor.
 */
@Data
public class CarDTO {
    private Long id;
    private String code;
    private Transmission transmission;
    private AiScheme ai;
    private MetricsDTO maxSpeed;
}
