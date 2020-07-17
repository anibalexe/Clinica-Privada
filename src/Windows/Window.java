package Windows;

import javax.swing.JFrame;

public abstract class Window {
	
	private JFrame frame;
	
	public Window() {
		frame = new JFrame();
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void showFrame() {
		frame.setVisible(true);
	}
	
	public void hideFrame() {
		frame.setVisible(false);
	}
	
	
//	public abstract void initialize();
	
	public abstract void initialize(Object objeto);
}
