package interfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import ManejadorExcepciones.ExcepcionGenerica;
import Usuario.Usuario;

@SuppressWarnings("serial")
/*
 * Esta es la clase principal de ventana y tiene el logueo de usuario
 */
public class Ventana extends JFrame{
	//ATRIBUTOS
	private JFrame ventana;
	private JLabel textoUsuario;
	private JTextField cajaUsuario;
	private JButton aceptar;
	private JButton cerrar;
	private Sonido reproductor;
	private File fondoLogueo= new File("src\\Imagenes\\FondoLogueo.jpg");
	private File cancionLogueo= new File("src\\Sonidos\\CancionLogueo.mp3");
	private Usuario usuario;
	
	
	//CONSTRUCTOR
	public Ventana() throws ExcepcionGenerica{
		ventana= new JFrame("Logueo");
		ventana.setLocationRelativeTo(null);
	    ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    ventana.setLayout(null);
	    ventana.setUndecorated(true);
	    ventana.setVisible(true);
	    ventana.setContentPane(new JLabel(new ImageIcon(fondoLogueo.getAbsolutePath())));
		textoUsuario = new JLabel("Usuario: ");
		textoUsuario.setForeground(Color.white);
		cajaUsuario = new JTextField(20);
		aceptar = new JButton("Aceptar");
		cerrar= new JButton("Salir");
		cerrar.setBackground(Color.red);
		cerrar.setForeground(Color.BLACK);
		cerrar.addActionListener(new BotonCerrar());
		aceptar.setBackground(Color.cyan);
		aceptar.setForeground(Color.BLACK);
		ventana.add(textoUsuario);
		ventana.add(cajaUsuario);
		ventana.add(aceptar);
		ventana.add(cerrar);
		textoUsuario.setBounds(675,402,50,10);
		cajaUsuario.setBounds(725, 400, 150, 20);
		aceptar.setBounds(750, 430,100,20);
		cerrar.setBounds(20, 850,100 , 20);
	    ventana.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		try {
			reproductor=new Sonido(cancionLogueo.getAbsolutePath());
			reproductor.Reproducir();
		}
		catch(ExcepcionGenerica error) {
			error.printStackTrace();
			throw new ExcepcionGenerica(error.MensajeError());
		}
	}
	
	public class BotonCerrar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent cerrar) {
			System.exit(0);
		}
	}
}