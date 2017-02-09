
public class Persona
{
    // calorias ingeridas por la persona
    private int caloriasMaximas;
    private int calorias;

    /**
     * Constructor for objects of class Persona
     */
    public Persona(String nombrePersona, boolean sexoHombre, int peso, int altura, int edad)
    {
        if (sexoHombre)
        {
            //máxmo de calorias que puede ingerir una persona.
            caloriasMaximas = (10 * peso) + (6 * altura) + (5 * edad)+5;
        }
        else
        {
            caloriasMaximas = (10 * peso) + (6 * altura) + (5 * edad) - 161;
        }
    }

    /**
     *metódo que debe permitir 1 único parámetro de tipo comida y debe devolver un entero consistente 
     *en las calorias ingeridas en esa comida en caso de que la persona la coma o -1 en caso de que no la coma.
     */
    public int comer(Comida comida)
    {
        int caloriasIngeridas = -1;
        if (caloriasMaximas >= calorias)
        {
           caloriasIngeridas = comida.getCalorias();
           calorias =caloriasIngeridas + calorias;
        }
        return caloriasIngeridas;
    }
    
    /**
     * método que permite saber la cantidad de calorias que lleva ingerida una persona se denomina getCaloriasIngeridas,
     * no admite parámetros y devuelve un entero.
     */
    public int getCaloriasIngeridas()
    {
        return calorias;
    }
    
    
    
}
