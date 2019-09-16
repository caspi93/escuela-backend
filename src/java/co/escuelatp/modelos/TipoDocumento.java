package co.escuelatp.modelos;

public class TipoDocumento {
    // Atributos
    private int id;
    private String nombre;
    private String nombreCorto;

     /*
    * Método constructor que recibe como parámetro la id
     */
    public TipoDocumento(int id) {
        this.id = id;
        this.nombre = null;
        this.nombreCorto = null;
    }
    
     public TipoDocumento() {
        this.id = 0;
        this.nombre = null;
        this.nombreCorto = null;
    }
    /*
    * Método constructor que recibe como parámetro la id y el nombre corto
     */
     public TipoDocumento(int id, String nombreCorto) {
        this.id = id;
        this.nombre = null;
        this.nombreCorto = nombreCorto;
    }
    /* 
    * Método constructor que recibe como parámetro el nombre corto
     */
     public TipoDocumento(String nombreCorto) {
        this.id = 0;
        this.nombre = null;
        this.nombreCorto = nombreCorto;
    }

    /*
    * Método get del campo id
     */
    public int getId() {
        return id;
    }
    
    /*
     * Método set del campo id
     */
    public void setId(int id) {
        this.id = id;
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
