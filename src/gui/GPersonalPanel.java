package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class GPersonalPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameTF;
	private JTextField snameTF;
	private JTextField birthTF;
	private JTextField neighborhoodTF;
	private JTextField stateTF;
	private JTextField searchTF;
	private JTable table;
	public DefaultTableModel tableModel = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID ", "Nombre", "Apellido", "Fecha Nacimiento", "Direcci\u00F3n", "Usuario", "Tel\u00E9fono", "G\u00E9nero"
			}
		);

	/**
	 * Create the panel.
	 */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JTextField userTF;
	private JTextField passTF;
	private JTextField telTF;

	public GPersonalPanel() {
		setBackground(new Color(238, 238, 238));
		setBounds(0, 0, screenSize.width-250, screenSize.height-40);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Añadir Personal");
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		lblNewLabel.setBounds(40, 20, 183, 46);
		add(lblNewLabel);
		
		JLabel nameLbl = new JLabel("Nombre:");
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setForeground(new Color(255, 255, 255));
		nameLbl.setBackground(new Color(0, 128, 192));
		nameLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		nameLbl.setBounds(40, 66, 111, 46);
		nameLbl.setOpaque(true);
		add(nameLbl);
		
		nameTF = new JTextField();
		nameTF.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		nameTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		nameTF.setDisabledTextColor(new Color(109, 109, 109));
		nameTF.setCaretColor(new Color(0, 128, 192));
		nameTF.setBounds(150, 66, 233, 46);
		add(nameTF);
		nameTF.setColumns(10);
		
		JLabel snameLbl = new JLabel("Apellido:");
		snameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		snameLbl.setForeground(new Color(255, 255, 255));
		snameLbl.setBackground(new Color(0, 128, 192));
		snameLbl.setOpaque(true);
		snameLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		snameLbl.setBounds(40, 138, 96, 46);
		add(snameLbl);
		
		snameTF = new JTextField();
		snameTF.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		snameTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		snameTF.setColumns(10);
		snameTF.setBounds(135, 138, 244, 46);
		add(snameTF);
		
		JLabel birthLbl = new JLabel("Fecha de Nacimiento:");
		birthLbl.setHorizontalAlignment(SwingConstants.CENTER);
		birthLbl.setForeground(new Color(255, 255, 255));
		birthLbl.setOpaque(true);
		birthLbl.setBackground(new Color(0, 128, 192));
		birthLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		birthLbl.setBounds(454, 66, 225, 46);
		add(birthLbl);
		
		birthTF = new JTextField();
		birthTF.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		birthTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		birthTF.setColumns(10);
		birthTF.setBounds(678, 66, 285, 46);
		add(birthTF);
		
		JLabel neighborhoodLbl = new JLabel("Sector:");
		neighborhoodLbl.setHorizontalAlignment(SwingConstants.CENTER);
		neighborhoodLbl.setForeground(new Color(255, 255, 255));
		neighborhoodLbl.setBackground(new Color(0, 128, 192));
		neighborhoodLbl.setOpaque(true);
		neighborhoodLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		neighborhoodLbl.setBounds(474, 138, 96, 46);
		add(neighborhoodLbl);
		
		neighborhoodTF = new JTextField();
		neighborhoodTF.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		neighborhoodTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		neighborhoodTF.setColumns(10);
		neighborhoodTF.setBounds(569, 138, 233, 46);
		add(neighborhoodTF);
		
		JLabel stateLbl = new JLabel("Provincia:");
		stateLbl.setHorizontalAlignment(SwingConstants.CENTER);
		stateLbl.setForeground(new Color(255, 255, 255));
		stateLbl.setBackground(new Color(0, 128, 192));
		stateLbl.setBorder(new LineBorder(new Color(0, 128, 192)));
		stateLbl.setOpaque(true);
		stateLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		stateLbl.setBounds(838, 138, 115, 46);
		add(stateLbl);
		
		stateTF = new JTextField();
		stateTF.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		stateTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		stateTF.setColumns(10);
		stateTF.setBounds(952, 138, 233, 46);
		add(stateTF);
		
		JLabel searchLbl = new JLabel("Buscar por teléfono:");
		searchLbl.setHorizontalAlignment(SwingConstants.CENTER);
		searchLbl.setForeground(new Color(255, 255, 255));
		searchLbl.setBackground(new Color(0, 128, 192));
		searchLbl.setOpaque(true);
		searchLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		searchLbl.setBounds(40, 220, 225, 46);
		add(searchLbl);
		
		searchTF = new JTextField();
		searchTF.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		searchTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		searchTF.setColumns(10);
		searchTF.setBounds(264, 220, 236, 46);
		add(searchTF);
		
		JComboBox<String> genero = new JComboBox<>();
		genero.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		genero.setModel(new DefaultComboBoxModel<>(new String[] {"Masculino", "Femenino"}));
		genero.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		genero.addItem("Masculino");
	    genero.addItem("Femenino");
		genero.setBounds(664, 220, 128, 46);
		add(genero);
		
		JLabel generoLbl = new JLabel("Genero:");
		generoLbl.setHorizontalAlignment(SwingConstants.CENTER);
		generoLbl.setForeground(new Color(255, 255, 255));
		generoLbl.setBackground(new Color(0, 128, 192));
		generoLbl.setOpaque(true);
		generoLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		generoLbl.setBounds(569, 220, 96, 46);
		add(generoLbl);
		
		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setFont(new Font("Roboto", tableScrollPane.getFont().getStyle(), tableScrollPane.getFont().getSize()));
		tableScrollPane.setBounds(39, 355, 1201, 438);
		add(tableScrollPane);
		
		
		table = new JTable();
		table.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		table.setRowHeight(30);
		table.setModel(tableModel);
		table.getTableHeader().setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		table.getColumnModel().getColumn(3).setPreferredWidth(96);
		tableScrollPane.setViewportView(table);
		
		JLabel searchBtn = new JLabel("");
		searchBtn.setIcon(new ImageIcon(GPersonalPanel.class.getResource("/gui/images/lupa (1).png")));
		searchBtn.setHorizontalAlignment(SwingConstants.CENTER);
		searchBtn.setBackground(new Color(0, 128, 192));
		searchBtn.setOpaque(true);
		searchBtn.setBounds(499, 220, 46, 46);
		add(searchBtn);
		
		JPanel addBtn = new JPanel();
		addBtn.setBackground(new Color(0, 128, 192));
		addBtn.setBounds(116, 293, 225, 46);
		add(addBtn);
		addBtn.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Añadir personal");
		lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 225, 46);
		addBtn.add(lblNewLabel_1);
		
		JPanel editBtn = new JPanel();
		editBtn.setBackground(new Color(0, 128, 192));
		editBtn.setBounds(450, 293, 225, 46);
		add(editBtn);
		editBtn.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Editar personal");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(0, 0, 225, 46);
		editBtn.add(lblNewLabel_1_1);
		
		JPanel delBtn = new JPanel();
		delBtn.setBackground(new Color(0, 128, 192));
		delBtn.setBounds(800, 293, 225, 46);
		add(delBtn);
		delBtn.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Eliminar personal");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		lblNewLabel_1_2.setBounds(0, 0, 225, 46);
		delBtn.add(lblNewLabel_1_2);
		
		JPanel refreshBtn = new JPanel();
		refreshBtn.setBackground(new Color(0, 128, 192));
		refreshBtn.setBounds(1100, 293, 50, 50);
		add(refreshBtn);
		refreshBtn.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 50, 50);
		refreshBtn.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(0, 128, 192));
		lblNewLabel_2.setIcon(new ImageIcon(GPersonalPanel.class.getResource("/gui/images/actualizar (1).png")));
		
		addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		refreshBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setOpaque(true);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		lblUsuario.setBorder(new LineBorder(new Color(0, 128, 192)));
		lblUsuario.setBackground(new Color(0, 128, 192));
		lblUsuario.setBounds(993, 66, 115, 46);
		add(lblUsuario);
		
		userTF = new JTextField();
		userTF.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		userTF.setColumns(10);
		userTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		userTF.setBounds(1107, 66, 152, 46);
		add(userTF);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setOpaque(true);
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		lblContrasea.setBorder(new LineBorder(new Color(0, 128, 192)));
		lblContrasea.setBackground(new Color(0, 128, 192));
		lblContrasea.setBounds(1050, 220, 115, 46);
		add(lblContrasea);
		
		passTF = new JTextField();
		passTF.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		passTF.setColumns(10);
		passTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		passTF.setBounds(1162, 220, 128, 46);
		add(passTF);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setOpaque(true);
		lblTelfono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelfono.setForeground(Color.WHITE);
		lblTelfono.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		lblTelfono.setBorder(new LineBorder(new Color(0, 128, 192)));
		lblTelfono.setBackground(new Color(0, 128, 192));
		lblTelfono.setBounds(802, 220, 115, 46);
		add(lblTelfono);
		
		telTF = new JTextField();
		telTF.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		telTF.setColumns(10);
		telTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		telTF.setBounds(915, 220, 100, 46);
		add(telTF);
		
		addBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				addBtn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				addBtn.setBackground(new Color(33, 131, 222));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String nombre = nameTF.getText();
				String apellido = snameTF.getText();
				String fechaN = birthTF.getText();
				String dire = neighborhoodTF.getText()+", "+stateTF.getText();
				String user = userTF.getText();
				String pass = passTF.getText();
				String tel = telTF.getText();
				int gen = genero.getSelectedIndex();
				String[] genero = new String[] {"M", "F"};
				
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
					
					Statement statement = con.createStatement();
					
					statement.executeUpdate("INSERT INTO Personal (Nombre, Apellido, FechaNacimiento, Direccion, Usuario, Contraseña, Telefono, Genero) VALUES ('"
							+nombre+"','"+apellido+"','"+fechaN+"','"+dire+"','"+user+"','"+pass+"','"+tel+"','"+genero[gen]+"')");
					
					con.close();
					
					
					JOptionPane.showMessageDialog(null, "Personal añadido");
					actualizarTabla();
					
				} catch(ClassNotFoundException err) {
					err.printStackTrace();
				} catch(SQLException err) {
					err.printStackTrace();
				}
			}
		});
		
		editBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				editBtn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				editBtn.setBackground(new Color(33, 131, 222));
			}
		});
		
		delBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				delBtn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				delBtn.setBackground(new Color(33, 131, 222));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int idEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el ID del paciente a eliminar de la BD."));
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
					
					Statement statement = con.createStatement();
					
					statement.executeUpdate("DELETE FROM Personal WHERE ID_Personal='"+idEliminar+"'");
					
					con.close();
					
					
					JOptionPane.showMessageDialog(null, "Personal eliminado");
					actualizarTabla();
					
				} catch(ClassNotFoundException err) {
					err.printStackTrace();
				} catch(SQLException err) {
					err.printStackTrace();
				}
				
			}
		});
		
		refreshBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				refreshBtn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				refreshBtn.setBackground(new Color(33, 131, 222));
			}
		});
		
		searchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				searchBtn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				searchBtn.setBackground(new Color(33, 131, 222));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				filtrarTabla(searchTF.getText());
			}
		});
		
		actualizarTabla();
	}
	
	public void actualizarTabla() {
		tableModel.setRowCount(0);
		String query = "SELECT * FROM Personal";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
			
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rSet = statement.executeQuery();
			
			
			while (rSet.next()) {
				tableModel.addRow(new Object[] {rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4), 
						rSet.getString(5), rSet.getString(6), rSet.getString(8), rSet.getString(9)});
			}
			con.close();
			
		} catch(ClassNotFoundException err) {
			err.printStackTrace();
		} catch(SQLException err) {
			err.printStackTrace();
		}
	}
	
	public void filtrarTabla(String tel) {
		tableModel.setRowCount(0);
		String query = "SELECT * FROM Personal WHERE Telefono LIKE '%"+tel+"%'";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
			
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rSet = statement.executeQuery();
			
			
			while (rSet.next()) {
				tableModel.addRow(new Object[] {rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4), 
						rSet.getString(5), rSet.getString(6), rSet.getString(8), rSet.getString(9)});
			}
			con.close();
			
		} catch(ClassNotFoundException err) {
			err.printStackTrace();
		} catch(SQLException err) {
			err.printStackTrace();
		}
	}
}
