package com.arrival.repository;

import com.arrival.entities.tracks.Track;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackRepository extends JpaRepository<Track, Long> {
    Page<Track> findTracksByNameContains(Pageable pageable, String search);

    /**
     * Find track by id with fetching cars.
     * @param id track id.
     * @return track.
     */
    @EntityGraph(attributePaths = "cars")
    Optional<Track> findTrackById(Long id);
}
