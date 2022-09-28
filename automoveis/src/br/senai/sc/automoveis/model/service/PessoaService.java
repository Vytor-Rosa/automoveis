package br.senai.sc.automoveis.model.service;

import br.senai.sc.automoveis.model.dao.PessoaDAO;
import br.senai.sc.automoveis.model.entities.Pessoa;

import java.sql.SQLException;
import java.util.Set;

public class PessoaService {

    public void inserir(Pessoa pessoa) throws SQLException {
        new PessoaDAO().inserir(pessoa);
    }

    public Pessoa selecionarPorMatricula(Integer matricula) throws SQLException {
        return new PessoaDAO().selecionarPorMatricula(matricula);
    }

    public void excluir(Integer matricula) throws  SQLException{
        new PessoaDAO().excluir(matricula);
    }

    public Set<Pessoa> selecionarTodos() throws SQLException{
        return new PessoaDAO().selecionarTodos();
    }
}
