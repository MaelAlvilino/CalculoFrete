package github.CalcularFrete.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class TabelaFrete {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String faixaPeso;

  private String faixaCepInicio;

  private String faixaCepFim;

  private Double tarifa;

  public TabelaFrete() {
  }

  public TabelaFrete(String faixaPeso, String faixaCepInicio, String faixaCepFim, Double tarifa) {
    this.faixaPeso = faixaPeso;
    this.faixaCepInicio = faixaCepInicio;
    this.faixaCepFim = faixaCepFim;
    this.tarifa = tarifa;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFaixaPeso() {
    return faixaPeso;
  }

  public void setFaixaPeso(String faixaPeso) {
    this.faixaPeso = faixaPeso;
  }

  public String getFaixaCepInicio() {
    return faixaCepInicio;
  }

  public void setFaixaCepInicio(String faixaCepInicio) {
    this.faixaCepInicio = faixaCepInicio;
  }

  public String getFaixaCepFim() {
    return faixaCepFim;
  }

  public void setFaixaCepFim(String faixaCepFim) {
    this.faixaCepFim = faixaCepFim;
  }

  public Double getTarifa() {
    return tarifa;
  }

  public void setTarifa(Double tarifa) {
    this.tarifa = tarifa;
  }

  @Override
  public String toString() {
    return "TabelaFrete{" +
        "id=" + id +
        ", faixaPeso='" + faixaPeso + '\'' +
        ", faixaCepInicio='" + faixaCepInicio + '\'' +
        ", faixaCepFim='" + faixaCepFim + '\'' +
        ", tarifa=" + tarifa +
        '}';
  }
}
