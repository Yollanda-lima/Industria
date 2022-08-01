package entidade;

import java.io.IOException;

public class MaquinaOriginal extends Maquina {  // Maquina já existente na empresa 

	public MaquinaOriginal(String path) throws IOException {
		super(path);
	}

	public double tempoPedido(int idPedido) {
		return ((retornaPacotesDeCadaPedido(idPedido) * 5) + ((retornaPacotesDeCadaPedido(idPedido) - 1) * 0.5)); // Tempo padrão, como escrito no documento.
	       //  cada pacote demora 5 segundos para ser embrulhado, + 0.5 segundos entre cada um dos pacotes por causa do rolamento.
	}

}
