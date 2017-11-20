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

import logica.InstanciaEquipo;
import logica.InstanciaJugadores;
import logica.Jugador;
import logica.Solver;

import java.awt.Toolkit;
public class InterfazSolucion extends JFrame {

	private JPanel contentPane;
	
	//private InstanciaEquipo j;
	private JTextField defensor1;
	private JTextField level2_n1;
	private JTextField level2_n2;
	private JTextField level2_n3;
	private JTextField defensor2;
	private JTextField level3_n1;
	private JTextField level3_n2;
	private JTextField level3_n3;
	private JTextField levell3_n4;
	private JPanel panel_n4;
	private JPanel panel_n1;
	private JPanel panel_n2;
	private JPanel panel_n3;
	private JTextField defensor3;
	private JTextField posarquero;
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
		System.out.println(IngresoDatos.getEquipo().get(i));
		}
		solver = new Solver(instancia);
		System.out.println(solver.getJugadores());
		equipo=solver.getJugadores();
		System.out.println(equipo);
		
		defensores= new ArrayList<Jugador>();
		mediocampistas= new ArrayList<Jugador>();
		goleadores= new ArrayList<Jugador>();
		
		
		for ( int i=0; i<equipo.size();i++)
		{
			System.out.println(equipo.get(i).getPosicion());
			if(equipo.get(i).getPosicion().equals("Defensor"))
				defensores.add(equipo.get(i));
		    if(equipo.get(i).getPosicion().equals("Medicampista"))
				mediocampistas.add(equipo.get(i));
		    if(equipo.get(i).getPosicion().equals("Delantero"))
				goleadores.add(equipo.get(i));
		    if(equipo.get(i).getPosicion().equals("Arquero"))
		    	arquero=equipo.get(i);
		}
		
		
		System.out.println(defensores);
		
		 panel_n1 = new JPanel();
		panel_n1.setBounds(49, 415, 475, 107);
		contentPane.add(panel_n1);
		panel_n1.setOpaque(false);
		panel_n1.setLayout(null);
		
		 panel_n2 = new JPanel();
		panel_n2.setBounds(49, 204, 475, 188);
		contentPane.add(panel_n2);
		panel_n2.setOpaque(false);
		panel_n2.setVisible(false);
		
		//Panel nivel 3
		 panel_n3 = new JPanel();
		panel_n3.setBounds(49, 43, 475, 118);
		contentPane.add(panel_n3);
		panel_n3.setOpaque(false);
		panel_n3.setVisible(false);
		panel_n3.setLayout(null);
		
		
		panel_n4 = new JPanel();
		panel_n4.setBounds(58, 552, 475, 62);
		contentPane.add(panel_n4);
		panel_n4.setVisible(false);
		panel_n4.setOpaque(false);
		panel_n4.setLayout(null);
		
		
		
		defensor1 = new JTextField();
		defensor1.setText(this.defensores.get(0).getNombre());
		defensor1.setBounds(59, 11, 45, 45);
		panel_n1.add(defensor1);
	
		defensor1.setColumns(10);
		
		defensor3 = new JTextField();
		defensor3.setText(this.defensores.get(2).getNombre());
		defensor3.setBounds(211, 51, 45, 45);
		panel_n1.add(defensor3);
	
		defensor3.setColumns(10);
		
	
		
		defensor2 = new JTextField();
		defensor2.setText(this.defensores.get(1).getNombre());
		defensor2.setBounds(350, 11, 45, 45);
		panel_n1.add(defensor2);
	
		defensor2.setColumns(10);
		panel_n1.setVisible(false);
		
		
		
		
		level3_n2 = new JTextField();
		level3_n2.setText(this.goleadores.get(2).getNombre());
		
			
		level3_n2.setColumns(10);
		level3_n2.setBounds(215, 62, 45, 45);
		panel_n3.add(level3_n2);
		
		level3_n1 = new JTextField();
		level3_n1.setText(this.goleadores.get(1).getNombre());
		
		level3_n1.setBounds(86, 15, 45, 45);
		panel_n3.add(level3_n1);
		level3_n1.setColumns(10);
		
		level3_n3 = new JTextField();
		level3_n3.setText(this.goleadores.get(0).getNombre());
		
		level3_n3.setColumns(10);
		level3_n3.setBounds(355, 15, 45, 45);
		panel_n3.add(level3_n3);
		
		JLabel botonEquipo = new JLabel("  Nivel del equipo :  "  );
		botonEquipo.setBounds(80, 671, 189, 29);
		contentPane.add(botonEquipo);

				
		level2_n1 = new JTextField();
		level2_n1.setText(this.mediocampistas.get(1).getNombre());
		level2_n1.setBounds(10, 8, 45, 45);
		

		
		panel_n2.setLayout(null);
		level2_n1.setColumns(4);
		panel_n2.add(level2_n1);
		
		level2_n2 = new JTextField();
		level2_n2.setText(this.mediocampistas.get(2).getNombre());
		level2_n2.setBounds(116, 96, 45, 45);
		
		panel_n2.add(level2_n2);
		level2_n2.setColumns(4);

		
		level2_n3 = new JTextField();
		level2_n3.setText(this.mediocampistas.get(0).getNombre());
		level2_n3.setBounds(282, 96, 45, 45);
		
		panel_n2.add(level2_n3);
		level2_n3.setColumns(4);
		
		levell3_n4 = new JTextField();
		levell3_n4.setText(this.mediocampistas.get(3).getNombre());
		levell3_n4.setBounds(371, 8, 45, 45);
		panel_n2.add(levell3_n4);
		
		levell3_n4.setColumns(10);
		
		posarquero = new JTextField();
		posarquero.setText(arquero.getNombre());
		
		
		
		posarquero.setColumns(10);
		posarquero.setBounds(202, 11, 45, 45);
		panel_n4.add(posarquero);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InterfazSolucion.class.getResource("/imagenes/CANCHA.png")));
		lblNewLabel.setBounds(49, 11, 485, 655);
		contentPane.add(lblNewLabel);
		
	
	}
	

		
		

	}

	
	
	
	
	
	

