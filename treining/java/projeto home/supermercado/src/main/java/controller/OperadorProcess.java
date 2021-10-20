package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.OperadorDAO;
import model.Operador;

public class OperadorProcess {
	
	public static OperadorDAO od;
	public static ArrayList<Operador> operadores;
	
	public static void carregarDados() throws SQLException {
		od = new OperadorDAO();
		operadores = od.readAll();
	}
	
	public static void testes() {
		operadores = new ArrayList<>();
		operadores.add(new Operador(1, 1, "Franciely Souza", "11111111111"));
		operadores.add(new Operador(2, 5, "Marcia Nogueira", "11111111111"));
		operadores.add(new Operador(3, 8, "Gabrielly Mendes", "11111111111"));
		operadores.add(new Operador(4, 3, "Bruna Mello", "11111111111"));
	}
}