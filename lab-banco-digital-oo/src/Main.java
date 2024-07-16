
public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(300);
		cc.depositar(250);
		cc.depositar(400);
		cc.sacar(100);
		cc.depositar(100);
		cc.transferir(400, poupanca);

		cc.imprimirExtrato();
		cc.imprimirMovimentacao();
		poupanca.imprimirExtrato();
	}

}
