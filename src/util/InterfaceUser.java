package util;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;


public class InterfaceUser {

    Locale locale = new Locale("pt", "BR");
    private Scanner scanner;

    public InterfaceUser() {
        this.scanner = new Scanner(System.in);
    }
    
    
    public int solicitarTipoImovel() {
    	while (true) {
    		System.out.printf("Informe o tipo de Imovel que será financiado: %n" + "1 - Casa%n" + "2 - Apartamento%n" + "3 - Terreno%n" + "Tipo Imóvel:");
    		if (scanner.hasNextInt()) {
    			int tipoImovel = scanner.nextInt();
    			if(tipoImovel >= 1 && tipoImovel <= 3 ) {
    				return tipoImovel;
    			}
    		} 
    		 System.out.println("Por favor, digite o tipo de Imóvel: 1 - Casa, 2 - Apartamento ou 3 - Terreno.");
             scanner.nextLine();
    	}
    }
    

    public double solicitarValorImovel() {
        while (true) {
            System.out.print("Digite o Valor do Imóvel: ");
            if (scanner.hasNextDouble()) {
                double valorImovel = scanner.nextDouble();
                if (valorImovel > 0) {
                    return valorImovel;
                }
            }
            System.out.println("Entrada inválida. Por favor, digite um valor válido.");
            scanner.nextLine();
        }
    }

    public int solicitarPrazoFinanciamento() {
        while (true) {
            System.out.print("Informe o prazo do financiamento em anos: ");
            if (scanner.hasNextInt()) {
                int prazoFinanciamento = scanner.nextInt();
                if (prazoFinanciamento > 0 && prazoFinanciamento <= 30 ) {
                    return prazoFinanciamento;
                }
            }
            System.out.println("Entrada inválida. Por favor, digite um valor maior que 0. Prazo máximo 30 anos.");
            scanner.nextLine();
        }
    }

    public double solicitarTaxaJuros() {
        while (true) {
            System.out.print("Informe a taxa de juros anual(%): ");
            if (scanner.hasNextDouble()) {
                double taxaJurosAnual = scanner.nextDouble();
                if (taxaJurosAnual > 0 && taxaJurosAnual <= 200) {
                    return taxaJurosAnual;
                }
            }
            System.out.println("Entrada inválida. Por favor, digite um valor maior que 0. Taxa máxima 200%.");
            scanner.nextLine();
        }
    }
   
         public double solicitarAreaConstruida() {
            while (true) {
                System.out.print("Informe o total da area construída do imovel (m2): ");
                if (scanner.hasNextDouble()) {
                    double areaConstruida = scanner.nextDouble();
                    if (areaConstruida > 0) {
                        return areaConstruida;
                    }
                }
                                           
            System.out.println("Digite o valor total de area construida");
                scanner.nextLine();
            }
         }

         public double solicitarTamanhoTerreno() {
             while (true) {
                 System.out.print("Informe a área total do terreno (m2): ");
                 if (scanner.hasNextDouble()) {
                     double tamanhoTerreno = scanner.nextDouble();
                     if (tamanhoTerreno > 0) {
                         return tamanhoTerreno;
                     }
                 }
                                            
             System.out.println("Digite a área total do terreno (m2)");
                 scanner.nextLine();
             }
          }
         
         public int solicitarVagasGaragem() {
             while (true) {
                 System.out.print("Informe a quantidade de vagas de garagem: ");
                 if (scanner.hasNextInt()) {
                     int vagasGaragem = scanner.nextInt();
                     if (vagasGaragem >= 0) {
                         return vagasGaragem;
                     }
                 }
                                            
             System.out.println("Digite a quantidade de vagas de garagem:");
                 scanner.nextLine();
             }
         }
       
         public int solicitarAndar() {
             while (true) {
                 System.out.print("Informe o andar do apartamento: ");
                 if (scanner.hasNextInt()) {
                     int andar = scanner.nextInt();
                     if (andar >= 0) {
                         return andar;
                     }
                 }
                                            
             System.out.println("Digite o andar do apartamento. Se Térreo, digite: 0.");
                 scanner.nextLine();
             }
         }
         
         public int solicitarZona() {
             while (true) {
                 System.out.printf("Informe a zona onde o imovel está localizado: %n" + "1 - Residencial%n" + "2 - Comercial%n" + "3 - Industrial%n" + "Digite o tipo de zona do imovel: ");
                 if (scanner.hasNextInt()) {
                     int zona = scanner.nextInt();
                     if (zona >= 1 && zona <= 3) {
                         return zona;
                     }
                 }
                                            
             System.out.println("Informe umas das opções de zona.");
                 scanner.nextLine();
             }
         }
        public void closeScanner() {
            scanner.close();
        }
        
 }
