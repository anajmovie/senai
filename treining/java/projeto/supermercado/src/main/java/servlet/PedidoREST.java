package servlet;

import java.io.IOException;
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
		resp.setCharacterEncoding("utf8"); // configura��o do charset
		
		PedidoProcess.testes();
		
		// recebendo dados por par�metro
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
	}
<<<<<<< HEAD
	
	// delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configura��o do charset
		
		PedidoProcess.testes();
		
		String id = req.getParameter("idPedido");
		if(id != null) {
			if(PedidoProcess.pedidos.contains(new Pedido(id))) {
				int ind = PedidoProcess.pedidos.indexOf(new Pedido(id));
				PedidoProcess.pedidos.remove(ind);
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}else {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}
=======
>>>>>>> 5cc34c1647d47740b91a84552c2d35ed9f3350f1
}