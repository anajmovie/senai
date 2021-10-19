package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.OperadorDAO;
import model.Operador;

public class OperadorProcess {
	
	private static OperadorDAO od;
	private static ArrayList<Operador> operadores;
	
	public static void carregarDados() throws SQLException {
		od = new OperadorDAO();
		operadores = od.readAll();
	}
}