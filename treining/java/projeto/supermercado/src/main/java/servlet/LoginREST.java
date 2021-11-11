package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.json.JSONArray;

import controller.LoginProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Login;

@WebServlet("/logins")
public class LoginREST extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	
	// read
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8");		// configuração do charset
		
		out = resp.getWriter();
		
		try {
			LoginProcess.carregarDados();
			String id = req.getParameter("idCliente"); // recebendo dados por parâmetro
			if(id != null ) {
				if(LoginProcess.logins.contains(new Login(id))) {
					int ind = LoginProcess.logins.indexOf(new Login(id));	// obtem o indice
					out.print(LoginProcess.logins.get(ind).toJSON());		// nos da a resposta em formato json
				}else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			}else {
				JSONArray ja = new JSONArray();							// armazena cada objeto json
				LoginProcess.logins.forEach(l -> ja.put(l.toJSON()));	// percorre preenchendo o vetor com dados da lista
				out.print(ja);											// resposta, mostra o vetor json
			}
		} catch (SQLException e) {
			System.out.println("Erro ao carregar dados do SGBD: "+e);
		}
	}
}
