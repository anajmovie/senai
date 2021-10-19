package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
		
		ClienteProcess.testes(); //abrindo e lendo dados do banco
		
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
	}

	// create
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClienteProcess.testes(); // abrindo e lendo os dados do banco
		
		//lendo o corpo da requisição http
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			// decodificando o corpo em json
			JSONObject json = new JSONObject(body);
			String cpf = json.getString("cpf"); // pega o parâmetro json
			String nome = json.getString("nome");
			String email = json.getString("email");
			String senha = json.getString("senha");
			String endereco = json.getString("endereco");
			String telefone = json.getString("telefone");
			
			// adiciona a lista
			ClienteProcess.clientes.add(new Cliente(cpf, nome, email, senha, endereco, telefone));
			resp.setStatus(HttpServletResponse.SC_CREATED);
		}catch(JSONException e) {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}
	
	// delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClienteProcess.testes(); // abrindo e lendo os dados do banco
		
		// recebendo os dados por parametro
		String id = req.getParameter("idCliente");
		if(id != null) { // verifica se chegou o parametro id
			if(ClienteProcess.clientes.contains(id)) {
				int ind = ClienteProcess.clientes.indexOf(new Cliente(id)); // obtem o indice
				ClienteProcess.clientes.remove(ind); // remove esse id da lista
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}
}