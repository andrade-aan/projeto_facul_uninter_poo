package aplicativos;

import java.util.ArrayList;

public class Imprimir {
	
		
	public static void imprimirListaMoedas(){
		
		String arquivoCsv = "moedas.csv";
		
		ArrayList<Pesquisa> valoresArquivo =
				new ControleInstanciar().lerArquivo(arquivoCsv);
		
		System.out.println("Nome da Moeda - " + 
							"Sigla da Moeda - " + 
				"País de Origem" + "\n");
		
		for (Pesquisa i: valoresArquivo) {
			
			System.out.println(i.getNomeMoeda() + " - " + 
								i.getSiglaMoeda() + " - " +
								i.getPaisMoeda());
		}
		
		System.out.println(valoresArquivo.size());
	
		
	}

}
