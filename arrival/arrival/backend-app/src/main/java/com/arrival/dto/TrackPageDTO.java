package com.arrival.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class TrackPageDTO.
 * @author Karetko Victor.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TrackPageDTO extends PageDTO<TrackListItemDTO> {
}
