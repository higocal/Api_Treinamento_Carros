package com.carros.api.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Erros
@RestControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            EmptyResultDataAccessException.class
    })
    public ResponseEntity errorNotFound() {
 //     return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error("404","Não encontrado"));

    }

    @ExceptionHandler({
           IllegalArgumentException.class
    })
    public ResponseEntity errorBadRequest() {
//       return ResponseEntity.badRequest().build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error("400","Acesso negado"));

    }

    @ExceptionHandler({
            AccessDeniedException.class
    })
    public ResponseEntity accessDenied() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Error("403","Acesso negado"));
    }
}

class Error {
    public String status;
    public String error;

    public Error(String status, String error) {
        this.status = status;
        this.error = error;
    }
}