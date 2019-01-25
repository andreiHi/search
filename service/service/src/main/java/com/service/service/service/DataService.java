package com.service.service.service;

import com.service.service.domain.Topic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 11.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
@Service
public class DataService {
    private static final Logger LOG = LogManager.getLogger(DataService.class);
    private WebClient webClient = WebClient.create("http://localhost:8080");

    public Mono<Topic> getTopic(Long id) {
        return webClient.get()
                .uri("/topics/{id}", id).accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(Topic.class);
    }
}
