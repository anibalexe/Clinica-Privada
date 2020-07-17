package ventanas;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import stocks.Almacen;

public class MenuButtons {
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void addComponentsToPane(Container pane, Almacen ini) {

        JPanel panel = new JPanel();
		panel.setBounds(310, 144, 250, 170);
		pane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		addAButtonEstante("Ver Estantes", panel, ini);
        addAButtonAgregarInsumo("Agregar Insumo", panel, ini);
        addAButtonReporte("Generar Reporte Insumos", panel ,ini);
        addAButtonExit("Salir", panel);
    }

    private static void addAButtonAgregarInsumo(String text, Container container, Almacen ini) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ComboFormulario frame = new ComboFormulario(ini);
        		frame.setVisible(true);
        	}
        });
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }
    private static void addAButtonReporte(String text, Container container, Almacen ini) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ini.generarReporteInsumos();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
        	}
        });
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }
    
    //Función boton salida
    private static void addAButtonExit(String text, Container container) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
        if(text.contentEquals("Salir"))
        	button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	System.exit(0);
                }
            });
    }
    // Boton ver estantes
    private static void addAButtonEstante(String text, Container container, Almacen ini) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SecundaryFrame frame = new SecundaryFrame(ini, "Almacen");
				frame.setVisible(true);
            }
        });
    }
    // Barra de Menu
    public static JMenuBar addMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de ");
		mnAyuda.add(mntmAcercaDe);
		
		return menuBar;
    }

}
