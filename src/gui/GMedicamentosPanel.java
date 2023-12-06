package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import hospital.Medicamento;


public class GMedicamentosPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField medicamentoTF;
	

	public ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JTextField precioTF;
	private JTextField stockTF;
    @SuppressWarnings("serial")
	DefaultTableModel model = new DefaultTableModel(new Object[][] {
		{null, null, null, null},
	},
	new String[] {
			"ID", "Medicamento", "Precio", "Stock"
	}
) {
	boolean[] columnEditables = new boolean[] {
		false, false, false, false
	};
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
};
    private JTextField searchTF;
	
	
	public GMedicamentosPanel() {
		setBackground(new Color(238, 238, 238));
		setBounds(0, 0, screenSize.width-250, screenSize.height-40);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, screenSize.width-250, screenSize.height-40);
		scrollPane.setBackground(new Color(238, 238, 238));
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Añadir medicamentos");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Roboto Condensed", Font.BOLD, 24));
		title.setBounds(10, 11, 310, 48);
		panel.add(title);
		
		JPanel namePanel = new JPanel();
		namePanel.setBackground(new Color(0, 128, 192));
		namePanel.setBounds(49, 111, 170, 39);
		panel.add(namePanel);
		namePanel.setLayout(null);
		
		JLabel nameLbl = new JLabel("Medicamento:");
		nameLbl.setBounds(0, 0, 170, 39);
		namePanel.add(nameLbl);
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		nameLbl.setForeground(new Color(255, 255, 255));
		
		medicamentoTF = new JTextField();
		medicamentoTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
		medicamentoTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		medicamentoTF.setBounds(214, 111, 300, 39);
		panel.add(medicamentoTF);
		medicamentoTF.setColumns(10);
		
		// Modelo de la tabla

        JTable table = new JTable(model);
        table.setFont(new Font("Roboto Condensed", Font.BOLD, 16));
        table.getTableHeader().setFont(new Font("Roboto Condensed", Font.BOLD, 18));
        table.setRowHeight(30);
        table.setShowVerticalLines(true);
        
        
        
        // ScrollPane para la tabla
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(100, 356, 1096, 359);
        panel.add(tableScrollPane);
        
        JPanel namePanel_1 = new JPanel();
        namePanel_1.setLayout(null);
        namePanel_1.setBackground(new Color(0, 128, 192));
        namePanel_1.setBounds(49, 249, 170, 39);
        panel.add(namePanel_1);
        
        JLabel lblCantidad = new JLabel("Precio:");
        lblCantidad.setBounds(0, 0, 170, 39);
        namePanel_1.add(lblCantidad);
        lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        lblCantidad.setForeground(Color.WHITE);
        lblCantidad.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
        
        precioTF = new JTextField();
        precioTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
        precioTF.setColumns(10);
        precioTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
        precioTF.setBounds(214, 249, 300, 39);
        panel.add(precioTF);
        
        JPanel namePanel_3 = new JPanel();
        namePanel_3.setLayout(null);
        namePanel_3.setBackground(new Color(0, 128, 192));
        namePanel_3.setBounds(49, 180, 170, 39);
        panel.add(namePanel_3);
        
        JLabel lblPrecioVenta = new JLabel("Stock:");
        lblPrecioVenta.setBounds(0, 0, 170, 39);
        namePanel_3.add(lblPrecioVenta);
        lblPrecioVenta.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrecioVenta.setForeground(Color.WHITE);
        lblPrecioVenta.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
        
        stockTF = new JTextField();
        stockTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
        stockTF.setColumns(10);
        stockTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
        stockTF.setBounds(214, 180, 300, 39);
        panel.add(stockTF);
        
        JPanel addBtn = new JPanel();
        addBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		String nombre = medicamentoTF.getText();
        		double precio = Double.parseDouble(precioTF.getText());
        		int stock = Integer.parseInt(stockTF.getText());
        		
        		listaMedicamentos.add(new Medicamento(nombre, precio, stock));
        		
        		try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
					
					String query = "INSERT INTO Medicamentos (Nombre, Precio, Stock) VALUES (?, ?, ?)";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, nombre);
					pst.setDouble(2, precio);
					pst.setInt(3, stock);
					
					pst.executeUpdate();					
					con.close();
										
					JOptionPane.showMessageDialog(null, "Medicamento agregados");
					actualizarTabla();
					
				} catch(ClassNotFoundException err) {
					err.printStackTrace();
				} catch(SQLException err) {
					err.printStackTrace();
				}
        		
        	}
			@Override
			public void mouseEntered(MouseEvent e) {
				addBtn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				addBtn.setBackground(new Color(33, 131, 222));
			}
        });
        addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBtn.setBackground(new Color(0, 128, 192));
        addBtn.setBounds(600, 111, 250, 50);
        panel.add(addBtn);
        addBtn.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Agregar medicamento");
        lblNewLabel.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 250, 50);
        addBtn.add(lblNewLabel);
        
        JPanel editBtn = new JPanel();
        editBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		new EditMedicamentoFrame();
        	}
			@Override
			public void mouseEntered(MouseEvent e) {
				editBtn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				editBtn.setBackground(new Color(33, 131, 222));
			}
        });
        editBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editBtn.setLayout(null);
        editBtn.setBackground(new Color(0, 128, 192));
        editBtn.setBounds(600, 180, 250, 50);
        panel.add(editBtn);
        
        JLabel lblEditarMedicamento = new JLabel("Editar medicamento");
        lblEditarMedicamento.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditarMedicamento.setForeground(Color.WHITE);
        lblEditarMedicamento.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
        lblEditarMedicamento.setBounds(0, 0, 250, 50);
        editBtn.add(lblEditarMedicamento);
        
        JPanel delBtn = new JPanel();
        delBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
				int idEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el ID del medicamento a eliminar de la BD."));
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
					
					Statement statement = con.createStatement();
					
					statement.executeUpdate("DELETE FROM Medicamentos WHERE ID_Medicamento='"+idEliminar+"'");
					
					con.close();
					
					
					JOptionPane.showMessageDialog(null, "Medicamento eliminado");
					actualizarTabla();
					
				} catch(ClassNotFoundException err) {
					err.printStackTrace();
				} catch(SQLException err) {
					err.printStackTrace();
				}
        	}
			@Override
			public void mouseEntered(MouseEvent e) {
				delBtn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				delBtn.setBackground(new Color(33, 131, 222));
			}
        });
        delBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        delBtn.setLayout(null);
        delBtn.setBackground(new Color(0, 128, 192));
        delBtn.setBounds(600, 249, 250, 50);
        panel.add(delBtn);
        
        JLabel lblEliminarMedicamento = new JLabel("Eliminar medicamento");
        lblEliminarMedicamento.setHorizontalAlignment(SwingConstants.CENTER);
        lblEliminarMedicamento.setForeground(Color.WHITE);
        lblEliminarMedicamento.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
        lblEliminarMedicamento.setBounds(0, 0, 250, 50);
        delBtn.add(lblEliminarMedicamento);
        
        JLabel refreshBtn = new JLabel("");
        refreshBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		actualizarTabla();
        	}
        	
			@Override
			public void mouseEntered(MouseEvent e) {
				refreshBtn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				refreshBtn.setBackground(new Color(33, 131, 222));
			}
        	
        });
        refreshBtn.setBackground(new Color(0, 128, 192));
        refreshBtn.setOpaque(true);
        refreshBtn.setIcon(new ImageIcon(GMedicamentosPanel.class.getResource("/gui/images/actualizar (1).png")));
        refreshBtn.setBounds(908, 249, 50, 50);
        panel.add(refreshBtn);
        
        JLabel lblNewLabel_1 = new JLabel("Filtrar por nombre");
        lblNewLabel_1.setBackground(new Color(0, 128, 192));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setOpaque(true);
        lblNewLabel_1.setBounds(908, 111, 244, 48);
        panel.add(lblNewLabel_1);
        
        searchTF = new JTextField();
        searchTF.setFont(new Font("Roboto Condensed", Font.BOLD, 20));
        searchTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
        searchTF.setBounds(908, 159, 205, 40);
        panel.add(searchTF);
        searchTF.setColumns(10);
        
        JLabel searchBtn = new JLabel("");
        searchBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		filtrarTabla(searchTF.getText());
        	}
			@Override
			public void mouseEntered(MouseEvent e) {
				searchBtn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				searchBtn.setBackground(new Color(33, 131, 222));
			}
        });
        searchBtn.setHorizontalAlignment(SwingConstants.CENTER);
        searchBtn.setBackground(new Color(0, 128, 192));
        searchBtn.setOpaque(true);
        searchBtn.setIcon(new ImageIcon(GMedicamentosPanel.class.getResource("/gui/images/lupa (1).png")));
        searchBtn.setBounds(1112, 159, 40, 40);
        panel.add(searchBtn);
        
        
        actualizarTabla();
	}
	
	public void actualizarTabla() {
		model.setRowCount(0);
		String query = "SELECT * FROM Medicamentos";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
			
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rSet = statement.executeQuery();
			
			
			while (rSet.next()) {
				model.addRow(new Object[] {rSet.getInt(1), rSet.getString(2), rSet.getDouble(3), rSet.getInt(4)});
			}
			con.close();
			
		} catch(ClassNotFoundException err) {
			err.printStackTrace();
		} catch(SQLException err) {
			err.printStackTrace();
		}
	}
	
	public void filtrarTabla(String nom) {
		model.setRowCount(0);
		String query = "SELECT * FROM Medicamentos WHERE Nombre LIKE '%"+nom+"%'";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
			
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rSet = statement.executeQuery();
			
			
			while (rSet.next()) {
				model.addRow(new Object[] {rSet.getInt(1), rSet.getString(2), rSet.getDouble(3), rSet.getInt(4)});
			}
			con.close();
			
		} catch(ClassNotFoundException err) {
			err.printStackTrace();
		} catch(SQLException err) {
			err.printStackTrace();
		}
	}
}
