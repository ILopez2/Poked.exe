package Pokemon;

public class Agua_Hielo extends Pokemon implements IAgua , IHielo{
	
	/**
     * Constructor COPIA
     * @param id
     * @param nombre
     * @param vidas
     * @param genero
     * @param rutaImagen
     */
    public Agua_Hielo (int id, String nombre,int nivel, int vidas, int evolucion,String rutaImagen)
    {
    	super(id, nombre,nivel, vidas, evolucion, tipoAgua + tipoHielo, rutaImagen);
    }
	/**
     * Constructor COPIA2
     * @param Pokemon
     */
    public Agua_Hielo(Pokemon poke)
    {
    	super(poke.getId(), poke.getNombre(),poke.getEvolucion(), tipoAgua + tipoHielo, poke.getRutaImagen());
    	setVidasNivel(calcularNivel());
    }
    
    /**
     * Constructor DEFECTO
     * @param id
     * @param nombre
     * @param genero
     * @param tipo
     * @param rutaImagen
     */
    public Agua_Hielo(int id, String nombre, int evolucion,String tipo,String rutaImagen)
    {
    	super(id, nombre,evolucion, tipoAgua + tipoHielo, rutaImagen);
    	setVidasNivel(calcularNivel());
    }

    
    
	
	/**
	 * Metodo abstracto entre las clases solo cambia el "tipo" las evoluciones quedan igual.
	 */
    
	protected int calcularNivel() 
	{
		return nivelAgua+nivelHielo+nivelPrimeraEvolucion()+nivelSegundaEvolucion()+nivelTerceraEvolucion();
	}

}
