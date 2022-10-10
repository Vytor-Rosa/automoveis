package br.senai.sc.automoveis.controller;

import br.senai.sc.automoveis.model.entities.Pessoa;
import br.senai.sc.automoveis.model.service.*;

import java.sql.SQLException;
import java.util.Set;

public class PessoaController {
    public void cadastrar(String nome, String senha, String cpf, Integer matricula, Integer idade) throws SQLException {
        PessoaService service = new PessoaService();
        Pessoa pessoa = Pessoa.cadastrar(nome, senha, cpf, matricula, idade);
        service.inserir(pessoa);
    }
    public void excluir(Integer matricula) throws SQLException {
        PessoaService service = new PessoaService();
        service.excluir(matricula);
    }

    public Pessoa selecionarPorMatricula(Integer matricula) throws SQLException {
        PessoaService service = new PessoaService();
        return service.selecionarPorMatricula(matricula);
    }

    public Set<Pessoa> selecionarPorTipo(Integer tipo) throws SQLException{
        PessoaService service = new PessoaService();
        return service.selecionarPorTipo(tipo);
    }

    public void editar(Integer matricula, String nome, String senha, String cpf, Integer matriculaNova, Integer idade) throws SQLException {
        PessoaService service = new PessoaService();
        Pessoa pessoa = Pessoa.editar(nome , senha, cpf, matriculaNova, idade);
        service.editar(matricula, pessoa);
    }
}
