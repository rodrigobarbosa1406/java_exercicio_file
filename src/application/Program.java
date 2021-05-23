package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Pedido;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pedido> pedido = new ArrayList<>();
		
		try {
			System.out.print("Informe o caminho do arquivo CSV: ");
			String strArquivoCSV = sc.nextLine();
			
			File arquivo = new File(strArquivoCSV);
			String diretorio = arquivo.getParent();
			String diretorioOut = diretorio + "\\out";
			String arquivoSummary = diretorio + "\\out\\summary.csv";
			
			try (BufferedReader br = new BufferedReader(new FileReader(strArquivoCSV))){
				String line = br.readLine();
				
				while (line != null) {
					String[] vetor = line.split(",");
					pedido.add(new Pedido(vetor[0], Double.parseDouble(vetor[1]), Integer.parseInt(vetor[2])));
					
					line = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			new File(diretorioOut).mkdir();
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSummary))){
				for (Pedido x : pedido) {
					bw.write(x.toString());
					bw.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}
