package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.EntregadorDAO;
import model.Entregador;

public class EntregadorProcess {
	
	public static EntregadorDAO ed;
	public static ArrayList<Entregador> entregadores;
	
	public static void carregarDados() throws SQLException {
		ed = new EntregadorDAO();
		entregadores = ed.readAll();
	}
	
	public static int autoIncrementId() {
		if(entregadores.size()<=0) {
			return 1;
		}else {
			return entregadores.get(entregadores.size()-1).getidEntregador()+1;
		}
	}
	
	public static void testes() {
		entregadores = new ArrayList<>();
		entregadores.add(new Entregador(1, "Osvaldo Silva", "moto, ABC1D34"));
		entregadores.add(new Entregador(2, "Murilo Bueno", "moto, CCV3F45"));
		entregadores.add(new Entregador(3, "Vinicius Mello", "bicicleta"));
		entregadores.add(new Entregador(4, "Bruno Vieira", "moto, HJL9Y76"));
	}
}