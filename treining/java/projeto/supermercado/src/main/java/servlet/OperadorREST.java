package servlet;

import java.io.IOException;
import org.json.JSONArray;

import controller.OperadorProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Operador;


@WebServlet("/operadores")
public class OperadorREST extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// read
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		OperadorProcess.testes();
		
		// recebendo dados por parâmetro
		String id = req.getParameter("idCaixa");
		if(id != null) {
			if(OperadorProcess.operadores.contains(new Operador(id))) {
				int ind = OperadorProcess.operadores.indexOf(new Operador(id)); // obtem o indice
				resp.getWriter().print(OperadorProcess.operadores.get(ind).toJSON()); // nos da a resposta em formato json
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}else {
			JSONArray ja = new JSONArray(); // armazena cada objeto json
			OperadorProcess.operadores.forEach(o -> ja.put(o.toJSON())); // percorre preenchendo o vetor com dados da lista
			resp.getWriter().print(ja); // resposta, mostra o vetor json
		}
	}
	
	// delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		OperadorProcess.testes();
		
		String id = req.getParameter("idCaixa");
		if(id != null) {
			if(OperadorProcess.operadores.contains(new Operador(id))) {
				int ind = OperadorProcess.operadores.indexOf(new Operador(id));
				OperadorProcess.operadores.remove(ind);
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}else {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}
}