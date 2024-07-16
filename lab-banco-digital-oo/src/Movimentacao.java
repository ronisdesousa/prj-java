
import java.util.Date;

public class Movimentacao {
    private TipoMovimentacaoEnum tipo;
    private double valor;
    private Date dataMovimentacao;

    public Movimentacao(TipoMovimentacaoEnum tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataMovimentacao = new Date();
    }

    public TipoMovimentacaoEnum getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }
}
