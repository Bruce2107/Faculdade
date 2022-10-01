package org.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conexao = null;

    public static Connection getConexao() throws ClassNotFoundException, SQLException {
    	String senha = "senha";
        if (conexao == null) {
            String url = "jdbc:postgresql://localhost:5432/Trabalho_POO";
            String usuario = "user";
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);
        }
        return conexao;
    }

    
    

}
