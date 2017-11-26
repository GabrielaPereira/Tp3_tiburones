package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Threads.ThreadBarra;
import logica.Jugador;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;




public class IngresoDatos {
    private JComboBox<String> jcombobox;
	private JFrame frmArgentinaRusia;
	private JTable grid_jugadores;
	private ArrayList<Jugador> lista_jugadores ;

	DefaultTableModel modelo;
	UIManager.LookAndFeelInfo[] lafinfo = UIManager.getInstalledLookAndFeels();
	public static JProgressBar PbhayEquipo;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoDatos window = new IngresoDatos();
					window.frmArgentinaRusia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public IngresoDatos() {
		initialize();
			try
		{		 
				UIManager.setLookAndFeel("UpperEssential.UpperEssentialLookAndFeel");
		}
		 catch(Exception e) { e.printStackTrace();}
	}

	/**
	 * Initialize the contents of the frame.
	 */
		
	private void initialize() {
		frmArgentinaRusia = new JFrame();
		frmArgentinaRusia.setIconImage(Toolkit.getDefaultToolkit().getImage(IngresoDatos.class.getResource("/imagenes/Copa Mundial Rusia 2018.png")));
		frmArgentinaRusia.setFont(new Font("Book Antiqua", Font.PLAIN, 14));
		frmArgentinaRusia.setTitle("Argentina Rusia 2018");
		frmArgentinaRusia.setBounds(100, 100, 838, 582);
		frmArgentinaRusia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArgentinaRusia.getContentPane().setLayout(null);
		
		lista_jugadores = new ArrayList<Jugador>();
			
		JButton btnSubirListaIncompativas = new JButton("Incompatibles");
		btnSubirListaIncompativas.setIcon(new ImageIcon(IngresoDatos.class.getResource("/imagenes/incompatible.png")));
		btnSubirListaIncompativas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				File file = new File("");
				 
			    file = abrirarchivo();
				if(file != null){
				org.w3c.dom.Document document = buildDocument(file);
				if(document != null){
				NodeList nodeList = document.getElementsByTagName("dato");
				
			    for (int i = 0; i < nodeList.getLength(); i++) {
			    				    				    	
			        Node node = nodeList.item(i);
			        if (node.getNodeType() == Node.ELEMENT_NODE) {

			        	String jugador, i1, i2, i3;
									        	
			        	jugador = ((org.w3c.dom.Document) document).getElementsByTagName("jugador").item(i).getTextContent();
			        	i1 =  ((org.w3c.dom.Document) document).getElementsByTagName("i1").item(i).getTextContent();
			        	i2 = ((org.w3c.dom.Document) document).getElementsByTagName("i2").item(i).getTextContent();
			        	i3 = ((org.w3c.dom.Document) document).getElementsByTagName("i3").item(i).getTextContent();

			        	for(int k=0;k<lista_jugadores.size();k++){

			        		if(lista_jugadores.get(k).getNombre().equals(jugador)){
			        			
				        		lista_jugadores.get(k).setIncompatibles(i1);
					        	lista_jugadores.get(k).setIncompatibles(i2);
					        	lista_jugadores.get(k).setIncompatibles(i3);
					        	grid_jugadores.setValueAt(i1, k, 3);
					        	grid_jugadores.setValueAt(i2, k, 4);
					        	grid_jugadores.setValueAt(i3, k, 5);
					        	
					        	RowsRenderer rr = new RowsRenderer(3);
					        	grid_jugadores.setDefaultRenderer(Object.class, rr);
					        					        	
			        		}
			        	}
			        }
			       }
			    }else{
			    	JOptionPane.showMessageDialog(null,"Error al abrir el archivo");
			    }
				}
				
				
			}
		});
		btnSubirListaIncompativas.setBounds(599, 11, 184, 30);
		frmArgentinaRusia.getContentPane().add(btnSubirListaIncompativas);
		
		JButton btn_jugadores = new JButton("Jugadores");
		btn_jugadores.setIcon(new ImageIcon(IngresoDatos.class.getResource("/imagenes/argentina1r.png")));
		btn_jugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Toolkit.getDefaultToolkit().beep();
				File file = new File("");
				 
			    file = abrirarchivo();
				if(file != null){
				org.w3c.dom.Document document = buildDocument(file);
				if(document != null ){
				NodeList nodeList = document.getElementsByTagName("dato");
				
			    for (int i = 0; i < nodeList.getLength(); i++) {
			    				    				    	
			        Node node = nodeList.item(i);
			        if (node.getNodeType() == Node.ELEMENT_NODE) {

			        	String jugador, posicion, n;
						Double nivel = null;
			        	
			        	jugador = ((org.w3c.dom.Document) document).getElementsByTagName("jugador").item(i).getTextContent();
			        	n =  ((org.w3c.dom.Document) document).getElementsByTagName("nivel").item(i).getTextContent();
			        	posicion = ((org.w3c.dom.Document) document).getElementsByTagName("posicion").item(i).getTextContent();
			        	
//						Agrego a la grilla de conexiones
			        	modelo.addRow(new Object[]{ 
			        			jugador, n, posicion, "", "", ""
						});
			        	  
			        			        	
			   
			        	Jugador j = new Jugador();
			        	j.setNombre(jugador);
			        	j.setNivel(nivel);
			        	j.setPosicion(posicion);
			        	lista_jugadores.add(j);
			        	
			        }
			        }
			    }else{
			    	JOptionPane.showMessageDialog(null,"Error al abrir el archivo");
			    }
				}
			}

		
		});
		
		
		
		btn_jugadores.setBounds(412, 11, 177, 30);
		frmArgentinaRusia.getContentPane().add(btn_jugadores);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 52, 714, 440);
		frmArgentinaRusia.getContentPane().add(scrollPane);
		
		grid_jugadores = new JTable();
		grid_jugadores.setEnabled(false);
		grid_jugadores.setRowSelectionAllowed(false);
		grid_jugadores.setCellSelectionEnabled(true);
		grid_jugadores.setColumnSelectionAllowed(true);
		grid_jugadores.setBounds(53, 52, 714, 456);
		grid_jugadores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Jugador", "Nivel", "Posicion", "Incompatible", "Incompatible", "Incompatible"
			}
		));
	
//		frame.getContentPane().add(grid_jugadores);
		
		modelo = (DefaultTableModel) grid_jugadores.getModel();   //modelo para la grilla

		scrollPane.setViewportView(grid_jugadores);
		
		JButton btn_hayEquipo = new JButton("Hay equipo?!");
		btn_hayEquipo.setIcon(new ImageIcon(IngresoDatos.class.getResource("/imagenes/pelota.png")));
		btn_hayEquipo.setToolTipText("Genera las soluciones para estos jugadores ");
		btn_hayEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				formandoEquipo(); 
				
				
				ThreadBarra barra= new ThreadBarra();				
				barra.start();
			    
			}
		});
		
		btn_hayEquipo.setBounds(589, 503, 177, 30);
		frmArgentinaRusia.getContentPane().add(btn_hayEquipo);
		
		 jcombobox = new JComboBox<String>();
		jcombobox.setBounds(97, 16, 197, 20);
		frmArgentinaRusia.getContentPane().add(jcombobox);
		
		JButton btnNewButton = new JButton("Cambiar Tema");
		btnNewButton.setToolTipText("Cambia el tema de la aplicacion");
		btnNewButton.setBounds(293, 15, 109, 23);
		frmArgentinaRusia.getContentPane().add(btnNewButton);
		
		JTextArea txtrTemas = new JTextArea();
		txtrTemas.setBackground(SystemColor.menu);
		txtrTemas.setEnabled(false);
		txtrTemas.setEditable(false);
		txtrTemas.setText("Temas ");
		txtrTemas.setBounds(26, 14, 61, 22);
		frmArgentinaRusia.getContentPane().add(txtrTemas);
		
		PbhayEquipo = new JProgressBar();
		PbhayEquipo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				formandoEquipo(); 
				
			}
		});
		PbhayEquipo.setStringPainted(true);
		PbhayEquipo.setBounds(176, 518, 242, 14);
		frmArgentinaRusia.getContentPane().add(PbhayEquipo);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				    String look = jcombobox.getSelectedItem().toString();
				    UIManager.setLookAndFeel(look);
				    SwingUtilities.updateComponentTreeUI(jcombobox);
				    }catch(Exception e){
				        e.printStackTrace();
				    }
				
			}
			});
			
		for (int i=0;i<lafinfo.length;i++){
			jcombobox.addItem(lafinfo[i].getClassName());
			jcombobox.addItem("UpperEssential.UpperEssentialLookAndFeel");
			jcombobox.addItem("com.jtattoo.plaf.smart.SmartLookAndFeel");
			jcombobox.addItem("com.jtattoo.plaf.mint.MintLookAndFeel");
			jcombobox.addItem("com.jtattoo.plaf.luna.LunaLookAndFeel");
			jcombobox.addItem("com.jtattoo.plaf.aero.AeroLookAndFeel");
		   
		    
		}
		
		
	}
	protected void formandoEquipo() {
		
		if( PbhayEquipo.getValue()==100)
		{
			InterfazSolucion pantallaEquipo = new InterfazSolucion(lista_jugadores);
			pantallaEquipo.setJugadores(lista_jugadores);
			pantallaEquipo.setVisible(true);
			frmArgentinaRusia.setVisible(false);
			
			
		}
	}

	public ArrayList<Jugador> getJugadores(){
		return this.lista_jugadores; 
	}
	
	private org.w3c.dom.Document buildDocument(File file) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
		        .newInstance();
		DocumentBuilder documentBuilder = null;
		documentBuilder = newDocument(documentBuilderFactory, documentBuilder);
		org.w3c.dom.Document document = null;
		document = parseFile(file, documentBuilder, document);
		return document;
	}

	private DocumentBuilder newDocument(DocumentBuilderFactory documentBuilderFactory,
			DocumentBuilder documentBuilder) {
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		}
		return documentBuilder;
	}

	private org.w3c.dom.Document parseFile(File file, DocumentBuilder documentBuilder,
			org.w3c.dom.Document document) {
		try {
			document =  documentBuilder.parse(file);
		} catch (SAXException | IOException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error formato");
			document = null;
		}
		
		return document;
	}

	
	
	
	private File abrirarchivo() {
		
		File file = null;
		JFileChooser f =new JFileChooser();
		int r = f.showOpenDialog(f);
		if(r == JFileChooser.APPROVE_OPTION){
		 File abre=f.getSelectedFile();
		 file = new File(abre.toString());
		}
		  
		return file;
		
	}
}
