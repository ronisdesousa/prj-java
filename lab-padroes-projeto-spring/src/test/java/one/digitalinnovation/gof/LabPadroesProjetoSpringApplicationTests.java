package one.digitalinnovation.gof;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import one.digitalinnovation.gof.controller.EstoqueRestController;
import one.digitalinnovation.gof.controller.ProdutoRestController;
import one.digitalinnovation.gof.controller.requests.RequestEstoque;
import one.digitalinnovation.gof.model.Estoque;
import one.digitalinnovation.gof.model.Produto;
import one.digitalinnovation.gof.service.EstoqueService;
import one.digitalinnovation.gof.service.ProdutoService;

@SpringBootTest
class LabPadroesProjetoSpringApplicationTests {

	@InjectMocks
    ProdutoRestController produtoController;

	@InjectMocks
    EstoqueRestController estoqueController;

    @Mock
    ProdutoService produtoService;

	@Mock
    EstoqueService estoqueService;

	@Test
	void simularMovimentosProduto() {
		Produto produto = new Produto();
		produto.setNome("Celular");
		produto.setId(1L);
		doNothing().when(produtoService).inserir(produto);
		produtoController.inserir(produto);

		Estoque estoque = new Estoque();
		estoque.setId(1L);
		estoque.setProdutoId(1L);
		estoque.setQuantidade(5);
		estoque.setTipo("E");
		doNothing().when(estoqueService).salvarEstoque(estoque);

		RequestEstoque request = new RequestEstoque();
		request.setProdutoId(1L);
		request.setQuantidade(5);
		estoqueController.inserirEntrada(request);

		when(estoqueService.buscarSaldo(1L)).thenReturn(5);

		var saldo = estoqueController.buscarSaldoEstoquePorProduto(1L);

		assertEquals(saldo, 5);
	}

}
