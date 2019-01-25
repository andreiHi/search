package com.arrival.service.impl;

import com.arrival.dto.TrackDTO;
import com.arrival.dto.TrackPageDTO;
import com.arrival.repository.TrackRepository;
import com.arrival.service.TrackService;
import com.arrival.entities.tracks.Track;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * Implementation of track service.
 * @author Karetko Victor.
 */
@Service
@Transactional
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository,
                            ModelMapper modelMapper) {
        this.trackRepository = trackRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Get tracks with pagination.
     * trackPageDTO.setHasNext is a hack, because model mapper can't map fields through inheritance
     * without additional configuration.
     * @param page number of page.
     * @param size size of page.
     * @param search search parameter(by name)
     * @return page with tracks, tracks are in content list.
     */
    @Override
    @Transactional(readOnly = true)
    public TrackPageDTO getTracksdWithPagination(int page, int size, String search) {
        Page<Track> trackPage = trackRepository
                .findTracksByNameContains(PageRequest.of(page, size), search);
        TrackPageDTO trackPageDTO = modelMapper.map(trackPage, TrackPageDTO.class);
        trackPageDTO.setHasNext(trackPage.hasNext());
        return trackPageDTO;
    }

    /**
     * Add track, two-way mapping for updating id in dto.
     * @param trackDTO dto with track data.
     * @return created track.
     */
    @Override
    public TrackDTO addTrack(TrackDTO trackDTO) {
        Track track = modelMapper.map(trackDTO, Track.class);
        this.trackRepository.save(track);
        return modelMapper.map(track, TrackDTO.class);
    }

    /**
     * Update track, two-way mapping for updating id's of cars in dto..
     * TODO change "track" to enum EntityType.
     * @param trackDTO dto with track data.
     * @return created track.
     */
    @Override
    public TrackDTO updateTrack(TrackDTO trackDTO) {
        Track track = trackRepository.findTrackById(trackDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("track"));
        modelMapper.map(trackDTO, track);
        this.trackRepository.save(track);
        return modelMapper.map(track, TrackDTO.class);
    }

    /**
     * Get track by id from db and map to dto.
     * @param trackId track id.
     * @return track or exception.
     */
    @Override
    @Transactional(readOnly = true)
    public TrackDTO getTrackById(Long trackId) {
        Track track = trackRepository.findTrackById(trackId)
                .orElseThrow(() -> new EntityNotFoundException("track"));
        return modelMapper.map(track, TrackDTO.class);
    }
}
