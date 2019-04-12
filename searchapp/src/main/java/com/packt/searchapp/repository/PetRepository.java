package com.packt.searchapp.repository;

import com.packt.searchapp.domain.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 16.01.2019.
 * @version $Id$.
 * @since 0.1.
 */

public interface PetRepository extends CrudRepository<Pet, Long>, ExtendedRepository<Pet, Long> {

}
