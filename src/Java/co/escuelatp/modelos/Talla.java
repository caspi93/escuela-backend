package co.escuelatp.modelos;
public class Talla {
    // Atributos
    private int id;
    private String nombre;

    /*
     * Método constructor que recibe como parámetro la id
     */
    public  Talla(int id) {
        this .id = id;
        this.nombre = null;
    }

    /*
     * Método get del campo Id
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
