package modelo;

public class Casa extends Financiamento {
	
	private double areaConstruida;
	private double tamanhoTerreno;
	
	public Casa (int tipoImovel, double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
		super (tipoImovel,valorImovel, prazoFinanciamento, taxaJurosAnual);
		this.areaConstruida = areaConstruida;
		this.tamanhoTerreno = tamanhoTerreno;
		
	}
		
	@Override
	public double calcularPgtoMensal() {
	    double pgtoMensalCasa = super.calcularPgtoMensal(); 
	    if (getTipoImovel() == 1) {
	    	if (pgtoMensalCasa <= 1000) {
	    		return pgtoMensalCasa * 0.9; 
	    	} 
	    	else {
	    		return pgtoMensalCasa - 100; 
	    	}
	    } else {
	    	return calcularPgtoMensal();
	    }
	}

	public double getAreaConstruida() {
		return areaConstruida;
	}

	public double getTamanhoTerreno() {
		return tamanhoTerreno;
	}
}



