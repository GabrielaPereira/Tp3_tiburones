package interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logica.InstanciaJugadores;
import logica.Jugador;
import logica.Solver;

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
		panel_n1.setBounds(49, 404, 475, 145);
		contentPane.add(panel_n1);
		panel_n1.setOpaque(false);
		panel_n1.setLayout(null);
		panel_n1.setVisible(true);
		
		 panel_n2 = new JPanel();
		panel_n2.setBounds(49, 203, 475, 188);
		contentPane.add(panel_n2);
		panel_n2.setOpaque(false);
		panel_n2.setVisible(true);
		panel_n2.setLayout(null);
	
		 panel_n3 = new JPanel();
		panel_n3.setBounds(49, 24, 475, 143);
		contentPane.add(panel_n3);
		panel_n3.setOpaque(false);
		panel_n3.setVisible(true);
		panel_n3.setLayout(null);
		
		
		panel_n4 = new JPanel();
		panel_n4.setBounds(49, 560, 475, 88);
		contentPane.add(panel_n4);
		panel_n4.setVisible(true);
		panel_n4.setOpaque(false);
		panel_n4.setLayout(null);
		
		posarquero = new JLabel();
		posarquero.setBounds(192, 11, 140, 74);
		panel_n4.add(posarquero);
		posarquero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		posarquero.setIcon(setFoto(arquero.getNombre()));
		posarquero.setText(arquero.getNombre());
		
		
		
		defensor1 = new JLabel();
		defensor1.setText(this.defensores.get(0).getNombre());
		defensor1.setBounds(41, 24, 116, 73);
		panel_n1.add(defensor1);   
		defensor1.setIcon(setFoto(this.defensores.get(0).getNombre()));
	
		
		defensor3 = new JLabel();
		defensor3.setText(this.defensores.get(2).getNombre());
		defensor3.setBounds(201, 72, 138, 73);
		panel_n1.add(defensor3);
		defensor3.setIcon(setFoto(this.defensores.get(2).getNombre()));
		
		
		defensor2 = new JLabel();
		defensor2.setText(this.defensores.get(1).getNombre());
		defensor2.setBounds(316, 21, 159, 78);
		panel_n1.add(defensor2);
		defensor2.setIcon(setFoto(this.defensores.get(1).getNombre()));
		
	
		level3_n2 = new JLabel();
		level3_n2.setText(this.goleadores.get(2).getNombre());	
		level3_n2.setBounds(213, 62, 132, 81);
		panel_n3.add(level3_n2);
		level3_n2.setIcon(setFoto(this.goleadores.get(2).getNombre()));
		
		level3_n1 = new JLabel();
		level3_n1.setText(this.goleadores.get(1).getNombre());		
		level3_n1.setBounds(86, 15, 147, 72);
		panel_n3.add(level3_n1);
		level3_n1.setIcon(setFoto(this.goleadores.get(1).getNombre()));
		
		
		level3_n3 = new JLabel();
		level3_n3.setText(this.goleadores.get(0).getNombre());		
		level3_n3.setBounds(355, 15, 110, 72);
		panel_n3.add(level3_n3);
		level3_n3.setIcon(setFoto(this.goleadores.get(0).getNombre()));
		
		
		JLabel botonEquipo = new JLabel("  Nivel del equipo :  "+ "hacer ");
		botonEquipo.setBounds(80, 671, 189, 29);
		contentPane.add(botonEquipo);

				
		level2_n1 = new JLabel();
		level2_n1.setText(this.mediocampistas.get(1).getNombre());
		level2_n1.setBounds(33, 23, 140, 61);			
		panel_n2.add(level2_n1);
		level2_n1.setIcon(setFoto(this.mediocampistas.get(1).getNombre()));
		
		level2_n2 = new JLabel();
		level2_n2.setText(this.mediocampistas.get(2).getNombre());
		level2_n2.setBounds(119, 106, 131, 61);		
		panel_n2.add(level2_n2);
		level2_n2.setIcon(setFoto(this.mediocampistas.get(2).getNombre()));

		
		level2_n3 = new JLabel();
		level2_n3.setText(this.mediocampistas.get(0).getNombre());
		level2_n3.setBounds(284, 96, 140, 81);	
		panel_n2.add(level2_n3);
		level2_n3.setIcon(setFoto(this.mediocampistas.get(0).getNombre()));
		
		levell3_n4 = new JLabel();
		levell3_n4.setText(this.mediocampistas.get(3).getNombre());
		levell3_n4.setBounds(354, 15, 121, 77);
		panel_n2.add(levell3_n4);	
		levell3_n4.setIcon(setFoto(this.mediocampistas.get(3).getNombre()));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InterfazSolucion.class.getResource("/imagenes/CANCHA.png")));
		lblNewLabel.setBounds(49, 11, 485, 655);
		contentPane.add(lblNewLabel);
		
	
	}

	private Icon setFoto(String nombre) {
		ImageIcon imagen = null;
	
		switch(nombre){
		
		case("Mascherano"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Mascherano.png"));
		break;
		case("Marchesin"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Marchesin.png"));
		break;
		case("Dybala"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Dybala.png"));
		break;
		case("Di Maria"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Di Maria.png"));
		break;
		case("Otamendi"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Otamendi.png"));
		break;
		case("Funes Mori"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Funes Mori.png"));
		break;	
		case("Mercado"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Mercado.png"));
		break;
		case("Pazzela"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Pazzela.png"));
		break;
		case("Fazio"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Fazio.png"));
		break;
		case("Romero"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Romero.png"));
		break;
		case("Guzman"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Guzman.png"));
		break;
		case("Acuña"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Acuña.png"));
		break;
		case("Biglia"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Biglia.png"));
		break;
		case("Rigone"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Rigone.png"));
		break;
		case("Paredes"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Paredes.png"));
		break;
		case("Kranevitter"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Kranevitter.png"));
		break;
		case("Banega"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Banega.png"));
		break;
		case("Papu Gomez"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Papu Gomez.png"));
		break;
		case("Salvio"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Salvio.png"));
		break;
		case("Diego peroti"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Diego peroti.png"));
		break;
		case("Messi"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Messi.png"));
		break;
		case("Agüero"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Agüero.png"));
		break;
		case("Icardi"):imagen = new ImageIcon(InterfazSolucion.class.getResource("/imagenes/Icardi.png"));
		break;
		default: break;
		
		}
	
		return imagen;
	
	}
		
		

	}

	
	
	
	
	
	

