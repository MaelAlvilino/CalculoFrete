package github.CalcularFrete.Dto;

import java.util.List;

public record Orcamento(String empresa, String cnpj, List<Endereco> endereco, List<Itens> itens) {}
