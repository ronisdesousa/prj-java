package one.digitalinnovation.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.gof.controller.requests.RequestEstoque;
import one.digitalinnovation.gof.model.Estoque;
import one.digitalinnovation.gof.service.EstoqueService;

@RestController
@RequestMapping("estoque")
public class EstoqueRestController {

	@Autowired
	private EstoqueService estoqueService;
	
	@GetMapping
	public Integer buscarSaldoEstoquePorProduto(@PathVariable Long produtoId) {
		return estoqueService.buscarSaldo(produtoId);
	}

	@PostMapping("/entrada")
	public ResponseEntity<Estoque> inserirEntrada(@RequestBody RequestEstoque request) {
		Estoque estoque = new Estoque();
		estoque.setProdutoId(request.produtoId);
		estoque.setQuantidade(request.quantidade);
		estoque.setTipo("E");
		estoqueService.salvarEstoque(estoque);
		return ResponseEntity.ok(estoque);
	}

	@PostMapping("/saida")
	public ResponseEntity<Estoque> inserirSaida(@RequestBody RequestEstoque request) {
		Estoque estoque = new Estoque();
		estoque.setProdutoId(request.produtoId);
		estoque.setQuantidade(request.quantidade);
		estoque.setTipo("S");
		estoqueService.salvarEstoque(estoque);
		return ResponseEntity.ok(estoque);
	}
}
