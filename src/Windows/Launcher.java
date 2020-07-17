package Windows;

import java.awt.EventQueue;

public class Launcher {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Login();
					window.showFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
