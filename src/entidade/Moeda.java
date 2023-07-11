package entidade;

public abstract class Moeda {
	
	
	public String paisMoeda; // identificar o país de origem da moeda
	public String nomeMoeda; // nome da moeda
	public String siglaMoeda; // identificação de três posições das moedas como BRL USD EUR
	public double valorMoeda; // valor de face da moeda
	public double valorCambio; // valor para realização do cambio
	
	
	// Construtor da Moeda
	public Moeda(String paisMoeda, String nomeMoeda,
			String siglaMoeda){
		this.paisMoeda = paisMoeda;
		this.nomeMoeda = nomeMoeda;
		this.siglaMoeda = siglaMoeda;
	}
}
