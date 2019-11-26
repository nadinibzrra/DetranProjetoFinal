/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Clara
 */
public class Usuario {
    
    private int id_usuario;
    private String nome;
    private String cpf;
    private Date data_de_nascimento;
    private String login;
    private String senha;
       
    public Usuario(int id_usuario, String nome, String cpf, Date data_de_nascimento, String login, String senha) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.cpf = cpf;
        this.data_de_nascimento = data_de_nascimento;
        this.login = login;
        this.senha = senha;
    }
    
     public Usuario(String nome, String cpf, Date data_de_nascimento, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_de_nascimento = data_de_nascimento;
        this.login = login;
        this.senha = senha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(Date data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "login=" + login + ", senha=" + senha;
    }
    
    
    
    
    
}
