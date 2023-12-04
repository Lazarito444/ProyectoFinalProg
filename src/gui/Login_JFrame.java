package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login_JFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	private JLabel xLabel;


	public Login_JFrame() {
		setBounds(new Rectangle(0, 0, 800, 450));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel bg = new JPanel();
		bg.setBackground(new Color(238, 238, 238));
		bg.setBounds(0, 0, 800, 450);
		contentPane.add(bg);
		bg.setLayout(null);
		
		JPanel sidebar = new JPanel();
		sidebar.setBackground(new Color(27, 85, 139));
		sidebar.setBounds(550, 0, 250, 450);
		bg.add(sidebar);
		sidebar.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(43, 35, 164, 164);
		sidebar.add(logo);
		logo.setAlignmentX(Component.CENTER_ALIGNMENT);
		logo.setIcon(new ImageIcon(Login_JFrame.class.getResource("/gui/LogoHospital.png")));
		
		JLabel hospital = new JLabel("HOSPITAL DR. TUGO");
		hospital.setHorizontalAlignment(SwingConstants.CENTER);
		hospital.setForeground(new Color(255, 255, 255));
		hospital.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		hospital.setBounds(0, 233, 250, 29);
		sidebar.add(hospital);
		
		JSeparator line = new JSeparator();
		line.setBounds(20, 268, 210, 3);
		sidebar.add(line);
		
		JLabel slogan = new JLabel("<html><div style='text-align: center;'>\"Un Hogar para tu Salud, un Refugio para tu Recuperación.\"</div></html>");
		slogan.setAlignmentX(Component.CENTER_ALIGNMENT);
		slogan.setHorizontalAlignment(SwingConstants.CENTER);
        slogan.setVerticalAlignment(JLabel.CENTER);
		slogan.setPreferredSize(new Dimension(250, 45));
		slogan.setForeground(new Color(255, 255, 255));
		slogan.setFont(new Font("Roboto Condensed", Font.ITALIC, 16));
		slogan.setBounds(20, 275, 210, 45);
		sidebar.add(slogan);
		
		JPanel exit = new JPanel();
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "¿Estás seguro de que deseas cerrar el programa?",
                        "Confirmar Cierre",
                        JOptionPane.YES_NO_OPTION);
			
			if (confirm == JOptionPane.YES_OPTION) {
				dispose();
			}
		
			}			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setBackground(Color.RED);
				xLabel.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setBackground(new Color(238, 238, 238));
				xLabel.setForeground(Color.BLACK);
			}
});
		exit.setBackground(new Color(238, 238, 238));
		exit.setBounds(0, 0, 30, 30);
		bg.add(exit);
		exit.setLayout(null);
		
		xLabel = new JLabel("X");
		xLabel.setHorizontalAlignment(SwingConstants.CENTER);
		xLabel.setVerticalAlignment(SwingConstants.CENTER);
		xLabel.setBounds(0, 0, 30, 30);
		exit.add(xLabel);
		xLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 22));
		
		JLabel SistemaLbl = new JLabel("SISTEMA DE GESTIÓN DEL HOSPITAL");
		SistemaLbl.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		SistemaLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		SistemaLbl.setBounds(56, 56, 350, 25);
		bg.add(SistemaLbl);
		
		JLabel loginLbl = new JLabel("INICIAR SESIÓN");
		loginLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		loginLbl.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		loginLbl.setBounds(56, 114, 150, 25);
		bg.add(loginLbl);
		
		JPanel btn = new JPanel();
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(new Color(42, 126, 201));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(new Color(27, 85, 139));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
				
				Statement statement = con.createStatement();
				
				String user = userField.getText();
				String pass = String.valueOf(passwordField.getPassword());
				
				ResultSet resultSet = statement.executeQuery("SELECT Nombre, Contraseña FROM Personal WHERE Usuario='"+user+"'");
				
				resultSet.next();
				
				if (pass.equals(resultSet.getString("Contraseña"))) {
					dispose();
					String name = resultSet.getString("Nombre");
					new MainFrame(name);
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
				}
				
				con.close();
				
			} catch(ClassNotFoundException err) {
				err.printStackTrace();
				
			} catch(SQLException err) {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
				err.printStackTrace();
			}
				
			}
		});
		btn.setBackground(new Color(27, 85, 139));
		btn.setBounds(213, 370, 125, 45);
		bg.add(btn);
		btn.setLayout(null);
		
		JLabel entrarLbl = new JLabel("ENTRAR");
		entrarLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		entrarLbl.setForeground(new Color(255, 255, 255));
		entrarLbl.setFont(new Font("Roboto Condensed Medium", Font.PLAIN, 18));
		entrarLbl.setHorizontalAlignment(SwingConstants.CENTER);
		entrarLbl.setBounds(0, 0, 125, 45);
		btn.add(entrarLbl);
		
		JLabel userLbl = new JLabel("Usuario");
		userLbl.setFont(new Font("Roboto Condensed", Font.PLAIN, 18));
		userLbl.setBounds(57, 182, 79, 25);
		bg.add(userLbl);
		
		JLabel passwordLbl = new JLabel("Contraseña");
		passwordLbl.setFont(new Font("Roboto Condensed", Font.PLAIN, 18));
		passwordLbl.setBounds(57, 266, 114, 25);
		bg.add(passwordLbl);
		
		userField = new JTextField();
		userField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				
				if (userField.getText().isEmpty() || userField.getText().equals("Ingrese su usuario")) {
					
					userField.setText("");
					userField.setForeground(Color.BLACK);
				}
				
				if (String.valueOf(passwordField.getPassword()).isEmpty()) {
					
					passwordField.setText("********");
					passwordField.setForeground(new Color(177, 177, 177));
				}
			}
		});
		userField.setForeground(new Color(177, 177, 177));
		userField.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
		userField.setText("Ingrese su usuario");
		userField.setBorder(null);
		userField.setBackground(new Color(238, 238, 238));
		userField.setBounds(57, 218, 238, 22);
		bg.add(userField);
		userField.setColumns(10);
		
		JSeparator userInputLine = new JSeparator();
		userInputLine.setBackground(new Color(0, 0, 0));
		userInputLine.setBounds(57, 240, 238, 3);
		bg.add(userInputLine);
		
		JSeparator passInputLine = new JSeparator();
		passInputLine.setBackground(Color.BLACK);
		passInputLine.setBounds(57, 324, 238, 3);
		bg.add(passInputLine);
		
		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if (String.valueOf(passwordField.getPassword()).isEmpty() || String.valueOf(passwordField.getPassword())
																				.equals("********")) {
					
					passwordField.setText("");
					passwordField.setForeground(Color.BLACK);
				}
				
				if (userField.getText().equals("Ingrese su usuario") || userField.getText().isEmpty()) {
					userField.setText("Ingrese su usuario");
					userField.setForeground(new Color(177, 177, 177));					
				}
			}
		});
		passwordField.setForeground(new Color(177, 177, 177));
		passwordField.setText("********");
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(238, 238, 238));
		passwordField.setBounds(56, 302, 238, 22);
		bg.add(passwordField);
	
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
