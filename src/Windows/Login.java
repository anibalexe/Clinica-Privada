package Windows;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import conexiones.BaseDeDatos;
import cuentas.*;
import excepciones.*;
import stocks.Clinica;

public class Login extends Window {
	
	private JTextField userField;
	private JPasswordField passwordField;

	public Login() {
		super();
		initialize(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	public void initialize(Object objeto){
	
		//Recibe usuarios
		Iniciar iniciales = new Iniciar();
		
		// Establece parametros de ventana
		JFrame frame = super.getFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Campos y botones de interaccion con usuario
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(68, 198, 114, 25);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(245, 198, 114, 25);
		frame.getContentPane().add(btnExit);
		
		userField = new JTextField();
		userField.setBounds(178, 73, 124, 19);
		frame.getContentPane().add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 99, 124, 19);
		frame.getContentPane().add(passwordField);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(79, 75, 66, 15);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(94, 101, 66, 15);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(125, 155, 300, 19);
		frame.getContentPane().add(lblError);
		
		//Accionadores
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = userField.getText();
				Usuario user = iniciales.buscarUsuario(data);
				Window newFrame = null;

				if(user != null) {
					if(user.validarCuenta() == "Administrador") {
						Administrador admin = (Administrador) user;
						if(admin.comparePass().equals(new String(passwordField.getPassword()))) {
							newFrame = new AdministratorWindow();
						}
					} else {
						Paciente paciente = (Paciente) user;
						if(paciente.comparePass().equals(new String(passwordField.getPassword()))) {
							newFrame = new PatientWindow();
						}
					}
					if(newFrame != null) {
						frame.dispose();
						newFrame.showFrame();	
						try {
							BaseDeDatos.getConexion();
							Clinica openClinica = new Clinica();
						} catch (SQLException e1) {
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						}
					} else {
						try {
							throw new UsuarioOClaveInvalidaException();
						} catch (UsuarioOClaveInvalidaException e1) {
							lblError.setText(e1.getMessage());
							userField.setText("");
							passwordField.setText("");
						}
					}
				} else {
					try {
						throw new UsuarioOClaveInvalidaException();
					} catch (UsuarioOClaveInvalidaException e1) {
						lblError.setText(e1.getMessage());
						userField.setText("");
						passwordField.setText("");
					}
				}
			}

		}); 
		
	}	

}
