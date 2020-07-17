package Windows;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import stocks.Almacen;
import stocks.Clinica;
import stocks.Insumo;

public class Management extends Window {
	
	public Management() {
		super();
		initialize(null);
	}

	@Override
	public void initialize(Object objeto) {
		
		//Crea la ventana
		JFrame frame = super.getFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Variables
		Almacen almacen = Clinica.allAlmacenes();
		DefaultListModel<String> model = new DefaultListModel<String>();
		ArrayList<Insumo> arrayLista = almacen.agruparInsumosAlmacen();
		Dimension sizeList = new Dimension(550, 450);
		
		
		//Se definen los botones y barra de menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 900, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mnArchivo.add(mntmLogOut);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnArchivo.add(mntmExit);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(700, 36, 114, 21);
		frame.getContentPane().add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(700, 69, 114, 25);
		frame.getContentPane().add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(700, 106, 114, 25);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(700, 500, 114, 25);
		frame.getContentPane().add(btnVolver);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 33, 600, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JList<String> list;
		JScrollPane scrollableList;
		
		//Carga datos por pantalla
		for(Insumo in : arrayLista) {
			model.addElement(in.toString());
		}
		
		list = new JList<String>(model);
		list.setFixedCellWidth(550);
		
		scrollableList = new JScrollPane(list);
		scrollableList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollableList.setPreferredSize(sizeList);
		panel.add(scrollableList); 
		
		// Accionaldores y lanzadores
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window newFrame = new EditInsumo(arrayLista.get(list.getSelectedIndex()));
				newFrame.showFrame();
				frame.dispose();
			}
		});
		
	   	btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window newFrame = new AddInsumo();
				newFrame.showFrame();
				frame.dispose();
			}
		});
		
/*		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println((arrayLista.get((list.getSelectedIndex()))).toString());
			}
		});
*/		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window newFrame = new AdministratorWindow();
				newFrame.showFrame();
				frame.dispose();
			}
		});
		
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
