package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JComboBox;

public class MainWindow {

	private JFrame frame;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textDateDay;
	private JTextField textMes;
	private JTextField textAnno;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 */
	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		
		textId = new JTextField();
		textId.setBounds(130, 70, 124, 19);
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(41, 100, 66, 15);
		frame.getContentPane().add(lblNombre);
		
		JLabel labelDate = new JLabel("Fecha:");
		labelDate.setBounds(350, 40, 66, 15);
		frame.getContentPane().add(labelDate);
		
		textNombre = new JTextField();
		textNombre.setBounds(130, 100, 124, 19);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textDateDay = new JTextField();
		textDateDay.setBounds(400, 70, 124, 19);
		frame.getContentPane().add(textDateDay);
		textDateDay.setColumns(10);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(350, 70, 66, 15);
		frame.getContentPane().add(lblDia);
		
		textMes = new JTextField();
		textMes.setBounds(400, 100, 124, 19);
		frame.getContentPane().add(textMes);
		textMes.setColumns(10);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(350, 100, 66, 15);
		frame.getContentPane().add(lblMes);
		
		textAnno = new JTextField();
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
	}
}
