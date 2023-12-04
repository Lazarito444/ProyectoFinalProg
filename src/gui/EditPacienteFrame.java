package gui;


import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditPacienteFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idTF;
	private JTextField nameTF;
	private JTextField surnameTF;
	private JTextField birthTF;
	private JTextField telTF;
	private JTextField diseaseTF;
	private JTextField neighborhoodTF;
	private JTextField stateTF;
	public  boolean isOpened;
	
	public EditPacienteFrame() {
		isOpened = true;
		setLocationRelativeTo(null);
		setBounds(0, 0, 600, 400);
		setBackground(new Color(220, 220, 220));
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel title = new JPanel();
		title.setBackground(new Color(0, 128, 192));
		title.setBounds(0, 0, 600, 33);
		contentPane.add(title);
		title.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Paciente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.BOLD, 23));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 0, 600, 33);
		title.add(lblNewLabel);
		
		JPanel idPanel = new JPanel();
		idPanel.setBackground(new Color(0, 128, 192));
		idPanel.setBounds(10, 44, 53, 33);
		contentPane.add(idPanel);
		idPanel.setLayout(null);
		
		JLabel idLbl = new JLabel("ID:");
		idLbl.setHorizontalAlignment(SwingConstants.CENTER);
		idLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		idLbl.setForeground(new Color(255, 255, 255));
		idLbl.setBounds(0, 0, 53, 33);
		idPanel.add(idLbl);
		
		idTF = new JTextField();
		idTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		idTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		idTF.setBounds(63, 44, 82, 33);
		contentPane.add(idTF);
		idTF.setColumns(10);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(null);
		namePanel.setBackground(new Color(0, 128, 192));
		namePanel.setBounds(10, 116, 100, 33);
		contentPane.add(namePanel);
		
		JLabel nameLbl = new JLabel("Nombre:");
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setForeground(Color.WHITE);
		nameLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		nameLbl.setBounds(0, 0, 100, 33);
		namePanel.add(nameLbl);
		
		nameTF = new JTextField();
		nameTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		nameTF.setColumns(10);
		nameTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		nameTF.setBounds(110, 116, 165, 33);
		contentPane.add(nameTF);
		
		JPanel surnamePanel = new JPanel();
		surnamePanel.setLayout(null);
		surnamePanel.setBackground(new Color(0, 128, 192));
		surnamePanel.setBounds(305, 116, 100, 33);
		contentPane.add(surnamePanel);
		
		JLabel surnameLbl = new JLabel("Apellido:");
		surnameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		surnameLbl.setForeground(Color.WHITE);
		surnameLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		surnameLbl.setBounds(0, 0, 100, 33);
		surnamePanel.add(surnameLbl);
		
		surnameTF = new JTextField();
		surnameTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		surnameTF.setColumns(10);
		surnameTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		surnameTF.setBounds(405, 116, 165, 33);
		contentPane.add(surnameTF);
		
		JPanel birthPanel = new JPanel();
		birthPanel.setLayout(null);
		birthPanel.setBackground(new Color(0, 128, 192));
		birthPanel.setBounds(10, 173, 160, 33);
		contentPane.add(birthPanel);
		
		JLabel birthLbl = new JLabel("Fecha Nacimiento:");
		birthLbl.setHorizontalAlignment(SwingConstants.CENTER);
		birthLbl.setForeground(Color.WHITE);
		birthLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		birthLbl.setBounds(0, 0, 160, 33);
		birthPanel.add(birthLbl);
		
		birthTF = new JTextField();
		birthTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		birthTF.setColumns(10);
		birthTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		birthTF.setBounds(170, 173, 165, 33);
		contentPane.add(birthTF);
		
		JPanel telPanel = new JPanel();
		telPanel.setLayout(null);
		telPanel.setBackground(new Color(0, 128, 192));
		telPanel.setBounds(10, 227, 100, 33);
		contentPane.add(telPanel);
		
		JLabel telLbl = new JLabel("Teléfono:");
		telLbl.setHorizontalAlignment(SwingConstants.CENTER);
		telLbl.setForeground(Color.WHITE);
		telLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		telLbl.setBounds(0, 0, 100, 33);
		telPanel.add(telLbl);
		
		telTF = new JTextField();
		telTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		telTF.setColumns(10);
		telTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		telTF.setBounds(110, 227, 165, 33);
		contentPane.add(telTF);
		
		JPanel diseasePanel = new JPanel();
		diseasePanel.setLayout(null);
		diseasePanel.setBackground(new Color(0, 128, 192));
		diseasePanel.setBounds(305, 227, 100, 33);
		contentPane.add(diseasePanel);
		
		JLabel diseaseLbl = new JLabel("Enfermedad:");
		diseaseLbl.setHorizontalAlignment(SwingConstants.CENTER);
		diseaseLbl.setForeground(Color.WHITE);
		diseaseLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		diseaseLbl.setBounds(0, 0, 100, 33);
		diseasePanel.add(diseaseLbl);
		
		diseaseTF = new JTextField();
		diseaseTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		diseaseTF.setColumns(10);
		diseaseTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		diseaseTF.setBounds(405, 227, 165, 33);
		contentPane.add(diseaseTF);
		
		JPanel neighborhoodPanel = new JPanel();
		neighborhoodPanel.setLayout(null);
		neighborhoodPanel.setBackground(new Color(0, 128, 192));
		neighborhoodPanel.setBounds(10, 281, 100, 33);
		contentPane.add(neighborhoodPanel);
		
		JLabel neighborhoodLbl = new JLabel("Sector:");
		neighborhoodLbl.setHorizontalAlignment(SwingConstants.CENTER);
		neighborhoodLbl.setForeground(Color.WHITE);
		neighborhoodLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		neighborhoodLbl.setBounds(0, 0, 100, 33);
		neighborhoodPanel.add(neighborhoodLbl);
		
		neighborhoodTF = new JTextField();
		neighborhoodTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		neighborhoodTF.setColumns(10);
		neighborhoodTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		neighborhoodTF.setBounds(110, 281, 165, 33);
		contentPane.add(neighborhoodTF);
		
		JPanel statePanel = new JPanel();
		statePanel.setLayout(null);
		statePanel.setBackground(new Color(0, 128, 192));
		statePanel.setBounds(305, 281, 100, 33);
		contentPane.add(statePanel);
		
		JLabel stateLbl = new JLabel("Provincia:");
		stateLbl.setHorizontalAlignment(SwingConstants.CENTER);
		stateLbl.setForeground(Color.WHITE);
		stateLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		stateLbl.setBounds(0, 0, 100, 33);
		statePanel.add(stateLbl);
		
		stateTF = new JTextField();
		stateTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		stateTF.setColumns(10);
		stateTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		stateTF.setBounds(405, 281, 165, 33);
		contentPane.add(stateTF);
		
		JComboBox<String> gender = new JComboBox<>();
		gender.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		gender.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		gender.setModel(new DefaultComboBoxModel<>(new String[] {"Masculino", "Femenino"}));
		gender.setBounds(10, 333, 203, 39);
		contentPane.add(gender);
		
		JPanel btn = new JPanel();
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(new Color(33, 131, 222));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int idEditar = Integer.parseInt(idTF.getText());
				String nombre = nameTF.getText();
				String apellido = surnameTF.getText();
				String fechaN = birthTF.getText();
				String direccion = neighborhoodTF.getText()+", "+stateTF.getText();
				String tel = telTF.getText();
				String disease = diseaseTF.getText();
				int gen = gender.getSelectedIndex();
				String[] gender = new String[] {"M", "F"};
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
					
					String query = "UPDATE Pacientes SET Nombre=?, Apellido=?, FechaNacimiento=?, Direccion=?, Telefono=?, "
								 + "Enfermedad=?, Genero=? WHERE ID_Paciente="+idEditar;
					
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, nombre);
					pst.setString(2, apellido);
					pst.setString(3, fechaN);
					pst.setString(4, direccion);
					pst.setString(5, tel);
					pst.setString(6, disease);
					pst.setString(7, gender[gen]);
					pst.executeUpdate();
					
					con.close();
					JOptionPane.showMessageDialog(null, "Paciente editado");
					dispose();
					isOpened = false;
				} catch(ClassNotFoundException err) {
					err.printStackTrace();
					
				} catch(SQLException err) {
					err.printStackTrace();
				}
			}
		});
		btn.setBackground(new Color(0, 128, 192));
		btn.setBounds(415, 333, 155, 39);
		contentPane.add(btn);
		btn.setLayout(null);
		
		JLabel btnLbl = new JLabel("Editar Paciente");
		btnLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		btnLbl.setForeground(new Color(255, 255, 255));
		btnLbl.setHorizontalAlignment(SwingConstants.CENTER);
		btnLbl.setBounds(0, 0, 155, 39);
		btn.add(btnLbl);
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
