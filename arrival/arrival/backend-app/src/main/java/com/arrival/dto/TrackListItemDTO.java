package com.arrival.dto;

import com.arrival.entities.templates.MetricsUnit;
import lombok.Data;

/**
 * Class TrackDTO.
 * @author Karetko Victor.
 */
@Data
public class TrackListItemDTO {
    private Long id;
    private String name;
    private String description;
    private MetricsUnit length;
}
