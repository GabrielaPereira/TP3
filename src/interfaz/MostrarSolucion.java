package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Jugador;
import logica.Solucion;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MostrarSolucion extends JFrame {

	private JPanel contentPane;
	private Solucion equipoSolucion;
	private String soltxt;
	private JLabel lbl_sol;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarSolucion frame = new MostrarSolucion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MostrarSolucion() {
		
		Solucion aux = equipoSolucion;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		lbl_sol = new JLabel("hola");
//		lbl_sol.setBounds(10, 11, 421, 31);
//		contentPane.add(lbl_sol);
		
		JLabel lbl_cancha = new JLabel("");
		lbl_cancha.setIcon(new ImageIcon("C:\\Users\\IBM_ADMIN\\git5\\Tp3\\imagenes\\CANCHA.png"));
		lbl_cancha.setBounds(0, 0, 484, 650);
		contentPane.add(lbl_cancha);
		
	
	}

	public void setSolucion(Solucion sol) {
		equipoSolucion = sol;
		int x = 0, y =5;
//		soltxt = sol.toString();
		for (int i=0;i<sol.cantJugadores();i++){
			lbl_sol = new JLabel(sol.getJugador(i).toString());
			lbl_sol.setBounds((x+=5), y, 20, 5);
			contentPane.add(lbl_sol);
		}
//		System.out.println("mostrar :"+ equipoSolucion);
		
	}
	
}
