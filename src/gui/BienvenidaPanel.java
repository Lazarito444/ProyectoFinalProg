package gui;

import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.awt.Cursor;

public class BienvenidaPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public BienvenidaPanel(String username) {

		setBounds(0, 0, 1350, 860);
		setBackground(new Color(238, 238, 238));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1350, 860);
		scrollPane.setBackground(new Color(238, 238, 238));
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(33, 131, 222));
		header.setBounds(0, 0, 1350, 200);
		panel.add(header);
		header.setLayout(null);
		
		JLabel bienvenidaLbl = new JLabel("¡Bienvenido al sistema de gestión del hospital, "+username+"!");
		bienvenidaLbl.setForeground(new Color(255, 255, 255));
		bienvenidaLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 28));
		bienvenidaLbl.setBounds(100, 50, 752, 40);
		header.add(bienvenidaLbl);
		
		LocalDate fecha = LocalDate.now();
		
		int weekDay = fecha.getDayOfWeek().getValue();
		int day = fecha.getDayOfMonth();
		int month = fecha.getMonthValue();
		int year = fecha.getYear();
		
		String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
		String[] meses = {"Enero", "Febrero", "Marzo",  "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		
		JLabel fechaLbl = new JLabel("Hoy es "+diasSemana[weekDay-1]+" "+day+" del mes de "+meses[month-1]+" del año "+year+".");
		fechaLbl.setForeground(Color.WHITE);
		fechaLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 24));
		fechaLbl.setBounds(100, 101, 620, 40);
		header.add(fechaLbl);
		
		JLabel lblNewLabel = new JLabel("¿Qué puedes hacer en este sistema?");
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.BOLD, 35));
		lblNewLabel.setBounds(122, 255, 687, 71);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><ul>\r\n<li>Gestionar a los pacientes del hospital.</li>\r\n<li>Gestionar al personal del hospital.</li>\r\n<li>Gestionar los medicamentos que el hospital tiene disponible.</li>\r\n<li>Realizar facturaciones y cobros</li>\r\n<li>Gestionar las ventas del hospital</li>\r\n</ul></html>");
		lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.BOLD, 26));
		lblNewLabel_1.setBounds(157, 318, 789, 230);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Si necesitas ayuda no dudes en visitar la");
		lblNewLabel_2.setFont(new Font("Roboto Condensed", Font.BOLD, 25));
		lblNewLabel_2.setBounds(157, 641, 416, 42);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("<html>\r\n<a href=\"#\">Documentación Oficial</a>\r\n</html>");
		lblNewLabel_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						if (desktop.isSupported(Desktop.Action.BROWSE)) {
							desktop.browse(new URI("https://itlaedudo-my.sharepoint.com/:w:/g/personal/20230253_itla_edu_do/EWQcbKYp9bVMp890XEltC5IBE_azLSCje76s_6enjeLaeQ?e=qBbkjP"));
						}
					}
				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		lblNewLabel_2_1.setFont(new Font("Roboto Condensed", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(570, 641, 239, 42);
		panel.add(lblNewLabel_2_1);
		
	}
}
