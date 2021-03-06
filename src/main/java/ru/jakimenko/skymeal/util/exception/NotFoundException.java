package ru.jakimenko.skymeal.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by konst on 06.05.17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No data found")
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
