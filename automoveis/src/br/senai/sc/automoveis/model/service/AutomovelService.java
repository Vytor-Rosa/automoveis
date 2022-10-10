package br.senai.sc.automoveis.model.service;

import br.senai.sc.automoveis.model.dao.*;
import br.senai.sc.automoveis.model.entities.*;

import java.sql.SQLException;
import java.util.Set;

public class AutomovelService {
    public void inserir(String tipo, Automovel automovel) throws SQLException {
        new AutomovelDAO().inserir(tipo, automovel);
    }

    public Automovel selecionarPorCodigo(Integer codigo) throws SQLException {
        return new AutomovelDAO().selecionarPorCodigo(codigo);
    }

    public void excluir(Integer codigo) throws SQLException {
        new AutomovelDAO().excluir(codigo);
    }

    public void editar(Integer matricula, Automovel automovel) throws SQLException {
        new AutomovelDAO().editar(matricula, automovel);
    }

    public Set<Automovel> selecionarTodos() throws SQLException {
        return new AutomovelDAO().selecionarTodos();
    }
}
