package servlet;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/*") // filtra todas as requisi��es da aplica��o
public class Filtro implements Filter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		/*o getLocalAddr retorna o endere�o IP da interface que a solicita��o foi recebida e o 
		 * getRemoteAddr retorna o endere�o IP do cliente que enviou a solicita��o 
		 */ 
		
		if(req.getLocalAddr().equals(req.getRemoteAddr())) { // vai permitir requisi��es apenas do pr�prio endere�o URL
			chain.doFilter(req, resp); // o pr�ximo filtro na cadeia ser� chamado, quando a cadeia termina, invoca o servlet
		}else {
			JSONObject jo = new JSONObject();
			try {
				jo.put("erro", "Acesso negado");
			} catch (JSONException e) {
				System.out.println("Erro na convers�o JSON: "+e);
			}
			resp.getWriter().print(jo.toString());
		}	
	}
}

	/* qualquer c�digo colocado antes da chamada 'chain.doFilter()' 
	 * ser� executado na ida, e qualquer c�digo depois, na volta
	 */
