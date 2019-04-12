package com.packt.searchapp.controller;

import com.packt.searchapp.domain.Pet;
import com.packt.searchapp.service.PetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 16.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
@RestController
public class CatalogController {
    private static final Logger LOG = LogManager.getLogger(CatalogController.class);

    private final PetService service;

    @Autowired
    public CatalogController(PetService petService) {
        this.service = petService;
    }

    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(service.findAll());
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> options() {
        return ResponseEntity.ok()
                .allow(HttpMethod.GET, HttpMethod.POST,
                        HttpMethod.PUT, HttpMethod.DELETE,
                        HttpMethod.OPTIONS, HttpMethod.HEAD)
                .build();
    }

    @GetMapping("/pet/{id}")
    public ResponseEntity<Pet> findPetById(@PathVariable("id") Long id) {
        return this.service.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Pet with id=%s not found!", id)));
            //    .orElseThrow(() -> new PetStoreException("Pet with id=%s not found!", id));
    }
}
