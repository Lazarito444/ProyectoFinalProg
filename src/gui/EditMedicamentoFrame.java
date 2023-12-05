package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditMedicamentoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField idTF;
	private JTextField nombreTF;
	private JTextField precioTF;
	private JTextField stockTF;

	public EditMedicamentoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 400, 400);
		setBackground(new Color(220, 220, 220));
		setUndecorated(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Medicamento");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 400, 50);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 128, 192));
		lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(60, 79, 71, 31);
		getContentPane().add(lblNewLabel_1);
		
		idTF = new JTextField();
		idTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		idTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		idTF.setBounds(130, 79, 195, 31);
		getContentPane().add(idTF);
		idTF.setColumns(10);
		
		nombreTF = new JTextField();
		nombreTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		nombreTF.setColumns(10);
		nombreTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		nombreTF.setBounds(157, 166, 168, 31);
		getContentPane().add(nombreTF);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		lblNewLabel_1_1.setBackground(new Color(0, 128, 192));
		lblNewLabel_1_1.setBounds(60, 166, 99, 31);
		getContentPane().add(lblNewLabel_1_1);
		
		precioTF = new JTextField();
		precioTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		precioTF.setColumns(10);
		precioTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		precioTF.setBounds(157, 215, 168, 31);
		getContentPane().add(precioTF);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Precio:");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		lblNewLabel_1_1_1.setBackground(new Color(0, 128, 192));
		lblNewLabel_1_1_1.setBounds(60, 215, 99, 31);
		getContentPane().add(lblNewLabel_1_1_1);
		
		stockTF = new JTextField();
		stockTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		stockTF.setColumns(10);
		stockTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		stockTF.setBounds(157, 264, 168, 31);
		getContentPane().add(stockTF);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Stock:");
		lblNewLabel_1_1_2.setOpaque(true);
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		lblNewLabel_1_1_2.setBackground(new Color(0, 128, 192));
		lblNewLabel_1_1_2.setBounds(60, 264, 99, 31);
		getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Editar Medicamento");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				int id = Integer.parseInt(idTF.getText());
				String nombre = nombreTF.getText();
				double precio = Double.parseDouble(precioTF.getText());
				int stock = Integer.parseInt(stockTF.getText());
				
				String query = "UPDATE Medicamentos SET Nombre=?, Precio=?, Stock=? WHERE ID_Medicamento="+id;
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, nombre);
					pst.setDouble(2, precio);
					pst.setInt(3, stock);
					
					pst.executeUpdate();

					con.close();
					JOptionPane.showMessageDialog(null, "Medicamento actualizado");
					dispose();
					
					
				} catch(ClassNotFoundException err) {
					err.printStackTrace();
				} catch(SQLException err) {
					err.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setBackground(new Color(50, 142, 227));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setBackground(new Color(0, 128, 192));
			}
		});
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(0, 128, 192));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(60, 328, 267, 50);
		getContentPane().add(lblNewLabel_2);
		
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
