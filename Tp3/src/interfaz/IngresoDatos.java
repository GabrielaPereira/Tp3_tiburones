package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class IngresoDatos {

	private JFrame frame;
	private JTable table;

	
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
		frame.setBounds(100, 100, 545, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				NodeList nodeList = document.getElementsByTagName("dato");
				
			    for (int i = 0; i < nodeList.getLength(); i++) {
			    	
			        Node node = nodeList.item(i);
			        if (node.getNodeType() == Node.ELEMENT_NODE) {

			        	String jugador, nivel, pos;
			        	jugador = ((org.w3c.dom.Document) document).getElementsByTagName("jugador").item(i).getTextContent();
			        	nivel = ((org.w3c.dom.Document) document).getElementsByTagName("nivel").item(i).getTextContent();
			        	pos = ((org.w3c.dom.Document) document).getElementsByTagName("pos").item(i).getTextContent();
			        
			        	
			        	nuevaConexion = new DatosLocalidad(prov,loc,hab,lat,lon);
			        	conexiones.add(nuevaConexion);
//					Agrego a la grilla de conexiones
			        	modelo.addRow(new Object[]{ prov, loc, 
								habs, lats,lons
								});
			        }
			        }
			    }
			    
			}
		});
		btn_jugadores.setBounds(76, 33, 164, 30);
		frame.getContentPane().add(btn_jugadores);
		
		JButton btnSubirListaIncompativas = new JButton("Subir lista Incompatibles");
		btnSubirListaIncompativas.setBounds(277, 33, 164, 30);
		frame.getContentPane().add(btnSubirListaIncompativas);
		
		table = new JTable();
		table.setBounds(40, 108, 459, 282);
		frame.getContentPane().add(table);
	}
}
