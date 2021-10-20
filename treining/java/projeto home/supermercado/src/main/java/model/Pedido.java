package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Pedido {
	// atributos principais
	private int idPedido;
	private Cliente cliente;
	private Entregador entregador;
	private Operador caixa;
	private Date data;
	private Date horaPedido;
	private Date horaInicio;
	private Date horaFim;
	
	// atributos de formatação de hora e data
	private SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat fh = new SimpleDateFormat("hh:mm");
	
	// contrutor vazio
	public Pedido() {
		
	}
	
	public Pedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	// construtor do id - string
	public Pedido(String idPedido) {
		this.idPedido = Integer.valueOf(idPedido);
	}
	
	public Pedido(int idPedido, int idCliente, int idEntregador, int idCaixa) {
		this.idPedido = Integer.valueOf(idPedido);
		this.cliente = new Cliente(idCliente);
		this.entregador = new Entregador(idEntregador);
		this.caixa = new Operador(idCaixa);
	}
	
	// contrutor cheio
	public Pedido(int idPedido, Cliente cliente, Entregador entregador, Operador caixa, Date data, Date horaPedido,Date horaInicio, Date horaFim) {
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.entregador = entregador;
		this.caixa = caixa;
		this.data = data;
		this.horaPedido = horaPedido;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}
	
	// consturto cheio - string
	public Pedido(String idPedido, String idCliente, String idEntregador, String idCaixa, String data, String horaPedido,String horaInicio, String horaFim) {
		this.idPedido = Integer.valueOf(idPedido);
		this.cliente = new Cliente(idCliente);
		this.entregador = new Entregador(idEntregador);
		this.caixa = new Operador(idCaixa);
		try {
			this.data = fd.parse(data);
			this.horaPedido = fh.parse(horaPedido);
			this.horaInicio = fh.parse(horaInicio);
			this.horaFim = fh.parse(horaFim);
		} catch (ParseException e) {
			System.out.println("Erro de conversão de data e hora: "+e);
		}
	}

	// getter e setters
	public int getidPedido() {
		return idPedido;
	}

	public void setidPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public Operador getCaixa() {
		return caixa;
	}

	public void setCaixa(Operador caixa) {
		this.caixa = caixa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora_pedidPedidoo() {
		return horaPedido;
	}

	public void setHora_pedidPedidoo(Date horaPedido) {
		this.horaPedido = horaPedido;
	}

	public Date gethoraInicio() {
		return horaInicio;
	}

	public void sethoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date gethoraFim() {
		return horaFim;
	}

	public void sethoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	// hash e equals
	@Override
	public int hashCode() {
		return Objects.hash(idPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return idPedido == other.idPedido;
	}

	@Override
	public String toString() {
		if(horaInicio == null) {
			return idPedido + "\t" + cliente.getidCliente() + "\t" + entregador.getidEntregador() + "\t" + caixa.getIdCaixa() + "\t" + fd.format(data) + "\t" 
					+ fh.format(horaPedido) + "\tnull\tnull\n";
		} else if(horaFim == null) {
			return idPedido + "\t" + cliente.getidCliente() + "\t" + entregador.getidEntregador() + "\t" + caixa.getIdCaixa() + "\t" + fd.format(data) + "\t" 
					+ fh.format(horaPedido) + "\t" + fh.format(horaInicio) + "\tnull\n";
		}else {
			return idPedido + "\t" + cliente.getidCliente() + "\t" + entregador.getidEntregador() + "\t" + caixa.getIdCaixa() + "\t" + fd.format(data) + "\t" 
					+ fh.format(horaPedido) + "\t" + fh.format(horaInicio) + "\t" + fh.format(horaFim) + "\n";
		}
	}
	
	public String toCSV() {
		if(horaInicio == null) {
			return idPedido + ";" + cliente.getidCliente() + ";" + entregador.getidEntregador() + ";" + caixa.getIdCaixa() + ";" + fd.format(data) + ";" 
					+ fh.format(horaPedido) + ";null;null\r\n";
		} else if(horaFim == null) {
			return idPedido + ";" + cliente.getidCliente() + ";" + entregador.getidEntregador() + ";" + caixa.getIdCaixa() + ";" + fd.format(data) + ";" 
					+ fh.format(horaPedido) + ";" + fh.format(horaInicio) + ";null\r\n";
		} else {
			return idPedido + ";" + cliente.getidCliente() + ";" + entregador.getidEntregador() + ";" + caixa.getIdCaixa() + ";" + fd.format(data) + ";" 
					+ fh.format(horaPedido) + ";" + fh.format(horaInicio) + ";" + fh.format(horaFim) + "\r\n";
		}
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("idPedido", idPedido);
			if(cliente != null) {
				json.put("cliente", cliente.toJSON());
			}
			if(entregador != null) {
				json.put("entregador", entregador.toJSON());
			}
			if(caixa != null) {
				json.put("caixa", caixa.toJSON());
			}
			if(data != null) {
				json.put("data", fd.format(data));
			}
			if(horaPedido != null) {
				json.put("horaPedido", fh.format(horaPedido));
			}
			if(horaInicio != null) {
				json.put("horaInicio", fh.format(horaInicio));
			}
			if(horaFim != null) {
				json.put("horFim", fh.format(horaFim));
			}
		}catch(JSONException e) {
			System.out.println("Erro ao converter json: "+e);
		}
		return json;
	}
}