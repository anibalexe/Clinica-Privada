package ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import stocks.Almacen;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

public class SecundaryFrame extends JFrame {

	private static final long serialVersionUID = 5386195787008606431L;
	private JPanel contentPane;

	public SecundaryFrame(Almacen ini, String tipo) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 716, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		
		/*
		JButton btnNewButton = new JButton("Imprimir / PDF");
		panel_8.add(btnNewButton);
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		*/
		Component verticalStrut = Box.createVerticalStrut(10);
		panel_8.add(verticalStrut);
		String tipoReal = tipo;
		if(tipo.equals("Almacen"))
		tipoReal = "Estante";
		JButton btnNewButton_1 = new JButton("Agregar " + tipoReal);
		panel_8.add(btnNewButton_1);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Formulario frame = new Formulario(ini,"Estante",1, 0);
				frame.setVisible(true);
            }
        });
		if(tipo.equals("Espacio"))
			addFrameInsumos(ini);
		else
			if(tipo.equals("Estante"))
				addFrameEspacios(ini);
			else
				if(tipo.equals("Almacen"))
					addFrameEstantes(ini);
	}
	
	public void addFrameEstantes(Almacen ini) {
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		panel_9.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblNewLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(60);
		panel_1.add(horizontalStrut);
		
		JLabel lblNewLabel_2 = new JLabel("Capacidad");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblNewLabel_2);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(40);
		panel_1.add(horizontalStrut_2);
		
		showEstantes(ini, panel_3);
	}
		
	
	public void addFrameEspacios(Almacen ini) {
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		panel_9.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblNewLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(60);
		panel_1.add(horizontalStrut);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblNewLabel_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(40);
		panel_1.add(horizontalStrut_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblNewLabel_2);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(40);
		panel_1.add(horizontalStrut_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblNewLabel_3);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_1);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		
		JPanel panel_5 = new JPanel();
		panel_7.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		String dato = Integer.toString(ini.mostrarEstante(1).getId());
		
		JLabel lblNewLabel3 = new JLabel(dato);
		lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel3);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_3);
		
		JLabel lblNewLabel_11 = new JLabel("hola");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_11);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_4);
		
		JLabel lblNewLabel_21 = new JLabel("New label");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_21);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_5);
		
		JLabel lblNewLabel_31 = new JLabel("New label");
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_31);
		
		JPanel panel_6 = new JPanel();
		panel_7.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JButton btnNewButton_211 = new JButton("Editar");
		panel_6.add(btnNewButton_211);
		
		JButton btnNewButton_311 = new JButton("Eliminar");
		panel_6.add(btnNewButton_311);
	}
	
	public void addFrameInsumos(Almacen ini) {
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		panel_9.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblNewLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(60);
		panel_1.add(horizontalStrut);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblNewLabel_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(40);
		panel_1.add(horizontalStrut_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblNewLabel_2);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(40);
		panel_1.add(horizontalStrut_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblNewLabel_3);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_1);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		
		JPanel panel_5 = new JPanel();
		panel_7.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		String dato = Integer.toString(ini.mostrarEstante(1).getId());
		
		JLabel lblNewLabel3 = new JLabel(dato);
		lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel3);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_3);
		
		JLabel lblNewLabel_11 = new JLabel("hola");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_11);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_4);
		
		JLabel lblNewLabel_21 = new JLabel("New label");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_21);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_5);
		
		JLabel lblNewLabel_31 = new JLabel("New label");
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_31);
		
		JPanel panel_6 = new JPanel();
		panel_7.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JButton btnNewButton_211 = new JButton("Editar");
		panel_6.add(btnNewButton_211);
		
		JButton btnNewButton_311 = new JButton("Eliminar");
		panel_6.add(btnNewButton_311);
	}
	
	public void showEstantes(Almacen ini, JPanel panel) {
		int i = 1;
		
		while(ini.mostrarEstante(i)!= null) {
			ini.mostrarEstante(i);
			
			Component verticalStrut_1 = Box.createVerticalStrut(20);
			panel.add(verticalStrut_1);
			
			JPanel panel_7 = new JPanel();
			panel.add(panel_7);
			panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
			
			
			JPanel panel_5 = new JPanel();
			panel_7.add(panel_5);
			panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			//String dato = Integer.toString(ini.mostrarEstante(1).getId());
			
			JLabel lblNewLabel3 = new JLabel(Integer.toString(ini.mostrarEstante(i).getId()));
			lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
			panel_5.add(lblNewLabel3);
			
			Component horizontalStrut_3 = Box.createHorizontalStrut(20);
			panel_5.add(horizontalStrut_3);
			
			Component horizontalStrut_4 = Box.createHorizontalStrut(20);
			panel_5.add(horizontalStrut_4);
			
			JLabel lblNewLabel_21 = new JLabel(Integer.toString(ini.mostrarEstante(i).getCapacidad()));
			lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
			panel_5.add(lblNewLabel_21);
			
			JPanel panel_6 = new JPanel();
			panel_7.add(panel_6);
			panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
			
			JButton btnNewButton_211 = new JButton("Editar");
			panel_6.add(btnNewButton_211);
			
			JButton btnNewButton_311 = new JButton("Eliminar");
			panel_6.add(btnNewButton_311);
			
			i++;
		}
		
		/*
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		
		JPanel panel_5 = new JPanel();
		panel_7.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		String dato = Integer.toString(ini.mostrarEstante(1).getId());
		
		JLabel lblNewLabel3 = new JLabel(dato);
		lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel3);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_3);
		
		JLabel lblNewLabel_11 = new JLabel("hola");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_11);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_4);
		
		JLabel lblNewLabel_21 = new JLabel("New label");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_21);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_5);
		
		JLabel lblNewLabel_31 = new JLabel("New label");
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_31);
		
		JPanel panel_6 = new JPanel();
		panel_7.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JButton btnNewButton_211 = new JButton("Editar");
		panel_6.add(btnNewButton_211);
		
		JButton btnNewButton_311 = new JButton("Eliminar");
		panel_6.add(btnNewButton_311);
		*/
	}
	
}
