package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import controll.PescadorProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pescador;

@WebServlet("/pescadores")
public class PescadorREST extends HttpServlet{

	private PrintWriter out;
	private JSONObject json;
	
	// read
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		resp.setContentType("application/json"); // configura a resposta no formato json
		resp.setCharacterEncoding("utf8"); // configuração do charset
		
		PescadorProcess pp = new PescadorProcess();
		try {
			JSONArray ja = pp.readAll();
			out.print(ja.toString());
		} catch (SQLException e) {
			System.out.println("Erro ao carregar dados do SGBD: "+e);
		} catch (JSONException e) {
			System.out.println("Erro ao converter JSON: "+e);
		}
	}
	
	// create
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			json = new JSONObject(body);	// convertendo para json
			String cidade = json.getString("cidade");
			int quantidade = json.getInt("quantidade");
			
			Pescador pesc = new Pescador(); // criando um novo objeto
			pesc.setCidade(cidade);
			pesc.setQuantidade(quantidade);
			
			PescadorProcess pp = new PescadorProcess();
			try {
				int idPesc = pp.create(pesc);
				if(idPesc > 0) {
					resp.setStatus(HttpServletResponse.SC_CREATED);
					out.print("{\"id\":"+idPesc+"}");
				}else {
					resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
				}
			} catch (SQLException e) {
				System.out.println("Erro ao carregar dados do SGBD: "+e);
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}
		} catch (JSONException e) {
			System.out.println("Erro ao converter JSON: "+e);
		}
	}
	
	// delete
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		PescadorProcess pp = new PescadorProcess();
		
		String tempId = req.getParameter("id");
		int id = Integer.parseInt(tempId);
		try {
			if(pp.delete(id) == false) {
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			}else {
				resp.setStatus(HttpServletResponse.SC_OK);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao carregar dados do SGBD: "+e);
		}
	}
	
	// update
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		PescadorProcess pp = new PescadorProcess();
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			json = new JSONObject(body);
			String cidade = json.getString("cidade");
			int quantidade = json.getInt("quantidade");
			int id = json.getInt("id");
			
			Pescador pesc = new Pescador();
			pesc.setCidade(cidade);
			pesc.setQuantidade(quantidade);
			pesc.setId(id);
			
			try {
				if(pp.update(pesc) == 1) {
					out.print(json.toString());
					resp.setStatus(HttpServletResponse.SC_GONE);
				}else {
					resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
				}
			} catch (SQLException e) {
				System.out.println("Erro ao carregar dados do SGBD: "+e);
			}
		} catch (JSONException e) {
			System.out.println("Erro ao converter JSON: "+e);
		}
	}
}