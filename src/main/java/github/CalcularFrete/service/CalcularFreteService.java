package github.CalcularFrete.service;

import static github.CalcularFrete.enums.FaixaPeso.calcularFaixaPeso;

import github.CalcularFrete.dto.Orcamento;
import github.CalcularFrete.dto.Resposta;
import github.CalcularFrete.enums.FaixaPeso;
import github.CalcularFrete.enums.Medidas;
import github.CalcularFrete.exception.BadRequestException;
import github.CalcularFrete.exception.NotFoundException;
import github.CalcularFrete.model.TabelaFrete;
import github.CalcularFrete.repository.TabelaFreteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CalcularFreteService {
  private final TabelaFreteRepository repository;

  public CalcularFreteService(TabelaFreteRepository repository) {
    this.repository = repository;
  }
  public Resposta post(Orcamento r){

    if(r.cnpj().length() != 14){
      throw new BadRequestException("Cnpj invalido");
    }

    if(r.endereco().getCep().length() != 8){
      throw new BadRequestException("Cep invalido");
    }
    List<Optional<TabelaFrete>> buscarCepExistente = repository.buscarCep(r.endereco().getCep());

    if (buscarCepExistente.isEmpty()){
      throw new NotFoundException("Cep fora do alcance de frete");
    }

    double pesoTotal = r.itens().stream()
        .mapToDouble(item -> {
          double peso = item.getPeso_produto();
          Medidas medida = Medidas.valueOf(item.getMedida_peso());
          if (medida == Medidas.gr) {
            peso /= 1000;
          } else if (medida == Medidas.ton) {
            peso *= 1000;
          }
          return peso * item.getQuantidade();
        })
        .sum();
    if (pesoTotal > 10000) {
      throw new BadRequestException("Peso total excede 10 ton");
    }
    FaixaPeso calcularFaixaPeso = calcularFaixaPeso(pesoTotal);

    String faixaPeso = calcularFaixaPeso.getDescricao();

    TabelaFrete buscarFreteECep = repository.buscarPrecoECep(r.endereco().getCep(), faixaPeso);

    if (buscarFreteECep == null){
      throw new NotFoundException("Cep fora do alcance de frete para o total de peso");
    }


    return new Resposta("Autorizado", buscarFreteECep.getTarifa(), pesoTotal);
  }
}
