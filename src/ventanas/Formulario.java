package ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import stocks.Almacen;
import stocks.Estante;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Formulario extends JFrame {

	private static final long serialVersionUID = 2609174371611479380L;	
	private JPanel contentPane;
	private JTextField textID;
	//private JTextField textNombre;
	private JTextField textValor;
	//private JTextField textFecha;
	
	
	public Formulario(Almacen ini, String tipo, int idContenedor, int idContenedor2) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*if(tipo.equals("Insumo"))
			addFormInsumo(ini, idContenedor, idContenedor2);
		else*/
			if(tipo.equals("Estante"))
				addFormEstante(ini, idContenedor);
			/*else
				if(tipo.equals("Espacio"))
					addFormEspacio(ini, idContenedor);*/
	}
	
	//Formulario para un nuevo insumo
/*	public void addFormInsumo(Almacen ini, int idEspacio, int idEstante) {
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 440, 253);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		textID = new JTextField();
		textID.setBounds(169, 28, 222, 19);
		panel_3.add(textID);
		textID.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(169, 59, 222, 19);
		panel_3.add(textNombre);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(169, 84, 222, 19);
		panel_3.add(textValor);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(169, 113, 222, 19);
		panel_3.add(textFecha);
		
		JLabel label1 = new JLabel("ID");
		label1.setBounds(53, 30, 66, 15);
		panel_3.add(label1);
		
		JLabel label2 = new JLabel("Nombre");
		label2.setBounds(53, 61, 66, 15);
		panel_3.add(label2);
		
		JLabel label3 = new JLabel("Valor");
		label3.setBounds(53, 86, 66, 15);
		panel_3.add(label3);
		
		JLabel label4 = new JLabel("Fecha");
		label4.setBounds(53, 115, 66, 15);
		panel_3.add(label4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(150, 161, 156, 19);
		lblNewLabel.setText("");
		panel_3.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("New button");
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(textID.getText().isEmpty()||(textNombre.getText().isEmpty())||(textValor.getText().isEmpty())||(textFecha.getText().isEmpty()))
                    lblNewLabel.setText("No Agregado. Existe al menos un espacio en blanco.");
                else {       
        			Insumo insumo = new Insumo(Integer.parseInt(textID.getText()), Integer.parseInt(textValor.getText()), textNombre.getText(),textFecha.getText());
        			ini.mostrarEstante(idEstante).mostrarEspacio(idEspacio).agregarInsumosEspacio(insumo);
                	lblNewLabel.setText("Insumo Agregado con exito.");
                }
            }
        });

		
		JButton btnCancel = new JButton("Cancelar");
		panel_2.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblNewLabel.setText("");
        		dispose();
            }
        });
	}*/

	//Formulario para un nuevo Estante
	public void addFormEstante(Almacen ini, int idAlmacen) {
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 440, 253);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		textID = new JTextField();
		textID.setBounds(169, 28, 222, 19);
		panel_2.add(textID);
		textID.setColumns(10);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(169, 84, 222, 19);
		panel_2.add(textValor);
				
		JLabel label1 = new JLabel("ID");
		label1.setBounds(53, 30, 66, 15);
		panel_2.add(label1);
		
		JLabel label3 = new JLabel("Capacidad");
		label3.setBounds(53, 86, 80, 15);
		panel_2.add(label3);
				
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(150, 161, 200, 19);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("Agregar");
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(textID.getText().isEmpty()||(textValor.getText().isEmpty()))
                    lblNewLabel.setText("No Agregado. Existe al menos un espacio en blanco.");
                else {       
        			Estante newEstante = new Estante(Integer.parseInt(textID.getText()), Integer.parseInt(textValor.getText()), ini.getSala());
        			try {
						ini.agregarEstante(newEstante);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
                	lblNewLabel.setText("Estante Agregado con exito.");
                }
            }
        });

		
		JButton btnCancel = new JButton("Cerrar");
		panel_3.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblNewLabel.setText("");
        		dispose();
            }
        });
	}
	
	//Formulario para un nuevo Espacio
	/*public void addFormEspacio(Almacen ini, int idEstante) {
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 440, 253);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		textID = new JTextField();
		textID.setBounds(169, 28, 222, 19);
		panel_2.add(textID);
		textID.setColumns(10);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(169, 84, 222, 19);
		panel_2.add(textValor);
		
		JLabel label1 = new JLabel("ID");
		label1.setBounds(53, 30, 66, 15);
		panel_2.add(label1);
				
		JLabel label3 = new JLabel("Capacidad");
		label3.setBounds(53, 86, 80, 15);
		panel_2.add(label3);
		
		
		JLabel estado = new JLabel("");
		estado.setBounds(150, 161, 200, 19);
		panel_2.add(estado);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("New button");
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(textID.getText().isEmpty()||(textNombre.getText().isEmpty())||(textValor.getText().isEmpty()))
                    estado.setText("No Agregado. Existe al menos un espacio en blanco.");
                else {       
        			Espacio newEspacio = new Espacio(Integer.parseInt(textID.getText()), Integer.parseInt(textValor.getText()));
        			ini.mostrarEstante(idEstante).agregarEspacio(newEspacio);
                	estado.setText("Espacio Agregado con exito.");
                }
            }
        });

		
		JButton btnCancel = new JButton("Cerrar");
		panel_2.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		estado.setText("");
        		dispose();
            }
        });
	}*/
}
