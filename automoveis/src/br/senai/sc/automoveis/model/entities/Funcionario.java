package br.senai.sc.automoveis.model.entities;

public class Funcionario extends Pessoa{
	String setor;

	@Override
	public String toString() {
		return super.toString() + "\nsetor: " + setor;
	}

	public Funcionario(String nome, String senha, String cpf, int matricula, int idade, String bbb) {
		super(nome, senha, cpf, matricula, idade);
		this.setor = bbb;
	}

	public Funcionario(String nome, String senha, String cpf, int matricula, int idade) {
		super(nome, senha, cpf, matricula, idade);
	}
}
