package br.edu.uniandrade.entidade;

public class Pessoa {
	String nome;
	long rg;
	public Pessoa(String nome, long rg) {
		this.nome = nome;
		this.rg = rg;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getRg() {
		return rg;
	}
	public void setRg(long rg) {
		this.rg = rg;
	}

}
