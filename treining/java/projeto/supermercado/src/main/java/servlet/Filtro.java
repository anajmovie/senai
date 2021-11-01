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

@WebFilter("/*") // filtra todas as requisições da aplicação
public class Filtro implements Filter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		/*o getLocalAddr retorna o endereço IP da interface que a solicitação foi recebida e o 
		 * getRemoteAddr retorna o endereço IP do cliente que enviou a solicitação 
		 */ 
		
		if(req.getLocalAddr().equals(req.getRemoteAddr())) { // vai permitir requisições apenas do próprio endereço URL
			chain.doFilter(req, resp); // o próximo filtro na cadeia será chamado, quando a cadeia termina, invoca o servlet
		}else {
			JSONObject jo = new JSONObject();
			try {
				jo.put("erro", "Acesso negado");
			} catch (JSONException e) {
				System.out.println("Erro na conversão JSON: "+e);
			}
			resp.getWriter().print(jo.toString());
		}	
	}
}

	/* qualquer código colocado antes da chamada 'chain.doFilter()' 
	 * será executado na ida, e qualquer código depois, na volta
	 */
