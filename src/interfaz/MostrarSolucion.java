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
	private JLabel lbl_beneficio; 
	private JLabel lbl_ico;
	private JLayeredPane layer_fotos_del;
	private JLayeredPane layer_fotos_mc;
	private JLayeredPane layer_fotos_def;
	private JLayeredPane layer_foto_arq;

	
	
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
		
		lbl_beneficio = new JLabel("");
		lbl_beneficio.setBounds(109, 53, 269, 40);
		contentPane.add(lbl_beneficio);
		
		layer_fotos_del = new JLayeredPane();
		layer_fotos_del.setBounds(15, 130, 464, 82);
		contentPane.add(layer_fotos_del);
		
		layer_delanteros = new JLayeredPane();
		layer_delanteros.setBounds(15, 201, 464, 27);
		contentPane.add(layer_delanteros);
		
		layer_fotos_mc = new JLayeredPane();
		layer_fotos_mc.setBounds(15, 255,464, 82);
		contentPane.add(layer_fotos_mc);
		
		layer_mediocampo = new JLayeredPane();
		layer_mediocampo.setBounds(15, 340, 464, 27);
		contentPane.add(layer_mediocampo);
		
		layer_defensores = new JLayeredPane();
		layer_defensores.setBounds(15, 500, 464, 33);
		contentPane.add(layer_defensores);
		
		layer_fotos_def = new JLayeredPane();
		layer_fotos_def.setBounds(15, 420, 464, 82);
		contentPane.add(layer_fotos_def);
		
		layer_foto_arq = new JLayeredPane();
		layer_foto_arq.setLayout(null);
		layer_foto_arq.setBounds(210, 530, 61, 82);
		contentPane.add(layer_foto_arq);
		
		layer_arquero = new JLayeredPane();
		layer_arquero.setBounds(197, 614, 117, 25);
		contentPane.add(layer_arquero);
		layer_arquero.setLayout(null);
		
		JLabel lbl_cancha = new JLabel("");
		lbl_cancha.setIcon(new ImageIcon(MostrarSolucion.class.getResource("/img/cancha.png")));
		lbl_cancha.setBounds(0, 0, 484, 650);
		contentPane.add(lbl_cancha);

	}

	public void setSolucion(Solucion sol) {
		equipoSolucion = sol;
		
		int x = 10, y =0;
		int xmc = 5, xde =5;
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
				lbl_sol.setText(sol.getJugador(i).getNombre().toString() );
				layer_delanteros.setAlignmentX(CENTER_ALIGNMENT);
				layer_delanteros.add(lbl_sol);
				
				lbl_ico = new JLabel();
				try {
				lbl_ico.setIcon(new ImageIcon(MostrarSolucion.class.getResource("/img/"+ sol.getJugador(i).getNombre().toString()+".png")));
				}catch (NullPointerException Exception){
					lbl_ico.setIcon(new ImageIcon(MostrarSolucion.class.getResource("/img/error.png")));
				}
				lbl_ico.setBounds(x, y, 100, 82);
				layer_fotos_del.add(lbl_ico);
				
				x += prop;
			}
			if(sol.getJugador(i).getPosicion().equals("Mediocampista")){
				
				lbl_sol.setBounds(xmc, y, 100, 20);
				lbl_sol.setText( sol.getJugador(i).getNombre().toString() );
				layer_mediocampo.add(lbl_sol);
				
				lbl_ico = new JLabel();
				try{
				lbl_ico.setIcon(new ImageIcon(MostrarSolucion.class.getResource("/img/"+ sol.getJugador(i).getNombre().toString()+".png")));
				}catch (NullPointerException Exception){
					lbl_ico.setIcon(new ImageIcon(MostrarSolucion.class.getResource("/img/error.png")));
				}
				lbl_ico.setBounds(xmc, y, 100, 82);
				layer_fotos_mc.add(lbl_ico);		
				
				xmc += propmc ;
			}
			if(sol.getJugador(i).getPosicion().equals("Defensor")){
				
				lbl_sol.setBounds(xde, y, 100, 25);
				lbl_sol.setText(sol.getJugador(i).getNombre().toString() );
				layer_defensores.add(lbl_sol);
				
				lbl_ico = new JLabel();
				try {
					lbl_ico.setIcon(new ImageIcon(MostrarSolucion.class.getResource("/img/"+ sol.getJugador(i).getNombre().toString()+".png")));
				} catch (NullPointerException Exception){
					lbl_ico.setIcon(new ImageIcon(MostrarSolucion.class.getResource("/img/error.png")));
				}
				

				lbl_ico.setBounds(xde, y, 100, 82);
				layer_fotos_def.add(lbl_ico);
				xde += propde ;
			}
			if(sol.getJugador(i).getPosicion().equals("Arquero")){
				lbl_sol.setBounds(5, y, 100, 25);
				lbl_sol.setText( sol.getJugador(i).getNombre().toString() );
				layer_arquero.setAlignmentX(CENTER_ALIGNMENT);
				layer_arquero.add(lbl_sol);
				
				lbl_ico = new JLabel();
				try{
				lbl_ico.setIcon(new ImageIcon(MostrarSolucion.class.getResource("/img/"+ sol.getJugador(i).getNombre().toString()+".png")));
				} catch (NullPointerException Exception){
					lbl_ico.setIcon(new ImageIcon(MostrarSolucion.class.getResource("/img/error.png")));
				}
				lbl_ico.setBounds(13, y, 100, 82);
				layer_foto_arq.add(lbl_ico);	
				
			}
		}
		lbl_beneficio.setOpaque(false);
		lbl_beneficio.setForeground(Color.WHITE);
		lbl_beneficio.setFont(new Font("Arial", Font.BOLD, 17));
		lbl_beneficio.setText("Beneficio : "+sol.beneficioSolucion());

		
	}
}
