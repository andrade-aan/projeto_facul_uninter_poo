package aplicativos;

public class Pesquisa {
	
	// campo para pesquisa no arquivo moedas.csv
	private String nomeMoeda; // campo [0]
	private String siglaMoeda; // campo [1]
	private String paisMoeda; // campo [2]
	
	//// campo para pesquisa no arquivo cambio_bacen.csv
	private String codigoMoeda; // campo [0]
	private String tipoMoeda; // campo [1]
	// private String nomeMoeda; campo [2] apenas referencia String
	private double taxaCompra; // campo [3]
	private double taxaVenda; // campo [4]
	private double paridadeCompra; // campo [5]
	private double paridadeVenda; // campo [6]
	
		
	public String getCodigoMoeda() {
		return codigoMoeda;
	}

	public void setCodigoMoeda(String codigoMoeda) {
		this.codigoMoeda = codigoMoeda;
	}

	public String getTipoMoeda() {
		return tipoMoeda;
	}

	public void setTipoMoeda(String tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}

	public double getTaxaCompra() {
		return taxaCompra;
	}

	public void setTaxaCompra(double taxaCompra) {
		this.taxaCompra = taxaCompra;
	}

	public double getTaxaVenda() {
		return taxaVenda;
	}

	public void setTaxaVenda(double taxaVenda) {
		this.taxaVenda = taxaVenda;
	}

	public double getParidadeCompra() {
		return paridadeCompra;
	}

	public void setParidadeCompra(double paridadeCompra) {
		this.paridadeCompra = paridadeCompra;
	}

	public double getParidadeVenda() {
		return paridadeVenda;
	}

	public void setParidadeVenda(double paridadeVenda) {
		this.paridadeVenda = paridadeVenda;
	}

	public String getNomeMoeda() {
		return nomeMoeda;
	}

	public void setNomeMoeda(String nomeMoeda) {
		this.nomeMoeda = nomeMoeda;
	}

	public String getSiglaMoeda() {
		return siglaMoeda;
	}

	public void setSiglaMoeda(String siglaMoeda) {
		this.siglaMoeda = siglaMoeda;
	}

	public String getPaisMoeda() {
		return paisMoeda;
	}

	public void setPaisMoeda(String paisMoeda) {
		this.paisMoeda = paisMoeda;
	}
}
