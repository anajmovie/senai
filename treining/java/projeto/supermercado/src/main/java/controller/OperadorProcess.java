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
	
	public static int autoIncrementId() {
		if(operadores.size()<=0) {
			return 1;
		}else {
			return operadores.get(operadores.size()-1).getIdCaixa()+1;
		}
	}
}