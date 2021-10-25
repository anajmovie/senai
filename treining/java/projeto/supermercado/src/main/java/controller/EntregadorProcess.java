package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import dao.EntregadorDAO;
import model.Entregador;

public class EntregadorProcess {
	
	public static EntregadorDAO ed;
	public static ArrayList<Entregador> entregadores;
	private static JSONObject jo;
	public static Entregador entregador;
	
	public static int autoIncrementId() {
		if(entregadores.size()<=0) {
			return 1;
		}else {
			return entregadores.get(entregadores.size()-1).getidEntregador()+1;
		}
	}
	
	// listando
	public static void carregarDados() throws SQLException {
		ed = new EntregadorDAO();
		entregadores = ed.readAll();
	}
	
	// criando
	public static int create(String body) throws SQLException {
		ed = new EntregadorDAO();
		try {
			jo = new JSONObject(body);
			entregador = new Entregador();
			entregador.setnomeCompleto(jo.getString("nome_completo"));
			entregador.setVeiculo(jo.getString("veiculo"));
		} catch (JSONException e) {
			System.out.println("Erro ao receber JSON: "+e);
		}
		return ed.create(entregador);
	}
	
	// deletando
	public static boolean delete(String idEntregador) throws SQLException {
		ed = new EntregadorDAO();
		return ed.delete(idEntregador);
	}
}