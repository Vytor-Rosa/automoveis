package br.senai.sc.automoveis.model.entities;

public class Cliente extends Pessoa{
    public Cliente(String nome, String senha, String cpf, int matricula, int idade) {
        super(nome, senha, cpf, matricula, idade);
    }

    public Cliente() {
    }
}
