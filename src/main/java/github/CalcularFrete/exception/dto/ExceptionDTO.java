package github.CalcularFrete.exception.dto;

public class ExceptionDTO {
  private  String descricao;

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  public static class Builder {
    private String descricao;

    public Builder setErrorDescription(String descricao) {
      this.descricao = descricao;
      return this;
    }

    public ExceptionDTO build() {
      ExceptionDTO exceptionDTO = new ExceptionDTO();
      exceptionDTO.setDescricao(this.descricao);
      return exceptionDTO;
    }
  }
}
