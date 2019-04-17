package com.packt.searchapp.service;

import com.packt.searchapp.domain.Pet;
import com.packt.searchapp.domain.User;

import java.util.Optional;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 18.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
public interface UserService {
    Optional<User> findById(Long id);

    User save(User user);

    Optional<Pet> buyPet(User user, Pet pet);
}
