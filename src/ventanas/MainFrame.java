package ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import stocks.Almacen;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -6624151426567046910L;
	private JPanel contentPane;

	public MainFrame(Almacen ini) {
		super("Gestión Clinica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);	
		setJMenuBar(MenuButtons.addMenuBar());

		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		MenuButtons.addComponentsToPane(contentPane, ini);
	}

}