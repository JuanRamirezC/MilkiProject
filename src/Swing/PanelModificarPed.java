package Swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class PanelModificarPed extends JPanel {
	private JTextField txtCodigoDelProducto;
	private JTextField txtCodigoProducto;
	private JTextField txtNmeroPedio;

	/**
	 * Create the panel.
	 */
	public PanelModificarPed() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 814, 700);
		add(panel);
		panel.setLayout(null);

		JPanel cabecera = new JPanel();
		cabecera.setBackground(new Color(255, 153, 153));
		cabecera.setBounds(0, 0, 814, 115);
		panel.add(cabecera);
		cabecera.setLayout(null);

		JLabel lblCabecera = new JLabel("MODIFICAR PEDIDO");
		lblCabecera.setFont(new Font("Verdana", Font.BOLD, 30));
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabecera.setForeground(Color.WHITE);
		lblCabecera.setBounds(227, 28, 363, 51);
		cabecera.add(lblCabecera);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(PanelAltaPedido.class.getResource("/imagenes/PAQUETE.PNG.png")));
		lblLogo.setBounds(309, 119, 163, 236);
		panel.add(lblLogo);
		
		JButton btnEliminarProducto = new JButton("ELIMINAR PRODUCTO");
		btnEliminarProducto.setFont(new Font("Verdana", Font.BOLD, 15));
		btnEliminarProducto.setFocusPainted(false);
		btnEliminarProducto.setBorderPainted(false);
		btnEliminarProducto.setBorder(null);
		btnEliminarProducto.setBackground(new Color(255, 228, 225));
		btnEliminarProducto.setBounds(437, 583, 345, 55);
		panel.add(btnEliminarProducto);
		
		JButton btnAadirProducto = new JButton("A\u00D1ADIR PRODUCTO");
		btnAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAadirProducto.setFont(new Font("Verdana", Font.BOLD, 15));
		btnAadirProducto.setFocusPainted(false);
		btnAadirProducto.setBorderPainted(false);
		btnAadirProducto.setBorder(null);
		btnAadirProducto.setBackground(new Color(255, 228, 225));
		btnAadirProducto.setBounds(43, 583, 345, 55);
		panel.add(btnAadirProducto);
		
		txtCodigoDelProducto = new JTextField();
		txtCodigoDelProducto.setText("Codigo Producto");
		txtCodigoDelProducto.setForeground(new Color(255, 182, 193));
		txtCodigoDelProducto.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtCodigoDelProducto.setColumns(10);
		txtCodigoDelProducto.setBorder(null);
		txtCodigoDelProducto.setBackground(new Color(255, 240, 245));
		txtCodigoDelProducto.setBounds(83, 453, 263, 37);
		panel.add(txtCodigoDelProducto);
		
		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setText("Cantidad Producto");
		txtCodigoProducto.setForeground(new Color(255, 182, 193));
		txtCodigoProducto.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtCodigoProducto.setColumns(10);
		txtCodigoProducto.setBorder(null);
		txtCodigoProducto.setBackground(new Color(255, 240, 245));
		txtCodigoProducto.setBounds(475, 453, 263, 37);
		panel.add(txtCodigoProducto);
		
		JButton btnVerTodosLos = new JButton("VER PRODUCTOS ALMAC\u00C9N");
		btnVerTodosLos.setForeground(new Color(0, 0, 0));
		btnVerTodosLos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerTodosLos.setFont(new Font("Verdana", Font.BOLD, 11));
		btnVerTodosLos.setFocusPainted(false);
		btnVerTodosLos.setBorderPainted(false);
		btnVerTodosLos.setBorder(null);
		btnVerTodosLos.setBackground(new Color(204, 255, 255));
		btnVerTodosLos.setBounds(602, 135, 186, 60);
		panel.add(btnVerTodosLos);
		
		JSeparator sep1_1 = new JSeparator();
		sep1_1.setForeground(new Color(255, 102, 153));
		sep1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		sep1_1.setBounds(83, 490, 264, 2);
		panel.add(sep1_1);
		
		JSeparator sep1_2 = new JSeparator();
		sep1_2.setForeground(new Color(255, 102, 153));
		sep1_2.setFont(new Font("Dialog", Font.BOLD, 12));
		sep1_2.setBounds(475, 490, 264, 2);
		panel.add(sep1_2);
		
		txtNmeroPedio = new JTextField();
		txtNmeroPedio.setText("N\u00FAmero Pedido");
		txtNmeroPedio.setForeground(new Color(255, 182, 193));
		txtNmeroPedio.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtNmeroPedio.setColumns(10);
		txtNmeroPedio.setBorder(null);
		txtNmeroPedio.setBackground(new Color(255, 240, 245));
		txtNmeroPedio.setBounds(258, 352, 263, 37);
		panel.add(txtNmeroPedio);
		
		JSeparator sep1_1_1 = new JSeparator();
		sep1_1_1.setForeground(new Color(255, 102, 153));
		sep1_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		sep1_1_1.setBounds(258, 391, 264, 2);
		panel.add(sep1_1_1);

	}
}
