package one.digitalinnovation.gof.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import one.digitalinnovation.gof.model.Estoque;
import one.digitalinnovation.gof.model.EstoqueRepository;
import one.digitalinnovation.gof.service.EstoqueService;

public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Override
    public void salvarEstoque(Estoque estoque) {
        estoqueRepository.save(estoque);
    }

    @Override
    public Integer buscarSaldo(Long produtoId) {
        Iterable<Estoque> estoque = estoqueRepository.findByProdutoId(produtoId);

        List<Estoque> estoqueMovimento = buscarEstoquePorProduto(estoque);
        Integer totalEntrada = buscarMovimento(estoqueMovimento, "E");
        Integer totalSaida = buscarMovimento(estoqueMovimento, "S");
        return totalEntrada - totalSaida;
    }

    private List<Estoque> buscarEstoquePorProduto(Iterable<Estoque> estoque)
    {
        return StreamSupport.stream(estoque.spliterator(), false).collect(Collectors.toList());
    }

    private Integer buscarMovimento(List<Estoque> estoqueMovimento, String tipo)
    {
        return estoqueMovimento.stream().filter(x -> x.getTipo().equals(tipo)).map(x -> x.getQuantidade()).reduce(0, Integer::sum);
    }
}
