package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.stream.Collectors;

import org.json.JSONArray;
import controller.ProdutoProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;

@WebServlet("/produtos")
public class ProdutoREST extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	
	// read
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		out = resp.getWriter();
		
		try {
			ProdutoProcess.carregarDados();
			
			// recebendo dados por parâmetro
			String id = req.getParameter("idProduto");
			if(id != null) {
				if(ProdutoProcess.produtos.contains(new Produto(id))) {
					int ind = ProdutoProcess.produtos.indexOf(new Produto(id)); // obtem o indice
					out.print(ProdutoProcess.produtos.get(ind).toJSON()); // nos da a resposta em formato json
				}else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			}else {
				JSONArray ja = new JSONArray(); // armazena cada objeto json
				ProdutoProcess.produtos.forEach(p -> ja.put(p.toJSON())); // percorre preenchendo o vetor com dados da lista
				out.print(ja); // resposta, mostra o vetor json
			}
		} catch (SQLException e) {
			System.out.println("Erro aocarregar dados do SGBD: "+e);
		}
	}
	
	// create
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		out = resp.getWriter();
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			int idProduto = ProdutoProcess.create(body);
			if(idProduto > 0) {
				resp.setStatus(HttpServletResponse.SC_CREATED);
				out.print("{\"id_produto\":"+idProduto+"}");
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
		String idProduto = req.getParameter("id_produto");
		
		if(idProduto != null) {
			try {
				if(ProdutoProcess.delete(idProduto)) {
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
}