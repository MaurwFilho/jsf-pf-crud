package br.edu.uniandrade.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.uniandrade.dao.ClienteDAO;
import br.edu.uniandrade.entidade.Cliente;

@ManagedBean
@SessionScoped
public class ClienteBean {

	private Cliente cliente = new Cliente();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private ClienteDAO clienteDAO = new ClienteDAO(); 

	public void cadastrar() {
		boolean flagCadastro = clienteDAO.salvar(cliente);
		//clienteDAO.salvar(cliente);
		cliente = new Cliente();
		
		if(flagCadastro){
			FacesContext ctx = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado!", "Cadastro realizado!");
			ctx.addMessage(null, msg);
		}
		else{
			FacesContext ctx = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao cadastrar!", "Falha ao cadastrar");
			ctx.addMessage(null, msg);
		}
	}

	public String verificar(){
		boolean controle = clienteDAO.verificar(cliente);
		if (controle){
			return "index";
		}else {
			FacesContext ctx = FacesContext.getCurrentInstance();
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário inválido", "Usuário inválido");
	        ctx.addMessage(null, msg);

		}
		return null;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
