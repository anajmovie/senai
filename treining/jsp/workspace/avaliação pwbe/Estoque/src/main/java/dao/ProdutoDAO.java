package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import control.ProdutoProcess;
import model.Produto;

public class ProdutoDAO {
	
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "c:\\dbs\\produtos.csv";
	private ArrayList<Produto> produtos;
	private Produto produto;
	
	// metodo de leitura de arquivo
	public ArrayList<Produto> abrir(){
		
		produtos = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String line = "";
			while((line = br.readLine()) != null) { // enquanto tiver dados para ser lidos no arquivo, vai ser armazenado na variavel 'line',
				produto = new Produto(line.split(";")); // os atributos serão separados por ;
				produtos.add(produto);
			}
			br.close();
		}catch(Exception e) {
			System.out.println("Erro ao ler o arquivo "+e);
		}
		return produtos; // nos retorna a lista
	}
	
	// metodo de gravação de arquivo
	public void salvar(ArrayList<Produto> produtos) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo, false));
			for(Produto p: ProdutoProcess.produtos) { // percorre a lista produtos
				bw.write(p.toCSV()); // tudo o que foi percorrido é escrito no arquivo CSV
			}
			bw.close();
		}catch(Exception e) {
			System.out.println("Erro ao gravar arquivo "+e);
		}
	}
}
