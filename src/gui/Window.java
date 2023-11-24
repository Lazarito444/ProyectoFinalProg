package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
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
		JFrame login_JFrame = new Login_JFrame();
		login_JFrame.setVisible(true);
	}
}
