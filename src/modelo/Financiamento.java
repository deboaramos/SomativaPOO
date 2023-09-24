package modelo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class Financiamento implements Serializable {
		
	private int tipoImovel;
	private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // Métodos da classe - Construtor

    public Financiamento(int tipoImovel, double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
    	
    	this.tipoImovel = tipoImovel;
    	this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;

    }

    //Método para adicionar financimento a financiamentos
        public String toString() {
        return "Tipo Imovel: "+ tipoImovel + ", Valor Imovel: " + valorImovel + ", Prazo: " + prazoFinanciamento + ", Taxa: " + taxaJurosAnual;
    }

    // Métodos da classe - Calcular pagamento mensal

    public double calcularPgtoMensal() {
        double pgtoMensal;
        pgtoMensal = (this.valorImovel / (prazoFinanciamento*12)) * (1 + (this.taxaJurosAnual / 12));
        return pgtoMensal;
    }

    // Métodos da classe - Calcular total do financiamento

    public double calcularTotalFinanciamento() {
        double totalFinanciamento;
        totalFinanciamento = (calcularPgtoMensal() * (prazoFinanciamento*12));
        return totalFinanciamento;
    }

    public double somarValorImoveis(){
        double totalImoveis;
        totalImoveis = valorImovel;
        return totalImoveis;
    }
    
     public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }
    
    public int getTipoImovel() {
        return tipoImovel;
    }
    
   
    public void mostrarInformacoes() {
    	System.out.println(String.format("Valor da parcela: %.2f", calcularPgtoMensal()));
        System.out.println(String.format("Total do financiamento: %.2f", calcularTotalFinanciamento(), "%n"));
    }
}