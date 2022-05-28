package Swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class PanelPedidoEspe extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelPedidoEspe() {
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

		JLabel lblNewLabel = new JLabel("PEDIDO");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(227, 28, 363, 51);
		cabecera.add(lblNewLabel);
		
		JButton btnModifcarPedidos = new JButton("MODIFCAR PEDIDOS");
		btnModifcarPedidos.setFont(new Font("Verdana", Font.BOLD, 15));
		btnModifcarPedidos.setFocusPainted(false);
		btnModifcarPedidos.setBorder(null);
		btnModifcarPedidos.setBackground(new Color(255, 228, 225));
		btnModifcarPedidos.setBounds(202, 547, 408, 62);
		panel.add(btnModifcarPedidos);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(59, 183, 682, 315);
		panel.add(textArea);


	}
}
