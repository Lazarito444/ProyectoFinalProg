package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GVentasPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField clienteTF;
	private JTable table;
	private JTextField medicamentoTF;
	private JTextField cantidadTF;
	@SuppressWarnings("serial")
	public DefaultTableModel tableModel = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
					"ID_Venta", "ID_Cliente", "ID_Medicamento", "Cantidad"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

	public GVentasPanel() {
		setLayout(null);
		setBounds(0, 0, 1350, 860);
		
		
		JLabel lblVentaMedicamentos = new JLabel("Venta de Medicamentos");
		lblVentaMedicamentos.setBounds(38, 25, 373, 38);
		lblVentaMedicamentos.setFont(new Font("Roboto Condensed", Font.BOLD, 30));
		add(lblVentaMedicamentos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(1102, 59, 171, 166);
		lblNewLabel.setIcon(new ImageIcon(GVentasPanel.class.getResource("/gui/images/LogoHospital.png")));
		add(lblNewLabel);
		
		JLabel lblCliente = new JLabel("ID Cliente:");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setBounds(123, 162, 188, 32);
		lblCliente.setForeground(new Color(255, 255, 255));
		lblCliente.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		lblCliente.setOpaque(true);
		lblCliente.setBackground(new Color(0, 128, 192));
		add(lblCliente);
		
		clienteTF = new JTextField();
		clienteTF.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		clienteTF.setBounds(308, 162, 152, 32);
		clienteTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		add(clienteTF);
		clienteTF.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 304, 932, 305);
		add(scrollPane);
		
		table = new JTable();
		table.getTableHeader().setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		table.setRowHeight(30);
		table.setFont(new Font("Roboto Condensed", Font.BOLD, 16));
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel lblIdMedicamento = new JLabel("ID Medicamento:");
		lblIdMedicamento.setOpaque(true);
		lblIdMedicamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdMedicamento.setForeground(Color.WHITE);
		lblIdMedicamento.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		lblIdMedicamento.setBackground(new Color(0, 128, 192));
		lblIdMedicamento.setBounds(571, 162, 188, 32);
		add(lblIdMedicamento);
		
		medicamentoTF = new JTextField();
		medicamentoTF.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		medicamentoTF.setColumns(10);
		medicamentoTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		medicamentoTF.setBounds(756, 162, 152, 32);
		add(medicamentoTF);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setOpaque(true);
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		lblCantidad.setBackground(new Color(0, 128, 192));
		lblCantidad.setBounds(571, 216, 188, 32);
		add(lblCantidad);
		
		cantidadTF = new JTextField();
		cantidadTF.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
		cantidadTF.setColumns(10);
		cantidadTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		cantidadTF.setBounds(756, 216, 152, 32);
		add(cantidadTF);
		
		JLabel btn = new JLabel("Realizar venta");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int cliente = Integer.parseInt(clienteTF.getText());
				int med = Integer.parseInt(medicamentoTF.getText());
				int cantidad = Integer.parseInt(cantidadTF.getText());
				
				String query = "INSERT INTO Ventas (ID_Cliente, ID_Medicamento, Cantidad) VALUES (?,?,?)";
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
					
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, cliente);
					pst.setInt(2, med);
					pst.setInt(3, cantidad);
					pst.executeUpdate();
					
					con.close();
					
					JOptionPane.showMessageDialog(null, "Venta realizada");
					actualizarTabla();
					
				} catch(ClassNotFoundException err) {
					err.printStackTrace();
				} catch(SQLException err) {
					err.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(new Color(33, 131, 222));
			}
		});
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn.setOpaque(true);
		btn.setBackground(new Color(0, 128, 192));
		btn.setFont(new Font("Roboto Condensed", Font.BOLD, 25));
		btn.setForeground(new Color(255, 255, 255));
		btn.setHorizontalAlignment(SwingConstants.CENTER);
		btn.setBounds(648, 667, 260, 50);
		add(btn);

		
		actualizarTabla();
	}	

	public void actualizarTabla() {
		tableModel.setRowCount(0);
		String query = "SELECT * FROM Ventas";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
			
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rSet = statement.executeQuery();
			
			
			while (rSet.next()) {
				tableModel.addRow(new Object[] {rSet.getInt(1), rSet.getInt(2), rSet.getInt(3), rSet.getInt(4)});
			}
			con.close();
			
		} catch(ClassNotFoundException err) {
			err.printStackTrace();
		} catch(SQLException err) {
			err.printStackTrace();
		}
	}
}