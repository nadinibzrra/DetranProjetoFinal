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
public class Prova {
    
    private int id_prova;
    private String categoria;
    private Date dia_data;

    public Prova(int id_prova, String categoria, Date dia_data) {
        this.id_prova = id_prova;
        this.categoria = categoria;
        this.dia_data = dia_data;
    }

    public Prova(String categoria, Date dia_data) {
        this.categoria = categoria;
        this.dia_data = dia_data;
    }
    

    public int getId_prova() {
        return id_prova;
    }

    public void setId_prova(int id_prova) {
        this.id_prova = id_prova;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getDia_data() {
        return dia_data;
    }

    public void setDia_data(Date dia_data) {
        this.dia_data = dia_data;
    }

    @Override
    public String toString() {
        return "Prova{" + "id_prova=" + id_prova + ", categoria=" + categoria + ", dia_data=" + dia_data + '}';
    }
    
}
