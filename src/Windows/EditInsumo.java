package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import stocks.Insumo;

public class EditInsumo extends Window {

	public EditInsumo(Insumo in) {
		super();
		initialize(in);
	}

	@Override
	public void initialize(Object objeto) {
		// TODO Auto-generated method stub
		JFrame frame = super.getFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mnArchivo.add(mntmLogOut);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnArchivo.add(mntmExit);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(400, 200, 114, 25);
		frame.getContentPane().add(btnVolver);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(41, 70, 66, 15);
		frame.getContentPane().add(lblId);
		
		JTextField textId = new JTextField();
		textId.setBounds(130, 70, 124, 19);
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(41, 100, 66, 15);
		frame.getContentPane().add(lblNombre);
		
		JLabel labelDate = new JLabel("Fecha:");
		labelDate.setBounds(350, 40, 66, 15);
		frame.getContentPane().add(labelDate);
		
		JTextField textNombre = new JTextField();
		textNombre.setBounds(130, 100, 124, 19);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JTextField textDateDay = new JTextField();
		textDateDay.setBounds(400, 70, 124, 19);
		frame.getContentPane().add(textDateDay);
		textDateDay.setColumns(10);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(350, 70, 66, 15);
		frame.getContentPane().add(lblDia);
		
		JTextField textMes = new JTextField();
		textMes.setBounds(400, 100, 124, 19);
		frame.getContentPane().add(textMes);
		textMes.setColumns(10);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(350, 100, 66, 15);
		frame.getContentPane().add(lblMes);
		
		JTextField textAnno = new JTextField();
		textAnno.setBounds(400, 130, 124, 19);
		frame.getContentPane().add(textAnno);
		textAnno.setColumns(10);
		
		JLabel lblAnno = new JLabel("Año");
		lblAnno.setBounds(350, 130, 66, 15);
		frame.getContentPane().add(lblAnno);
		
		JLabel lblDatos = new JLabel("Datos:");
		lblDatos.setBounds(41, 40, 66, 15);
		frame.getContentPane().add(lblDatos);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(100, 200, 114, 25);
		frame.getContentPane().add(btnAceptar);
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
 
 		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window newFrame = new Login();
				newFrame.showFrame();
				frame.dispose();
			}
		});
	}
	
	
	

}
