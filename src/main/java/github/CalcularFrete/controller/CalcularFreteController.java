package github.CalcularFrete.controller;

import github.CalcularFrete.dto.Orcamento;
import github.CalcularFrete.dto.Resposta;
import github.CalcularFrete.service.CalcularFreteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularFreteController {

  private final CalcularFreteService service;

  public CalcularFreteController(CalcularFreteService service) {
    this.service = service;
  }
  @PostMapping("/orcamento")
  public Resposta post(@RequestBody Orcamento r){
    return new ResponseEntity<>(this.service.post(r), HttpStatus.OK).getBody();
  }
}
