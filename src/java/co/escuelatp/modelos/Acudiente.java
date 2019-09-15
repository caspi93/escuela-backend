package co.escuelatp.modelos;



public class Acudiente {
    // Atributos
    private int id;
    private String correo;
    private String celular;
    private Persona persona;

    /*
     * Método constructor que recibe como parámetro la id
     */
    public Acudiente(int id) {
        this.persona = null;
        this.id = id;
        this.correo = null;
        this.celular = null;
    }
    
      public Acudiente() {
        this.persona = null;
        this.id = 0;
        this.correo = null;
        this.celular = null;
    }

    /*
     * Método get del campo acudienteId
     */
    public int getId() {
        return id;
    }
    
     /*
    *Método set del campo id
     */
    public void setId(int id) {
        this.id = id;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
