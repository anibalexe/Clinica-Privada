package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PatientWindow extends Window {

	public PatientWindow() {
		super();
		initialize(null);
	}

	@Override
	public void initialize(Object objeto) {
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
		
		
		JButton btnCotizacion = new JButton("Cotizaciones");
		btnCotizacion.setBounds(63, 53, 114, 25);
		frame.getContentPane().add(btnCotizacion);
		
		JButton btnServicios = new JButton("Servicios");
		btnServicios.setBounds(250, 53, 114, 25);
		frame.getContentPane().add(btnServicios);
		
		JButton btnAlmacenes = new JButton("Almacenes");
		btnAlmacenes.setBounds(63, 144, 114, 25);
		frame.getContentPane().add(btnAlmacenes);
		
		JButton btnPendiente = new JButton("Pendiente");
		btnPendiente.setBounds(250, 144, 114, 25);
		frame.getContentPane().add(btnPendiente);
		
		
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
