package br.senai.sc.automoveis.controller;
 
import br.senai.sc.automoveis.model.entities.*;
import br.senai.sc.automoveis.model.service.*;

import java.sql.SQLException;
import java.util.Set;

public class AutomovelController {
    public void cadastrar(Integer codigo, String marca, String modelo, String tipo) throws SQLException {
        AutomovelService service = new AutomovelService();
        Automovel automovel = Automovel.cadastrar(marca, modelo, codigo, tipo);
        service.inserir(tipo, automovel);
    }

    public void excluir(Integer codigo) throws SQLException {
        AutomovelService service = new AutomovelService();
        service.excluir(codigo);
    }

    public void editar(Integer codigo, String marca, String modelo, String tipo) throws SQLException {
        AutomovelService service = new AutomovelService(); 
        Automovel automovel = Automovel.editar(marca, modelo, codigo, tipo);
        service.editar(codigo, automovel);
    }

    public Set<Automovel> selecionarTodos() throws SQLException {
        AutomovelService service = new AutomovelService();
        return service.selecionarTodos();
    }
}
