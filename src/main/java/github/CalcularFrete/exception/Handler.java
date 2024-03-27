package github.CalcularFrete.exception;

import github.CalcularFrete.exception.dto.ExceptionDTO;
import github.CalcularFrete.exception.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
  @Autowired
  ExceptionService service;
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ExceptionDTO> handleException(NotFoundException ex) {
    return new ResponseEntity<>(
        service.notFoundException(ex),
        HttpStatus.NOT_FOUND);
  }
  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ExceptionDTO> handleException(BadRequestException ex) {
    return new ResponseEntity<>(
        service.badRequestException(ex),
        HttpStatus.BAD_REQUEST);
  }
}