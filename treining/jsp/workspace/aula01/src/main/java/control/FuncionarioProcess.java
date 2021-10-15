package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import model.Funcionario;

public class FuncionarioProcess {
	
	// escrevendo o arquivo
	public boolean cadastrar(Funcionario func) {
		try {
			FileWriter cad = new FileWriter("d:/cad.txt", true);
			BufferedWriter bw = new BufferedWriter(cad);
			
			String linha = func.getNome() + ";" +
						func.getDoc() + ";" +
						func.getNascimento() + ";" +
						func.getRegistro() + "\r\n";
			bw.write(linha);
			bw.close();
			cad.close();
			return true;
		}catch(Exception e) {
			System.out.println(e); 
		}
		return false;
	}
	
	// lendo o arquivo
	public ArrayList<String> lista() {
		ArrayList<String> data = new ArrayList<String>();
		
		try {
			FileReader fr = new FileReader("d:/cad.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine()) != null) {
				data.add(linha);
			}
			fr.close();
			br.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return data;
	}
	
	// editando o arquivo
	public boolean editar(Funcionario func) {
		ArrayList<String> data = lista();
		try {
			FileWriter fw = new FileWriter("d:/cad.txt", false); // passando o false ele apaga o dado e começa do 0
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i = 0; i < data.size(); i++) { //percorre a lista
				String linha = data.get(i);
				if(linha.contains(func.getDoc())){ // se contem aquele dado na lista, vão ser alterados
						linha = func.getNome() + ";" +
							func.getDoc() + ";" +
							func.getNascimento() + ";" +
							func.getRegistro();
					data.remove(i);
					data.add(i, linha);
				}
				bw.write(data.get(i) + "\r\n");
			}
			bw.close();
			fw.close();
			
			return true;
		}catch(Exception e) {
			
		}
		return false;
	}
	
	public boolean excluir(Funcionario func) {
		return false;
	}
}