package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import dao.LoginDAO;
import model.Cliente;
import model.Login;

public class LoginProcess {
	
	public static LoginDAO ld;
	public static ArrayList<Login> logins;
	public static Login login;
	private static JSONObject jo;
	
	// listando
	public static void carregarDados() throws SQLException {
		ld = new LoginDAO();
		logins = ld.readAll();
	}
	
	// criando
	public static int create(String body) throws SQLException {
		ld = new LoginDAO();
		try {
			jo = new JSONObject(body);
			login = new Login();
			login.setCliente(new Cliente(jo.getString("email"), jo.getString("senha")));
		} catch (JSONException e) {
			System.out.println("Erro ao receber JSON: "+e);
		}
		return ld.create(login);
	}
	
	// deletando
	public static boolean delete(String idCliente) throws SQLException {
		ld = new LoginDAO();
		return ld.delete(idCliente);
	}
	
	// editando
	public static boolean update(String body) throws SQLException {
		ld = new LoginDAO();
		try {
			jo = new JSONObject(body);
			login = new Login();
			login.setCliente(new Cliente(jo.getInt("id_cliente"), jo.getString("email"), jo.getString("senha")));
		} catch (JSONException e) {
			System.out.println("Erro ao receber JSON: "+e);
		}
		return ld.update(login) > 0;
	}
}