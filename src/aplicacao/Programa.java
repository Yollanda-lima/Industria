package aplicacao;

import java.io.IOException;

import entidade.Maquina;
import entidade.MaquinaAgil;
import entidade.MaquinaOriginal;

public class Programa {


	public static void main(String[] args) {

	    String path = "c:\\temp2\\trabalho.txt";       // Caminho para ler o arquivo.
		
		try {
			Maquina maquinaOriginal = new MaquinaOriginal(path);       // Instanciando a maquina Original
			Maquina maquinaAgil = new MaquinaAgil(path);              // Instanciando uma soposta nova maquina
          
			//-----------------DADOS LIDOS--------------// Os das máquinas são o mesmo para poder comparar e verificar qual mais vale a pena.
			System.out.println(maquinaOriginal.pedidosToString());
			//--------------------------//-----------------------//
			System.out.println("Máquina Original");
			System.out.println(maquinaOriginal.detalhesProcessamento());     // Processamento da máquina original
			System.out.println("--------------------------------------------------------");
			System.out.println("Máquina Ágil");
			System.out.println(maquinaAgil.detalhesProcessamento());          // Processamento da máquina (nova).
	          
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
