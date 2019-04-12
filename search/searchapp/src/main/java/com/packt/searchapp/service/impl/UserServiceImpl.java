package com.packt.searchapp.service.impl;

import com.packt.searchapp.domain.Pet;
import com.packt.searchapp.domain.User;
import com.packt.searchapp.exceptions.UserDoNotHaveEnoughFoundsException;
import com.packt.searchapp.repository.PetRepository;
import com.packt.searchapp.repository.UserRepository;
import com.packt.searchapp.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 18.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);
    private final UserRepository repository;
    private final PetRepository petRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository, PetRepository petRepository) {
        this.repository = repository;
        this.petRepository = petRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User save(User user) {
        return this.repository.save(user);
    }

    @Transactional
    @Override
    public Optional<Pet> buyPet(User user, Pet pet) {
        if (user.getMoneyAvailable() < pet.getCost()) {
            throw new UserDoNotHaveEnoughFoundsException("User %s not have enough Money", user.getId());
        }
        user.setMoneyAvailable(user.getMoneyAvailable() - pet.getCost());
        pet.setNumberInStock(pet.getNumberInStock() - 1);
        repository.save(user);
        return Optional.of(petRepository.save(pet));
    }
}
