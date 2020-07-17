package ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import stocks.Almacen;
import stocks.Insumo;

public class ComboFormulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public ComboFormulario(Almacen ini) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, -20, 143, 225);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Almacen");
		lblNewLabel.setBounds(62, 32, 58, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Estante");
		lblNewLabel_1.setBounds(62, 59, 52, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Espacio");
		lblNewLabel_2.setBounds(62, 86, 51, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(62, 113, 66, 15);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		lblNewLabel_4.setBounds(62, 138, 66, 15);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Valor");
		lblNewLabel_5.setBounds(62, 165, 66, 15);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(141, -20, 287, 225);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(29, 32, 197, 24);
		comboBox.addItem("1");
		panel_2.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(29, 78, 197, 24);
		panel_2.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(29, 55, 197, 24);
		panel_2.add(comboBox_2);
		
		textField = new JTextField();
		textField.setBounds(29, 114, 197, 19);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(29, 138, 197, 19);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(29, 165, 197, 19);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lbl = new JLabel("");
		lbl.setBounds(0, 183, 250, 15);
		panel_2.add(lbl);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 205, 428, 48);
		panel.add(panel_3); 
		
		JButton btnNewButton_1 = new JButton("Agregar");
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
		panel_3.add(btnNewButton);
		
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBox_2.removeAllItems();
				comboBox_1.removeAllItems();
				String combo1 = comboBox.getSelectedItem().toString();
				int i = 0;
				while(i < ini.contarEstantes()) {
					comboBox_2.addItem(ini.mostrarEstantePosicion(i).getId());
					i++;
				}
				comboBox_2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						comboBox_1.removeAllItems();
						String combo2 = comboBox_2.getSelectedItem().toString();
						int j = 0;
						while(j<ini.mostrarEstante(Integer.parseInt(combo2)).contarEspacios()) {
							comboBox_1.addItem(ini.mostrarEstante(Integer.parseInt(combo2)).mostrarEspacioPosicion(j).getId());
							j++;
						}
					}
				});

			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println(comboBox.getSelectedItem().toString() + comboBox_2.getSelectedItem().toString() + comboBox_1.getSelectedItem().toString());
        		if(textField.getText().isEmpty()||(textField_1.getText().isEmpty()) ||(textField_2.getText().isEmpty()))
                    lbl.setText("No Agregado. Existe al menos un espacio en blanco.");
                else {       
        			Insumo newInsumo = new Insumo(Integer.parseInt(textField.getText()), Integer.parseInt(textField_2.getText()), textField_1.getText(),0,0,0,Integer.parseInt(comboBox_1.getSelectedItem().toString()));
        			try {
						ini.mostrarEstante(Integer.parseInt(comboBox_2.getSelectedItem().toString())).mostrarEspacio(Integer.parseInt(comboBox_1.getSelectedItem().toString())).agregarInsumo(newInsumo);
					} catch (NumberFormatException | SQLException e1) {
						e1.printStackTrace();
					}
                }
            }
		});
		
	}
}
