package br.senai.sc.automoveis.model.dao;

import br.senai.sc.automoveis.model.entities.Cliente;
import br.senai.sc.automoveis.model.entities.Funcionario;
import br.senai.sc.automoveis.model.entities.Pessoa;
import br.senai.sc.automoveis.model.factory.ConexaoFactory;
import br.senai.sc.automoveis.model.factory.PessoaFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PessoaDAO {

    private static final Set<Pessoa> listaPessoas = new HashSet<>();
    private Connection connection;

    public PessoaDAO() {
        this.connection = new ConexaoFactory().conectaDB();
    }

    public void inserir(Pessoa pessoa) throws SQLException {
        String sql = "insert into pessoa(nome, senha, cpf, matricula, idade, tipo) values (?,?,?,?,?,?)";
        System.out.println("entrou");
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getSenha());
            statement.setString(3, pessoa.getCpf());
            statement.setInt(4, pessoa.getMatricula());
            statement.setInt(5, pessoa.getIdade());
            statement.setInt(6, (pessoa instanceof Cliente) ? 1 :
                    (pessoa instanceof Funcionario) ? 2 : 3);
            try {
                statement.execute();
            } catch (Exception exception) {
                throw new RuntimeException("Erro na execução sql");
            }
        } catch (Exception exception) {
            throw new RuntimeException("Erro na preparação sql");
        }
    }

    public Pessoa selecionarPorMatricula(Integer matricula) throws SQLException {
        String sql = "select * from pessoa where matricula = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, matricula);
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

    public void excluir(Integer matricula) throws SQLException {
        String sql = "delete from pessoa where matricula = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, matricula);
            try {
                statement.execute();
            } catch (Exception exception) {
                throw new RuntimeException("Erro na execucao");
            }
        } catch (Exception exception) {
            throw new RuntimeException("Erro na preparacao");
        }
    }

    public Set<Pessoa> selecionarTodos() throws SQLException {
        String sql = "select * from pessoa";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    listaPessoas.add(extrairObjeto(resultSet));
                }
                return listaPessoas;
            } catch (Exception exception) {
                throw new RuntimeException("Erro na execução sql");
            }
        } catch (Exception exception) {
            throw new RuntimeException("Erro na preparação sql");
        }
    }


    private Pessoa extrairObjeto(ResultSet resultSet) {
        try{
            return new PessoaFactory().getPessoas(
                resultSet.getString("nome"),
                resultSet.getString("senha"),
                resultSet.getString("cpf"),
                resultSet.getInt("matricula"),
                resultSet.getInt("idade"),
                resultSet.getInt("tipo")
            );
        }catch (Exception exception){
            throw new RuntimeException();
        }
    }


    public void editar(Integer matricula) throws SQLException{
    }
}
