package br.senai.sc.automoveis.model.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {
    private String url = "jdbc:mysql://localhost:3306/mydb";
    private String username = "root";
    private String password = "root";
    public Connection conectaDB() {
        try{
            return DriverManager.getConnection(url, username, password);
        }catch (Exception exception){
            exception.printStackTrace();
            throw new RuntimeException("Erro na conexão!");
        }
    }
}
