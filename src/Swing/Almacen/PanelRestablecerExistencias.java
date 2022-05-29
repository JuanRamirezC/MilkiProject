package Swing.Almacen;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Milki.Empresa;

public class PanelRestablecerExistencias extends JPanel {
	
	private JTextField txtNombre;
	private JTextField txtCantidad;
	/**
	 * Create the panel.
	 */
	public PanelRestablecerExistencias() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 814, 711);
		add(panel);
		panel.setLayout(null);

		JSeparator sep1 = new JSeparator();
		sep1.setFont(new Font("Dialog", Font.BOLD, 12));
		sep1.setForeground(new Color(255, 102, 153));
		sep1.setBounds(374, 422, 87, 2);
		panel.add(sep1);

		JSeparator sep3 = new JSeparator();
		sep3.setForeground(new Color(255, 102, 153));
		sep3.setFont(new Font("Dialog", Font.BOLD, 12));
		sep3.setBounds(374, 501, 87, 2);
		panel.add(sep3);

		JPanel cabecera = new JPanel();
		cabecera.setLayout(null);
		cabecera.setBackground(new Color(255, 153, 153));
		cabecera.setBounds(0, 0, 814, 115);
		panel.add(cabecera);

		JLabel lblAñadirCliente = new JLabel("RESTABLECER EXISTENCIAS");
		lblAñadirCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAñadirCliente.setForeground(Color.WHITE);
		lblAñadirCliente.setFont(new Font("Verdana", Font.BOLD, 30));
		lblAñadirCliente.setBounds(196, 27, 493, 51);
		cabecera.add(lblAñadirCliente);

		txtNombre = new JTextField();
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(txtNombre.getText().equals("Codigo Producto")) {
					txtNombre.setText("");
					txtNombre.setForeground(Color.black);
				}
				if(txtCantidad.getText().isEmpty()) {
					txtCantidad.setText("Cantidad");
					txtCantidad.setForeground(new Color(255, 182, 193));
				}

			}
		});
		txtNombre.setBackground(new Color(255, 240, 245));
		txtNombre.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtNombre.setText("Codigo ");
		txtNombre.setForeground(new Color(255, 182, 193));
		txtNombre.setBorder(null);
		txtNombre.setBounds(374, 385, 87, 37);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtCantidad.getText().equals("Cantidad")) {
					txtCantidad.setText("");
					txtCantidad.setForeground(Color.black);
				}
				if(txtNombre.getText().isEmpty()) {
					txtNombre.setText("Codigo Producto");
					txtNombre.setForeground(new Color(255, 182, 193));
				}

			}
		});
		txtCantidad.setBackground(new Color(255, 240, 245));
		txtCantidad.setText("Cantidad");
		txtCantidad.setForeground(new Color(255, 182, 193));
		txtCantidad.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtCantidad.setColumns(10);
		txtCantidad.setBorder(null);
		txtCantidad.setBounds(374, 466, 87, 37);
		panel.add(txtCantidad);

		JLabel lblResultado = new JLabel("");
		lblResultado.setBackground(new Color(255, 255, 224));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.BLACK);
		lblResultado.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		lblResultado.setBounds(214, 628, 419, 72);
		panel.add(lblResultado);

		JButton btnAñadir = new JButton("RESTABLECER");
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtNombre.getText().isEmpty() && !txtCantidad.getText().isEmpty()) {
						Empresa.modificarExistencias(Integer.parseInt(txtNombre.getText()),Integer.parseInt(txtCantidad.getText()));
						lblResultado.setText("CANTIDAD MODIFICADA");
				}
				else {
					lblResultado.setText("ERROR AL MODIFICAR, COMPRUEBE LOS DATOS");
				}

			}
		});
		btnAñadir.setForeground(Color.WHITE);
		btnAñadir.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnAñadir.setFocusPainted(false);
		btnAñadir.setBorderPainted(false);
		btnAñadir.setBorder(null);
		btnAñadir.setBackground(new Color(255, 153, 153));
		btnAñadir.setBounds(345, 564, 156, 42);
		panel.add(btnAñadir);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelRestablecerExistencias.class.getResource("/imagenes/YY.png")));
		lblNewLabel_1.setBounds(345, 161, 156, 170);
		panel.add(lblNewLabel_1);

	}

}
