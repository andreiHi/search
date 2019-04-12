package com.packt.searchapp.exceptions;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 18.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
@ControllerAdvice
@RequestMapping
public class CustomerControllerAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<VndErrors> notFoundException(final EntityNotFoundException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    }

    @ExceptionHandler(PetStoreException.class)
    public ResponseEntity<VndErrors> notFoundException(final PetStoreException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getId().toString());
    }

    private ResponseEntity<VndErrors> error(
            final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message =
                Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<VndErrors> assertionException(final IllegalArgumentException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    }

//    @ExceptionHandler({EntityNotFoundException.class})
//    public @ResponseBody
//    ErrorResponseDTO handleNotFoundException(HttpServletResponse response, Exception e) throws IOException {
//        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//        return ErrorResponseDTO.builder()
//                .code(HttpServletResponse.SC_NOT_FOUND)
//                .date(new Date(System.currentTimeMillis()))
//                .message(e.getMessage())
//                .build();
//    }
}
