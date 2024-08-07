package one.digitalinnovation.gof.model;

import org.springframework.data.repository.CrudRepository;

public interface  EstoqueRepository extends CrudRepository<Estoque, Long> {
    Iterable<Estoque> findByProdutoId(Long produtoId);
}
