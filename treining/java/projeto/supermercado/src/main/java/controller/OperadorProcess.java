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
	
<<<<<<< HEAD
	public static int autoIncrementId() {
		if(operadores.size()<=0) {
			return 1;
		}else {
			return operadores.get(operadores.size()-1).getIdCaixa()+1;
		}
	}
	
=======
>>>>>>> 5cc34c1647d47740b91a84552c2d35ed9f3350f1
	public static void testes() {
		operadores = new ArrayList<>();
		operadores.add(new Operador(1, 1, "Franciely Souza", "11111111111"));
		operadores.add(new Operador(2, 5, "Marcia Nogueira", "11111111111"));
		operadores.add(new Operador(3, 8, "Gabrielly Mendes", "11111111111"));
		operadores.add(new Operador(4, 3, "Bruna Mello", "11111111111"));
	}
}