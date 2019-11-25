/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author Clara
 */
public class UsuarioDAO {
    private Conexao con = new Conexao();
     
    private final String INSERTUSUARIO = "INSERT INTO USUARIO (NOME,CPF, DATA_DE_NASCIMENTO,LOGIN,SENHA) VALUES (?,?,?,?,?)";
    private final String UPDATEUSUARIO = "UPDATE USUARIO SET NOME = ?, CPF = ?,DATA_DE_NASCIMENTO = ?,LOGIN = ? ,SENHA = ? WHERE ID = ?";
    private final String DELETEUSUARIO = "DELETE FROM USUARIO WHERE ID = ?";
    private final String LISTUSUARIO = "SELECT * FROM USUARIO ORDER BY ID";
    
    
     public boolean insertUsuario(Usuario u) throws SQLException{
        
        try{
            System.out.println("ESTOU ACESSANDO O BANCO");
            con.conecta();
            System.out.println("PASSEI DO CONECTA");
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTUSUARIO);
            System.out.println("ESTOU AQUI DEPOIS DA CONEXAO");

            System.out.println("ESTOU ACESSANDO AS CLASSES");
            preparaInstrucao.setString(1,u.getNome().toUpperCase());
            preparaInstrucao.setString(2,u.getCpf().toUpperCase());
            preparaInstrucao.setDate(3, new java.sql.Date(u.getData_de_nascimento().getTime()));
            preparaInstrucao.setString(4,u.getLogin().toUpperCase());
            preparaInstrucao.setString(5,u.getSenha().toUpperCase());
            System.out.println("ESTOU ACESSEI AS CLASSES");
            preparaInstrucao.execute();
            con.desconecta();

            System.out.println("DESCONECTEI");
                   
        return true;    
       }catch (SQLException e) {
           System.err.println(e);
        return false;    
        }
    }
     
     public boolean upadateUsuario(Usuario u) throws SQLException{
     
        try{
            System.out.println("conexao para editar");
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEUSUARIO);
            
            preparaInstrucao.setString(1, u.getNome().toUpperCase());
            preparaInstrucao.setString(2, u.getCpf().toUpperCase());
            preparaInstrucao.setDate(3, (Date) u.getData_de_nascimento()); //MUDANDO O TIPO
            preparaInstrucao.setString(4, u.getLogin().toUpperCase());
            preparaInstrucao.setString(5, u.getSenha().toUpperCase());
            preparaInstrucao.setInt(6, u.getId_usuario());
            
            System.out.println("conectei e editei");
            preparaInstrucao.execute();
            System.out.println("enviei para o banco");
            con.desconecta();

        return true;    
       }catch (SQLException e) {
           System.err.println(e);
        return false;    
        }
    }
     
     public boolean deleteUsuario(int id) throws SQLException{
        
        try{
            con.conecta();
            System.out.println("Estou conectado no banco para deletar");
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(DELETEUSUARIO);
            System.out.println("fiz conexao com o delete");
            preparaInstrucao.setInt(1, id);
            preparaInstrucao.execute();
            System.out.println("Deletei");
            con.desconecta();		
            return true;
	} catch (SQLException e) {
                System.err.println(e);
                return false;
        } 
    }
    
    public ArrayList<Usuario> listUsuario(){
      
      ArrayList<Usuario> lista = new ArrayList<>(); 

	try {
			
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTUSUARIO); 
			
            ResultSet rs = preparaInstrucao.executeQuery(); 
			
            while (rs.next()) { 
                
                Usuario u = new Usuario(
                        rs.getInt("ID"),
                        rs.getString("NOME"),
                        rs.getString("CPF"),
                        rs.getDate("DATA_DE_NASCIMENTO"),
                        rs.getString("LOGIN"),
                        rs.getString("SENHA")
                        );
		lista.add(u);               
            }           
            con.desconecta();
            
            } catch (SQLException e) {
                System.err.println(e);
            }
            return lista;
     
    }

}
