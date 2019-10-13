package br.edu.uniandrade.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.uniandrade.dao.PedidoDAO;
import br.edu.uniandrade.entidade.Pedido;

@ManagedBean
@SessionScoped
public class PedidoBean {

	private Pedido pedido = new Pedido();
	private PedidoDAO pedidoDAO = new PedidoDAO();
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	public void adicionar() {
		pedidoDAO.salvar(pedido);
		pedido = new Pedido();
		FacesContext ctx = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Adicionado", "null");
		ctx.addMessage(null, msg);
	}
	
	public void listar(){
		pedidos = pedidoDAO.buscar();
	}
	
	public void deletar(Pedido p){
		pedidoDAO.deletar(p.getId());
		FacesContext ctx = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Deletado", "null");
		ctx.addMessage(null, msg);
	}
	
	public void editar(Pedido p){
		pedido = p;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
