package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.SwingConstants;

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
		
		
		
		JPanel conteoPacientes = new JPanel();
		conteoPacientes.setBackground(new Color(106, 238, 109));
		conteoPacientes.setBounds(100, 250, 300, 180);
		panel.add(conteoPacientes);
		conteoPacientes.setLayout(null);
		
		JLabel pacientesLbl = new JLabel("PACIENTES REGISTRADOS HOY");
		pacientesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pacientesLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		pacientesLbl.setForeground(new Color(255, 255, 255));
		pacientesLbl.setBounds(0, 32, 300, 46);
		conteoPacientes.add(pacientesLbl);
		
		JLabel pacientesCount = new JLabel("CANTIDAD");
		pacientesCount.setHorizontalAlignment(SwingConstants.CENTER);
		pacientesCount.setForeground(Color.WHITE);
		pacientesCount.setFont(new Font("Roboto Condensed", Font.BOLD, 32));
		pacientesCount.setBounds(0, 97, 300, 46);
		conteoPacientes.add(pacientesCount);
		
		JPanel conteoPersonal = new JPanel();
		conteoPersonal.setLayout(null);
		conteoPersonal.setBackground(new Color(98, 204, 255));
		conteoPersonal.setBounds(525, 250, 300, 180);
		panel.add(conteoPersonal);
		
		JLabel personalLbl = new JLabel("PERSONAL REGISTRADO HOY");
		personalLbl.setHorizontalAlignment(SwingConstants.CENTER);
		personalLbl.setForeground(Color.WHITE);
		personalLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		personalLbl.setBounds(0, 32, 300, 46);
		conteoPersonal.add(personalLbl);
		
		JLabel personalCount = new JLabel("CANTIDAD");
		personalCount.setHorizontalAlignment(SwingConstants.CENTER);
		personalCount.setForeground(Color.WHITE);
		personalCount.setFont(new Font("Roboto Condensed", Font.BOLD, 32));
		personalCount.setBounds(0, 97, 300, 46);
		conteoPersonal.add(personalCount);
		
		JPanel conteoMedicamentos = new JPanel();
		conteoMedicamentos.setLayout(null);
		conteoMedicamentos.setBackground(new Color(255, 123, 60));
		conteoMedicamentos.setBounds(950, 250, 300, 180);
		panel.add(conteoMedicamentos);
		
		JLabel medicamentosLbl = new JLabel("MEDICAMENTOS VENDIDOS HOY");
		medicamentosLbl.setHorizontalAlignment(SwingConstants.CENTER);
		medicamentosLbl.setForeground(Color.WHITE);
		medicamentosLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		medicamentosLbl.setBounds(0, 32, 300, 46);
		conteoMedicamentos.add(medicamentosLbl);
		
		JLabel medicamentosCount = new JLabel("CANTIDAD");
		medicamentosCount.setHorizontalAlignment(SwingConstants.CENTER);
		medicamentosCount.setForeground(Color.WHITE);
		medicamentosCount.setFont(new Font("Roboto Condensed", Font.BOLD, 32));
		medicamentosCount.setBounds(0, 97, 300, 46);
		conteoMedicamentos.add(medicamentosCount);
		
		JPanel conteoPacientesA = new JPanel();
		conteoPacientesA.setLayout(null);
		conteoPacientesA.setBackground(new Color(106, 238, 109));
		conteoPacientesA.setBounds(100, 500, 300, 120);
		panel.add(conteoPacientesA);
		
		JLabel ayerLbl = new JLabel("AYER");
		ayerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ayerLbl.setForeground(Color.WHITE);
		ayerLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		ayerLbl.setBounds(0, 11, 300, 46);
		conteoPacientesA.add(ayerLbl);
		
		JLabel pacientesCountA = new JLabel("CANTIDAD");
		pacientesCountA.setHorizontalAlignment(SwingConstants.CENTER);
		pacientesCountA.setForeground(Color.WHITE);
		pacientesCountA.setFont(new Font("Roboto Condensed", Font.BOLD, 28));
		pacientesCountA.setBounds(0, 56, 300, 46);
		conteoPacientesA.add(pacientesCountA);
		
		JPanel conteoPacientesU7 = new JPanel();
		conteoPacientesU7.setLayout(null);
		conteoPacientesU7.setBackground(new Color(106, 238, 109));
		conteoPacientesU7.setBounds(100, 690, 300, 120);
		panel.add(conteoPacientesU7);
		
		JLabel uDiasLbl = new JLabel("ÚLTIMOS 7 DÍAS");
		uDiasLbl.setHorizontalAlignment(SwingConstants.CENTER);
		uDiasLbl.setForeground(Color.WHITE);
		uDiasLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		uDiasLbl.setBounds(0, 11, 300, 46);
		conteoPacientesU7.add(uDiasLbl);
		
		JLabel pacientesCountS = new JLabel("CANTIDAD");
		pacientesCountS.setHorizontalAlignment(SwingConstants.CENTER);
		pacientesCountS.setForeground(Color.WHITE);
		pacientesCountS.setFont(new Font("Roboto Condensed", Font.BOLD, 28));
		pacientesCountS.setBounds(0, 56, 300, 46);
		conteoPacientesU7.add(pacientesCountS);
		
		JPanel conteoPersonalA = new JPanel();
		conteoPersonalA.setLayout(null);
		conteoPersonalA.setBackground(new Color(98, 204, 255));
		conteoPersonalA.setBounds(525, 500, 300, 120);
		panel.add(conteoPersonalA);
		
		JLabel ayerLbl_1 = new JLabel("AYER");
		ayerLbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		ayerLbl_1.setForeground(Color.WHITE);
		ayerLbl_1.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		ayerLbl_1.setBounds(0, 11, 300, 46);
		conteoPersonalA.add(ayerLbl_1);
		
		JLabel personalCountA = new JLabel("CANTIDAD");
		personalCountA.setHorizontalAlignment(SwingConstants.CENTER);
		personalCountA.setForeground(Color.WHITE);
		personalCountA.setFont(new Font("Roboto Condensed", Font.BOLD, 28));
		personalCountA.setBounds(0, 56, 300, 46);
		conteoPersonalA.add(personalCountA);
		
		JPanel conteoPersonalU7 = new JPanel();
		conteoPersonalU7.setLayout(null);
		conteoPersonalU7.setBackground(new Color(98, 204, 255));
		conteoPersonalU7.setBounds(525, 690, 300, 120);
		panel.add(conteoPersonalU7);
		
		JLabel uDiasLbl_1 = new JLabel("ÚLTIMOS 7 DÍAS");
		uDiasLbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		uDiasLbl_1.setForeground(Color.WHITE);
		uDiasLbl_1.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		uDiasLbl_1.setBounds(0, 11, 300, 46);
		conteoPersonalU7.add(uDiasLbl_1);
		
		JLabel personalCountU7 = new JLabel("CANTIDAD");
		personalCountU7.setHorizontalAlignment(SwingConstants.CENTER);
		personalCountU7.setForeground(Color.WHITE);
		personalCountU7.setFont(new Font("Roboto Condensed", Font.BOLD, 28));
		personalCountU7.setBounds(0, 56, 300, 46);
		conteoPersonalU7.add(personalCountU7);
		
		JPanel conteoMedicamentosA = new JPanel();
		conteoMedicamentosA.setLayout(null);
		conteoMedicamentosA.setBackground(new Color(255, 123, 60));
		conteoMedicamentosA.setBounds(950, 500, 300, 120);
		panel.add(conteoMedicamentosA);
		
		JLabel ayerLbl_2 = new JLabel("AYER");
		ayerLbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		ayerLbl_2.setForeground(Color.WHITE);
		ayerLbl_2.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		ayerLbl_2.setBounds(0, 11, 300, 46);
		conteoMedicamentosA.add(ayerLbl_2);
		
		JLabel medicamentosCountA = new JLabel("CANTIDAD");
		medicamentosCountA.setHorizontalAlignment(SwingConstants.CENTER);
		medicamentosCountA.setForeground(Color.WHITE);
		medicamentosCountA.setFont(new Font("Roboto Condensed", Font.BOLD, 28));
		medicamentosCountA.setBounds(0, 56, 300, 46);
		conteoMedicamentosA.add(medicamentosCountA);
		
		JPanel conteoMedicamentosU7 = new JPanel();
		conteoMedicamentosU7.setLayout(null);
		conteoMedicamentosU7.setBackground(new Color(255, 123, 60));
		conteoMedicamentosU7.setBounds(950, 690, 300, 120);
		panel.add(conteoMedicamentosU7);
		
		JLabel uDiasLbl_2 = new JLabel("ÚLTIMOS 7 DÍAS");
		uDiasLbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		uDiasLbl_2.setForeground(Color.WHITE);
		uDiasLbl_2.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		uDiasLbl_2.setBounds(0, 11, 300, 46);
		conteoMedicamentosU7.add(uDiasLbl_2);
		
		JLabel medicamentosCountU7 = new JLabel("CANTIDAD");
		medicamentosCountU7.setHorizontalAlignment(SwingConstants.CENTER);
		medicamentosCountU7.setForeground(Color.WHITE);
		medicamentosCountU7.setFont(new Font("Roboto Condensed", Font.BOLD, 28));
		medicamentosCountU7.setBounds(0, 56, 300, 46);
		conteoMedicamentosU7.add(medicamentosCountU7);
		
	}
}
