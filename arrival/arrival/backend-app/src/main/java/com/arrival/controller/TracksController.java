package com.arrival.controller;

import com.arrival.dto.TrackDTO;
import com.arrival.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.completedFuture;

@RestController
@RequestMapping("/api/tracks")
public class TracksController {

    private final TrackService trackService;

    @Autowired
    public TracksController(TrackService trackService) {
        this.trackService = trackService;
    }

    /**
     * Get list of tracks with pagination
     *
     * @param page - page number.
     * @param size - page size.
     * @return pageDto with tracks.
     */
    @Async
    @GetMapping
    public CompletableFuture<ResponseEntity> getTracks(@RequestParam(required = false, defaultValue = "") String search,
                                                       @RequestParam(required = false, defaultValue = "0") int page,
                                                       @RequestParam(required = false, defaultValue = "0x7fffffff") int size) {
        return completedFuture(trackService.getTracksdWithPagination(page, size, search))
                .thenApply(ResponseEntity::ok);
    }

    /**
     * Add new track.
     * @param trackDTO new track.
     * @return created track.
     */
    @Async
    @PostMapping
    public CompletableFuture<ResponseEntity> addTrack(@RequestBody TrackDTO trackDTO) {
        return completedFuture(trackService.addTrack(trackDTO))
                .thenApply(res -> ResponseEntity.status(201).body(res));
    }

    /**
     * Update track.
     * @param trackDTO track to update.
     * @return updated track.
     */
    @Async
    @PutMapping
    public CompletableFuture<ResponseEntity> updateTrack(@RequestBody TrackDTO trackDTO) {
        return completedFuture(trackService.updateTrack(trackDTO))
                .thenApply(ResponseEntity::ok);
    }

    /**
     * Get track by id.
     * @param trackId track id.
     * @return track.
     */
    @Async
    @GetMapping("/{trackId}")
    public CompletableFuture<ResponseEntity> trackById(@PathVariable Long trackId) {
        return completedFuture(trackService.getTrackById(trackId))
                .thenApply(ResponseEntity::ok);
    }
}
