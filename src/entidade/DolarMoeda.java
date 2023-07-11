package entidade;

import java.util.ArrayList;

public class DolarMoeda extends Moeda {

	private static ArrayList <DolarMoeda> dolarMoedas = new ArrayList<DolarMoeda>();

	public static void inserirMoeda(double valorFaceMoeda) {
		
		dolarMoedas.add(new DolarMoeda("EUA",
				"DOLAR", "USD", valorFaceMoeda));
		
	} 
	
	public static void listaMoedasDolar() {
		
		int j = 0;
		
		for (int i = 0; i < dolarMoedas.size(); i++) {
			
			j += 1;
			
			System.out.printf("USD %.2f  ", dolarMoedas.get(i).valorMoeda);
			
			// apenas para controle de tabulação do print
			if (j >= 6) {
				j = 0;
				System.out.println();
			}
		}
		System.out.println("\n");
	}
	
	public static double cambioDolar(double valorCambioDolar) {
		
		double atualizacaoCambial = 0;
		
		for (int i = 0; i < dolarMoedas.size(); i++) {
			
			atualizacaoCambial += valorCambioDolar*dolarMoedas.get(i).valorMoeda;
			
		}
		return atualizacaoCambial;
	}
	
	public DolarMoeda(String paisMoeda, String nomeMoeda, 
			String siglaMoeda, double valorMoeda) {
		
		super(paisMoeda = "EUA",
				nomeMoeda = "DOLAR AMERICANO",
				siglaMoeda = "USD");
		
		this.valorMoeda = valorMoeda;
		
	}

	public static ArrayList <DolarMoeda> getDolarMoedas() {
		return dolarMoedas;
	}

}
