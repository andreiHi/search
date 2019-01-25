package com.arrival.service;

import com.arrival.dto.TrackDTO;
import com.arrival.dto.TrackPageDTO;

public interface TrackService {
    TrackPageDTO getTracksdWithPagination(int page, int size, String search);
    TrackDTO addTrack(TrackDTO trackDTO);
    TrackDTO updateTrack(TrackDTO trackDTO);
    TrackDTO getTrackById(Long trackId);
}
