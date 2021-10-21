package servlet;

import java.io.IOException;
import java.sql.SQLException;
import org.json.JSONArray;
import controller.ClienteProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;

@WebServlet("/clientes")
public class ClienteREST extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// read
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		try {
			ClienteProcess.carregarDados(); //abrindo e lendo dados do banco
			
			// recebendo dados por parâmetro
			String id = req.getParameter("idCliente");
			if(id != null) { // verifica se chegou o parâmetro id
				if(ClienteProcess.clientes.contains(new Cliente(id))) { // se caso tiver o id na lista
					int ind = ClienteProcess.clientes.indexOf(new Cliente(id)); // obtem o indice
					resp.getWriter().print(ClienteProcess.clientes.get(ind).toJSON()); // nos da a resposta em formato json
				}else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // caso não tenha, mensagem de erro aparecerá
				}
			}else {
				JSONArray ja = new JSONArray(); // armazena cada objeto json
				ClienteProcess.clientes.forEach(c -> ja.put(c.toJSON())); // percorre preenchendo o vetor com dados da lista
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
			ClienteProcess.carregarDados();
			
			String id = req.getParameter("idCliente");
			if(id != null) {
				if(ClienteProcess.clientes.contains(new Cliente(id))) {
					int ind = ClienteProcess.clientes.indexOf(new Cliente(id));
					ClienteProcess.clientes.remove(ind);
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