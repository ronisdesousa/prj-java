
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected Cliente cliente;
	protected List<Movimentacao> movimentacao;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.movimentacao = new ArrayList<>();
	}

	@Override
	public void sacar(double valor) {
		Movimentacao debito = new Movimentacao(TipoMovimentacaoEnum.DEBITO, valor);
		this.movimentacao.add(debito);
	}

	@Override
	public void depositar(double valor) {
		Movimentacao credito = new Movimentacao(TipoMovimentacaoEnum.CREDITO, valor);
		this.movimentacao.add(credito);
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return getTotalCreditos() - getTotalDebitos();
	}

	private double getTotalCreditos() {
		Predicate<Movimentacao> creditos = x -> x.getTipo().equals(TipoMovimentacaoEnum.CREDITO);
		return this.movimentacao.stream().filter(creditos).mapToDouble(x -> x.getValor()).sum();
	}

	private double getTotalDebitos() {
		Predicate<Movimentacao> creditos = x -> x.getTipo().equals(TipoMovimentacaoEnum.DEBITO);
		return this.movimentacao.stream().filter(creditos).mapToDouble(x -> x.getValor()).sum();
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.getSaldo()));
	}

	protected void imprimirMovimentacao() {
		Consumer<Movimentacao> c = new Consumer<Movimentacao>() {
            @Override
            public void accept(Movimentacao m) {
                System.out.println(m.getTipo().toString() + " | " + m.getValor() + " | " + m.getDataMovimentacao().toString());
            }
        };
        
        this.movimentacao.forEach(c);
	}
}
