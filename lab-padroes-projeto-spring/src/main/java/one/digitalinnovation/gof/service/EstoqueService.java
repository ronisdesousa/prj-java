package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Estoque;

public interface  EstoqueService {
    void salvarEstoque(Estoque estoque);
    Integer buscarSaldo(Long produtoId);
}
