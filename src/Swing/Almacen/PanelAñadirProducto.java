package Swing.Almacen;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Milki.Empresa;
import javax.swing.ImageIcon;

public class PanelAñadirProducto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtCantidad;
	private JTextField txtMarca;
	private JTextField txtPrecio;

	public PanelAñadirProducto() {

		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 814, 711);
		add(panel);
		panel.setLayout(null);

		JSeparator sep1 = new JSeparator();
		sep1.setFont(new Font("Dialog", Font.BOLD, 12));
		sep1.setForeground(new Color(255, 102, 153));
		sep1.setBounds(21, 421, 264, 2);
		panel.add(sep1);

		JSeparator sep5 = new JSeparator();
		sep5.setForeground(new Color(255, 102, 153));
		sep5.setFont(new Font("Dialog", Font.BOLD, 12));
		sep5.setBounds(319, 421, 227, 2);
		panel.add(sep5);

		JSeparator sep3_1 = new JSeparator();
		sep3_1.setForeground(new Color(255, 102, 153));
		sep3_1.setFont(new Font("Dialog", Font.BOLD, 12));
		sep3_1.setBounds(562, 421, 87, 2);
		panel.add(sep3_1);

		JSeparator sep3 = new JSeparator();
		sep3.setForeground(new Color(255, 102, 153));
		sep3.setFont(new Font("Dialog", Font.BOLD, 12));
		sep3.setBounds(677, 421, 87, 2);
		panel.add(sep3);

		JPanel cabecera = new JPanel();
		cabecera.setLayout(null);
		cabecera.setBackground(new Color(255, 153, 153));
		cabecera.setBounds(0, 0, 814, 115);
		panel.add(cabecera);

		JLabel lblAñadirCliente = new JLabel("A\u00D1ADIR PRODUCTO");
		lblAñadirCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAñadirCliente.setForeground(Color.WHITE);
		lblAñadirCliente.setFont(new Font("Verdana", Font.BOLD, 30));
		lblAñadirCliente.setBounds(220, 28, 363, 51);
		cabecera.add(lblAñadirCliente);
		
		JLabel lblCod = new JLabel("");
		lblCod.setHorizontalAlignment(SwingConstants.CENTER);
		lblCod.setForeground(Color.BLACK);
		lblCod.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		lblCod.setBackground(new Color(255, 255, 224));
		lblCod.setBounds(506, 455, 298, 72);
		panel.add(lblCod);


		txtNombre = new JTextField();
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(txtNombre.getText().equals("Nombre")) {
					txtNombre.setText("");
					txtNombre.setForeground(Color.black);
				}
				if(txtCantidad.getText().isEmpty()) {
					txtCantidad.setText("Cantidad");
					txtCantidad.setForeground(new Color(255, 182, 193));
				}
				if(txtMarca.getText().isEmpty()) {
					txtMarca.setText("Marca");
					txtMarca.setForeground(new Color(255, 182, 193));
				}
				if(txtPrecio.getText().isEmpty()) {
					txtPrecio.setText("Precio");
					txtPrecio.setForeground(new Color(255, 182, 193));
				}

			}
		});
		txtNombre.setBackground(new Color(255, 240, 245));
		txtNombre.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtNombre.setText("Nombre");
		txtNombre.setForeground(new Color(255, 182, 193));
		txtNombre.setBorder(null);
		txtNombre.setBounds(21, 386, 263, 37);
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
					txtNombre.setText("Nombre");
					txtNombre.setForeground(new Color(255, 182, 193));
				}

				if(txtMarca.getText().isEmpty()) {
					txtMarca.setText("Marca");
					txtMarca.setForeground(new Color(255, 182, 193));
				}
				if(txtPrecio.getText().isEmpty()) {
					txtPrecio.setText("Precio");
					txtPrecio.setForeground(new Color(255, 182, 193));
				}

			}
		});
		txtCantidad.setBackground(new Color(255, 240, 245));
		txtCantidad.setText("Cantidad");
		txtCantidad.setForeground(new Color(255, 182, 193));
		txtCantidad.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtCantidad.setColumns(10);
		txtCantidad.setBorder(null);
		txtCantidad.setBounds(677, 386, 87, 37);
		panel.add(txtCantidad);

		txtMarca = new JTextField();
		txtMarca.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(txtMarca.getText().equals("Marca")) {
					txtMarca.setText("");
					txtMarca.setForeground(Color.black);
				}
				if(txtNombre.getText().isEmpty()) {
					txtNombre.setText("Nombre");
					txtNombre.setForeground(new Color(255, 182, 193));
				}
				if(txtCantidad.getText().isEmpty()) {
					txtCantidad.setText("Cantidad");
					txtCantidad.setForeground(new Color(255, 182, 193));
				}

				if(txtPrecio.getText().isEmpty()) {
					txtPrecio.setText("Precio");
					txtPrecio.setForeground(new Color(255, 182, 193));
				}

			}
		});
		txtMarca.setBackground(new Color(255, 240, 245));
		txtMarca.setText("Marca");
		txtMarca.setForeground(new Color(255, 182, 193));
		txtMarca.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtMarca.setColumns(10);
		txtMarca.setBorder(null);
		txtMarca.setBounds(319, 386, 227, 37);
		panel.add(txtMarca);

		txtPrecio = new JTextField();
		txtPrecio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(txtNombre.getText().isEmpty()) {
					txtNombre.setText("Nombre");
					txtNombre.setForeground(new Color(255, 182, 193));
				}
				if(txtCantidad.getText().isEmpty()) {
					txtCantidad.setText("Cantidad");
					txtCantidad.setForeground(new Color(255, 182, 193));
				}
				if(txtMarca.getText().isEmpty()) {
					txtMarca.setText("Marca");
					txtMarca.setForeground(new Color(255, 182, 193));
				}
				if(txtPrecio.getText().equals("Precio")) {
					txtPrecio.setText("");
					txtPrecio.setForeground(Color.black);
				}

			}
		});
		txtPrecio.setBackground(new Color(255, 240, 245));
		txtPrecio.setText("Precio");
		txtPrecio.setForeground(new Color(255, 182, 193));
		txtPrecio.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtPrecio.setColumns(10);
		txtPrecio.setBorder(null);
		txtPrecio.setBounds(562, 386, 87, 37);
		panel.add(txtPrecio);

		JLabel lblResultado = new JLabel("");
		lblResultado.setBackground(new Color(255, 255, 224));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.BLACK);
		lblResultado.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		lblResultado.setBounds(21, 455, 419, 72);
		panel.add(lblResultado);

		JButton btnAñadir = new JButton("A\u00D1ADIR");
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtNombre.getText().isEmpty() && !txtCantidad.getText().isEmpty() &&
						!txtMarca.getText().isEmpty() && !txtPrecio.getText().isEmpty()) {	
					lblCod.setText(String.valueOf(Empresa.anhadirProductoN(txtNombre.getText(), Integer.parseInt(txtCantidad.getText()), txtMarca.getText(), Double.valueOf(txtPrecio.getText()))));
					lblResultado.setText("¡PRODUCTO AÑADIDO CON EXITO!");
				}
				else {
					lblResultado.setText("TODOS LOS CAMPOS SON OBLIGATORIOS");
				}

			}
		});
		btnAñadir.setForeground(Color.WHITE);
		btnAñadir.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnAñadir.setFocusPainted(false);
		btnAñadir.setBorderPainted(false);
		btnAñadir.setBorder(null);
		btnAñadir.setBackground(new Color(255, 153, 153));
		btnAñadir.setBounds(329, 563, 142, 42);
		panel.add(btnAñadir);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelAñadirProducto.class.getResource("/imagenes/YY.png")));
		lblNewLabel_1.setBounds(315, 158, 156, 170);
		panel.add(lblNewLabel_1);
		
		
	}
}
