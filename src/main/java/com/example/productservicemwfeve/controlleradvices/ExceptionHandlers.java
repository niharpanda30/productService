package com.example.productservicemwfeve.controlleradvices;

import com.example.productservicemwfeve.dtos.ArithmaticExceptionhandlerDto;
import com.example.productservicemwfeve.dtos.ExceptionDto;
import com.example.productservicemwfeve.exceptions.ProductNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmaticExceptionhandlerDto> handleArithmeticException(){
        ArithmaticExceptionhandlerDto arithmaticExceptionhandlerDto = new ArithmaticExceptionhandlerDto();
        arithmaticExceptionhandlerDto.setMessage("Something is wrong");
        return new ResponseEntity<ArithmaticExceptionhandlerDto>(arithmaticExceptionhandlerDto, HttpStatus.OK);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Void> handleArrayindexOutofBoundsException(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<ExceptionDto> handleProductNotExistsException(ProductNotExistsException exception){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
