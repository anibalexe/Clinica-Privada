package Windows;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AddData extends Window {

	public AddData() {
		super();
		initialize();
	}

	@Override
	public void initialize() {
		JFrame frame = super.getFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mnArchivo.add(mntmLogOut);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnArchivo.add(mntmExit);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(mntmAcercaDe);
		
		JButton btnAlmacen = new JButton("Almacen");
		btnAlmacen.setBounds(152, 33, 114, 21);
		frame.getContentPane().add(btnAlmacen);
		
		JButton btnEstante = new JButton("Estante");
		btnEstante.setBounds(152, 66, 114, 25);
		frame.getContentPane().add(btnEstante);
		
		JButton btnEspacio = new JButton("Espacio");
		btnEspacio.setBounds(152, 103, 114, 25);
		frame.getContentPane().add(btnEspacio);
		
		JButton btnInsumo = new JButton("Insumo");
		btnInsumo.setBounds(152, 136, 114, 25);
		frame.getContentPane().add(btnInsumo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(152, 209, 114, 25);
		frame.getContentPane().add(btnVolver);
	}

}
