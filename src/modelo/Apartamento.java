package modelo;

public class Apartamento extends Financiamento {
	
	private int vagasGaragem;
	private int andar;
		

public Apartamento (int tipoImovel, double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int andar) {
	super (tipoImovel,valorImovel, prazoFinanciamento, taxaJurosAnual);
	this.vagasGaragem = vagasGaragem;
	this.andar = andar;
	
}

@Override

public double calcularPgtoMensal() {
 double pgtoMensalApto = super.calcularPgtoMensal();
           if (getTipoImovel() == 2) {
    	   double taxaJurosAp = super.getTaxaJurosAnual();
    	   double taxaAtual = taxaJurosAp;
    	   double taxaDescontoAnual = taxaAtual*0.05;
    	   double somaTaxas = 0;
    	   
    	   for (int i = 1; i <= getPrazoFinanciamento(); i++) {
    		   taxaAtual = taxaAtual - (taxaAtual*taxaDescontoAnual);
    		   somaTaxas += taxaAtual;
    	   }
    	 double mediaTaxas = somaTaxas/getPrazoFinanciamento();
    	 return pgtoMensalApto = (getValorImovel() / (getPrazoFinanciamento()*12)) * (1 + (mediaTaxas / 12));
	   }
return calcularPgtoMensal();
}
	

public int getVagasGaragem() {
	return vagasGaragem;
}


public int getAndar() {
	return andar;
	}
}