package CentroPokemon;


import java.util.ArrayList;

import ManejadorExcepciones.ExcepcionGenerica;
import Pokemon.*;
import Usuario.Usuario;

public class CentroPokemon 
{
	Usuario usuario;
	boolean compuerta;
	
	
	public CentroPokemon(Usuario usuario)
	{
		this.usuario =usuario;
		this.compuerta = true;
	}
	

	public String mostrarPokemonsDa�ados() throws ExcepcionGenerica
	{
		ArrayList <Pokemon> pokemonsDa�ados = usuario.getPokemonsDa�ados();
		
		String da�ados = "";
		
		for(Pokemon da�ado : pokemonsDa�ados)
		{
			da�ados = da�ado + "\n" +  da�ado.toString();
		}
		
		return da�ados;
	}
	
	// devuelve false si ya se curaron los pokemon, asi la compuerta se cierra, true si no se curaron, asi la compuerta sigue abierta.
	public boolean curarPokemonsDa�ados() throws ExcepcionGenerica
	{
		boolean rta=false;
		
		if(usuario.restaurarVidas(usuario.getPokemonsDa�ados()));
		
		else rta=true;
		
		return rta;
	}
	
	
	
	
}
