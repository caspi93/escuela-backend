package co.escuelatp.modelos;

public class Persona {
    // Atributos
    protected int idPersona;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Genero genero;
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String direccion;

      /*
    * Método constructor por defecto
     */
    public Persona() {
        this.idPersona = 0;
        this.primerNombre = null;
        this.segundoNombre = null;
        this.primerApellido = null;
        this.segundoApellido = null;
        this.genero = null;
        this.tipoDocumento = null;
        this.numeroDocumento = null;
        this.direccion = null;
    }
    /*
    * Método constructor que recibe la id como parámetro
     */
    public Persona(int idPersona) {
        this.idPersona = idPersona;
        this.primerNombre = null;
        this.segundoNombre = null;
        this.primerApellido = null;
        this.segundoApellido = null;
        this.genero = null;
        this.tipoDocumento = null;
        this.numeroDocumento = null;
        this.direccion = null;
    }

    /*
    * Método get del campo id
     */
    public int getIdPersona() {
        return idPersona;
    }
    
     /*
    * Método set del campo id
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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
    
    /*
     * Método get del campo numeroDocumento
     */

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /*
     * Método set del campo Docummento
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /*
     * Método get del campo Direccion
     */
    public String getDireccion() {
        return direccion;
    }
    
    /*
     * Método set del campo Direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
