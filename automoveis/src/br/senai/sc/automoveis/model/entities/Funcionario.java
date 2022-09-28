package br.senai.sc.automoveis.model.entities;

public class Funcionario extends Pessoa{
	String bbb;

	@Override
	public String toString() {
		return super.toString() + "\nbbb: " + bbb;
	}
	
	public String getBbb() {
		return bbb;
	}

	public void setBbb(String bbb) {
		this.bbb = bbb;
	}

	public Funcionario(String nome, String senha, String cpf, int matricula, int idade, String bbb) {
		super(nome, senha, cpf, matricula, idade);
		this.bbb = bbb;
	}

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String senha, String cpf, int matricula, int idade) {
		super(nome, senha, cpf, matricula, idade);
	}
}
