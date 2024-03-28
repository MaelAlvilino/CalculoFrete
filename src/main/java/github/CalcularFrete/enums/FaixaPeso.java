package github.CalcularFrete.enums;

public enum FaixaPeso {
  ATE_10KG("0 a 10kg"),
  ATE_100KG("10 a 100kg"),
  ATE_1TON("100kg a 1ton"),
  ATE_10TON("1ton a 10ton");

  private final String descricao;

  FaixaPeso(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

  public static FaixaPeso calcularFaixaPeso(Double pesoTotal) {
    if (pesoTotal <= 10) {
      return ATE_10KG;
    } else if (pesoTotal <= 100) {
      return ATE_100KG;
    } else if (pesoTotal <= 1000) {
      return ATE_1TON;
    } else {
      return ATE_10TON;
    }
  }
}