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
import modelo.Prova;

/**
 *
 * @author Clara
 */
public class ProvaDAO {
     private Conexao con = new Conexao();
     
    private final String INSERTPROVA = "INSERT INTO PROVA (CATEGORIA,DIA_DATA) VALUES (?,?)";
    private final String UPDATEPROVA = "UPDATE PROVA SET CATEGORIA = ?, DIA_DATA = ? WHERE ID = ?";
    private final String DELETEPROVA = "DELETE FROM PROVA WHERE ID = ?";
    private final String LISTPROVA = "SELECT * FROM PROVA ORDER BY ID";
   
    
    public boolean insertProva(Prova p) throws SQLException{
        
        try{
            System.out.println("ESTOU ACESSANDO O BANCO");
            con.conecta();
            System.out.println("PASSEI DO CONECTA");
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTPROVA);
            System.out.println("ESTOU AQUI DEPOIS DA CONEXAO");

            System.out.println("ESTOU ACESSANDO AS CLASSES");
            preparaInstrucao.setString(1, p.getCategoria().toUpperCase());
            preparaInstrucao.setDate(2, new java.sql.Date(p.getDia_data().getTime()));
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
    
     public boolean upadateProva(Prova p) throws SQLException{
     
        try{
            System.out.println("conexao para editar");
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEPROVA);
            
            preparaInstrucao.setString(1, p.getCategoria().toUpperCase());
            preparaInstrucao.setDate(2, (Date) p.getDia_data()); //MUDANDO O TIPO
            preparaInstrucao.setInt(3, p.getId_prova());
            
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
     
     public boolean deleteProva(int id) throws SQLException{
        
        try{
            con.conecta();
            System.out.println("Estou conectado no banco para deletar");
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(DELETEPROVA);
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
    
    public ArrayList<Prova> listProva(){
      
      ArrayList<Prova> lista = new ArrayList<>(); 

	try {
			
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTPROVA); 
			
            ResultSet rs = preparaInstrucao.executeQuery(); 
			
            while (rs.next()) { 
                
                Prova p = new Prova(
                        rs.getInt("ID"),
                        rs.getString("CATEGORIA"),
                        rs.getDate("DIA_DATA")
                        );
		lista.add(p);               
            }           
            con.desconecta();
            
            } catch (SQLException e) {
                System.err.println(e);
            }
            return lista;
     
    }

}
