package co.escuelatp.modelos;

public class Alumno {
    // Atributos
   
    private int id;
    private float peso;
    private int altura;
    private Talla talla;
    private String direccion;
    private Persona persona;
    private Categoria categoria;

    /*
     * Método constructor que recibe como parámetro la id
     */
    public Alumno(int id) {
        this.persona = null;
        this.id = id;
        this.peso = 0;
        this.altura = 0;
        this.talla = null;
        this.direccion = null;
        this.categoria = null;
    }

    /*
     * Método get del campo Id
     */
    public int getId() {
        return id;
    }

    /*
    * Método get del campo peso
     */
    public float getPeso() {
        return peso;
    }

    /*
    * Método set del campo peso
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /*
    * Método get del campo altura
     */
    public int getAltura() {
        return altura;
    }

    /*
    * Método set del campo altura
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /*
    * Método get del campo talla
     */
    public Talla getTalla() {
        return talla;
    }

    /*
    * Método set del campo talla
     */

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    /*
     * Método get del campo direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /*
    * Método set del campo direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    /*
    * Método get del campo categoria
     */

    public Categoria getCategoria() {
        return categoria;
    }

    /*
    * Método set del campo categoria
     */

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
