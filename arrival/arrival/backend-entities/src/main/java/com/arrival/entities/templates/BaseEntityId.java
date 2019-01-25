package com.arrival.entities.templates;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Base entity for all other entities.
 *
 * @author Karetko Victor.
 */
@Data
@MappedSuperclass
@ToString(of = {"id"})
@EqualsAndHashCode(of = {"id"}, callSuper = false)
public abstract class BaseEntityId implements Serializable {

    /**
     * Primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
}
