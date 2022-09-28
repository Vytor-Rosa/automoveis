package br.senai.sc.automoveis.model.factory;

import br.senai.sc.automoveis.model.entities.*;

public class PessoaFactory {
    public Pessoa getPessoas(String nome, String senha, String cpf, Integer matricula, Integer idade, Integer tipo) {
        switch (tipo) {
            case 1 -> {
                return new Cliente(nome, senha, cpf, matricula, idade);
            }
            case 2 -> {
                return new Funcionario(nome, senha, cpf, matricula, idade);
            }
            default -> {
                return new Dono(nome, senha, cpf, matricula, idade);
            }
        }
    }

}
