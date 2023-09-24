package modelo;

public class Terreno extends Financiamento {
	
	private int zona;


public Terreno (int tipoImovel, double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int zona) {
	super (tipoImovel,valorImovel, prazoFinanciamento, taxaJurosAnual);
	this.zona = zona;
	
}


@Override
	public double calcularTotalFinanciamento() {
	if (getTipoImovel() == 3) {
	  return super.calcularTotalFinanciamento() * 1.02;  // Acréscimo de 2%
	}
	return calcularTotalFinanciamento();
	}

public int getZona() {
	return zona;
}
}