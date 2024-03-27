package github.CalcularFrete.service;

import github.CalcularFrete.Dto.Orcamento;
import github.CalcularFrete.Dto.Resposta;
import org.springframework.stereotype.Service;

@Service
public class CalcularFreteService {
  public Resposta post(Orcamento r){
    return new Resposta("Autorizado", 1000, 10);
  }
}
