package co.escuelatp.modelos;

public class TipoDocumento {
    // Atributos
    private int id;
    private String nombre;
    private String nombreCorto;

    public TipoDocumento(int id) {
        this.id = id;
        this.nombre = null;
        this.nombreCorto = null;
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

    /*
     * Método set del campo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
     * Método get del campo nombreCorto
     */
    public String getNombreCorto() {
        return nombreCorto;
    }

    /*
     * Método set del campo nombreCorto
     */
    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }
}
