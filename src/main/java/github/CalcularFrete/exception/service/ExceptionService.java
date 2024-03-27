package github.CalcularFrete.exception.service;

import github.CalcularFrete.exception.BadRequestException;
import github.CalcularFrete.exception.NotFoundException;
import github.CalcularFrete.exception.dto.ExceptionDTO;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

  public ExceptionDTO notFoundException(NotFoundException ex) {
    return new ExceptionDTO.Builder()
        .setErrorDescription(ex.getMessage())
        .build();
  }
  public ExceptionDTO badRequestException(BadRequestException ex) {
    return new ExceptionDTO.Builder()
        .setErrorDescription(ex.getMessage())
        .build();
  }

  public ExceptionDTO exception(Exception ex) {

    return new ExceptionDTO.Builder()
        .setErrorDescription(ex.getMessage())
        .build();
  }
}