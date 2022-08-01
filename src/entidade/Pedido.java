package entidade;

public class Pedido {         // Objeto de cada linha do arquivo.

	private String cliente; // Nome
	private int totalProdutos; // Total de Produtos
	private int prazo;  // Prazo de Empacotamento

	public Pedido(String cliente, int totalProdutos, int prazo) {
		this.cliente = cliente;
		this.totalProdutos = totalProdutos;
		this.prazo = prazo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getTotalProdutos() {
		return totalProdutos;
	}

	public void setTotalProdutos(int totalProdutos) {
		this.totalProdutos = totalProdutos;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	
	@Override
	public String toString() {
		return cliente+";"+totalProdutos+";"+prazo;
	}

}
