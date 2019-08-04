package co.escuelatp.modelos;

public class Categoria {
    //Atributos
   
    private int id;
    private String nombre;
    private int anoInicial;
    private int anoFinal;

    //Método constructor
    public Categoria(int id) {
        this.id = id;
        this.nombre = null;
        this.anoInicial = 0;
        this.anoFinal = 0;
    }

    /*
    ¨* Método get del campo Id
     */
    public int getId() {
        return id;
    }

    /*
    ¨* Método get del campo nombre
     */

    public String getNombre() {
        return nombre;
    }

    /*
    ¨* Método set del campo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
    * Método get del campo añoInicial
     */
    public int getAnoInicial() {

        return anoInicial;
    }

    /*
    * Método set del campo añoInicial
     */
    public void setAnoInicial(int anoInicial) {

        this.anoInicial = anoInicial;
    }

    /*
    * Método get del campo añoFinal
     */
    public int getAnoFinal() {
        return anoFinal;
    }

    /*
    * Método set del campo añoFinal
     */
    public void setAnoFinal(int anoFinal) {
        this.anoFinal = anoFinal;
    }
}
