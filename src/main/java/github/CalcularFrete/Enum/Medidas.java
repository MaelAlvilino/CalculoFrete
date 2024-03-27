package github.CalcularFrete.Enum;

public enum Medidas {
  gr("gr"),
  kg("kg"),
  ton("ton");
  private final String medida;
  Medidas(String medida){
    this.medida =  medida;
  }
  public String getMedida(){
    return medida;
  }
}
