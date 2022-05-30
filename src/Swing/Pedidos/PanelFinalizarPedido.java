package Swing.Pedidos;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Milki.Empresa;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelFinalizarPedido extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;


	public PanelFinalizarPedido() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 814, 711);
		add(panel);

		JSeparator sep1 = new JSeparator();
		sep1.setForeground(new Color(255, 102, 153));
		sep1.setFont(new Font("Dialog", Font.BOLD, 12));
		sep1.setBounds(322, 422, 156, 2);
		panel.add(sep1);

		JPanel cabecera = new JPanel();
		cabecera.setLayout(null);
		cabecera.setBackground(new Color(255, 153, 153));
		cabecera.setBounds(0, 0, 814, 115);
		panel.add(cabecera);

		JLabel lblFinalizarPedido = new JLabel("FINALIZAR PEDIDO");
		lblFinalizarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalizarPedido.setForeground(Color.WHITE);
		lblFinalizarPedido.setFont(new Font("Verdana", Font.BOLD, 30));
		lblFinalizarPedido.setBounds(220, 28, 438, 51);
		cabecera.add(lblFinalizarPedido);

		JLabel lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.BLACK);
		lblResultado.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		lblResultado.setBackground(new Color(255, 255, 224));
		lblResultado.setBounds(192, 475, 419, 72);
		panel.add(lblResultado);

		JButton btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFinalizar.setBackground(new Color(255, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFinalizar.setBackground(new Color(255, 153, 153));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!textField.getText().isEmpty()) {
					Empresa.finalizarPedido(Integer.parseInt(textField.getText()));
					lblResultado.setText("PEDIDO FINALIZADO");

				}
				else {
					lblResultado.setText("ERROR AL FINALIZAR EL PEDIDO, COMPRUEBE LOS DATOS");
				}

			}
		});
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnFinalizar.setFocusPainted(false);
		btnFinalizar.setBorderPainted(false);
		btnFinalizar.setBorder(null);
		btnFinalizar.setBackground(new Color(255, 153, 153));
		btnFinalizar.setBounds(322, 577, 156, 42);
		panel.add(btnFinalizar);

		textField = new JTextField();
		textField.setText("Numero Pedido");
		textField.setForeground(new Color(255, 182, 193));
		textField.setFont(new Font("Verdana", Font.ITALIC, 18));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(255, 240, 245));
		textField.setBounds(322, 385, 156, 37);
		panel.add(textField);

		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(textField.getText().equals("Numero Pedido")) {
					textField.setText("");
					textField.setForeground(Color.black);
				}
			}
		});



		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelFinalizarPedido.class.getResource("/imagenes/PAQUETE.PNG.png")));
		lblNewLabel.setBounds(317, 195, 161, 161);
		panel.add(lblNewLabel);

	}
}
