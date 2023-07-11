package entidade;

import java.util.ArrayList;

public class EuroMoeda extends Moeda {

	private static ArrayList<EuroMoeda> euroMoedas = new ArrayList<EuroMoeda>();
	
	public static void inserirMoeda(double valorFaceMoeda) {
		
		euroMoedas.add(new EuroMoeda ("UNIAO EUROPEIA",
				"EURO", "EUR",
				valorFaceMoeda));
		
	}
	
	public static double cambioEuro(double valorCambioEuro) {
		
		double atualizacaoCambial = 0;
		
		for(int i = 0; i < euroMoedas.size(); i++) {
			
			atualizacaoCambial += valorCambioEuro*euroMoedas.get(i).valorMoeda;
			
		}
		
		
		return atualizacaoCambial;
	}
	
	public static void listaMoedasEuro() {
		
		int j = 0;
		
		for (int i = 0; i < euroMoedas.size(); i++) {
			
			j += 1;
			
			System.out.printf(euroMoedas.get(i).siglaMoeda + " %.2f ",
					euroMoedas.get(i).valorMoeda);
			
			// apenas para controle de tabulação do print
			if (j >= 6) {
				j = 0;
				System.out.println();
			}

		}
		System.out.println("\n");
	}
	
	public EuroMoeda(String paisMoeda, String nomeMoeda,
			String siglaMoeda, double valorMoeda) {
		
		super(paisMoeda ="UNIAO EUROPEIA",
				nomeMoeda = "EURO",
				siglaMoeda = "EUR");
		this.valorMoeda = valorMoeda;
		
	}

}
