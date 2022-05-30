package Swing.Pedidos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import Milki.Empresa;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class PanelCrearPedido extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	public static int num;
	public  static String codpers;

	
	public PanelCrearPedido() {
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

		JLabel lblCabecera = new JLabel("CREAR PEDIDO");
		lblCabecera.setFont(new Font("Verdana", Font.BOLD, 30));
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabecera.setForeground(Color.WHITE);
		lblCabecera.setBounds(227, 28, 363, 51);
		cabecera.add(lblCabecera);

		JLabel lblResultado = new JLabel();
		lblResultado.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblResultado.setBounds(250, 442, 306, 71);
		panel.add(lblResultado);

		JLabel lblCodigo = new JLabel();
		lblCodigo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblCodigo.setBounds(143, 524, 520, 71);
		panel.add(lblCodigo);

		JButton btnAccederAPedido = new JButton("ACCEDER A PEDIDO");
		btnAccederAPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAccederAPedido.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAccederAPedido.setBackground(new Color(255, 228, 225));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				FramePedido f1;
				try {
					f1 = new FramePedido();
					f1.setLocation(0,0);
					f1.setLocationRelativeTo(null);
					f1.setVisible(true);

					panel.removeAll();
					panel.setLayout(null);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"ERROR AL ACCEDER AL PEDIDO", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnAccederAPedido.setEnabled(false);
		btnAccederAPedido.setFont(new Font("Verdana", Font.BOLD, 15));
		btnAccederAPedido.setFocusPainted(false);
		btnAccederAPedido.setBorder(null);
		btnAccederAPedido.setBackground(new Color(255, 228, 225));
		btnAccederAPedido.setBounds(581, 606, 223, 62);
		panel.add(btnAccederAPedido);


		JButton btnCrear = new JButton("CREAR PEDIDO");

		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCrear.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCrear.setBackground(new Color(255, 228, 225));
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				codpers=txtNombre.getText();
				num= Empresa.altaPedido(txtNombre.getText());
				lblResultado.setText("¡PEDIDO CREADO CON EXITO!");
				lblCodigo.setText("Identificador de pedido: "+num);
				btnAccederAPedido.setEnabled(true);

			}
		});
		btnCrear.setFont(new Font("Verdana", Font.BOLD, 15));
		btnCrear.setFocusPainted(false);
		btnCrear.setBorder(null);
		btnCrear.setBackground(new Color(255, 228, 225));
		btnCrear.setBounds(22, 606, 520, 62);
		panel.add(btnCrear);

		txtNombre = new JTextField();
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtNombre.getText().equals("Codigo Cliente/Proveedor")) {
					txtNombre.setText("");
					txtNombre.setForeground(Color.black);
				}
				else {
					codpers=(txtNombre.getText());
				}
			}
		});
		txtNombre.setBackground(new Color(255, 240, 245));
		txtNombre.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtNombre.setText("Codigo Cliente/Proveedor");
		txtNombre.setForeground(new Color(255, 182, 193));
		txtNombre.setBorder(null);
		txtNombre.setBounds(267, 373, 263, 37);
		panel.add(txtNombre);


		JSeparator sep1 = new JSeparator();
		sep1.setFont(new Font("Dialog", Font.BOLD, 12));
		sep1.setForeground(new Color(255, 102, 153));
		sep1.setBounds(266, 418, 264, 2);
		panel.add(sep1);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(PanelCrearPedido.class.getResource("/imagenes/PAQUETE.PNG.png")));
		lblLogo.setBounds(312, 126, 163, 236);
		panel.add(lblLogo);


	}

}
