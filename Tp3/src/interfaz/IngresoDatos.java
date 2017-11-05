package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
				org.w3c.dom.Document document = buildDocument(file);
				if(document != null){
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
//					e.printStackTrace();
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
				}else{
					JOptionPane.showMessageDialog(null,"Se cancelo la subida");
				}
				  
				return file;
				
			}
		});
		btn_jugadores.setBounds(124, 33, 177, 30);
		frame.getContentPane().add(btn_jugadores);
		
		JButton btnSubirListaIncompativas = new JButton("Subir lista Incompatibles");
		btnSubirListaIncompativas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSubirListaIncompativas.setBounds(377, 33, 184, 30);
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
