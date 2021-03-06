package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	// atributos de conex?o com o banco de dados
	private static final String DNS = "jdbc:mysql://localhost:3306/spicemercado";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	private static Connection con;
	
	// metodo que faz a conex?o
	public static Connection getConnection() {
		try {
			if(con == null || con.isClosed()) {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				con = DriverManager.getConnection(DNS, USUARIO, SENHA);
			}
			return con;
		}catch(SQLException e) {
			System.out.println("Erro de conex?o com o banco de dados: "+e);
			return null;
		}
	}
}