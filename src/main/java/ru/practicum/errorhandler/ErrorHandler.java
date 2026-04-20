package ru.practicum.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.practicum.errorhandler.exception.CriticalException;
import ru.practicum.errorhandler.exception.UserNotFoundException;
import ru.practicum.errorhandler.exception.ValidateException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse userNotFound(UserNotFoundException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(ValidateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse validateException(ValidateException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(CriticalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAll(CriticalException e) {
        return new ErrorResponse(e.getMessage());
    }
}
