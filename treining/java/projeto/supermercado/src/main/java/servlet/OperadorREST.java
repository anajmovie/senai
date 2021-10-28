package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.stream.Collectors;
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
	private PrintWriter out;
	
	// read
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		out = resp.getWriter();
		
		try {
			OperadorProcess.carregarDados();
			
			// recebendo dados por parâmetro
			String id = req.getParameter("idCaixa");
			if(id != null) {
				if(OperadorProcess.operadores.contains(new Operador(id))) {
					int ind = OperadorProcess.operadores.indexOf(new Operador(id)); // obtem o indice
					out.print(OperadorProcess.operadores.get(ind).toJSON()); // nos da a resposta em formato json
				}else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			}else {
				JSONArray ja = new JSONArray(); // armazena cada objeto json
				OperadorProcess.operadores.forEach(o -> ja.put(o.toJSON())); // percorre preenchendo o vetor com dados da lista
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
			int idCaixa = OperadorProcess.create(body);
			if(idCaixa > 0) {
				resp.setStatus(HttpServletResponse.SC_CREATED);
				out.print("{\"idCaixa\":"+idCaixa+"}");
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
		String idCaixa = req.getParameter("id_caixa");
		
		if(idCaixa != null) {
			try {
				if(OperadorProcess.delete(idCaixa)) {
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
				if(OperadorProcess.update(body)) {
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