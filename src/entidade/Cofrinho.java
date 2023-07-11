package entidade;

import java.util.ArrayList;

public class Cofrinho {
	
	private static ArrayList <Moeda> listaMoedasCofrinho = new ArrayList<Moeda>(); 
	
	public static ArrayList<Moeda> getListaMoedasCofrinho() {
		return listaMoedasCofrinho;
	}

	public static void setListaMoedasCofrinho(ArrayList<Moeda> listaMoedasCofrinho) {
		Cofrinho.listaMoedasCofrinho = listaMoedasCofrinho;
	}

	public static void inserirMoedaCofrinho(Moeda x) {
		
		listaMoedasCofrinho.add(x);
		
	}
	
	public static void removerMoedasCofrinho(String siglaMoeda, double valorMoeda) {
		
		boolean moedaNoCofre = false;
		
		for(int i = 0; i < listaMoedasCofrinho.size(); i++) {
			
			if (siglaMoeda.equals(listaMoedasCofrinho.get(i).siglaMoeda))
					if( valorMoeda == listaMoedasCofrinho.get(i).valorMoeda)
						if(moedaNoCofre == false) {
				
							moedaNoCofre = true;
							
							listaMoedasCofrinho.remove(i);
			}
			
			
		}
		
		if (moedaNoCofre == false) {
			System.out.println("Moeda não localizada no Cofrinho!"+
								"\nOperação não realizada\n");
			
		} else {
		
			System.out.printf("Moeda de %s", siglaMoeda); 
			System.out.printf(" %.2f", valorMoeda); 
			System.out.printf(" retirada do Cofrinho!!\n\n");
			
		}
		
	}
	
	public static void listarMoedasCofrinho() {
		
		int j = 0;
		
		for (int i = 0; i < listaMoedasCofrinho.size(); i++) {
			
			j += 1;
			
			System.out.printf(listaMoedasCofrinho.get(i).siglaMoeda + " %.2f ",
					listaMoedasCofrinho.get(i).valorMoeda);
			
			if (j >= 6) {
				j = 0;
				System.out.println();
			}
			
		}
		System.out.println("\n");
	}
	

}
