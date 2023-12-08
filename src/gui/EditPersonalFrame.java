package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Cursor;

public class EditPersonalFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idTF;
	private JTextField nameTF;
	private JTextField snameTF;
	private JTextField neighborhoodTF;
	private JTextField stateTF;
	private JTextField birthTF;
	private JTextField telTF;
	private JTextField userTF;
	private JTextField passTF;


	public EditPersonalFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 35);
		panel.setBackground(new Color(0, 128, 192));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Personal");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		lblNewLabel.setBounds(0, 0, 600, 35);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		lblNewLabel_1.setBackground(new Color(0, 128, 192));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(40, 72, 50, 35);
		contentPane.add(lblNewLabel_1);
		
		idTF = new JTextField();
		idTF.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		idTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		idTF.setBounds(90, 72, 100, 35);
		contentPane.add(idTF);
		idTF.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		lblNewLabel_1_1.setBackground(new Color(0, 128, 192));
		lblNewLabel_1_1.setBounds(40, 169, 100, 35);
		contentPane.add(lblNewLabel_1_1);
		
		nameTF = new JTextField();
		nameTF.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		nameTF.setColumns(10);
		nameTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		nameTF.setBounds(140, 169, 150, 35);
		contentPane.add(nameTF);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Apellido:");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBackground(new Color(0, 128, 192));
		lblNewLabel_1_1_1.setBounds(310, 169, 100, 35);
		contentPane.add(lblNewLabel_1_1_1);
		
		snameTF = new JTextField();
		snameTF.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		snameTF.setColumns(10);
		snameTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		snameTF.setBounds(410, 169, 150, 35);
		contentPane.add(snameTF);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Sector:");
		lblNewLabel_1_1_2.setOpaque(true);
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBackground(new Color(0, 128, 192));
		lblNewLabel_1_1_2.setBounds(40, 215, 100, 35);
		contentPane.add(lblNewLabel_1_1_2);
		
		neighborhoodTF = new JTextField();
		neighborhoodTF.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		neighborhoodTF.setColumns(10);
		neighborhoodTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		neighborhoodTF.setBounds(140, 215, 150, 35);
		contentPane.add(neighborhoodTF);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Provincia:");
		lblNewLabel_1_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBackground(new Color(0, 128, 192));
		lblNewLabel_1_1_1_1.setBounds(310, 215, 100, 35);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		stateTF = new JTextField();
		stateTF.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		stateTF.setColumns(10);
		stateTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		stateTF.setBounds(410, 215, 150, 35);
		contentPane.add(stateTF);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Fecha N:");
		lblNewLabel_1_1_3.setOpaque(true);
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_3.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		lblNewLabel_1_1_3.setBackground(new Color(0, 128, 192));
		lblNewLabel_1_1_3.setBounds(40, 261, 100, 35);
		contentPane.add(lblNewLabel_1_1_3);
		
		birthTF = new JTextField();
		birthTF.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		birthTF.setColumns(10);
		birthTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		birthTF.setBounds(140, 261, 150, 35);
		contentPane.add(birthTF);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Teléfono:");
		lblNewLabel_1_1_1_2.setOpaque(true);
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		lblNewLabel_1_1_1_2.setBackground(new Color(0, 128, 192));
		lblNewLabel_1_1_1_2.setBounds(310, 261, 100, 35);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		telTF = new JTextField();
		telTF.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		telTF.setColumns(10);
		telTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		telTF.setBounds(410, 261, 150, 35);
		contentPane.add(telTF);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Usuario:");
		lblNewLabel_1_1_4.setOpaque(true);
		lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_4.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		lblNewLabel_1_1_4.setBackground(new Color(0, 128, 192));
		lblNewLabel_1_1_4.setBounds(40, 307, 100, 35);
		contentPane.add(lblNewLabel_1_1_4);
		
		userTF = new JTextField();
		userTF.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		userTF.setColumns(10);
		userTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		userTF.setBounds(140, 307, 150, 35);
		contentPane.add(userTF);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Contraseña:");
		lblNewLabel_1_1_1_3.setOpaque(true);
		lblNewLabel_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_3.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		lblNewLabel_1_1_1_3.setBackground(new Color(0, 128, 192));
		lblNewLabel_1_1_1_3.setBounds(310, 307, 100, 35);
		contentPane.add(lblNewLabel_1_1_1_3);
		
		passTF = new JTextField();
		passTF.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		passTF.setColumns(10);
		passTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		passTF.setBounds(410, 307, 150, 35);
		contentPane.add(passTF);
		
		JComboBox<String> gender = new JComboBox<>();
		gender.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		gender.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		gender.setModel(new DefaultComboBoxModel<>(new String[] {"Masculino", "Femenino"}));
		gender.setBounds(40, 118, 150, 35);
		contentPane.add(gender);
		
		JLabel editBtn = new JLabel("Editar Personal");
		editBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					editBtn.setBackground(new Color(50, 142, 227));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					editBtn.setBackground(new Color(0, 128, 192));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					int idEditar = Integer.parseInt(idTF.getText());
					String nombre = nameTF.getText();
					String apellido = snameTF.getText();
					String fechaN = birthTF.getText();
					String direccion = neighborhoodTF.getText()+", "+stateTF.getText();
					String user = userTF.getText();
					String pass = passTF.getText();
					String tel = telTF.getText();
					int gen = gender.getSelectedIndex();
					String[] gender = new String[] {"M", "F"};
					
					try {
						
						Connection con = MySQLConnection.getConnection();
						
						String query = "UPDATE Personal SET Nombre=?, Apellido=?, FechaNacimiento=?, Direccion=?, "
								+ "Usuario=?, Contraseña=?, Telefono=?, Genero=? WHERE ID_Personal="+idEditar;
						
						PreparedStatement pst = con.prepareStatement(query);
						pst.setString(1, nombre);
						pst.setString(2, apellido);
						pst.setString(3, fechaN);
						pst.setString(4, direccion);
						pst.setString(5, user);
						pst.setString(6, pass);
						pst.setString(7, tel);
						pst.setString(8, gender[gen]);
						pst.executeUpdate();
						
						con.close();
						JOptionPane.showMessageDialog(null, "Paciente editado");
						dispose();

					} catch(SQLException err) {
						err.printStackTrace();
					}
				}	
		});
		editBtn.setOpaque(true);
		editBtn.setHorizontalAlignment(SwingConstants.CENTER);
		editBtn.setForeground(Color.WHITE);
		editBtn.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		editBtn.setBackground(new Color(0, 128, 192));
		editBtn.setBounds(410, 72, 150, 50);
		contentPane.add(editBtn);
	
		
		

		setBounds(0, 0, 600, 400);
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
		setBackground(new Color(220, 220, 220));
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}