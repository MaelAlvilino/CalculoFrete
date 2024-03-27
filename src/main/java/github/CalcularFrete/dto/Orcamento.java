package github.CalcularFrete.dto;

import java.util.List;

public record Orcamento(String empresa, String cnpj, Endereco endereco, List<Itens> itens) {}
