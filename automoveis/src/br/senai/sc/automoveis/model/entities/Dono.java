package br.senai.sc.automoveis.model.entities;

public class Dono extends Pessoa{
	String concessionaria;

	@Override
	public String toString() {
		return super.toString() + "\nconcessionaria: " + concessionaria;
	}

	public Dono(String nome, String senha, String cpf, int matricula, int idade, String aaa) {
		super(nome, senha, cpf, matricula, idade);
		this.concessionaria = aaa;
	}

	public Dono(String nome, String senha, String cpf, int matricula, int idade) {
		super(nome, senha, cpf, matricula, idade);
	}
}
