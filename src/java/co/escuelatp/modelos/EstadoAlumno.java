/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.modelos;

/**
 *
 * @author Luisk
 */
public class EstadoAlumno {
    // Atributos
    private int id;
    private String codigo;
    
    /*
    *Método constructor que recibe como parámero la id y el código
    */
    public EstadoAlumno(int id, String codigo) {
        this.id = id;
        this.codigo = codigo;
    }
    
     public EstadoAlumno(int id) {
        this.id = id;
        this.codigo = null;
    }
     
     public EstadoAlumno() {
        this.id = 0;
        this.codigo = null;
    }
   
    /*
    *Método get del  campo id
    */
    public int getId() {
        return id;
    }
    /*
    *Método get del  campo id
    */
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}


