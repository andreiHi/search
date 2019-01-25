package com.packt.searchapp.repository;

import com.packt.searchapp.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 18.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
public interface UserRepository extends CrudRepository<User, Long>, ExtendedRepository<User, Long> {

}
