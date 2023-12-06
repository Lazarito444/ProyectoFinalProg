package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import hospital.Factura;


public class FacturacionPagosPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField idTF;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JTextField reasonTF;
	private JTextField amountTF;
	private JTextField cardTF;
	private JTextField cvcTF;
	private JTextField expDateTF;
	
	public ArrayList<Factura> listaFacturas = new ArrayList<>();
	
	
	public FacturacionPagosPanel() {
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
		
		JLabel title = new JLabel("Facturación ");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Dialog", Font.BOLD, 28));
		title.setBounds(-27, 30, 310, 48);
		panel.add(title);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FacturacionPagosPanel.class.getResource("/gui/images/LogoHospital.png")));
		lblNewLabel.setBounds(933, 11, 171, 164);
		panel.add(lblNewLabel);
		
		JPanel namePanel = new JPanel();
		namePanel.setBackground(new Color(0, 128, 192));
		namePanel.setBounds(49, 111, 80, 39);
		panel.add(namePanel);
		namePanel.setLayout(null);
		
		JLabel nameLbl = new JLabel("ID:");
		nameLbl.setBounds(0, 0, 80, 39);
		namePanel.add(nameLbl);
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setFont(new Font("Dialog", Font.BOLD, 20));
		nameLbl.setForeground(new Color(255, 255, 255));
		
		idTF = new JTextField();
		idTF.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		idTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		idTF.setBounds(128, 111, 161, 39);
		panel.add(idTF);
		idTF.setColumns(10);
		
		JPanel namePanel_1_1_1 = new JPanel();
		namePanel_1_1_1.setLayout(null);
		namePanel_1_1_1.setBackground(new Color(0, 128, 192));
		namePanel_1_1_1.setBounds(49, 350, 322, 39);
		panel.add(namePanel_1_1_1);
		
		JLabel lblRaznDelPago = new JLabel("Razón del pago:");
		lblRaznDelPago.setBounds(0, 0, 322, 39);
		namePanel_1_1_1.add(lblRaznDelPago);
		lblRaznDelPago.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaznDelPago.setForeground(Color.WHITE);
		lblRaznDelPago.setFont(new Font("Dialog", Font.BOLD, 20));
		
		reasonTF = new JTextField();
		reasonTF.setFont(new Font("Dialog", Font.BOLD, 18));
		reasonTF.setColumns(10);
		reasonTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		reasonTF.setBounds(368, 350, 470, 39);
		panel.add(reasonTF);
		
		JPanel namePanel_1_1_2 = new JPanel();
		namePanel_1_1_2.setLayout(null);
		namePanel_1_1_2.setBackground(new Color(0, 128, 192));
		namePanel_1_1_2.setBounds(49, 462, 245, 39);
		panel.add(namePanel_1_1_2);
		
		JLabel lblMontoAPagar = new JLabel("Monto a pagar:");
		lblMontoAPagar.setBounds(0, 0, 235, 39);
		namePanel_1_1_2.add(lblMontoAPagar);
		lblMontoAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontoAPagar.setForeground(Color.WHITE);
		lblMontoAPagar.setFont(new Font("Dialog", Font.BOLD, 20));
		
		amountTF = new JTextField();
		amountTF.setFont(new Font("Dialog", Font.BOLD, 18));
		amountTF.setColumns(10);
		amountTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		amountTF.setBounds(289, 462, 191, 39);
		panel.add(amountTF);
		
		JComboBox<String> paymentM = new JComboBox<>();
		paymentM.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				if (paymentM.getSelectedIndex() == 0) {
					cardTF.setEnabled(false);
					expDateTF.setEnabled(false);
					cvcTF.setEnabled(false);
				} else {
					cardTF.setEnabled(true);
					expDateTF.setEnabled(true);
					cvcTF.setEnabled(true);
				}
			}
		});
		paymentM.setBackground(new Color(255, 255, 255));
		paymentM.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		paymentM.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		paymentM.setModel(new DefaultComboBoxModel<>(new String[] {"Efectivo", "Tarjeta"}));
		paymentM.setBounds(270, 527, 210, 39);
		panel.add(paymentM);
		
		JPanel namePanel_1_1_2_1 = new JPanel();
		namePanel_1_1_2_1.setLayout(null);
		namePanel_1_1_2_1.setBackground(new Color(0, 128, 192));
		namePanel_1_1_2_1.setBounds(49, 527, 222, 39);
		panel.add(namePanel_1_1_2_1);
		
		JLabel lblFormasDePago = new JLabel("Método de pago:");
		lblFormasDePago.setBounds(0, 0, 225, 39);
		namePanel_1_1_2_1.add(lblFormasDePago);
		lblFormasDePago.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormasDePago.setForeground(Color.WHITE);
		lblFormasDePago.setFont(new Font("Dialog", Font.BOLD, 20));
        
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(497, 446, 23, 170);
        panel.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(513, 446, 23, 170);
        panel.add(separator_1);
        
        JPanel namePanel_1_1_2_2 = new JPanel();
        namePanel_1_1_2_2.setLayout(null);
        namePanel_1_1_2_2.setBackground(new Color(0, 128, 192));
        namePanel_1_1_2_2.setBounds(547, 474, 245, 39);
        panel.add(namePanel_1_1_2_2);
        
        JLabel lblNmeroDeTarjeta = new JLabel("Número de tarjeta:");
        lblNmeroDeTarjeta.setBounds(0, 0, 245, 39);
        namePanel_1_1_2_2.add(lblNmeroDeTarjeta);
        lblNmeroDeTarjeta.setHorizontalAlignment(SwingConstants.CENTER);
        lblNmeroDeTarjeta.setForeground(Color.WHITE);
        lblNmeroDeTarjeta.setFont(new Font("Dialog", Font.BOLD, 20));
        
        cardTF = new JTextField();
        cardTF.setFont(new Font("Dialog", Font.BOLD, 18));
        cardTF.setColumns(10);
        cardTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
        cardTF.setBounds(788, 474, 300, 39);
        panel.add(cardTF);
        
        JPanel namePanel_1_1_2_2_1 = new JPanel();
        namePanel_1_1_2_2_1.setLayout(null);
        namePanel_1_1_2_2_1.setBackground(new Color(0, 128, 192));
        namePanel_1_1_2_2_1.setBounds(547, 578, 153, 39);
        panel.add(namePanel_1_1_2_2_1);
        
        JLabel lblCvvcvc = new JLabel("CVV/CVC:");
        lblCvvcvc.setBounds(0, 0, 161, 39);
        namePanel_1_1_2_2_1.add(lblCvvcvc);
        lblCvvcvc.setHorizontalAlignment(SwingConstants.CENTER);
        lblCvvcvc.setForeground(Color.WHITE);
        lblCvvcvc.setFont(new Font("Dialog", Font.BOLD, 20));
        
        cvcTF = new JTextField();
        cvcTF.setFont(new Font("Dialog", Font.BOLD, 18));
        cvcTF.setColumns(10);
        cvcTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
        cvcTF.setBounds(696, 578, 171, 39);
        panel.add(cvcTF);
        
        JPanel namePanel_1_1_2_2_1_1 = new JPanel();
        namePanel_1_1_2_2_1_1.setLayout(null);
        namePanel_1_1_2_2_1_1.setBackground(new Color(0, 128, 192));
        namePanel_1_1_2_2_1_1.setBounds(547, 527, 153, 39);
        panel.add(namePanel_1_1_2_2_1_1);
        
        JLabel lblCvvcvc_1 = new JLabel("Fecha Exp.:");
        lblCvvcvc_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblCvvcvc_1.setForeground(Color.WHITE);
        lblCvvcvc_1.setFont(new Font("Dialog", Font.BOLD, 20));
        lblCvvcvc_1.setBounds(0, 0, 161, 39);
        namePanel_1_1_2_2_1_1.add(lblCvvcvc_1);
        
        expDateTF = new JTextField();
        expDateTF.setFont(new Font("Dialog", Font.BOLD, 18));
        expDateTF.setColumns(10);
        expDateTF.setBorder(new LineBorder(new Color(0, 128, 192), 3));
        expDateTF.setBounds(696, 527, 171, 39);
        panel.add(expDateTF);
        
        JLabel payBtn = new JLabel("Pagar Servicio");
        payBtn.addMouseListener(new MouseAdapter() {
        	
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String query = "INSERT INTO Facturacion (ID_Cliente, Monto, Razon, MetodoPago) VALUES (?, ?, ?, ?)";
        		
            	listaFacturas.add(new Factura("Pago hospital", Double.parseDouble(amountTF.getText()), 
            			reasonTF.getText()));
        		try {
        			
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_hospital", "root", "admin");
        			
        			PreparedStatement pst = con.prepareStatement(query);
        			
        			pst.setInt(1, Integer.parseInt(idTF.getText()));
        			pst.setDouble(2, Double.parseDouble(amountTF.getText()));
        			pst.setString(3, reasonTF.getText());
        			pst.setString(4, (String) paymentM.getSelectedItem());
        			
        			pst.executeUpdate();
        			
        			con.close();
        			JOptionPane.showMessageDialog(null, "Facturación añadida");
        			
        		} catch(ClassNotFoundException err) {
        			err.printStackTrace();
        		} catch(SQLException err) {
        			err.printStackTrace();
        		}
        	}
        	
			@Override
			public void mouseEntered(MouseEvent e) {
				payBtn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				payBtn.setBackground(new Color(33, 131, 222));
			}
        });
        payBtn.setOpaque(true);
        payBtn.setBackground(new Color(0, 128, 192));
        payBtn.setHorizontalAlignment(SwingConstants.CENTER);
        payBtn.setForeground(new Color(255, 255, 255));
        payBtn.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
        payBtn.setBounds(547, 692, 245, 48);
        panel.add(payBtn);
        
        JLabel clearBtn = new JLabel("Limpiar datos");
        clearBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		idTF.setText("");
        		reasonTF.setText("");
        		amountTF.setText("");
        		cardTF.setText("");
        		expDateTF.setText("");
        		cvcTF.setText("");
        		
        	}
        	
			@Override
			public void mouseEntered(MouseEvent e) {
				clearBtn.setBackground(new Color(50, 142, 227));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				clearBtn.setBackground(new Color(33, 131, 222));
			}
        });
        clearBtn.setOpaque(true);
        clearBtn.setHorizontalAlignment(SwingConstants.CENTER);
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFont(new Font("Roboto Condensed", Font.BOLD, 21));
        clearBtn.setBackground(new Color(0, 128, 192));
        clearBtn.setBounds(843, 692, 245, 48);
        panel.add(clearBtn);
        
        
        setVisible(true);
	}
}
