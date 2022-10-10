package br.senai.sc.automoveis.model.entities;

import automoveis.*;
import br.senai.sc.automoveis.model.factory.*;

public class Pessoa {
	String nome, senha, cpf;
	int matricula, idade;

	@Override
	public String toString() {
		return "\n[nome: " + nome + "\nsenha: " + senha + "\ncpf: " + cpf + "\nmatricula: " + matricula + "\nidade: "
				+ idade + "]";
	}

	public static Pessoa cadastrar(String nome, String senha, String cpf, Integer matricula, Integer idade){
		Integer tipo = 1;
		if(Main.usuario instanceof Dono){
			tipo = 2;
			return new PessoaFactory().getPessoas(nome, senha, cpf, matricula, idade, tipo);
		}
		return new PessoaFactory().getPessoas(nome, senha, cpf, matricula, idade, tipo);
	}

	public static Pessoa editar(String nome, String senha, String cpf, Integer matricula, Integer idade){
			return new PessoaFactory().getPessoas(nome, senha, cpf, matricula, idade);
	}

	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}
	public String getCpf() {
		return cpf;
	}
	public int getMatricula() {
		return matricula;
	}
	public int getIdade() {
		return idade;
	}

	public Pessoa(String nome, String senha, String cpf, int matricula, int idade) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.matricula = matricula;
		this.idade = idade;
	}
	
}
