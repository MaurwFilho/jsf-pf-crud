package br.edu.uniandrade.entidade;

public class Funcionario extends Pessoa {
	private String cpf;
	private double salario;
	private int comissao;
	double valorHora;

	public Funcionario(String nome, long rg, double valorHora) {
		super(nome, rg);
		if (valorHora < 0) {
			this.valorHora = 1;
		} else {
			this.valorHora = valorHora;

		}

	}

	public double getSalarioBruto(int nrHorasTrabalhadas) {
		return this.valorHora * nrHorasTrabalhadas;
	}

	public double getSalarioLiquido(double salarioBruto) {
		double inss = salarioBruto * 0.8;
		double ir = 0;
		if (salarioBruto >= 2000 && salarioBruto < 5000) {
			ir = salarioBruto * 0.15;
		}
		if (salarioBruto >= 5000) {
			ir = salarioBruto * 0.275;
		}
		if (salarioBruto >= 50000) {
			ir = salarioBruto * 0.5;
		}
		return salarioBruto - inss - ir;
	}

	public double getBonificacao() {
		return this.salario * 0.10;

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getComissao() {
		return comissao;
	}

	public void setComissao(int comissao) {
		this.comissao = comissao;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
}
