package entidade;

import java.util.ArrayList;

import aplicativos.ControleInstanciar;
import aplicativos.Pesquisa;

public class OutrasMoedas extends Moeda {
	
	private static ArrayList <OutrasMoedas> outrasMoedas = new ArrayList<OutrasMoedas>();
	
	public static void inserirMoeda(String paisMoeda,
			String nomeMoeda, String siglaMoeda,
			double valorMoeda) {
		
		outrasMoedas.add(new OutrasMoedas(paisMoeda, 
				nomeMoeda, siglaMoeda, valorMoeda) );
		
	}
	
	
	public static double cambioOutrasMoedas() {
		
		ArrayList<Pesquisa> consultaCambio = 
				new ArrayList<Pesquisa>();
		
		// arquivo em csv instaciado como Array
		consultaCambio = ControleInstanciar.lerArquivoCambio(
				"cambio_bacen.csv");
		
		int tam_j = consultaCambio.size();
		int tam_i = outrasMoedas.size();
		
		double somaCambio = 0, cambio = 0; 
		
		// for menor percorrendo Array outrasMoedas
		for(int i = 0; i < tam_i; i++) {
			
			double valorCofre = 
					outrasMoedas.get(i).valorMoeda;
						
			String siglaCofre =  
					outrasMoedas.get(i).siglaMoeda;
			
			// for maior percorrendo Array do arquivo em csv
			for (int j = 0; j < tam_j; j++) {
				
				String siglaArquivo = 
						consultaCambio.get(j).getSiglaMoeda();
				
				double valorCambioVenda = 
						consultaCambio.get(j).getParidadeVenda();
				
				// condição para cálculo do Câmbio
				if(siglaCofre.equals(siglaArquivo)) {
					
					cambio = valorCofre/valorCambioVenda;
					
					System.out.printf("\nMoeda %s", siglaCofre);
					System.out.printf(" %.2f ", outrasMoedas.get(i).valorMoeda);
					System.out.printf(" equivale a BRL %.2f%n", cambio);
					
					somaCambio += cambio;
				}	
				cambio = 0;
			}
			
		}
		
		System.out.printf("\nSoma do Cambio de Moedas"
				+ " Diversas equivale BRL %.2f",somaCambio);
		System.out.println("\n");
		
		return somaCambio;
	}
	
	
	
	public static void listaMoedasOutras() {
		
		int j = 0;
		
		for (int i = 0; i < outrasMoedas.size(); i++) {
			
			j += 1;
			
			System.out.printf(outrasMoedas.get(i).siglaMoeda + " %.2f  ",
					outrasMoedas.get(i).valorMoeda);
			
			// apenas para controle de tabulação do print
			if (j >= 6) {
				j = 0;
				System.out.println();
			}
			
		}
		System.out.println();
	}
	
	public OutrasMoedas(String paisMoeda, String nomeMoeda,
			String siglaMoeda, double valorMoeda) {
		
		super(paisMoeda, nomeMoeda, siglaMoeda);
		
		this.valorMoeda = valorMoeda;
		
	}

}
