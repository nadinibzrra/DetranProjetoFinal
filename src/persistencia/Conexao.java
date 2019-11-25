/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import java.sql.*;

/**
 *
 * @author Clara
 */
public class Conexao {
    private static final String USUARIO = "detran";	
	private static final String SENHA = "123";
	private static final String CAMINHO = "jdbc:h2:~/test";
	private static final String DRIVER = "org.h2.Driver";
	private Connection conexao;		
	
	public void conecta() {
		try {
			Class.forName(DRIVER); 
			conexao = DriverManager.getConnection(CAMINHO, USUARIO,SENHA);
                        System.out.println("CONECTOU!!!");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e);
		}
	}

	public void desconecta() {
		try {
			conexao.close();
                        System.out.println("DESCONECTOU..");
		} catch (SQLException ex) {
			System.err.println(ex);
		}
	}

	public Connection getConexao() {
		return conexao;
	}
	
}
