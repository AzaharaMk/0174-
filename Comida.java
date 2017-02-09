
public class Comida
{
    private int caloriasIngeridas;

    /**
     * Constructor for objects of class Comida
     */
    public Comida(String nombreComida, int cantidadCalorias)
    {
        // initialise instance variables
        caloriasIngeridas= cantidadCalorias;
    }

     /**
     * método que permite saber la cantidad de calorias que lleva ingerida una persona se denomina getCaloriasIngeridas,
     * no admite parámetros y devuelve un entero.
     */
    public int getCalorias()
    {
        return caloriasIngeridas;
    }
}
