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
import java.awt.Color;

public class MostrarSolucion extends JFrame {

	private JPanel contentPane;
	private Solucion equipoSolucion;
	private String soltxt;
	private JLabel lbl_sol;
	private JPanel jp_delanteros;
	
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
		
		jp_delanteros = new JPanel();
		jp_delanteros.setForeground(new Color(255, 255, 255));
		jp_delanteros.setBackground(new Color(0, 128, 0));
		jp_delanteros.setBounds(10, 149, 460, 66);
		contentPane.add(jp_delanteros);
		jp_delanteros.setLayout(null);
//		lbl_sol = new JLabel("hola");
//		lbl_sol.setBounds(10, 11, 421, 31);
//		contentPane.add(lbl_sol);
		
		JLabel lbl_cancha = new JLabel("");
		lbl_cancha.setIcon(new ImageIcon(MostrarSolucion.class.getResource("/img/cancha.png")));
		lbl_cancha.setBounds(0, 0, 484, 650);
		contentPane.add(lbl_cancha);
		
		
		
	
	}

	public void setSolucion(Solucion sol) {
		equipoSolucion = sol;
		int x = 0, y =5;
		//		soltxt = sol.toString();
		int prop = (jp_delanteros.getWidth()/sol.cantDelanteros()-50);
		for (int i=0;i<sol.cantJugadores();i++){
			String posAux = sol.getJugador(i).getPosicion().toString();
			
			if(sol.getJugador(i).getPosicion().equals("Delantero")){
				x += prop ;
				lbl_sol = new JLabel();
				lbl_sol.setOpaque(false);
				lbl_sol.setBounds(x, y, 100, 25);
				lbl_sol.setText(sol.getJugador(i).getNombre().toString());
				
				jp_delanteros.add(lbl_sol);
			}
		}
//		System.out.println("mostrar :"+ equipoSolucion);
		
	}
}
