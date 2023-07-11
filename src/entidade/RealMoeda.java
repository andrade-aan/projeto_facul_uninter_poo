package entidade;

import java.util.ArrayList;

public class RealMoeda extends Moeda{
	
	private static ArrayList<Moeda> realMoedas = new ArrayList<Moeda>();

	public static void inserirMoeda(double valorFaceMoeda) {
		
		realMoedas.add(new RealMoeda("BRASIL", "REAL", "BRL", valorFaceMoeda));
		
	}
	
	public static double somaMoedasReal() {
		
		double somaMoedas = 0;
		
		for (int i = 0; i < realMoedas.size(); i++) {
			
			somaMoedas += realMoedas.get(i).valorMoeda;
			
		}
		
		return somaMoedas;
	}
	
	public static void listaMoedasReal() {
		
		int j = 0;
		
		for (int i = 0; i < realMoedas.size(); i++) {
			
			j += 1;
			
			System.out.printf("BRL %.2f  ", realMoedas.get(i).valorMoeda);
			
			// apenas para controle de tabulação do print
			if (j >= 6) {
				j = 0;
				System.out.println();
			}
		}
		System.out.println("\n");
	}
	
	// construtor
	public RealMoeda(String paisMoeda, String nomeMoeda,
			String siglaMoeda, double valorMoeda) {
		
		super(paisMoeda = "BRASIL",
				nomeMoeda = "REAL",
				siglaMoeda = "BRL");
		this.valorMoeda = valorMoeda;
		
	}
}