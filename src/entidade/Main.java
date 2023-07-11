package entidade;


import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import aplicativos.ControleInstanciar;
import aplicativos.Imprimir;
import aplicativos.Pesquisa;


public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.getDefault());
		
		Scanner sc = new Scanner(System.in);
		
		int opcaoMenu = 0;
		
		// Inicio do laço de repetição do..while
		
		do {
			
			System.out.println("Menu Cofrinho" + "\n" +
					"\n1 - Inserir Moeda de Real - BRL" + 
					"\n2 - Inserir Moeda de Dolar Americano - USD" + 
					"\n3 - Inserir Moeda de Euro - EUR" +
					"\n4 - Listar todas as Moedas dentro do Cofrinho" +
					"\n5 - Listar todas as Moedas de Real, Dolar e Euro" +
					"\n6 - Inserir Moedas de Outros Países" +
					"\n7 - Remover Moedas" +
					"\n8 - Atualizar Câmbio - Valores em Reais do Cofrinho" +
					"\n9 - Listar tipos de Moedas e Países cadastrados" +
					"\n99 - Encerrar o Programa!");
			try {
				String tratamentoMenu = sc.nextLine();
				opcaoMenu = Integer.valueOf(tratamentoMenu);
			}catch (Exception e) {
				System.out.println("Erro ao digitar numeração");
			}
			
			// opções de Menu switch..case
			switch (opcaoMenu) {
			
			case 1: // Inserir Moeda de Real - BRL
				
				System.out.println();
				System.out.println("Digite o valor de face Moeda:");
				System.out.print(">>> ");
				
				double valorMoedaReal = 0;
				
				// tratamento de erro para digitação incorreta
				try {
					String tratamentoReal = sc.nextLine();
					valorMoedaReal = Double.valueOf(tratamentoReal);
				}catch (Exception e) {
					System.out.println("Erro ao digitar numeração"
							+ "\nOperação cancelada!!" 
							+ "\nPara valores fracionados use o (.) no lugar da (,)");
					break; // volta para inicio do Menu em caso de erro
				}
				
				RealMoeda.inserirMoeda(valorMoedaReal); //Array só de Real
				Cofrinho.inserirMoedaCofrinho(new RealMoeda( // Array Geral
						"BRASIL", "REAL", "BRL",valorMoedaReal));;
				
				System.out.println("Lista de Moedas de REAL no Cofrinho:");
				RealMoeda.listaMoedasReal(); // Lista todas moedas de Real
						
				break;
			
			case 2: // Inserir Moeda de Dolar Americano - USD
				
				System.out.println();
				System.out.println("Digite o valor de face Moeda:");
				System.out.print(">>> ");

				double valorMoedaDolar = 0;
				
				// tratamento de erro para digitação incorreta
				try {
					String tratamentoDolar = sc.nextLine();
					valorMoedaDolar = Double.valueOf(tratamentoDolar);
				}catch (Exception e) {
					System.out.println("Erro ao digitar numeração"
							+ "\nOperação cancelada!!" +
							"\nPara valores fracionados use o (.) no lugar da (,)");
					break;
				}
				DolarMoeda.inserirMoeda(valorMoedaDolar);
				Cofrinho.inserirMoedaCofrinho(new DolarMoeda(
						"EUA", "DOLAR", "USD", valorMoedaDolar));
				
				System.out.println("Lista de Moedas de DOLAR no Cofrinho:");
				DolarMoeda.listaMoedasDolar();
				
				break;
				
			case 3: // Inserir Moeda de Euro - EUR
				
				System.out.println();
				System.out.println("Digite o valor de face Moeda:");
				System.out.print(">>> ");
				

				double valorMoedaEuro = 0;
				
				// tratamento de erro para digitação incorreta
				try {
					String tratamentoEuro = sc.nextLine();
					valorMoedaEuro = Double.valueOf(tratamentoEuro);
				}catch (Exception e) {
					System.out.println("Erro ao digitar numeração"
							+ "\nOperação cancelada!!"
							+ "\nPara valores fracionados use o (.) no lugar da (,)");
					break;
				}
				EuroMoeda.inserirMoeda(valorMoedaEuro);
				Cofrinho.inserirMoedaCofrinho(new EuroMoeda("UNIAO EUROPEIA",
						"EURO",	"EUR", valorMoedaEuro));
				
				System.out.println("Lista de Moedas de EURO no Cofrinho:");
				EuroMoeda.listaMoedasEuro();
								
				break;
				
			case 4: // Listar todas as Moedas dentro do Cofrinho
				
				System.out.println("Lista de Moedas no Cofrinho:");
				Cofrinho.listarMoedasCofrinho();
								
				break;
			
			case 5: // Lista das Moedas de Real, Dolar, Euro e Outras
				
				System.out.println("Lista das Moedas de Real, Dolar, Euro e Outras");
				System.out.println();
				
				System.out.print("Real: ");RealMoeda.listaMoedasReal();
				
				System.out.print("Dolar: ");DolarMoeda.listaMoedasDolar();
				
				System.out.print("Euro: ");EuroMoeda.listaMoedasEuro();
				
				System.out.print("Outras: ");OutrasMoedas.listaMoedasOutras();
				
				break;

			case 6: // Inserir Moedas de Outros Países" 
				
				ArrayList<Pesquisa> consultaInterna =
						new ArrayList<Pesquisa>();
				consultaInterna = ControleInstanciar.lerArquivo(
						"moedas.csv");

				System.out.println("Digite o valor da Moeda:");
				
				double valorOutraMoeda = 0;
				
				// tratamento de erro para digitação incorreta
				try {
					String tratamentoOutra = sc.nextLine();
					valorOutraMoeda = Double.valueOf(tratamentoOutra);
				}catch (Exception e) {
					System.out.println("Erro ao digitar numeração"
							+ "\nOperação cancelada!!"
							+ "\nPara valores fracionados use o (.) no lugar da (,)");
					break;
				}
				
				System.out.println("Digite a Sigla da Moeda:");
				String siglaMoeda = sc.nextLine();
				
				// tratamento para uso do .equals(a) e condicional if
				siglaMoeda = siglaMoeda.toUpperCase();

				// variável boolean para controle de consulta e inserção
				boolean moedaInserida = false;
				
				for (int i = 0; i < consultaInterna.size(); i++) {
					
					String a = consultaInterna.get(i).getSiglaMoeda();
					
					a = a.toUpperCase();
					// condicional entre lista de moedas e entrada do usuário
					if (siglaMoeda.equals(a)) {
						OutrasMoedas.inserirMoeda(
								consultaInterna.get(i).getPaisMoeda(), 
								consultaInterna.get(i).getNomeMoeda(),
								consultaInterna.get(i).getSiglaMoeda(),
								valorOutraMoeda);
						
						Cofrinho.inserirMoedaCofrinho(new OutrasMoedas(
								consultaInterna.get(i).getPaisMoeda(),
								consultaInterna.get(i).getNomeMoeda(),
								consultaInterna.get(i).getSiglaMoeda(),
								valorOutraMoeda));
						
						// troca de valor dentro do condicional
						moedaInserida = true;
					}
				}	// caso de sigla de moeda não localizada
					if (moedaInserida == false) {
						System.out.println("Sigla de Moeda Inexistente!"
								+ " Moeda não inserida! Consulte Lista na opção 9!");
					}
					System.out.println("Lista de Moedas Estrangeiras Diversas no Cofrinho");
					OutrasMoedas.listaMoedasOutras();
					
				break;
			
			case 7: // Remover Moedas do Cofrinho
				
				System.out.println("Digite o valor da Moeda:");

				double valorMoedaRetirada = 0;
				
				try {
					String tratamentoRetirada = sc.nextLine();
					valorMoedaRetirada = Double.valueOf(tratamentoRetirada);
				}catch (Exception e) {
					System.out.println("Erro ao digitar numeração"
							+ "\nOperação cancelada!!"
							+ "\nPara valores fracionados use o (.) no lugar da (,)");
					break;
				}
				System.out.println("Digite a Sigla da Moeda:");
				String siglaMoedaRetirada = sc.nextLine();
				siglaMoedaRetirada = siglaMoedaRetirada.toUpperCase();
				
				Cofrinho.removerMoedasCofrinho(siglaMoedaRetirada, 
						valorMoedaRetirada);
				System.out.println();
				System.out.println("Lista de Moedas no Cofrinho:\n");
				Cofrinho.listarMoedasCofrinho();
				
				break;
				
			case 8: // Atualizar Câmbio - Valores em Reais do Cofrinho
				
				System.out.println("Valor de câmbio do Dolar USD:");
				
				double valorCambioDolar = 0;
				double valorCambioEuro = 0;
				
				try {
					String tratamentoCambioDolar = sc.nextLine();
					valorCambioDolar = Double.valueOf(tratamentoCambioDolar);
				}catch (Exception e) {
					System.out.println("Erro ao digitar numeração"
							+ "\nOperação cancelada!!"
							+ "\nPara valores fracionados use o (.) no lugar da (,)");
					break;
				}
				
				System.out.println("Valor de câmbio do Euro EUR:");
				
				try {
					
					String tratamentoCambioEuro = sc.nextLine();
					valorCambioEuro = Double.valueOf(tratamentoCambioEuro);
					
				}catch (Exception e) {
					
					System.out.println("Erro ao digitar numeração"
							+ "\nOperação cancelada!!"
							+ "\nPara valores fracionados use o (.) no lugar da (,)");
					break;
					
				}
				
				double totalCofre = 0;
				double resultadoMoedasReal = 0;
				double resultadoCambioOutras = 0;
				double resultadoCambioEuro = 0;
				double resultadoCambioDolar = 0;
				
				resultadoCambioEuro = EuroMoeda.cambioEuro(valorCambioEuro);
				resultadoCambioDolar = DolarMoeda.cambioDolar(valorCambioDolar);
				
				if (resultadoCambioDolar > 0) {
					
					System.out.println();
					System.out.println("Relação de Moedas de USD");
					DolarMoeda.listaMoedasDolar();
					System.out.printf("Valor Total das Moedas de Dolar:" +
							" BRL %.2f%n", resultadoCambioDolar);
					System.out.println();
				}
				
				if (resultadoCambioEuro > 0) {
					
					System.out.println();
					System.out.println("Relação de Moedas de EUR");
					EuroMoeda.listaMoedasEuro();
					System.out.printf("Valor Total das Moedas de Euro:" +
							" BRL %.2f%n", resultadoCambioEuro);
					System.out.println();
				}
				
				resultadoCambioOutras = OutrasMoedas.cambioOutrasMoedas();
				
				resultadoMoedasReal = RealMoeda.somaMoedasReal();
				
				totalCofre = resultadoMoedasReal +
						resultadoCambioOutras +
						resultadoCambioEuro +
						resultadoCambioDolar;
				
				System.out.printf("\nTotal no Cofre -> BRL %.2f%n", totalCofre);
				
				break;
				
			case 9: // Listar tipos de Moedas e Países cadastrados
				
				Imprimir.imprimirListaMoedas();
				break;
			
			case 99: // Encerrar programa
				break;
			
			default:
				System.out.println("Digite opção válida!");
				break;
				
			} // encerra switch case
		} while (opcaoMenu != 99);
		
		sc.close();
	}

}
