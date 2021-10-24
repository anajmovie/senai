package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.stream.Collectors;
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
	private PrintWriter out;
	
	// read
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		out = resp.getWriter();
		
		try {
			ClienteProcess.carregarDados();
			
			// recebendo dados por parâmetro
			String id = req.getParameter("idCliente");
			if(id != null) { // verifica se chegou o parâmetro id
				if(ClienteProcess.clientes.contains(new Cliente(id))) { // se caso tiver o id na lista
					int ind = ClienteProcess.clientes.indexOf(new Cliente(id)); // obtem o indice
					out.print(ClienteProcess.clientes.get(ind).toJSON()); // nos da a resposta em formato json
				}else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // caso não tenha, mensagem de erro aparecerá
				}
			}else {
				JSONArray ja = new JSONArray(); // armazena cada objeto json
				ClienteProcess.clientes.forEach(c -> ja.put(c.toJSON())); // percorre preenchendo o vetor com dados da lista
				out.print(ja); // resposta, mostra o vetor json
			}
		} catch (SQLException e) {
			System.out.println("Erro ao carregar dados do SGBD: "+e);
		}
	}
	
	// create
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			int idCliente = ClienteProcess.create(body);
			if(idCliente > 0) {
				resp.setStatus(HttpServletResponse.SC_CREATED);
				out.print("{\"idCliente\":"+idCliente+"}");
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao carregar dados do SGBD: "+e);
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}
	
	// delete
	/*@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		String idCliente = req.getParameter("idCliente");
		
		if(idCliente != null) {
			try {
				if(ProdutoProcess.delete(idCliente)) {
					resp.setStatus(HttpServletResponse.SC_OK);
				}else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			} catch (SQLException e) {
				System.out.println("Erro ao carregar dados do SGBD: "+e);
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		}else {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			out.print("{ \"erro\":\"É necessário o parâmetro 'id' para a exclusão\"}");
		}
	}*/
}