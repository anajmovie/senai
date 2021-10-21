package servlet;

import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONArray;

import controller.EntregadorProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Entregador;


@WebServlet("/entregadores")
public class EntregadorREST extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// read
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		try {
			EntregadorProcess.carregarDados();
			
			// recebendo dados por parâmetro
			String id = req.getParameter("idEntregador");
			if(id != null) {
				if(EntregadorProcess.entregadores.contains(new Entregador(id))) {
					int ind = EntregadorProcess.entregadores.indexOf(new Entregador(id)); // obtem o indice
					resp.getWriter().print(EntregadorProcess.entregadores.get(ind).toJSON()); // nos da a resposta em formato json
				}else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			}else {
				JSONArray ja = new JSONArray(); // armazena cada objeto json
				EntregadorProcess.entregadores.forEach(en -> ja.put(en.toJSON())); // percorre preenchendo o vetor com dados da lista
				resp.getWriter().print(ja); // resposta, mostra o vetor json
			}
		} catch (SQLException e) {
			System.out.println("Erro ao carregar dados do SGBD: "+e);
		}
	}
	
	// delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		try {
			EntregadorProcess.carregarDados();
			
			String id = req.getParameter("idEntregador");
			if(id != null) {
				if(EntregadorProcess.entregadores.contains(new Entregador(id))) {
					int ind = EntregadorProcess.entregadores.indexOf(new Entregador(id));
					EntregadorProcess.entregadores.remove(ind);
				}else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao carregar dados do SGBD: "+e);
		}
	}
}