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


public void verificarDesconto (double diferenca) throws DescontoMaiorDoQueJurosException{
	double valorDesconto = super.calcularPgtoMensal() - this.calcularPgtoMensal();
	double valorJurosMensalidade = super.calcularPgtoMensal()-(super.getValorImovel()/super.getPrazoFinanciamento()/12);
	diferenca = valorDesconto - valorJurosMensalidade;
	if (diferenca > 0)
		throw new DescontoMaiorDoQueJurosException ("O valor de desconto é maior que os juros da parcela");
		}
	}

