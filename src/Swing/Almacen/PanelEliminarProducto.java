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

public class PanelEliminarProducto extends JPanel {
	private JTextField txtNombre;
	/**
	 * Create the panel.
	 */
	public PanelEliminarProducto() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 814, 711);
		add(panel);
		panel.setLayout(null);

		JSeparator sep1 = new JSeparator();
		sep1.setFont(new Font("Dialog", Font.BOLD, 12));
		sep1.setForeground(new Color(255, 102, 153));
		sep1.setBounds(345, 422, 90, 2);
		panel.add(sep1);

		JPanel cabecera = new JPanel();
		cabecera.setLayout(null);
		cabecera.setBackground(new Color(255, 153, 153));
		cabecera.setBounds(0, 0, 814, 115);
		panel.add(cabecera);

		JLabel lblAñadirCliente = new JLabel("ELIMINAR EXISTENCIAS");
		lblAñadirCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAñadirCliente.setForeground(Color.WHITE);
		lblAñadirCliente.setFont(new Font("Verdana", Font.BOLD, 30));
		lblAñadirCliente.setBounds(220, 28, 438, 51);
		cabecera.add(lblAñadirCliente);

		JLabel lblResultado = new JLabel("");
		lblResultado.setBackground(new Color(255, 255, 224));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.BLACK);
		lblResultado.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		lblResultado.setBounds(192, 475, 419, 72);
		panel.add(lblResultado);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtNombre.getText().isEmpty()) {
					Empresa.borrarProducto(Integer.parseInt(txtNombre.getText()));
					lblResultado.setText("PRODUCTO ELIMINADO");

				}
				else {
					lblResultado.setText("ERROR AL BORRAR, COMPRUEBE LOS DATOS");
				}

			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnEliminar.setFocusPainted(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(255, 153, 153));
		btnEliminar.setBounds(322, 575, 142, 42);
		panel.add(btnEliminar);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelEliminarProducto.class.getResource("/imagenes/YOGURT-Triste.png")));
		lblNewLabel_1.setBounds(308, 160, 156, 170);
		panel.add(lblNewLabel_1);
		
				txtNombre = new JTextField();
				txtNombre.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {

						if(txtNombre.getText().equals("Codigo Producto")) {
							txtNombre.setText("");
							txtNombre.setForeground(Color.black);
						}
					}
				});
				txtNombre.setBackground(new Color(255, 240, 245));
				txtNombre.setFont(new Font("Verdana", Font.ITALIC, 18));
				txtNombre.setText("Codigo");
				txtNombre.setForeground(new Color(255, 182, 193));
				txtNombre.setBorder(null);
				txtNombre.setBounds(345, 387, 90, 37);
				panel.add(txtNombre);
				txtNombre.setColumns(10);

	}

}
