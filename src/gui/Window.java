package gui;

import java.awt.EventQueue;

public class Window {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Window();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Window() {
		initialize();
	}

	private void initialize() {
		new Login_JFrame();
		//JFrame mainFrame = new MainFrame();
	}
}
