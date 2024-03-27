package github.CalcularFrete.Dto;

public class Itens {
  private String nome;
  private Integer quantidade;
  private Integer preco_unitario;
  private Integer peso_produto;
  private String medida_peso;

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Integer getPreco_unitario() {
    return preco_unitario;
  }

  public void setPreco_unitario(Integer preco_unitario) {
    this.preco_unitario = preco_unitario;
  }

  public Integer getPeso_produto() {
    return peso_produto;
  }

  public void setPeso_produto(Integer peso_produto) {
    this.peso_produto = peso_produto;
  }

  public String getMedida_peso() {
    return medida_peso;
  }

  public void setMedida_peso(String medida_peso) {
    this.medida_peso = medida_peso;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
