package main;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import java.util.List;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManipulacaoArquivos {
	
	//Método para salvar financiamentos no txt//
	
	public static void salvarArquivo(ArrayList<Financiamento> listaFinanciamentos, String nomeArquivo) {
		try (PrintWriter writer = new PrintWriter (new FileWriter (nomeArquivo,true))) {
			for (Financiamento financiamento : listaFinanciamentos) {
				String linha = financiamento.getTipoImovel() + "," + financiamento.getValorImovel() + "," + financiamento.getPrazoFinanciamento() + ","
						+financiamento.getTaxaJurosAnual();
				if (financiamento instanceof Casa) {
					Casa casa = (Casa) financiamento;
					linha += "," + casa.getAreaConstruida() + "," + casa.getTamanhoTerreno();
				}
				
				if (financiamento instanceof Apartamento) {
					Apartamento apto = (Apartamento) financiamento;
					linha += "," + apto.getVagasGaragem() + "," + apto.getAndar();
				}
				
				if (financiamento instanceof Terreno) {
					Terreno terreno = (Terreno) financiamento;
					linha += "," + terreno.getZona();
				}
				
				writer.println(linha);
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Método para recuperar os financiamentos no txt//
		public static ArrayList<Financiamento> recuperarArquivo(String nomeArquivo){
			ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();
			try (BufferedReader reader = new BufferedReader (new FileReader(nomeArquivo))) {
				String linha;
				while ((linha = reader.readLine())!= null) {
					String [] partes = linha.split(",");
					if(partes.length >= 4) {
						int tipoImovel = Integer.parseInt(partes[0]);
						double valorImovel = Double.parseDouble(partes[1]);
						int prazoFinanciamento = Integer.parseInt(partes[2]);
	                    double taxaJurosAnual = Double.parseDouble(partes[3]);
	                    
	                    Financiamento financiamento = null;
	               if(tipoImovel == 1) {
	            	   double areaConstruida = Double.parseDouble(partes[4]);
	            	   double tamanhoTerreno = Double.parseDouble(partes[5]);
	            	   financiamento = new Casa(tipoImovel, valorImovel, prazoFinanciamento,taxaJurosAnual,areaConstruida,tamanhoTerreno);
	               } else if (tipoImovel == 2) {
	            	   int vagasGaragem = Integer.parseInt(partes[4]);
	            	   int andar = Integer.parseInt (partes[5]);
	            	   financiamento = new Apartamento(tipoImovel, valorImovel, prazoFinanciamento,taxaJurosAnual,vagasGaragem,andar);
	               }
	               else if (tipoImovel == 3) {
	            	   int zona = Integer.parseInt(partes[4]);
	            	   financiamento = new Terreno (tipoImovel, valorImovel, prazoFinanciamento,taxaJurosAnual,zona);
	               }
	               if (financiamento != null) {
						listaFinanciamentos.add(financiamento);
	               }	
				}
			}
				}catch (IOException e) {
				e.printStackTrace();
				}
			return listaFinanciamentos;
		}
		
		// Método para salvar financiamento em arquivo serializado
		public static void salvarArquivoSerializado(ArrayList<Financiamento> listaFinanciamentos, String nomeArquivo) {
			try (ObjectOutputStream outputStream = new ObjectOutputStream (new FileOutputStream (nomeArquivo))) {
				outputStream.writeObject(listaFinanciamentos);
			} catch (IOException e) {
				e.printStackTrace();
				}
			}
		
		//Método para recuperar dados de arquivo serializado
		public static ArrayList <Financiamento> recuperarArquivoSerializado(String nomeArquivo) {
			ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();
			try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
			listaFinanciamentos = (ArrayList<Financiamento>) inputStream.readObject();
			
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return listaFinanciamentos;
		}
		
}