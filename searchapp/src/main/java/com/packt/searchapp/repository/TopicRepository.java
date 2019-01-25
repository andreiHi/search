package com.packt.searchapp.repository;


import com.packt.searchapp.domain.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 06.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
public interface TopicRepository extends CrudRepository<Topic, Long>, ExtendedRepository<Topic, Long> {
        List<Topic> findByDescriptionLikeIgnoreCase(String searchString);

}
