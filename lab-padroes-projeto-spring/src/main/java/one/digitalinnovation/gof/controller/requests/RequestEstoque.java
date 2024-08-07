package one.digitalinnovation.gof.controller.requests;

public class RequestEstoque {
    public Long produtoId;
    public Integer quantidade;
    
    public Long getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}