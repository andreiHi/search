package com.money.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 28.12.2018.
 * @version $Id$.
 * @since 0.1.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    private Long id;
}
