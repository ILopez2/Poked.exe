package Ejecucion;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

import CapturaPokemon.Batalla;
import CentroPokemon.CentroPokemon;
import GestorPokedex.GestorPokedex;
import GestorUsuarios.GestorUsuarios;
import Json.*; 
import Pokemon.*;
import Usuario.Usuario;
import ManejadorExcepciones.ExcepcionGenerica;


public class Main 
{

	public static void main(String[] args) throws ExcepcionGenerica 
	{
		ManejadorJSON manejador = new ManejadorJSON();

		GestorUsuarios gestorUsuario = new GestorUsuarios();

		Scanner lectorDeTecladoInt = new Scanner(System.in);

		Scanner lectorDeTecladoString = new Scanner (System.in);

		Usuario usuario = null;

		CentroPokemon centroPokemon ;

		Batalla batalla;

		GestorPokedex gestorPokedex = new GestorPokedex();

		int control = 1;

		while(control != 0 )
		{
			switch(control)
			{
			case 1://MENU PRINCIPAL
			{
				if(gestorUsuario.elArchivoUsuariosEstaCreado())
				{

					System.out.println("BIENVENIDO A POKED.EXE\n\n 1--Ingresar con un usuario existente \n\n 2--Crear un usuario nuevo \n\n 0--Salir");

					int control1 = lectorDeTecladoInt.nextInt();

					while(control1 <0 || control1 >2)
					{
						System.out.println("La opci�n ingresada no corresponde a una opci�n. Por favor ingrese una nueva opcion: \n\n");
						control1 = lectorDeTecladoInt.nextInt();
					}

					switch(control1)
					{

					case 0:
					{
						control = 0;
					}break;

					case 1:
					{

						System.out.println("\r Ingrese un nombre de usuario existente: \n\n");

						String nombre = lectorDeTecladoString.nextLine();

						while(usuario == null)
						{
							if(gestorUsuario.ExisteNombre(nombre))
							{
								usuario = gestorUsuario.sacarUsuario(nombre);
							}
							else
							{
								System.out.println("\n\nEl nombre de usuario no existe, ingrese uno v�lido:\n\n");
								nombre = lectorDeTecladoString.nextLine();
							}
						}


						control = 2;


					}break;

					case 2:
					{

						System.out.println("\r Ingrese un nombre de usuario nuevo: \n\n");

						String nombre = lectorDeTecladoString.nextLine();

						while(nombre == " ")
						{
							System.out.println("El nombre ingresado no es valido. Por favor ingrese un nuevo: \n\n");
							nombre = lectorDeTecladoString.nextLine();
						}

						if(gestorUsuario.elArchivoUsuariosEstaCreado())
						{

							while( gestorUsuario.ExisteNombre(nombre) )
							{
								System.out.println("El nombre que ingres� ya existe. Por favor, ingrese uno nuevo \n\n");

								nombre = lectorDeTecladoString.nextLine();
							}

							usuario = gestorUsuario.cargarUnUsuario(nombre);
						}
						else
						{
							usuario = gestorUsuario.cargarUnUsuario(nombre);
						}


						System.out.println("\n\n\n \"�Hola a todos! �Bienvenidos al mundo de POK�MON! �Me llamo OAK! �Pero la gente me llama el PROFESOR POK�MON! �Este mundo est� habitado por unas criaturas llamadas POK�MON! Para algunos, los POK�MON son mascotas. Pero otros los usan para pelear. En cuanto a m�... Estudio a los POK�MON como profesi�n. �Bien! �Tu nombre es "+ usuario.getNombre()+"! \n ��Tu propia leyenda POK�MON est� a punto de comenzar! �Te espera un mundo de sue�os y aventuras con los POK�MON! �Adelante!");

						System.out.println("\"�Eh! �Alto! �No te vayas!\r\n" + 
								"�Cuidado! �En la hierba viven POK�MON salvajes! Necesitas a tu propio POK�MON como protecci�n! �Yo lo s�! �Ven conmigo! \"\n\n\"Quieres a:\n\t1--Charmander\n\t2--Squirtle\n\t3--Bulbasaur\n, que Pokemon eliges?\"");

						System.out.println("\n\nIngresa una opcion:   ");

						int opcion = lectorDeTecladoInt.nextInt();

						while(opcion <1 || opcion >3)
						{
							System.out.println("La opci�n ingresada no corresponde a una opci�n. Por favor ingrese una nueva opcion: \n\n");
							opcion = lectorDeTecladoInt.nextInt();
						}

						switch(opcion)
						{
						case 1:
						{
							gestorUsuario.cargarPrimerPokemon(usuario, 3);
						}break;
						case 2:
						{
							gestorUsuario.cargarPrimerPokemon(usuario, 6);
						}break;
						case 3:
						{
							gestorUsuario.cargarPrimerPokemon(usuario, 0);
						}break;
						}

						System.out.println("\"�Este POK�MON es muy energ�tico!�Si aparece un POK�MON salvaje, tu POK�MON podr� luchar contra �l!\"");

						System.out.println("\n\n�Este es un invento m�o, la POK�DEX! ��sta registrar� autom�ticamente datos sobre los POK�MON que hayas visto o capturado! \n�Es una tecno-enciclopedia! �"+ usuario.getNombre() +"! \n �Ten la POK�DEX! Quer�a hacer una gu�a de todos los POK�MON del mundo... �Era mi sue�o! �Pero ya soy muy viejo y no puedo hacerlo!\n �Por eso quiero que tu hagas realidad ese sue�o! �Adelante, ve en su busca! �Ser� una gran proeza en la historia de los POK�MON!");

						System.out.println("\n�" + usuario.getNombre() +", los POK�MON del mundo te esperan! \"");



						control = 2;




					}break;

					}
				}

				else
				{
					System.out.println("BIENVENIDO A POKED.EXE\n\n 1--Crear un usuario nuevo \n\n 0--Salir");

					int control1 = lectorDeTecladoInt.nextInt();

					while(control1 <0 || control1 >1)
					{
						System.out.println("La opci�n ingresada no corresponde a una opci�n. Por favor ingrese una nueva opcion: \n\n");
						control1 = lectorDeTecladoInt.nextInt();
					}

					switch(control1)
					{

					case 0:
					{
						control = 0;
					}break;

					case 1:
					{
						System.out.flush();

						System.out.println("\r Ingrese un nombre de usuario nuevo: \n\n");

						String nombre = lectorDeTecladoString.nextLine();

						while(nombre == " ")
						{
							System.out.println("El nombre ingresado no es valido. Por favor ingrese un nuevo: \n\n");
							nombre = lectorDeTecladoString.nextLine();
						}

						if(gestorUsuario.elArchivoUsuariosEstaCreado())
						{

							while( gestorUsuario.ExisteNombre(nombre) )
							{
								System.out.println("El nombre que ingres� ya existe. Por favor, ingrese uno nuevo \n\n");

								nombre = lectorDeTecladoString.nextLine();
							}

							usuario = gestorUsuario.cargarUnUsuario(nombre);
						}
						else
						{
							usuario = gestorUsuario.cargarUnUsuario(nombre);
						}

						System.out.println("\n\n\n \"�Hola a todos! �Bienvenidos al mundo de POK�MON! �Me llamo OAK! �Pero la gente me llama el PROFESOR POK�MON! \n �Este mundo est� habitado por unas criaturas llamadas POK�MON! Para algunos, los POK�MON son mascotas. Pero otros los usan para pelear.\n En cuanto a m�... Estudio a los POK�MON como profesi�n.\n �Bien! �Tu nombre es "+ usuario.getNombre()+"! \n ��Tu propia leyenda POK�MON est� a punto de comenzar! �Te espera un mundo de sue�os y aventuras con los POK�MON! �Adelante!\"");

						System.out.println("\"�Eh! �Alto! �No te vayas!\r\n" + 
								"�Cuidado! �En la hierba viven POK�MON salvajes! Necesitas a tu propio POK�MON como protecci�n! �Yo lo s�! �Ven conmigo! \"\n\n\"Quieres a:\n\t1--Charmander\n\t2--Squirtle\n\t3--Bulbasaur\n, que Pokemon eliges ?\"");

						System.out.println("\n\nIngresa una opcion:   ");

						int opcion = lectorDeTecladoInt.nextInt();

						while(opcion <1 || opcion >3)
						{
							System.out.println("La opci�n ingresada no corresponde a una opci�n. Por favor ingrese una nueva opcion: \n\n");
							opcion = lectorDeTecladoInt.nextInt();
						}

						switch(opcion)
						{
						case 1:
						{
							gestorUsuario.cargarPrimerPokemon(usuario, 3);
						}break;
						case 2:
						{
							gestorUsuario.cargarPrimerPokemon(usuario, 6);
						}break;
						case 3:
						{
							gestorUsuario.cargarPrimerPokemon(usuario, 0);
						}break;
						}

						System.out.println("\"�Este POK�MON es muy energ�tico!�Si aparece un POK�MON salvaje, tu POK�MON podr� luchar contra �l!\"");

						System.out.println("\n\n�Este es un invento m�o, la POK�DEX! ��sta registrar� autom�ticamente datos sobre los POK�MON que hayas visto o capturado! \n�Es una tecno-enciclopedia! �"+ usuario.getNombre() +"! \n �Ten la POK�DEX! Quer�a hacer una gu�a de todos los POK�MON del mundo... �Era mi sue�o! �Pero ya soy muy viejo y no puedo hacerlo!\n �Por eso quiero que tu hagas realidad ese sue�o! �Adelante, ve en su busca! �Ser� una gran proeza en la historia de los POK�MON!");

						System.out.println("\n�" + usuario.getNombre() +", los POK�MON del mundo te esperan! \"");


						System.out.println("\n\n Ingrese una tecla para continuar: ");
						String tecla = lectorDeTecladoString.nextLine();

						control = 2;
					}break;
					}
				}

			}break;

			case 2://MENU POKEMON
			{
				centroPokemon = new CentroPokemon(usuario);

				centroPokemon.manejadorDeCompuerta();

				int control2 = 1;

				limpiar();
				System.out.println("\n MEN� POKEMON\n\n\nCantidad de batallas : "+ usuario.getCantidadDeBatallas());
				
				if(usuario.estanTodosDebilitados())
				{


					while(control2 > -1 && control2 <5)
					{	

						

						System.out.println("\t1-- Mis Pokemon \n\n\t2-- Mi Pokedex \n\n\t3--Pokemons Cercanos \n\n\t4--Centro Pokemon \n\n\t0-- Cerrar Sesion");

						control2 = lectorDeTecladoInt.nextInt();

						while(control2 <0 || control2 >4)
						{
							System.out.println("La opci�n ingresada no corresponde a una opci�n. Por favor ingrese una nueva opcion: \n\n");
							control2 = lectorDeTecladoInt.nextInt();
						}

						switch(control2)
						{

						case 0:
						{
							control = 1;
						}break;

						case 1:
						{
							limpiar();

							System.out.println("\nMIS POKEMON \n\n\n");

							System.out.println(usuario.listarPokemonsCapturados());

							System.out.println("\n\n\n\n\n\t1--Volver al Men� Pokemon");

							control2 = lectorDeTecladoInt.nextInt();

							while(control2 != 1)
							{
								System.out.println("La opci�n ingresada no corresponde a una opci�n. Por favor ingrese la opci�n 1 : \n\n");
								control2 = lectorDeTecladoInt.nextInt();
							}


						}break;

						case 2:
						{
							limpiar();

							System.out.println("\nMI POKEDEX \n\n\n");

							System.out.println(usuario.listarPokemonsPokedex());

							System.out.println("\n\n\n\n\n\t1--Volver al Men� Pokemon");

							control2 = lectorDeTecladoInt.nextInt();

							while(control2 != 1)
							{
								System.out.println("La opci�n ingresada no corresponde a una opci�n. Por favor ingrese la opci�n 1 : \n\n");
								control2 = lectorDeTecladoInt.nextInt();
							}
						}break;

						case 3:
						{
							if(!usuario.estanTodosDebilitados()) {
							limpiar();

							System.out.println("\nPOKEMONS CERCANOS\n\n\n");

							Pokemon salvaje1 = gestorPokedex.pokemonRandomXnivel(usuario.getCantidadDeBatallas());

							Pokemon salvaje2 = gestorPokedex.pokemonRandomXnivel(usuario.getCantidadDeBatallas());

							Pokemon salvaje3 = gestorPokedex.pokemonRandomXnivel(usuario.getCantidadDeBatallas());

							System.out.println("�Entrenador! �Hay tres Pokemons Salvajes!\n\n 1--" + salvaje1.getNombre() + ", \t2--"+ salvaje2.getNombre()+", \t3--"+salvaje3.getNombre()+ "\n �Elige uno antes de que escapen!");

							int opcion = lectorDeTecladoInt.nextInt();

							while(opcion <0 || opcion > 3)
							{
								System.out.println("La opci�n ingresada no corresponde a una opci�n. Por favor ingrese una opcion valida: \n\n");
								control2 = lectorDeTecladoInt.nextInt();
							}

							limpiar();

							System.out.println("\n\nEscoja un Pokemon para luchar:\n\n");

							System.out.println(usuario.listarPokemonsNOdebilitados());

							System.out.println("\n\nIngrese la id del Pokemon con el que desea luchar");

							int idCapturado = lectorDeTecladoInt.nextInt();

							Pokemon capturadoPokemon = usuario.leerPokemonNOdebilitado(idCapturado);

							while(capturadoPokemon == null)
							{
								System.out.println("\nLa id no se encuentra entre sus Pokemon capturados. Por favor, ingrese una id valida: ");

								idCapturado = lectorDeTecladoInt.nextInt();

								capturadoPokemon = usuario.leerPokemonNOdebilitado(idCapturado);

							}

							limpiar();

							System.out.println("\"�Entrenador! �La batalla ha comenzado! �Mucha suerte " + capturadoPokemon.getNombre() + "! \"");

							int resultado =0;
							Pokemon salvaje = new Pokemon();

							switch(opcion)
							{
							case 1:
							{
								batalla = new Batalla(capturadoPokemon, salvaje1, usuario);
								System.out.println("\n\n" + capturadoPokemon.getNombre() + " VS "+ salvaje1.getNombre());
								batalla.resultadoPelea();
								resultado = batalla.getGanador();
								salvaje = batalla.getPokemonSalvaje();
								capturadoPokemon = batalla.getPokemonCapturado();



							}break;
							case 2:
							{
								batalla = new Batalla(capturadoPokemon, salvaje2, usuario);
								System.out.println("\n\n" + capturadoPokemon.getNombre() + " VS "+ salvaje2.getNombre());
								batalla.resultadoPelea();
								resultado = batalla.getGanador();
								salvaje = batalla.getPokemonSalvaje();
								capturadoPokemon = batalla.getPokemonCapturado();



							}break;
							case 3:
							{
								batalla = new Batalla(capturadoPokemon, salvaje3, usuario);
								System.out.println("\n\n" + capturadoPokemon.getNombre() + " VS "+ salvaje3.getNombre());
								batalla.resultadoPelea();
								resultado = batalla.getGanador();
								salvaje = batalla.getPokemonSalvaje();
								capturadoPokemon = batalla.getPokemonCapturado();



							}break;
							}

							System.out.println("\n\n\nRESULTADOS DE LA BATALLA");

							if(resultado == 1)
							{
								System.out.println("\n\n�El ganador es " + capturadoPokemon.getNombre()+ "!\n\n �Tu pokemon ha subido un nivel! �T� adquieres una batalla m�s! \n\n Si el Pokemon Salvaje no formaba parte de tu equipo, �ahora lo hace!, ve a verlo en \"MIS CAPTURADOS\".");
							}

							if(resultado == 2)
							{
								System.out.println("\n\n �Oh! Tu pokemon no ha podido vencer al pokemon salvaje y ha huido. T� adquieres una batalla mas.");
							}
							if(resultado == 3)
							{
								System.out.println("\n\n �El pokemon salvaje era demasiado fuerte! Tu pokemon ha sufrido un golpe cr�tico, ll�valo al Centro Pokemon cuando se habilite.");
							}

							System.out.println("\n\n Ingrese una tecla para continuar: ");
							String tecla = lectorDeTecladoString.nextLine();
							}

							control = 2;

						}break;
						case 4:
						{
							limpiar();
							System.out.println("\nCENTRO POKEMON\n\n Pokemons da�ados:\n\n");

							System.out.println(centroPokemon.listarPokemonsDanados());

							System.out.println("\n\nIngrese una tecka para curar los pokemons:");
							lectorDeTecladoInt.nextInt();

							centroPokemon.curarPokemonsDa�ados();

							System.out.println("\"�TUS POKEMONS YA SE ENCUENTRAN BIEN! �Gracias por visitar el Centro Pokemon!\" ");

							System.out.println("\n\n Ingrese una tecla para continuar: ");
							String tecla = lectorDeTecladoString.nextLine();

							control = 2;


						}break;




						}break;
					}
				}
				else
				{


					System.out.println("\t1-- Mis Pokemon \n\n\t2-- Mi Pokedex \n\n\t3--Pokemons Cercanos \n\n\t0-- Cerrar Sesion");

					control2 = lectorDeTecladoInt.nextInt();

					while(control2 <0 || control2 >3)
					{
						System.out.println("La opci�n ingresada no corresponde a una opci�n. Por favor ingrese una nueva opcion: \n\n");
						control2 = lectorDeTecladoInt.nextInt();
					}

					switch(control2)
					{

					case 0:
					{
						control = 1;
					}break;

					case 1:
					{
						limpiar();

						System.out.println("\nMIS POKEMON \n\n\n");

						System.out.println(usuario.listarPokemonsCapturados());

						System.out.println("\n\n\n\n\n\t1--Volver al Men� Pokemon");

						control2 = lectorDeTecladoInt.nextInt();

						while(control2 != 1)
						{
							System.out.println("La opci�n ingresada no corresponde a una opci�n. Por favor ingrese la opci�n 1 : \n\n");
							control2 = lectorDeTecladoInt.nextInt();
						}


					}break;

					case 2:
					{
						limpiar();

						System.out.println("\nMI POKEDEX \n\n\n");

						System.out.println(usuario.listarPokemonsPokedex());

						System.out.println("\n\n\n\n\n\t1--Volver al Men� Pokemon");

						control2 = lectorDeTecladoInt.nextInt();

						while(control2 != 1)
						{
							System.out.println("La opci�n ingresada no corresponde a una opci�n. Por favor ingrese la opci�n 1 : \n\n");
							control2 = lectorDeTecladoInt.nextInt();
						}
					}break;

					case 3:
					{
						limpiar();

						System.out.println("\nPOKEMONS CERCANOS\n\n\n");

						Pokemon salvaje1 = gestorPokedex.pokemonRandomXnivel(usuario.getCantidadDeBatallas());

						Pokemon salvaje2 = gestorPokedex.pokemonRandomXnivel(usuario.getCantidadDeBatallas());

						Pokemon salvaje3 = gestorPokedex.pokemonRandomXnivel(usuario.getCantidadDeBatallas());

						System.out.println("�Entrenador! �Hay tres Pokemons Salvajes!\n\n 1--" + salvaje1.getNombre() + ", \t2--"+ salvaje2.getNombre()+", \t3--"+salvaje3.getNombre()+ "\n �Elige uno antes de que escapen!");

						int opcion = lectorDeTecladoInt.nextInt();

						while(opcion <0 || opcion > 3)
						{
							System.out.println("La opci�n ingresada no corresponde a una opci�n. Por favor ingrese una opcion valida: \n\n");
							control2 = lectorDeTecladoInt.nextInt();
						}

						limpiar();

						System.out.println("\n\nEscoja un Pokemon para luchar:\n\n");

						System.out.println(usuario.listarPokemonsNOdebilitados());

						System.out.println("\n\nIngrese la id del Pokemon con el que desea luchar");

						int idCapturado = lectorDeTecladoInt.nextInt();

						Pokemon capturadoPokemon = usuario.leerPokemonNOdebilitado(idCapturado);

						while(capturadoPokemon == null)
						{
							System.out.println("\nLa id no se encuentra entre sus Pokemon capturados. Por favor, ingrese una id valida: ");

							idCapturado = lectorDeTecladoInt.nextInt();

							capturadoPokemon = usuario.leerPokemonNOdebilitado(idCapturado);

						}

						limpiar();

						System.out.println("\"�Entrenador! �La batalla ha comenzado! �Mucha suerte " + capturadoPokemon.getNombre() + "! \"");

						int resultado =0;
						Pokemon salvaje = new Pokemon();

						switch(opcion)
						{
						case 1:
						{
							batalla = new Batalla(capturadoPokemon, salvaje1, usuario);
							System.out.println("\n\n" + capturadoPokemon.getNombre() + " VS "+ salvaje1.getNombre());
							batalla.resultadoPelea();
							resultado = batalla.getGanador();
							salvaje = batalla.getPokemonSalvaje();
							capturadoPokemon = batalla.getPokemonCapturado();



						}break;
						case 2:
						{
							batalla = new Batalla(capturadoPokemon, salvaje2, usuario);
							System.out.println("\n\n" + capturadoPokemon.getNombre() + " VS "+ salvaje2.getNombre());
							batalla.resultadoPelea();
							resultado = batalla.getGanador();
							salvaje = batalla.getPokemonSalvaje();
							capturadoPokemon = batalla.getPokemonCapturado();



						}break;
						case 3:
						{
							batalla = new Batalla(capturadoPokemon, salvaje3, usuario);
							System.out.println("\n\n" + capturadoPokemon.getNombre() + " VS "+ salvaje3.getNombre());
							batalla.resultadoPelea();
							resultado = batalla.getGanador();
							salvaje = batalla.getPokemonSalvaje();
							capturadoPokemon = batalla.getPokemonCapturado();



						}break;
						}

						System.out.println("\n\n\nRESULTADOS DE LA BATALLA");

						if(resultado == 1)
						{
							System.out.println("\n\n�El ganador es " + capturadoPokemon.getNombre()+ "!\n\n �Tu pokemon ha subido un nivel! �T� adquieres una batalla m�s! \n\n Si el Pokemon Salvaje no formaba parte de tu equipo, �ahora lo hace!, ve a verlo en \"MIS CAPTURADOS\".");
						}

						if(resultado == 2)
						{
							System.out.println("\n\n �Oh! Tu pokemon no ha podido vencer al pokemon salvaje y ha huido. T� adquieres una batalla mas.");
						}
						if(resultado == 3)
						{
							System.out.println("\n\n �El pokemon salvaje era demasiado fuerte! Tu pokemon ha sufrido un golpe cr�tico, ll�valo al Centro Pokemon cuando se habilite.");
						}

						System.out.println("\n\n Ingrese una tecla para continuar: ");
						String tecla = lectorDeTecladoString.nextLine();

						control = 2;

					}break;
					}


				}

			}break;

			}
		}

	}		


	public static void limpiar()
	{
		for (int i=0; i < 40 ; i++)
		{
			System.out.println();
		}
		
	}

}
