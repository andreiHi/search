package com.packt.searchapp.service;

import com.packt.searchapp.domain.Pet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 16.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
public interface PetService {

    List<Pet>findAll();

    Optional<Pet> findById(Long id);

    Pet save(Pet pet);
}
