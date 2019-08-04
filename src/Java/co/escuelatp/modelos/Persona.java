package co.escuelatp.modelos;

public class Persona {
    // Atributos
    private int id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Genero genero;
    private TipoDocumento tipoDocumento;

    /*
    * Método constructor que recibe la id como parámetro
     */
    public Persona(int id) {
        this.id = id;
        this.primerNombre = null;
        this.segundoNombre = null;
        this.primerApellido = null;
        this.segundoApellido = null;
        this.genero = null;
        this.tipoDocumento = null;
    }

    /*
    * Método get del campo id
     */
    public int getId() {
        return id;
    }

    /*
     * Método get del campo primerNombre
     */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /*
     * Método set del campo primerNombre
     */
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    /*
     * Método get del campo segundoNombre
     */
    public String getSegundoNombre() {
        return segundoNombre;
    }

    /*
     * Método set del campo segundoNombre
     */
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    /*
     * Método get del campo primerApellido
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /*
     * Método set del campo primerApllido
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /*
     * Método get del campo segundoApellido
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /*
     * Método set del campo segundoApellido
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /*
     * Método get del campo genero
     */
    public Genero getGenero() {
        return genero;
    }

    /*
     * Método set del campo genero
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /*
     * Método get del campo tipoDocumento
     */
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    /*
     * Método set del campo tipoDocummento
     */
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

}
