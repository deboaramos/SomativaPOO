package main;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUser;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();

// Chamando métodos - instanciando
    InterfaceUser interfaceUser = new InterfaceUser();
    int tipoImovel = interfaceUser.solicitarTipoImovel();
    double valorImovel = interfaceUser.solicitarValorImovel();
    int prazoFinanciamento = interfaceUser.solicitarPrazoFinanciamento();
    double taxaJurosAnual = interfaceUser.solicitarTaxaJuros();
    double total_parcelas = 0.00;
    double total_financiamentos = 0.00;
    double total_imoveis = 0.00;

    // Imprimindo os valores do financiamento
    
     
    
    String nomeTipoImovel = "";
    switch (tipoImovel) {
    case 1: 
    	nomeTipoImovel = "Casa";
    	break;
    }
    switch (tipoImovel) {
    case 2: 
    	nomeTipoImovel = "Apartamento";
    	break;
    }
    switch (tipoImovel) {
    case 3: 
    	nomeTipoImovel = "Terreno";
    	break;
    }
    
    System.out.printf("%nTipo Imóvel = " + nomeTipoImovel);
    System.out.printf("%nValor do Imóvel: %.2f%n", valorImovel);
    System.out.println("Prazo financiamento: " + prazoFinanciamento + " anos");
    System.out.println("Taxa anual: " + taxaJurosAnual + "%");

                
    
    //Adicionando financiamentos
    Financiamento novo = new Financiamento(tipoImovel,valorImovel, prazoFinanciamento, taxaJurosAnual);
    listaFinanciamentos.add(novo);
    listaFinanciamentos.add (new Casa (1,150000,30,5));
    listaFinanciamentos.add (new Casa (1,200000,15,2));
    listaFinanciamentos.add (new Apartamento (2,150000,30,5));
    listaFinanciamentos.add (new Apartamento (2,200000,15,5));
    listaFinanciamentos.add (new Terreno (3,200000,15,2));
   

    //Looping para calcular valores e imprimir na tela
        int i = 1;
    System.out.printf("%nLista de Financiamentos:%n");
    for (Financiamento u : listaFinanciamentos) {
    System.out.println("- Financiamento " + i);
    i += 1;
    System.out.println((u));
    u.mostrarInformacoes();
    total_parcelas += u.calcularPgtoMensal();
    total_financiamentos += u.calcularTotalFinanciamento();
    total_imoveis += u.somarValorImoveis();
}
    // Imprimindo os valores na tela
    System.out.printf(" ---------------------------- %nValor total dos imóveis: %.2f%n", total_imoveis);
    System.out.printf("Total Parcelas: %.2f%n", total_parcelas);
    System.out.printf("Valor total dos Financiamentos: %.2f%n", total_financiamentos);

    interfaceUser.closeScanner();
    }

}