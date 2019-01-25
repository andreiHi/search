package com.arrival.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@ControllerAdvice
public class ExceptionHandlerController {
    /**
     * Customize entity not found exception
     */
    @ExceptionHandler({EntityNotFoundException.class})
    public @ResponseBody ErrorResponseDTO handleNotFoundException(HttpServletResponse response, Exception e) throws IOException {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return ErrorResponseDTO.builder()
                .code(HttpServletResponse.SC_NOT_FOUND)
                .date(new Date(System.currentTimeMillis()))
                .message(e.getMessage())
                .build();
    }
}
