package modelo;

public class Apartamento extends Financiamento {
	
private int tipoImovel;

public Apartamento (int tipoImovel, double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
	super (tipoImovel,valorImovel, prazoFinanciamento, taxaJurosAnual);
	this.tipoImovel = tipoImovel;
}

@Override

	public double calcularPgtoMensal() {
	    double taxaJurosAc = 0;
	    double taxaDescontoAnual = 0.005;
	    double taxaJurosReal = 0;
	       if (tipoImovel == 2) {
	    	   double taxaJurosAp = super.getTaxaJurosAnual();
	    	   for (int i = 1; i <= getPrazoFinanciamento(); i++) {
	    		    	if (taxaDescontoAnual > getTaxaJurosAnual());
	    		   		taxaDescontoAnual = 0;	
	    		   taxaJurosAp -= taxaDescontoAnual;
	    		   taxaJurosAc += taxaJurosAp;
	    	   }
	    	   taxaJurosReal = taxaJurosAc / getPrazoFinanciamento();
	    	   return taxaJurosReal;
	    	   }
	         	
		   return getTaxaJurosAnual();
	}
}
	  
