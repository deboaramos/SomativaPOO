package modelo;

public class Terreno extends Financiamento {

private int tipoImovel;

public Terreno (int tipoImovel, double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
	super (tipoImovel,valorImovel, prazoFinanciamento, taxaJurosAnual);
	this.tipoImovel = tipoImovel;
}

@Override
	public double calcularTotalFinanciamento() {
	if (tipoImovel == 3) {
	  return super.calcularTotalFinanciamento() * 1.02;  // Acréscimo de 2%
	}
	return calcularTotalFinanciamento();
	}
}