package entidade;

import java.io.IOException;

public class MaquinaAgil extends Maquina {  // Nova máquina, com melhorias !
	

	public MaquinaAgil(String path) throws IOException {
		super(path);
	}


	@Override
	public double tempoPedido(int idPedido) {
		return ((retornaPacotesDeCadaPedido(idPedido) * 2.5) + ((retornaPacotesDeCadaPedido(idPedido) - 1) * 0.5));
		// Nosso grupo pensou que a melhor forma de ganhamos mais eficaz no empacotamento de produtos seria
		// a compra de uma segundo esteira porém, (HIPOTETICAMENTE) não é viavél pois o custo seria muito alto
		// e não temos verbo para comprar no momento. Após reuniões e testes, Observamos que poderiamos aumentar
		// a velocidade do empacotamento de pacotes sem gastar tanto dinheiro assim, a compra de um braço mêcanico
		// mais eficiente mudaria o cénario de cada pacote ser embrulhado de 5,5 em 5,5 segundos. Conseguimos diminuir esse
		// tempo para 3.0 segundos, sendo 2.5 para empacotar e + 0.5 para rolar a esteira e vim os proximos produtos para repetir o processo.
	}

}
