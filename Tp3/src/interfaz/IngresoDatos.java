package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import logica.Jugador;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class IngresoDatos {

	private JFrame frame;
	private JTable grid_jugadores;
	private ArrayList<Jugador> lista_jugadores ;
	DefaultTableModel modelo;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoDatos window = new IngresoDatos();
					window.frame.setVisible(true);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 735, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lista_jugadores = new ArrayList<Jugador>();
		
		
		JButton btn_jugadores = new JButton("Subir lista Jugadores");
		btn_jugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File file = new File("");
				 
				 file = abrirarchivo();
				if(file != null){
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				        .newInstance();
				DocumentBuilder documentBuilder = null;
				try {
					documentBuilder = documentBuilderFactory.newDocumentBuilder();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				org.w3c.dom.Document document = null;
				try {
					document =  documentBuilder.parse(file);
				} catch (SAXException | IOException e) {

					e.printStackTrace();
				}
				
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
			        
//			        	n = Integer.parseInt(nivel.toString());
			        	Jugador j = new Jugador();
			        	j.setNombre(jugador);
			        	j.setNivel(nivel);
			        	j.setPosicion(posicion);
			        	lista_jugadores.add(j);
			        }
			        }
			    }
			    
			}

			private File abrirarchivo() {
				
				File file = null;
				JFileChooser f =new JFileChooser();
				int r = f.showOpenDialog(f);
				if(r == JFileChooser.APPROVE_OPTION){
				 File abre=f.getSelectedFile();
				 file = new File(abre.toString());
				}else{
					
				}
				  
				return file;
				
			}
		});
		btn_jugadores.setBounds(124, 33, 164, 30);
		frame.getContentPane().add(btn_jugadores);
		
		JButton btnSubirListaIncompativas = new JButton("Subir lista Incompatibles");
		btnSubirListaIncompativas.setBounds(377, 33, 164, 30);
		frame.getContentPane().add(btnSubirListaIncompativas);
		
		grid_jugadores = new JTable();
		grid_jugadores.setBounds(10, 108, 680, 282);
		grid_jugadores.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"jugador", "nivel", "pos","i1", "i2", "i3" 
				}
			));
		frame.getContentPane().add(grid_jugadores);
		
		modelo = (DefaultTableModel) grid_jugadores.getModel();   //modelo para la grilla

	}
}
