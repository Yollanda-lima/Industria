package entidade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Maquina {

	private int totalPedidos;                              //  Total de pedidos da máquina.
	private static final int volumeDoPacotesPorVez = 5000;
	private List<Pedido> pedidos = new ArrayList<>();      // A Maquina embrulha uma lista de pedidos

	public Maquina(String path) throws IOException {
		int contador = 0;
		int totalPedidos = 0;
		BufferedReader br = new BufferedReader(new FileReader(path));     // Quando a máquina é instanciada, juntamente é adicionado na lista
		String line = br.readLine();                                      // pedidos de um arquivo lido, com nome,totalProdutos e prazo.
		while (line != null) {
			String nomeCliente = null;
			int totalProdutos = 0;
			int prazoEntrega = 0;
			if (contador < 1) {
				totalPedidos = Integer.parseInt(line);          
			} else {
				String split[] = line.split(";");
				nomeCliente = split[0];
				totalProdutos = Integer.parseInt(split[1]);
				prazoEntrega = Integer.parseInt(split[2]);
			}
			setTotalPedidos(totalPedidos);
			if (contador >= 1) {
				pedidos.add(new Pedido(nomeCliente, totalProdutos, prazoEntrega));
			}
			contador++;
			line = br.readLine();
		}
		br.close();
	}

	public String pedidosToString() {                             // Identificar os dados dos pedidos.
		StringBuilder bd = new StringBuilder();
		bd.append("Total de pedidos : " + totalPedidos + "\n");
		bd.append("\n");
		for (Pedido pedido : pedidos) {
			bd.append(pedido + "\n");
		}
		return bd.toString();
	}

	public String detalhesProcessamento() {            // Detalhes do processamento, para COMPARAR uma máquina com a outra e fazer conclusoês
		StringBuilder bd = new StringBuilder();
		for (int i = 0; i < getPedidos().size(); i++) {
			bd.append("-----------------------\n");
			bd.append("Pedido #"+(i+1)+" : \n");
			bd.append("Quantidade de produtos do pedido : " + pedidos.get(i).getTotalProdutos() + "\n"); // total de produtos de cada pedido
			bd.append("Quantidade de pacotes : " + retornaPacotesDeCadaPedido(i) + "\n");     // Quantos pacotes por pedido
			if(tempoPedido(i)<60) {
			bd.append("Tempo : " + tempoPedido(i) + " segundos\n");
			} else {
			 double minutos = tempoPedido(i)/60;
				bd.append("Tempo : " + String.format("%.2f", minutos) + " minutos\n");     // tempo que durou para fazer cada pedido.
			}
			bd.append("Prazo do Cliente " + pedidos.get(i).getCliente() + " : " + pedidos.get(i).getPrazo()    // O prazo de cada cliente.
					+ " minutos\n");
			String cumprido;
			if ((tempoPedido(i)/60) <=pedidos.get(i).getPrazo() || pedidos.get(i).getPrazo()==0) { // Define se o prazo foi cumprido ou não
				cumprido = "SIM";
			} else {
				cumprido = "NÃO";
			}

			bd.append("Prazo cumprido : " + cumprido + "\n"); // Mostra se foi cumprido ou não.
			bd.append("\n");
		}
		bd.append("---------------------------\n");
		bd.append("Tempo total para processar a demanda toda : " + String.format("%.2f", (tempoTotal()/60))+" minutos\n"); // Tempo total de todos os pedidos
		return bd.toString();
	}

	public double tempoTotal() {          // Mostra o tempo total de um pedido.
		double segundos = 0;
		for (int i = 0; i < pedidos.size(); i++) {
			segundos += tempoPedido(i);
		}
		return segundos + ((pedidos.size() - 1) * 0.5); // tempo de todos os pacotes de um pedido + 0.5 segundos de pacotes de diferentes  pedidos  na esteira.
	}

	public int retornaPacotesDeCadaPedido(int idPedido) { // Retorna a qantidade de pacotes de cada pedido apartir da quantidade de produtos.
		Pedido pedido = getPedidos().get(idPedido);
		double volumeTotal = pedido.getTotalProdutos() * 250;
		double pacotes = volumeTotal / getVolumeDoPacotesPorVez();
		if (volumeTotal % 50000!= 0) {
			return (int) pacotes + 1; // Isso pois não existe 1,5 pacote ,   2,7 por exemplo. Então se n for inteiro, arredonda pra cima.
		} else {
			return (int)pacotes;
		}
	}

	public abstract double tempoPedido(int idPedido); // Abstrato pois cada tipo de maquina vai ter o temmpoParaFazerOPedido de uma forma diferente.

	public void MaquinaOriginal(int totalPedidos) {
		this.totalPedidos = totalPedidos;
	}

	public int getTotalPedidos() {
		return totalPedidos;
	}

	public void setTotalPedidos(int totalPedidos) {
		this.totalPedidos = totalPedidos;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public static int getVolumeDoPacotesPorVez() {
		return volumeDoPacotesPorVez;
	}
}
