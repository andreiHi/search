package com.arrival.dto;

import com.arrival.entities.templates.MetricsUnit;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Class TrackDTO.
 * @author Karetko Victor.
 */
@Data
public class TrackDTO {
    private Long id;
    private String name;
    private String description;
    private MetricsUnit length;
    private List<CarDTO> cars = new ArrayList<>();
}
