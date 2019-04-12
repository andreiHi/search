package com.packt.searchapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 18.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
@Entity
@Table(name = "pet_store_user")
public class User {

    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private @Id Long id;
    private String name;
    private Long moneyAvailable;
    private String email;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMoneyAvailable() {
        return moneyAvailable;
    }

    public void setMoneyAvailable(Long moneyAvailable) {
        this.moneyAvailable = moneyAvailable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
