package br.senai.sc.automoveis.model.dao;

import br.senai.sc.automoveis.model.entities.*;
import br.senai.sc.automoveis.model.factory.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class AutomovelDAO {
    private static final Set<Automovel> listaAutomoveis = new HashSet<>();
    private Connection connection;

    public AutomovelDAO() {
        this.connection = new ConexaoFactory().conectaDB();
    }

    /**
     * @param automovel
     * @throws SQLException
     * @author Vytor
     */
    public void inserir(String tipo, Automovel automovel) throws SQLException {
        String sql = "insert into automovel(codigo, marca, modelo, tipo) values (?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, automovel.getCodigo());
            statement.setString(2, automovel.getMarca());
            statement.setString(3, automovel.getModelo());
            statement.setString(4, tipo);
            try {
                statement.execute();
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * @param codigo
     * @param automovel
     * @throws SQLException
     */
    public void editar(Integer codigo, Automovel automovel) throws SQLException {
        String sql = "update automovel set marca = (?), modelo = (?) where codigo = (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, automovel.getMarca());
            statement.setString(2, automovel.getModelo());
            statement.setInt(3, codigo);
            try {
                statement.execute();
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * @param codigo
     * @return Automovel
     * @throws SQLException
     * @author Vytor
     */
    public Automovel selecionarPorCodigo(Integer codigo) throws SQLException {
        String sql = "select * from automovel where codigo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codigo);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extrairObjeto(resultSet);
                } else {
                    throw new RuntimeException("Erro na execução sql");
                }
            } catch (Exception exception) {
                throw new RuntimeException("Erro na preparaçao sql");
            }
        } catch (Exception exception) {
            throw new RuntimeException("Algo errado");
        }
    }

    /**
     * @param codigo
     * @throws SQLException
     * @author Vytor
     */
    public void excluir(Integer codigo) throws SQLException {
        String sql = "delete from automovel where codigo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codigo);
            try {
                statement.execute();
            } catch (Exception exception) {
                throw new RuntimeException("Erro na execucao");
            }
        } catch (Exception exception) {
            throw new RuntimeException("Erro na preparacao");
        }
    }

    /**
     * @return Set<Automovel>
     * @throws SQLException
     * @author Vytor
     */
    public Set<Automovel> selecionarTodos() throws SQLException {
        String sql = "select * from automovel";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    listaAutomoveis.add(extrairObjeto(resultSet));
                }
                return listaAutomoveis;
            } catch (Exception exception) {
                throw new RuntimeException(exception.getMessage());
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * @param resultSet
     * @return Automovel
     * @author Vytor
     */
    private Automovel extrairObjeto(ResultSet resultSet) {
        try {
            return new AutomovelFactory().getAutomoveis(
                    resultSet.getInt("codigo"),
                    resultSet.getString("marca"),
                    resultSet.getString("modelo"),
                    resultSet.getString("tipo")
            );
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
