package interfazGrafica;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import ManejadorExcepciones.ExcepcionGenerica;
import Usuario.Usuario;




@SuppressWarnings("serial")
public class VentanaSignIn extends JFrame{
	private JFrame ventana;
	private JButton cerrar;
	private JButton poke1;
	private JButton poke2;
	private JButton poke3;
	private Sonido reproductor2;
	private File fondoLogueo= new File("src\\Imagenes\\FondoLogueo.jpg");
	private File cancionSignIn= new File("src\\Sonidos\\CancionSignIn.mp3");
	private File IconoPoke1= new File("src\\Imagenes\\Charmander.png");
	private File IconoPoke2= new File("src\\Imagenes\\Charmander.png");
	private File IconoPoke3= new File("src\\Imagenes\\Charmander.png");
	private Usuario usu;
	
	public class BotonVolver implements ActionListener{
		@Override
		public void actionPerformed (ActionEvent cerrar) {

				try {
					
					Ventana volver=new Ventana();
					ventana.dispose();
				} catch (ExcepcionGenerica e) {
					e.printStackTrace();
				}


		}
	}
	public class BotonPoke1 implements ActionListener{
		@Override
		public void actionPerformed (ActionEvent cerrar) {
			

		}
	}
	public class BotonPoke2 implements ActionListener{
		@Override
		public void actionPerformed (ActionEvent cerrar) {
			

		}
	}
	public class BotonPoke3 implements ActionListener{
		@Override
		public void actionPerformed (ActionEvent cerrar) {
			

		}
	}
		
		
	public VentanaSignIn(String nombre) throws ExcepcionGenerica{
		usu=new Usuario(nombre);
		ventana= new JFrame("SignIn");
		ventana.setLocationRelativeTo(null);
	    ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    ventana.setLayout(null);
	    ventana.setUndecorated(true);
	    ventana.setVisible(true);
	    ventana.setContentPane(new JLabel(new ImageIcon(fondoLogueo.getAbsolutePath())));
	    ventana.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    cerrar= new JButton("Volver");
	    poke1=new JButton();
	    poke2=new JButton();
	    poke3=new JButton();
	    poke1.setIcon(new ImageIcon(IconoPoke1.getAbsolutePath()));
	    poke2.setIcon(new ImageIcon(IconoPoke2.getAbsolutePath()));
	    poke3.setIcon(new ImageIcon(IconoPoke3.getAbsolutePath()));
		cerrar.setBackground(Color.red);
		cerrar.setForeground(Color.BLACK);
		poke1.addActionListener(new BotonPoke1());
		poke2.addActionListener(new BotonPoke2());
		poke3.addActionListener(new BotonPoke3());
		cerrar.addActionListener( new BotonVolver());
		ventana.add(cerrar);
		ventana.add(poke1);
		ventana.add(poke2);
		ventana.add(poke3);
		poke1.setBounds(125,330, 230, 230);
		poke2.setBounds(675,330, 230, 230);
		poke3.setBounds(1225,330, 230, 230);
		cerrar.setBounds(20, 850,100 , 20);
		try {
			reproductor2=new Sonido(cancionSignIn.getAbsolutePath());
			reproductor2.Reproducir();
		}
		catch(ExcepcionGenerica error) {
			error.printStackTrace();
			throw new ExcepcionGenerica(error.MensajeError());
		}
	}

}