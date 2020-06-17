package application;

import java.io.BufferedReader;
/* import da classe File, etapa 1 do código */
//import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* import da classe Scanner, etapa 1 do código */
//import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		// Etapa 1: Leitura simples com File e Scanner
		/*
		File file = new File("C:\\Cursos\\JDevTreinamento\\leitura-arquivo-txt\\in1.txt");
		Scanner sc = null;
		
		try {
			 sc = new Scanner(file);
			
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		*/
		
		// Etapa 2: FileReader e BufferedReader com controle manual
		/*
		String path = "C:\\Cursos\\JDevTreinamento\\leitura-arquivo-txt\\in1.txt";
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}	
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
		
		// Etapa 3: Usando bloco 'try with resources'
		/*
		String path = "C:\\Cursos\\JDevTreinamento\\leitura-arquivo-txt\\in1.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path)))  {
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		*/
		
		// Etapa 4: lendo arquivo CSV e instanciando uma lista de objetos
		
		String path = "C:\\Cursos\\JDevTreinamento\\leitura-arquivo-txt\\in2.txt";
		
		List<Product> products = new ArrayList<Product>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine(); // aqui será feito a leitura da primeira linha do arquivo, onde contém um cabeçalho
			line = br.readLine(); // aqui será feito a leitura da segunda linha do arquivo, onde contém o primeiro produto
			
			while (line != null) {
				String[] vect = line.split(",");
				
				String name = vect[0];
				Double price = Double.parseDouble(vect[1]);
				Integer quantity = Integer.parseInt(vect[2]);
				
				Product product = new Product(name, price, quantity);
				products.add(product);
				
				line = br.readLine();
			}
			
			System.out.println("PRODUCTS:");
			for (Product p : products) {
				System.out.println(p);
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
