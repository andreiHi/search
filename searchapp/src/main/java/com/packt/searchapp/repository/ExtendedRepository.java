package com.packt.searchapp.repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 03.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
public interface ExtendedRepository<T, ID extends Serializable> {

    List<T> findByAttributeContainsText(String attributeName, String text);

    T updateWith(T with, ID id);
}
