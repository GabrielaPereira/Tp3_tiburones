package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
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
	private ArrayList<String> lista_incompatibles ;
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
		frame.setBounds(100, 100, 838, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lista_jugadores = new ArrayList<Jugador>();
		
		
		JButton btnSubirListaIncompativas = new JButton("Subir lista Incompatibles");
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
			        		System.out.println("lista "+lista_jugadores.get(k).getNombre()+"hola");
			        		System.out.println("jugador "+jugador+" ++++");
			        		if(lista_jugadores.get(k).getNombre().equals(jugador)){
			        			
				        		lista_jugadores.get(k).setIncompatibles(i1);
					        	lista_jugadores.get(k).setIncompatibles(i2);
					        	lista_jugadores.get(k).setIncompatibles(i3);
					        	String n = (String) grid_jugadores.getValueAt(k, 1);
					        	String p = (String) grid_jugadores.getValueAt(k, 2);
					        	grid_jugadores.setValueAt(i1, k, 3);
					        	grid_jugadores.setValueAt(i2, k, 4);
					        	grid_jugadores.setValueAt(i3, k, 5);
//					        	grid_jugadores.setValueAt("Incompatible", 0, 3);
//					        	grid_jugadores.setValueAt("Incompatible", 0, 4);
//					        	grid_jugadores.setValueAt("Incompatible", 0, 5);
					        	
					        	RowsRenderer rr = new RowsRenderer(3);
					        	grid_jugadores.setDefaultRenderer(Object.class, rr);
					        	
//					        	modelo.fireTableRowsUpdated(k, k);
					        	
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
		btnSubirListaIncompativas.setBounds(459, 11, 184, 30);
		frame.getContentPane().add(btnSubirListaIncompativas);
		
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

		
		});
		btn_jugadores.setBounds(137, 11, 177, 30);
		frame.getContentPane().add(btn_jugadores);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 52, 714, 440);
		frame.getContentPane().add(scrollPane);
		
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
		btn_hayEquipo.setBounds(540, 504, 227, 28);
		frame.getContentPane().add(btn_hayEquipo);
		

		
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
