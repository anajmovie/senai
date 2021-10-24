package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import dao.OperadorDAO;
import model.Operador;

public class OperadorProcess {
	
	public static OperadorDAO od;
	public static ArrayList<Operador> operadores;
	private static JSONObject jo;
	public static Operador operador;
	
	public static int autoIncrementId() {
		if(operadores.size()<=0) {
			return 1;
		}else {
			return operadores.get(operadores.size()-1).getIdCaixa()+1;
		}
	}
	
	//listando
	public static void carregarDados() throws SQLException {
		od = new OperadorDAO();
		operadores = od.readAll();
	}
	
	// deletando
	public static boolean delete(String idCaixa) throws SQLException {
		od = new OperadorDAO();
		return od.delete(idCaixa);
	}
	
	// criando
	public static int create(String body) throws SQLException {
		od = new OperadorDAO();
		try {
			jo = new JSONObject(body);
			operador = new Operador();
			operador.setIdFuncionario(jo.getInt("id_funcionario"));
			operador.setnomeCompleto(jo.getString("nome_completo"));
			operador.setCpf(jo.getString("cpf"));
		} catch (JSONException e) {
			System.out.println("Erro ao receber JSON: "+e);
		}
		return od.create(operador);
	}
}