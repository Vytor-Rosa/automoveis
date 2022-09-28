package br.senai.sc.automoveis.model.entities;

public class Dono extends Pessoa{
	String aaa;

	@Override
	public String toString() {
		return super.toString() + "\naaa: " + aaa;
	}

	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	public Dono(String nome, String senha, String cpf, int matricula, int idade, String aaa) {
		super(nome, senha, cpf, matricula, idade);
		this.aaa = aaa;
	}

	public Dono() {
		super();
	}

	public Dono(String nome, String senha, String cpf, int matricula, int idade) {
		super(nome, senha, cpf, matricula, idade);
	}
}
