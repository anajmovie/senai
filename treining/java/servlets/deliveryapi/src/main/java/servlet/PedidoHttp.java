package servlet;

import java.io.IOException;
import org.json.JSONObject;
import controllers.PedidoProcess;
import domains.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pedidos")
public class PedidoHttp extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PedidoProcess.testes();
		for(Pedido p: PedidoProcess.pedidos) {
			resp.getWriter().print(p.toJSON());
		}
	}
}
