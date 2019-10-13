package br.edu.uniandrade.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.uniandrade.dao.ProdutoDAO;
import br.edu.uniandrade.entidade.Produto;

@ManagedBean
@SessionScoped
public class ProdutoBean {

	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<Produto>();
	private ProdutoDAO produtoDAO = new ProdutoDAO();

	public void adicionar() {
		produtoDAO.salvar(produto);
		produto = new Produto();
		FacesContext ctx = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Adicionado", "null");
		ctx.addMessage(null, msg);
	}

	public void listar() {
		produtos = produtoDAO.buscar();
	}

	public void deletar(Produto p) {
		produtoDAO.deletar(p.getId());
		FacesContext ctx = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado", "");
		ctx.addMessage(null, msg);
	}

	public void editar(Produto p) {
		produto = p;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
