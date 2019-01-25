package com.packt.searchapp.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 18.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
public class UserDoNotHaveEnoughFoundsException extends PetStoreException {

    public UserDoNotHaveEnoughFoundsException(String message, Long id) {
        super(message, id);
    }
}
