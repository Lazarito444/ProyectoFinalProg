package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class GInventarioPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField productosTF;
	

	/**
	 * Create the panel.
	 */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JTextField textField;
	private JTextField textField_2;
	
	public GInventarioPanel() {
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
		nameLbl.setBounds(0, 0, 160, 39);
		namePanel.add(nameLbl);
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setFont(new Font("Dialog", Font.BOLD, 20));
		nameLbl.setForeground(new Color(255, 255, 255));
		
		productosTF = new JTextField();
		productosTF.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		productosTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		productosTF.setBounds(214, 111, 300, 39);
		panel.add(productosTF);
		productosTF.setColumns(10);
		
		// Modelo de la tabla
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
        JTable table = new JTable(model);
        table.setShowVerticalLines(false);
        
        
        
        // ScrollPane para la tabla
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(10, 356, 1096, 359);
        panel.add(tableScrollPane);
        
        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(10, 281, 1096, 69);
        buttonPanel.setLayout(null);
        panel.add(buttonPanel);
        
        JButton btnEditarMedicamento = new JButton("Editar medicamento");
        btnEditarMedicamento.setForeground(Color.WHITE);
        btnEditarMedicamento.setFont(new Font("Dialog", Font.BOLD, 20));
        btnEditarMedicamento.setBackground(new Color(0, 128, 192));
        btnEditarMedicamento.setBounds(147, 11, 260, 47);
        buttonPanel.add(btnEditarMedicamento);
        
        JButton btnEliminarMedicamento = new JButton("Eliminar medicamento");
        btnEliminarMedicamento.setForeground(Color.WHITE);
        btnEliminarMedicamento.setFont(new Font("Dialog", Font.BOLD, 20));
        btnEliminarMedicamento.setBackground(new Color(0, 128, 192));
        btnEliminarMedicamento.setBounds(700, 11, 271, 47);
        buttonPanel.add(btnEliminarMedicamento);
        
        JPanel namePanel_1 = new JPanel();
        namePanel_1.setLayout(null);
        namePanel_1.setBackground(new Color(0, 128, 192));
        namePanel_1.setBounds(616, 111, 158, 39);
        panel.add(namePanel_1);
        
        JLabel lblCantidad = new JLabel("Precio:");
        lblCantidad.setBounds(0, 0, 148, 39);
        namePanel_1.add(lblCantidad);
        lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        lblCantidad.setForeground(Color.WHITE);
        lblCantidad.setFont(new Font("Dialog", Font.BOLD, 20));
        
        textField = new JTextField();
        textField.setFont(new Font("Dialog", Font.BOLD, 18));
        textField.setColumns(10);
        textField.setBorder(new LineBorder(new Color(0, 128, 192), 3));
        textField.setBounds(773, 111, 170, 39);
        panel.add(textField);
        
        JPanel namePanel_3 = new JPanel();
        namePanel_3.setLayout(null);
        namePanel_3.setBackground(new Color(0, 128, 192));
        namePanel_3.setBounds(129, 196, 170, 39);
        panel.add(namePanel_3);
        
        JLabel lblPrecioVenta = new JLabel("Stock:");
        lblPrecioVenta.setBounds(0, 0, 160, 39);
        namePanel_3.add(lblPrecioVenta);
        lblPrecioVenta.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrecioVenta.setForeground(Color.WHITE);
        lblPrecioVenta.setFont(new Font("Dialog", Font.BOLD, 20));
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Dialog", Font.BOLD, 18));
        textField_2.setColumns(10);
        textField_2.setBorder(new LineBorder(new Color(0, 128, 192), 3));
        textField_2.setBounds(296, 196, 136, 39);
        panel.add(textField_2);
        
        JButton btnCancel = new JButton("Añadir medicamento");
        btnCancel.setBounds(552, 196, 260, 47);
        panel.add(btnCancel);
        btnCancel.setBackground(new Color(0, 128, 192));
        btnCancel.setForeground(new Color(255, 255, 255));
        btnCancel.setFont(new Font("Dialog", Font.BOLD, 20));
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 266, 1096, 16);
        panel.add(separator_1);
        
        

	}
}
