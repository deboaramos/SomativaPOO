package modelo;

public class Casa extends Financiamento {
	
	private int tipoImovel;
	
	public Casa (int tipoImovel, double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
		super (tipoImovel,valorImovel, prazoFinanciamento, taxaJurosAnual);
		this.tipoImovel = tipoImovel;
	}
		
	@Override
	public double calcularPgtoMensal() {
	    double pgtoMensalCasa = super.calcularPgtoMensal(); 
	    if (tipoImovel == 1) {
	    	if (pgtoMensalCasa <= 1000) {
	    		return pgtoMensalCasa * 0.9; 
	    	} 
	    	else {
	    		return pgtoMensalCasa - 100; 
	    	}
	    } else {
	    	return pgtoMensalCasa;
	    }
	}
}



