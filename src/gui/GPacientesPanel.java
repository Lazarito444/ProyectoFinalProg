package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class GPacientesPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public GPacientesPanel() {
		
		setBackground(new Color(238, 238, 238));
		setBounds(0, 0, 1350, 860);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1350, 860);
		scrollPane.setBackground(new Color(238, 238, 238));
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(106, 238, 109));
		panel_1.setBounds(1021, 103, 215, 190);
		panel.add(panel_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1331, 0, 17, 860);
		panel.add(scrollBar);
		
	}
}
