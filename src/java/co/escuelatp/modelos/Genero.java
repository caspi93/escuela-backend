package co.escuelatp.modelos;

public class Genero {
    // Atributos
    private int id;
    private String nombre;

    /*
    * Método constructor que recibe como parámetro la id
     */
    public  Genero(int id) {
        this .id = id;
        this.nombre = null;
    }
    
    /*
    * Método constructor que recibe como parámetro la id y el nombre
     */
    public  Genero(int id, String nombre) {
        this .id = id;
        this.nombre = nombre;
    }

    /*
     * Método get del campo id
     */
    public int getId() {
        return id;
    }

    /*
     * Método get del campo nombre
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
