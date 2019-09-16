package co.escuelatp.modelos;

import java.util.ArrayList;

public class Rol {
    //Atributos
    private int id;
    private String nombre;
    private ArrayList<Permiso> permisos;

    //Método constructor que recibe como parámetro la id
    public Rol(int id) {
        this.id = id;
        this.nombre = null;
        this.permisos = new ArrayList<>();
    }
    
     /*
    * Método constructor que recibe como parámetro la id y el nombre
    */
    public Rol(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.permisos = new ArrayList<>();
    }
    
     public Rol() {
        this.id = 0;
        this.nombre = null;
        this.permisos = new ArrayList<>();
    }
    
    /*
    * Método que asigna los permisos
    */
    public void asignarPermisos(Permiso permiso) {
        permisos.add(permiso);
    }
    
    /*
    * Método get de la lista de permisos
    */
    public ArrayList<Permiso> getPermisos(){
        return permisos;
    }
    /*
     * Método get del campo id
     */
    public int getId() {
        return id;
    }
    
    /*
     * Método get del campo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
    ¨* Método get del campo nombre
     */

    public String getNombre() {
        return nombre;
    }

    /*
    ¨* Método set del campo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
