package Swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class PanelVerPedido extends JPanel {
	private JTextField txtCdigoCliente;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PanelVerPedido() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 814, 711);
		add(panel);
		panel.setLayout(null);

		JPanel cabecera = new JPanel();
		cabecera.setBackground(new Color(255, 153, 153));
		cabecera.setBounds(0, 0, 814, 115);
		panel.add(cabecera);
		cabecera.setLayout(null);

		JLabel lblNewLabel = new JLabel("ELIJA UNA OPCION");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(227, 28, 363, 51);
		cabecera.add(lblNewLabel);

		JButton btnAñadir = new JButton("VER PEDIDOS");
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAñadir.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAñadir.setBackground(new Color(255, 228, 225));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelAltaPedido p1= new PanelAltaPedido();
				p1.setSize(814,711);
				p1.setLocation(0,0);

				panel.removeAll();
				panel.setLayout(null);
				panel.add(p1);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnAñadir.setFont(new Font("Verdana", Font.BOLD, 15));
		btnAñadir.setFocusPainted(false);
		btnAñadir.setBorder(null);
		btnAñadir.setBackground(new Color(255, 228, 225));
		btnAñadir.setBounds(263, 293, 408, 62);
		panel.add(btnAñadir);
		
		JButton btnVerPedidoEspecifico = new JButton("VER PEDIDO ESPECIFICO");
		btnVerPedidoEspecifico.setFont(new Font("Verdana", Font.BOLD, 15));
		btnVerPedidoEspecifico.setFocusPainted(false);
		btnVerPedidoEspecifico.setBorder(null);
		btnVerPedidoEspecifico.setBackground(new Color(255, 228, 225));
		btnVerPedidoEspecifico.setBounds(263, 415, 408, 62);
		panel.add(btnVerPedidoEspecifico);
		
		txtCdigoCliente = new JTextField();
		txtCdigoCliente.setText("C\u00F3digo Cliente");
		txtCdigoCliente.setForeground(new Color(255, 182, 193));
		txtCdigoCliente.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtCdigoCliente.setColumns(10);
		txtCdigoCliente.setBorder(null);
		txtCdigoCliente.setBackground(new Color(255, 240, 245));
		txtCdigoCliente.setBounds(84, 304, 142, 37);
		panel.add(txtCdigoCliente);
		
		textField_1 = new JTextField();
		textField_1.setText("N\u00FAmero Pedido");
		textField_1.setForeground(new Color(255, 182, 193));
		textField_1.setFont(new Font("Verdana", Font.ITALIC, 18));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(255, 240, 245));
		textField_1.setBounds(84, 426, 142, 37);
		panel.add(textField_1);


	}
}
