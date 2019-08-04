package co.escuelatp.modelos;
public class Usuario {
    // Atributos
    private int id;
    private String nombreUsuario;
    private String clave;
    private Rol rol;
    private Persona persona;

    /*
    * Método constructor que recibe la id como parámetro
     */
    public Usuario(int id) {
        this.persona = null;
        this.id = id;
        this.nombreUsuario = null;
        this.clave = null;
        this.rol = null;
    }

    /*
    * Método get del campo id
     */
    public int getId() {
        return id;
    }

    /*
    * Método get del campo nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /*
    * Método set del campo nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /*
     * Método get del campo clave
     */
    public String getClave() {
        return clave;
    }

    /*
     * Método set del campo clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /*
    * Método get del campo rol
     */
    public Rol getRol() {
        return rol;
    }

    /*
     * Método set del campo rol
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /*
     * Método get del campo persona
     */

    public Persona getPersona() {
        return persona;
    }

    /*
     * Método set del campo persona
     */

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
