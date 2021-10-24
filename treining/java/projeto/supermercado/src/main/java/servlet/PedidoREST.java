package servlet;

import java.io.IOException;
import java.sql.SQLException;

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
	
	// read
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		try {
			PedidoProcess.carregarDados();
			
			// recebendo dados por parâmetro
			String id = req.getParameter("idPedido");
			if(id != null) {
				if(PedidoProcess.pedidos.contains(new Pedido(id))) {
					int ind = PedidoProcess.pedidos.indexOf(new Pedido(id)); // obtem o indice
					resp.getWriter().print(PedidoProcess.pedidos.get(ind).toJSON()); // nos da a resposta em formato json
				}else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			}else {
				JSONArray ja = new JSONArray(); // armazena cada objeto json
				PedidoProcess.pedidos.forEach(p -> ja.put(p.toJSON())); // percorre preenchendo o vetor com dados da lista
				resp.getWriter().print(ja); // resposta, mostra o vetor json
			}
		} catch (SQLException e) {
			System.out.println("Erro ao carregar dados do SGBD: "+e);
		}
	}
}