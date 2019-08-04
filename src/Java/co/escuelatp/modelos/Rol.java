package co.escuelatp.modelos;

import java.util.ArrayList;

public class Rol {
    //Atributos
    private int id;
    private String nombre;
    private ArrayList<Permiso> permisos;

    //Método constructor
    public Rol(int id) {
        this.id = id;
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
    ¨* Método get del campo rolId
     */
    public int getId() {
        return id;
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
