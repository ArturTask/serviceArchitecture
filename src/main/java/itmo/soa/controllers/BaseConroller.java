package itmo.soa.controllers;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import itmo.soa.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

public class BaseConroller {

    @ExceptionHandler({ InvalidFormatException.class, InstantiationException.class})
    public ResponseEntity<ErrorDto> handleBaseExceptions() {
        return new ResponseEntity<>(new ErrorDto(HttpStatus.BAD_REQUEST.value(), "Wrong input"), HttpStatus.BAD_REQUEST);
    }
}
