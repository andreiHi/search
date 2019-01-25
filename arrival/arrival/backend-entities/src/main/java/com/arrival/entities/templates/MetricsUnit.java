package com.arrival.entities.templates;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Class MetricsUnit.
 *
 * @author Karetko Victor.
 */
@Data
@Embeddable
public class MetricsUnit {
    private String unit;
    private Double value;
}
