package servlet;

import java.io.IOException;
import org.json.JSONArray;

import controller.ItemProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ItemPedido;

@WebServlet("/itens")
public class ItemREST extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// read
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		ItemProcess.testes();
		
		// recebendo dados por parâmetro
		String id = req.getParameter("idPedido");
		if(id != null) {
			if(ItemProcess.itens.contains(new ItemPedido(id))) {
				int ind = ItemProcess.itens.indexOf(new ItemPedido(id)); // obtem o indice
				resp.getWriter().print(ItemProcess.itens.get(ind).toJSON()); // nos da a resposta em formato json
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}else {
			JSONArray ja = new JSONArray(); // armazena cada objeto json
			ItemProcess.itens.forEach(i -> ja.put(i.toJSON())); // percorre preenchendo o vetor com dados da lista
			resp.getWriter().print(ja); // resposta, mostra o vetor json
		}
	}
	
	// delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		ItemProcess.testes();
		
		String id = req.getParameter("idPedido");
		if(id != null) {
			if(ItemProcess.itens.contains(new ItemPedido(id))) {
				int ind = ItemProcess.itens.indexOf(new ItemPedido(id));
				ItemProcess.itens.remove(ind);
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}else {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}
}