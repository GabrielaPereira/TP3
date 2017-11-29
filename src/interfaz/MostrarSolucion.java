package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Jugador;
import logica.Solucion;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.Canvas;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JLayeredPane;

public class MostrarSolucion extends JFrame {

	private JPanel contentPane;
	private Solucion equipoSolucion;
	private String soltxt;
	private JLabel lbl_sol;
	private JLabel lbl_sol_ico;
	private JLayeredPane layer_defensores;
	private JLayeredPane layer_arquero;
	private JLayeredPane layer_mediocampo;
	private JLayeredPane layer_delanteros;
	
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
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layer_delanteros = new JLayeredPane();
		layer_delanteros.setBounds(10, 137, 464, 54);
		contentPane.add(layer_delanteros);
		
		layer_mediocampo = new JLayeredPane();
		layer_mediocampo.setBounds(10, 320, 464, 40);
		contentPane.add(layer_mediocampo);
		
		layer_defensores = new JLayeredPane();
		layer_defensores.setBounds(10, 435, 464, 54);
		contentPane.add(layer_defensores);
		
		layer_arquero = new JLayeredPane();
		layer_arquero.setBounds(181, 584, 117, 25);
		contentPane.add(layer_arquero);
		layer_arquero.setLayout(null);
		
		JLabel lbl_cancha = new JLabel("");
		lbl_cancha.setIcon(new ImageIcon(MostrarSolucion.class.getResource("/img/cancha.png")));
		lbl_cancha.setBounds(0, 0, 484, 650);
		contentPane.add(lbl_cancha);
		
		
		
	
	}

	public void setSolucion(Solucion sol) {
		equipoSolucion = sol;
		int x = 0, y =5;
		int xmc = 0, xde =0;
		//		soltxt = sol.toString();
		int prop = (layer_delanteros.getWidth()/sol.cantDelanteros());
		int propmc = (layer_mediocampo.getWidth()/sol.cantMediocampistas());
		int propde = (layer_defensores.getWidth()/sol.cantDefensores());
		for (int i=0;i<sol.cantJugadores();i++){
			lbl_sol = new JLabel();
			lbl_sol_ico = new JLabel();
			lbl_sol.setOpaque(false);
			lbl_sol.setForeground(Color.WHITE);
			lbl_sol.setFont(new Font("Arial", Font.BOLD, 13));
			
			if(sol.getJugador(i).getPosicion().equals("Delantero")){
				
				lbl_sol.setBounds(x, y, 100, 25);

				lbl_sol.setText("<html><div style='text-align: center;'><img src= '/img/Messi.png' width='30px' height='30px'/>"  + sol.getJugador(i).getNombre().toString() + "</div></html>");
				layer_delanteros.setAlignmentX(CENTER_ALIGNMENT);
				layer_delanteros.add(lbl_sol);

				x += prop;
			}
			if(sol.getJugador(i).getPosicion().equals("Mediocampista")){
				
				lbl_sol.setBounds(xmc, y, 100, 20);
				lbl_sol.setText("<html><div style='text-align: center;'>" + sol.getJugador(i).getNombre().toString() + "</div></html>");
				layer_mediocampo.add(lbl_sol);
				xmc += propmc ;
			}
			if(sol.getJugador(i).getPosicion().equals("Defensor")){
				xde += propde ;
				lbl_sol.setBounds(xde, y, 100, 25);
				lbl_sol.setText("<html><div style='text-align: center;'>"+ sol.getJugador(i).getNombre().toString() +"</div></html>");
				layer_defensores.add(lbl_sol);
			}
			if(sol.getJugador(i).getPosicion().equals("Arquero")){
				lbl_sol.setBounds(10, y, 100, 25);
				lbl_sol.setText("<html><div style='text-align: center;'>"+ sol.getJugador(i).getNombre().toString()+ "</div></html>");
				layer_arquero.add(lbl_sol);
			}
		}
//		System.out.println("mostrar :"+ equipoSolucion);
		
	}
}
