package co.escuelatp.modelos;

public class Usuario extends Persona {

    // Atributos
    private int id;
    private String nombreUsuario;
    private String clave;
    private Rol rol;
    private String correo;
    private String celular;

    /*
    * Método constructor que recibe la id como parámetro
     */
    public Usuario(int id, int idPersona) {
        this.id = id;
        this.nombreUsuario = null;
        this.clave = null;
        this.rol = null;
        this.idPersona = idPersona;
        this.correo = null;
        this.celular = null;
    }
    
     /*
    * Método constructor que recibe la id como parámetro
     */
    public Usuario() {
        this.id = 0;
        this.nombreUsuario = null;
        this.clave = null;
        this.rol = null;
        this.idPersona = 0;
        this.correo = null;
        this.celular = null;
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
     * Método get del campo correo
     */
    public String getCorreo() {
        return correo;
    }

    /*
     * Método set del campo correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /*
     * Método get del campo celular
     */
    public String getCelular() {
        return celular;
    }

    /*
     * Método set del campo celular
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    /*
    *Método set del campo id
     */
    public void setId(int id) {
        this.id = id;
    }

    public boolean verificarPermiso(String codigo) {
        for (Permiso p : rol.getPermisos()) {
            if (codigo.equals(p.getCodigo())) {
                return true;
            }
        }
        return false;
    }
}
