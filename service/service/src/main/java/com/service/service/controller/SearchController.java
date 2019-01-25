package com.service.service.controller;

import com.service.service.domain.Topic;
import com.service.service.service.DataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 11.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
@RestController
public class SearchController {
    private static final Logger LOG = LogManager.getLogger(SearchController.class);

    private final DataService service;

    @Autowired
    public SearchController(DataService service) {
        this.service = service;
    }
    @GetMapping("/topic/{id}")
    public Mono<Topic>getTopic(@PathVariable Long id) {
        return service.getTopic(id);
    }

}
