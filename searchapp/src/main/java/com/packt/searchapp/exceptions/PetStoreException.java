package com.packt.searchapp.exceptions;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 18.01.2019.
 * @version $Id$.
 * @since 0.1.
 */

public class PetStoreException extends RuntimeException {
    private Long id;

    public PetStoreException(String message, Long id) {
        super(String.format(message, id));
       this.id = id;
    }

    public Long getId() {
        return id;
    }
}
