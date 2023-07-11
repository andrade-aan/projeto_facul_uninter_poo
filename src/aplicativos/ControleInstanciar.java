package aplicativos;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ControleInstanciar {
	
		
	private static Scanner entradaDados; // realizar leitura do arquivo
	
	// recebe o conteudo do arquivo "moedas.csv" e retorna como ArrayList
	private static ArrayList<Pesquisa> valoresArquivo =
			new ArrayList<Pesquisa>();
	
	// recebe o conteudo do arquivo "cambio_bacen.csv"
	private static ArrayList<Pesquisa> valoresArquivoCambio = 
			new ArrayList<Pesquisa>();
	
	public static ArrayList<Pesquisa> lerArquivoCambio(String arquivo){
		
		try {
			
			valoresArquivoCambio.clear(); 
			
			entradaDados = new Scanner(Paths.get(arquivo));
			
			while(entradaDados.hasNext()) {
				
				// Vetor temporario para quebra de tabulação no (;)
				String[] capturaLinha = 
						entradaDados.nextLine().split(";");
				
				Pesquisa dadosTemporarios = new Pesquisa();
				
				// inicio tratamento de captura de dados
				double b = 0;
				String a = capturaLinha[6]; // isolar campo [6] String
				String aPonto = a.replace(".", ""); // retira (.) da String
				// transforma campo [6] String em double para
				// o setParidade, trocando (,) por (.)
				b = Double.valueOf(aPonto.replace(",", "."));
				
				dadosTemporarios.setSiglaMoeda(capturaLinha[2]);
				dadosTemporarios.setParidadeVenda(b); 
				
				
				
				valoresArquivoCambio.add(dadosTemporarios);
			}
			
			
			
		}catch (Exception e){
		
			System.out.println("Erro ao ler arquivo cambio_bacen.csv " +
						e.getMessage());
		
		} finally {
		
			entradaDados.close();
		}
		
		
		
		return valoresArquivoCambio;
	}
		
	public static ArrayList <Pesquisa> lerArquivo(String arquivo){
		
		
		try {
			
			valoresArquivo.clear();
		
			entradaDados = new Scanner(Paths.get(arquivo));
		
			while (entradaDados.hasNext()) {
				
				String[] capturaLinha = 
						entradaDados.nextLine().split(";");
				
				Pesquisa dadosTemporarios = new Pesquisa();
				
				dadosTemporarios.setNomeMoeda(capturaLinha[0]);
				dadosTemporarios.setSiglaMoeda(capturaLinha[1]);
				dadosTemporarios.setPaisMoeda(capturaLinha[2]);
				
				valoresArquivo.add(dadosTemporarios);
			}
			
		} catch (Exception e) {
			
			System.out.println("Erro ao ler arquivo moedas.csv " +
						e.getMessage());
			
		} finally {
			entradaDados.close();
		}
		
		
		
		return valoresArquivo;
	}
	
}
