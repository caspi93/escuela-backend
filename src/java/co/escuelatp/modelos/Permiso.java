package co.escuelatp.modelos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luisk
 */
public class Permiso {
    //Atributos
    private int id;
    private String codigo;
    
    // Método constructor que recibe como parámetro la id y el código
    public Permiso(int id, String codigo) {
        this.id = id;
        this.codigo = codigo;
    }
    
    /*
    * Método get del campo id
    */
    public int getId() {
        return id;
    }
    
    /*
    * Método get del campo código
    */
    public String getCodigo() {
        return codigo;
    }
    
    
}
