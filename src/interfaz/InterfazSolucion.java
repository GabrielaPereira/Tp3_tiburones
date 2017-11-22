package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.function.Consumer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


import logica.InstanciaJugadores;
import logica.Jugador;
import logica.Solver;

import java.awt.Toolkit;
public class InterfazSolucion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	//private InstanciaEquipo j;
	private JLabel defensor1;
	private JLabel level2_n1;
	private JLabel level2_n2;
	private JLabel level2_n3;
	private JLabel defensor2;
	private JLabel level3_n1;
	private JLabel level3_n2;
	private JLabel level3_n3;
	private JLabel levell3_n4;
	private JPanel panel_n4;
	private JPanel panel_n1;
	private JPanel panel_n2;
	private JPanel panel_n3;
	private JLabel defensor3;
	private JLabel posarquero;
	private JLabel lblNewLabel;
	private  ArrayList<Jugador> defensores;
	private  ArrayList<Jugador> mediocampistas;
	private  ArrayList<Jugador> goleadores;
	ArrayList<Jugador> equipo;
	private Jugador arquero;
	Solver solver;
	InstanciaJugadores instancia;
	

	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazSolucion frame = new InterfazSolucion();
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
	public InterfazSolucion() {
		initialize();}
	
	private void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		//j = new InstanciaEquipo(3, 4, 3); //Creo la instancia nueva el nuevo equipo
	
		instancia= new InstanciaJugadores(3, 4, 3);
		for (int i=0;i<IngresoDatos.getEquipo().size();i++)
		{
	
		instancia.agregarJugador(IngresoDatos.getEquipo().get(i));
		
		}
		solver = new Solver(instancia);
		
		solver.resolver();
		equipo=solver.getJugadores();
		System.out.println(equipo);
		
		
		defensores= new ArrayList<Jugador>();
		mediocampistas= new ArrayList<Jugador>();
		goleadores= new ArrayList<Jugador>();
		
		
		for ( int i=0; i<equipo.size();i++)
		{
			
			if(equipo.get(i).getPosicion().equals("Defensor"))
				defensores.add(equipo.get(i));
		    if(equipo.get(i).getPosicion().equals("Medicampista"))
				mediocampistas.add(equipo.get(i));
		    if(equipo.get(i).getPosicion().equals("Delantero"))
				goleadores.add(equipo.get(i));
		    if(equipo.get(i).getPosicion().equals("Arquero"))
		    	arquero=equipo.get(i);
		}
		
	
		
		 panel_n1 = new JPanel();
		panel_n1.setBounds(49, 415, 475, 107);
		contentPane.add(panel_n1);
		panel_n1.setOpaque(false);
		panel_n1.setLayout(null);
		panel_n1.setVisible(true);
		
		 panel_n2 = new JPanel();
		panel_n2.setBounds(49, 204, 475, 188);
		contentPane.add(panel_n2);
		panel_n2.setOpaque(false);
		panel_n2.setVisible(true);
		panel_n2.setLayout(null);
	
		 panel_n3 = new JPanel();
		panel_n3.setBounds(49, 49, 475, 118);
		contentPane.add(panel_n3);
		panel_n3.setOpaque(false);
		panel_n3.setVisible(true);
		panel_n3.setLayout(null);
		
		
		panel_n4 = new JPanel();
		panel_n4.setBounds(49, 552, 475, 96);
		contentPane.add(panel_n4);
		panel_n4.setVisible(true);
		panel_n4.setOpaque(false);
		panel_n4.setLayout(null);
		
		posarquero = new JLabel();
		posarquero.setBounds(185, 30, 112, 55);
		panel_n4.add(posarquero);
		posarquero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		posarquero.setIcon(new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Romero.png")));
		posarquero.setText(arquero.getNombre());
		
		
		
		defensor1 = new JLabel();
		defensor1.setText(this.defensores.get(0).getNombre());
		defensor1.setBounds(59, 11, 45, 45);
		panel_n1.add(defensor1);   
		
	
		
		defensor3 = new JLabel();
		defensor3.setText(this.defensores.get(2).getNombre());
		defensor3.setBounds(211, 51, 45, 45);
		panel_n1.add(defensor3);
	
	
		
		defensor2 = new JLabel();
		defensor2.setText(this.defensores.get(1).getNombre());
		defensor2.setBounds(350, 11, 45, 45);
		panel_n1.add(defensor2);
		
		
	
		level3_n2 = new JLabel();
		level3_n2.setText(this.goleadores.get(2).getNombre());	
		level3_n2.setBounds(215, 62, 45, 45);
		panel_n3.add(level3_n2);
		
		
		level3_n1 = new JLabel();
		level3_n1.setText(this.goleadores.get(1).getNombre());		
		level3_n1.setBounds(86, 15, 45, 45);
		panel_n3.add(level3_n1);

		
		level3_n3 = new JLabel();
		level3_n3.setText(this.goleadores.get(0).getNombre());		
		level3_n3.setBounds(355, 15, 45, 45);
		panel_n3.add(level3_n3);
		
		JLabel botonEquipo = new JLabel("  Nivel del equipo :  "+ solver.getNivel() );
		botonEquipo.setBounds(80, 671, 189, 29);
		contentPane.add(botonEquipo);

				
		level2_n1 = new JLabel();
		level2_n1.setText(this.mediocampistas.get(1).getNombre());
		level2_n1.setBounds(68, 8, 45, 45);			
		panel_n2.add(level2_n1);
		
		level2_n2 = new JLabel();
		level2_n2.setText(this.mediocampistas.get(2).getNombre());
		level2_n2.setBounds(116, 96, 45, 45);		
		panel_n2.add(level2_n2);
	

		
		level2_n3 = new JLabel();
		level2_n3.setText(this.mediocampistas.get(0).getNombre());
		level2_n3.setBounds(282, 96, 45, 45);	
		panel_n2.add(level2_n3);
		
		levell3_n4 = new JLabel();
		levell3_n4.setText(this.mediocampistas.get(3).getNombre());
		levell3_n4.setBounds(344, 8, 45, 45);
		panel_n2.add(levell3_n4);	
	
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InterfazSolucion.class.getResource("/imagenes/CANCHA.png")));
		lblNewLabel.setBounds(49, 11, 485, 655);
		contentPane.add(lblNewLabel);
		
	
	}
	

		
		

	}

	
	
	
	
	
	

