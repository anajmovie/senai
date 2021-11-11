package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.LoginDAO;
import model.Login;

public class LoginProcess {
	
	public static LoginDAO ld;
	public static ArrayList<Login> logins;
	public static Login login;
	
	// listando
	public static void carregarDados() throws SQLException {
		ld = new LoginDAO();
		logins = ld.readAll();
	}
}
