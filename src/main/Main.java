package main;
import modelo.Apartamento;
import modelo.Casa;
import modelo.DescontoMaiorDoQueJurosException;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUser;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Financiamento> listaFinanciamentos = new ArrayList<Financiamento>();
        
// Chamando métodos - instanciando
    InterfaceUser interfaceUser = new InterfaceUser();
    int tipoImovel = interfaceUser.solicitarTipoImovel();
    double valorImovel = interfaceUser.solicitarValorImovel();
    int prazoFinanciamento = interfaceUser.solicitarPrazoFinanciamento();
    double taxaJurosAnual = interfaceUser.solicitarTaxaJuros();
    	if (tipoImovel == 1) {
    		double areaConstruida = interfaceUser.solicitarAreaConstruida();
    		double tamanhoTerreno = interfaceUser.solicitarTamanhoTerreno();
    		Casa casa = new Casa(tipoImovel, valorImovel, prazoFinanciamento, taxaJurosAnual, areaConstruida, tamanhoTerreno);
    		listaFinanciamentos.add(casa);
    		try {
    			double diferenca = 0;
				casa.verificarDesconto(diferenca);
				}
    		catch (DescontoMaiorDoQueJurosException e) {
    			System.out.println("Erro:" + e.getMessage());
    		}
    	}
    	if (tipoImovel == 2) {
    		int vagasGaragem = interfaceUser.solicitarVagasGaragem();
    		int andar = interfaceUser.solicitarAndar();
    		Apartamento apto = new Apartamento (tipoImovel, valorImovel, prazoFinanciamento, taxaJurosAnual, vagasGaragem, andar);
    		listaFinanciamentos.add(apto);
       	}
    	if (tipoImovel == 3) {
    		int zona = interfaceUser.solicitarZona();
    		Terreno terreno = new Terreno (tipoImovel, valorImovel, prazoFinanciamento, taxaJurosAnual, zona);
    		listaFinanciamentos.add(terreno);
    		    		
    	}
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
     
 //   Casa casa1 = new Casa (1,150000,30,5,90,236);
 //   Casa casa2 = new Casa (1,200000,15,2, 200, 480);
 //  Apartamento apto1 = new Apartamento (2,150000,30,5,2,25);
 //  Apartamento apto2 = new Apartamento (2,200000,15,5,1,3);
 //   Terreno terreno1 = new Terreno (3,200000,15,2,1);
    
         
 // listaFinanciamentos.add (casa1);
 // listaFinanciamentos.add (casa2);
 // listaFinanciamentos.add (apto1);
 // listaFinanciamentos.add (apto2);
 // listaFinanciamentos.add (terreno1);
   
     
         
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
       
    
    //Salvando os financiamentos no txt
    ManipulacaoArquivos.salvarArquivo(listaFinanciamentos,"financiamentos.txt");
  
	//Recuperando dados do arquivo
	ArrayList <Financiamento> financiamentosLidos = ManipulacaoArquivos.recuperarArquivo("financiamentos.txt");
	
	   
	//Salvando financiamentos em arquivo serializado	
	ManipulacaoArquivos.salvarArquivoSerializado (listaFinanciamentos,"financiamentos.bin");
    
    
	//Recuperando dados arquivo serializado
    ArrayList <Financiamento> financiamentosLidosSerializados = ManipulacaoArquivos.recuperarArquivoSerializado("financiamentos.bin");

        
    interfaceUser.closeScanner();
    }

}