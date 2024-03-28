package github.CalcularFrete.repository;

import github.CalcularFrete.model.TabelaFrete;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaFreteRepository extends JpaRepository<TabelaFrete, Integer> {
  @Query("SELECT tf FROM TabelaFrete tf WHERE :cep BETWEEN tf.faixaCepInicio AND tf.faixaCepFim")
  List<Optional<TabelaFrete>> buscarCep(@Param("cep") String cep);


  @Query("  SELECT p"
      + "  FROM TabelaFrete p"
      + "  WHERE p.faixaPeso = :faixa_peso"
      + "  AND :cep BETWEEN p.faixaCepInicio AND p.faixaCepFim")
  TabelaFrete buscarPrecoECep(@Param("cep") String cep, String faixa_peso);
}

