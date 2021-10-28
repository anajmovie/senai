package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.stream.Collectors;
import org.json.JSONArray;
import controller.PedidoProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pedido;

@WebServlet("/pedidos")
public class PedidoREST extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	
	// read
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		out = resp.getWriter();
		
		try {
			PedidoProcess.carregarDados();
			
			// recebendo dados por parâmetro
			String id = req.getParameter("idPedido");
			if(id != null) {
				if(PedidoProcess.pedidos.contains(new Pedido(id))) {
					int ind = PedidoProcess.pedidos.indexOf(new Pedido(id)); // obtem o indice
					out.print(PedidoProcess.pedidos.get(ind).toJSON()); // nos da a resposta em formato json
				}else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			}else {
				JSONArray ja = new JSONArray(); // armazena cada objeto json
				PedidoProcess.pedidos.forEach(p -> ja.put(p.toJSON())); // percorre preenchendo o vetor com dados da lista
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
			int idPedido = PedidoProcess.create(body);
			if(idPedido > 0) {
				resp.setStatus(HttpServletResponse.SC_CREATED);
				out.print("{\"idPedido\":"+idPedido+"}");
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao carregar dados do SGBD: "+e);
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}
	
	// delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		String idPedido = req.getParameter("id_pedido");
		if (idPedido != null) {
			try {
				if (PedidoProcess.delete(idPedido)) {
					resp.setStatus(HttpServletResponse.SC_OK);
				} else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			} catch (SQLException e) {
				System.out.println("Erro ao conectar com SGBD: " + e);
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			out.print("{ \"erro\":\"Necessário o parâmetro 'id' para exclusão\"}");
		}
	}
	
	// update
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		String body = req.getReader().readLine();
		
		if(body != null) {
			req.getReader().reset();
			body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			try {
				if(PedidoProcess.update(body)) {
					resp.setStatus(HttpServletResponse.SC_GONE);
				}
			} catch (SQLException e) {
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
				out.print("{ \"erro\":\"Erro ao conectar ao SGBD: "+ e +"\"}");
			}
		}else {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}
}