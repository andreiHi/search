package com.packt.searchapp.controller;

import com.packt.searchapp.domain.Pet;
import com.packt.searchapp.domain.User;
import com.packt.searchapp.service.PetService;
import com.packt.searchapp.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 18.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
@RestController
public class BuyController {
    private static final Logger LOG = LogManager.getLogger(BuyController.class);

    private final PetService petService;
    private final UserService userService;

    @Autowired
    public BuyController(PetService petService, UserService userService) {
        this.petService = petService;
        this.userService = userService;
    }

    @PostMapping("/buy/{petId}")
    public ResponseEntity<Pet>buyPet(@PathVariable("petId")Long petId, @RequestParam("userId") Long userId) {
        ResponseEntity<Pet> build = ResponseEntity.badRequest().build();
        if (userId == null || userId == 0) {
            return build;
        }
        final Optional<User> userById = userService.findById(userId);
        if (!userById.isPresent()) {
            throw new EntityNotFoundException(String.format("User with id = %s not found", userId));
        }
        final Optional<Pet> petById = petService.findById(petId);
        if (!petById.isPresent()) {
            throw new EntityNotFoundException(String.format("Pet with id = %s not found", petId));
        }
        return userService.buyPet(userById.get(), petById.get()).map(ResponseEntity::ok).get();
    }
}
