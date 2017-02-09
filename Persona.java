import java.util.*;
public class Persona
{
    // calorias ingeridas por la persona
    private int caloriasMaximas;
    private int calorias;
    private static final int LONGITUD_PALABRA = 3;
    private String nombre;
	private ArrayList <Comida> listaComida;

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
        nombre = nombrePersona;
		listaComida = new ArrayList();
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
			listaComida.add(comida);
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
    
    /**
     * Método que permite hacerle una pregunta a la persona. Si no ha sobrepasado su metabolismo basal, te contestará "SI" o "NO" (¡en mayúsculas!) 
     * dependiendo de si la pregunta tiene una longitud (es decir, el número de letras de la misma) divisible por 3 o no, respectivamente.
     * En caso de que la persona ya haya sobrepasado el metabolismo basal o en el caso de que tu pregunta contenga el nombre de la persona,
     * responderá con la misma pregunta que le has hecho pero gritando (es decir, el mismo texto de la pregunta pero en mayúsculas) indiferentemente 
     * de la longitud de a pregunta.
     * Admite un único parámetro y debe devolver la respuesta además de imprimirla por pantalla.
     */
    public String contestar(String pregunta)
    {
        boolean respuesta = false;
        
        if(caloriasMaximas < calorias || pregunta.contains(nombre))
        {
            System.out.println(pregunta.toUpperCase());
            pregunta = pregunta.toUpperCase();
            respuesta = true;
        }
        
        if (caloriasMaximas >= calorias && !respuesta)
        {
            if(pregunta.length() % LONGITUD_PALABRA == 0)
            {
                System.out.println("SI");
                pregunta = "SI";
            }
                else
                {
                    System.out.println("NO");
                    pregunta= "NO";
                }
        }
        return pregunta;
    }
	/**
		Método que imprime por pantalla y que devuelva el nombre de la comida más calórico ingerida hasta ahora por un usuario.
		En caso de que la persona no haya comido nada el método infoma por pantalla de tal situación y devuelve null. 
		En caso de que haya empate entre dos o más comidas, imprime y devuelve la última de ellas.
	*/
	public String getAlimentoMasCaloricoConsumido()
	{
		Comida comidaMasCalorica= null;
		String nombreComida = null;
		for (Comida comida : listaComida)
		{
			if(comidaMasCalorica == null)
			{
				comidaMasCalorica = comida;
				nombreComida = comidaMasCalorica.getNombreComida();
			}
			else 
			{
                if (comidaMasCalorica.getCalorias() <= comida.getCalorias()) 
				{
                    comidaMasCalorica = comida;
                    nombreComida = comidaMasCalorica.getNombreComida();
                }
            }
        }

        if (comidaMasCalorica == null) 
		{
            System.out.println("Aún no ha comido nada.");
        }
        else 
		{
            System.out.println(nombreComida);
        }
        return nombreComida;
    }
	
	/**
		Método que no devuelve nada y que imprime por pantalla la lista de comidas ingeridas ordenadas de mayor a menor valor calórico. 
		En el listado debe mostrarse el nombre de la comida y su valor calórico.
		En caso de que la persona no haya ingerido aun comida el método debe indicarlo por pantalla.
	*/
	public void verListadoComidasIngeridas ()
	{
	}
}