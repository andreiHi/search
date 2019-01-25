package com.packt.searchapp.service.impl;

import com.packt.searchapp.domain.Pet;
import com.packt.searchapp.repository.PetRepository;
import com.packt.searchapp.service.PetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 16.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
@Service
public class PetServiceImpl implements PetService {

    private final PetRepository repository;

    public PetServiceImpl(PetRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Pet> findAll() {
        return (List<Pet>) repository.findAll();

    }

    @Override
    public Optional<Pet> findById(Long id) {
       return this.repository.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return repository.save(pet);
    }

}
