package Swing;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import Milki.Empresa;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class PanelAnhadirC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtDni;
	private JTextField txtNumTelefono;
	private JTextField txtCodigoPostal;

	/**
	 * Create the panel.
	 */
	public PanelAnhadirC() {

		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 814, 711);
		add(panel);
		panel.setLayout(null);

		JPanel cabecera = new JPanel();
		cabecera.setLayout(null);
		cabecera.setBackground(new Color(255, 153, 153));
		cabecera.setBounds(0, 0, 814, 115);
		panel.add(cabecera);

		JLabel lblAñadirCliente = new JLabel("A\u00D1ADIR CLIENTE");
		lblAñadirCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAñadirCliente.setForeground(Color.WHITE);
		lblAñadirCliente.setFont(new Font("Verdana", Font.BOLD, 30));
		lblAñadirCliente.setBounds(220, 28, 363, 51);
		cabecera.add(lblAñadirCliente);

		txtNombre = new JTextField();
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(txtNombre.getText().equals("Nombre")) {
					txtNombre.setText("");
					txtNombre.setForeground(Color.black);
				}
				if(txtApellidos.getText().isEmpty()) {
					txtApellidos.setText("Apellidos");
					txtApellidos.setForeground(new Color(255, 182, 193));
				}
				if(txtDireccion.getText().isEmpty()) {
					txtDireccion.setText("Direccion");
					txtDireccion.setForeground(new Color(255, 182, 193));
				}
				if(txtDni.getText().isEmpty()) {
					txtDni.setText("DNI");
					txtDni.setForeground(new Color(255, 182, 193));
				}
				if(txtNumTelefono.getText().isEmpty()) {
					txtNumTelefono.setText("Num. Telefono");
					txtNumTelefono.setForeground(new Color(255, 182, 193));
				}
				if(txtCodigoPostal.getText().isEmpty()) {
					txtCodigoPostal.setText("Codigo Postal");
					txtCodigoPostal.setForeground(new Color(255, 182, 193));
				}
				
			}
		});
		txtNombre.setBackground(new Color(255, 240, 245));
		txtNombre.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtNombre.setText("Nombre");
		txtNombre.setForeground(new Color(255, 182, 193));
		txtNombre.setBorder(null);
		txtNombre.setBounds(72, 253, 263, 37);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JSeparator sep1 = new JSeparator();
		sep1.setFont(new Font("Dialog", Font.BOLD, 12));
		sep1.setForeground(new Color(255, 102, 153));
		sep1.setBounds(71, 292, 264, 2);
		panel.add(sep1);

		txtApellidos = new JTextField();
		txtApellidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(txtNombre.getText().isEmpty()) {
					txtNombre.setText("Nombre");
					txtNombre.setForeground(new Color(255, 182, 193));
				}

				if(txtDireccion.getText().isEmpty()) {
					txtDireccion.setText("Direccion");
					txtDireccion.setForeground(new Color(255, 182, 193));
				}
				if(txtDni.getText().isEmpty()) {
					txtDni.setText("DNI");
					txtDni.setForeground(new Color(255, 182, 193));
				}
				if(txtNumTelefono.getText().isEmpty()) {
					txtNumTelefono.setText("Num. Telefono");
					txtNumTelefono.setForeground(new Color(255, 182, 193));
				}
				if(txtCodigoPostal.getText().isEmpty()) {
					txtCodigoPostal.setText("Codigo Postal");
					txtCodigoPostal.setForeground(new Color(255, 182, 193));
				}
				if(txtApellidos.getText().equals("Apellidos")) {
					txtApellidos.setText("");
					txtApellidos.setForeground(Color.black);
				}
			}
		});
		txtApellidos.setBackground(new Color(255, 240, 245));
		txtApellidos.setText("Apellidos");
		txtApellidos.setForeground(new Color(255, 182, 193));
		txtApellidos.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtApellidos.setColumns(10);
		txtApellidos.setBorder(null);
		txtApellidos.setBounds(72, 349, 366, 37);
		panel.add(txtApellidos);

		txtDireccion = new JTextField();
		txtDireccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(txtDireccion.getText().equals("Direccion")) {
					txtDireccion.setText("");
					txtDireccion.setForeground(Color.black);
				}
				if(txtNombre.getText().isEmpty()) {
					txtNombre.setText("Nombre");
					txtNombre.setForeground(new Color(255, 182, 193));
				}
				if(txtApellidos.getText().isEmpty()) {
					txtApellidos.setText("Apellidos");
					txtApellidos.setForeground(new Color(255, 182, 193));
				}

				if(txtDni.getText().isEmpty()) {
					txtDni.setText("DNI");
					txtDni.setForeground(new Color(255, 182, 193));
				}
				if(txtNumTelefono.getText().isEmpty()) {
					txtNumTelefono.setText("Num. Telefono");
					txtNumTelefono.setForeground(new Color(255, 182, 193));
				}
				if(txtCodigoPostal.getText().isEmpty()) {
					txtCodigoPostal.setText("Codigo Postal");
					txtCodigoPostal.setForeground(new Color(255, 182, 193));
				}
			}
		});
		txtDireccion.setBackground(new Color(255, 240, 245));
		txtDireccion.setText("Direccion");
		txtDireccion.setForeground(new Color(255, 182, 193));
		txtDireccion.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtDireccion.setColumns(10);
		txtDireccion.setBorder(null);
		txtDireccion.setBounds(72, 449, 318, 37);
		panel.add(txtDireccion);

		JSeparator sep3 = new JSeparator();
		sep3.setForeground(new Color(255, 102, 153));
		sep3.setFont(new Font("Dialog", Font.BOLD, 12));
		sep3.setBounds(72, 386, 366, 2);
		panel.add(sep3);

		JSeparator sep5 = new JSeparator();
		sep5.setForeground(new Color(255, 102, 153));
		sep5.setFont(new Font("Dialog", Font.BOLD, 12));
		sep5.setBounds(72, 486, 318, 2);
		panel.add(sep5);

		txtDni = new JTextField();
		txtDni.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(txtNombre.getText().isEmpty()) {
					txtNombre.setText("Nombre");
					txtNombre.setForeground(new Color(255, 182, 193));
				}
				if(txtApellidos.getText().isEmpty()) {
					txtApellidos.setText("Apellidos");
					txtApellidos.setForeground(new Color(255, 182, 193));
				}
				if(txtDireccion.getText().isEmpty()) {
					txtDireccion.setText("Direccion");
					txtDireccion.setForeground(new Color(255, 182, 193));
				}
				if(txtDni.getText().equals("DNI")) {
					txtDni.setText("");
					txtDni.setForeground(Color.black);
				}
				if(txtNumTelefono.getText().isEmpty()) {
					txtNumTelefono.setText("Num. Telefono");
					txtNumTelefono.setForeground(new Color(255, 182, 193));
				}
				if(txtCodigoPostal.getText().isEmpty()) {
					txtCodigoPostal.setText("Codigo Postal");
					txtCodigoPostal.setForeground(new Color(255, 182, 193));
				}
			}
		});
		txtDni.setBackground(new Color(255, 240, 245));
		txtDni.setText("DNI");
		txtDni.setForeground(new Color(255, 182, 193));
		txtDni.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtDni.setColumns(10);
		txtDni.setBorder(null);
		txtDni.setBounds(520, 253, 227, 37);
		panel.add(txtDni);

		JSeparator sep2 = new JSeparator();
		sep2.setForeground(new Color(255, 102, 153));
		sep2.setFont(new Font("Dialog", Font.BOLD, 12));
		sep2.setBounds(520, 292, 227, 2);
		panel.add(sep2);

		txtNumTelefono = new JTextField();
		txtNumTelefono.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(txtNombre.getText().isEmpty()) {
					txtNombre.setText("Nombre");
					txtNombre.setForeground(new Color(255, 182, 193));
				}
				if(txtApellidos.getText().isEmpty()) {
					txtApellidos.setText("Apellidos");
					txtApellidos.setForeground(new Color(2255, 182, 193));
				}
				if(txtDireccion.getText().isEmpty()) {
					txtDireccion.setText("Direccion");
					txtDireccion.setForeground(new Color(255, 182, 193));
				}
				if(txtDni.getText().isEmpty()) {
					txtDni.setText("DNI");
					txtDireccion.setForeground(new Color(255, 182, 193));
				}

				if(txtNumTelefono.getText().equals("Num. Telefono")) {
					txtNumTelefono.setText("");
					txtNumTelefono.setForeground(Color.black);
				}
				if(txtCodigoPostal.getText().isEmpty()) {
					txtCodigoPostal.setText("Codigo Postal");
					txtCodigoPostal.setForeground(new Color(255, 182, 193));
				}
			}
		});
		txtNumTelefono.setBackground(new Color(255, 240, 245));
		txtNumTelefono.setText("Num. Telefono");
		txtNumTelefono.setForeground(new Color(255, 182, 193));
		txtNumTelefono.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtNumTelefono.setColumns(10);
		txtNumTelefono.setBorder(null);
		txtNumTelefono.setBounds(567, 349, 180, 37);
		panel.add(txtNumTelefono);

		JSeparator sep4 = new JSeparator();
		sep4.setForeground(new Color(255, 102, 153));
		sep4.setFont(new Font("Dialog", Font.BOLD, 12));
		sep4.setBounds(567, 386, 180, 2);
		panel.add(sep4);

		txtCodigoPostal = new JTextField();
		txtCodigoPostal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(txtNombre.getText().isEmpty()) {
					txtNombre.setText("Nombre");
					txtNombre.setForeground(new Color(255, 182, 193));
				}
				if(txtApellidos.getText().isEmpty()) {
					txtApellidos.setText("Apellidos");
					txtApellidos.setForeground(new Color(255, 182, 193));
				}
				if(txtDireccion.getText().isEmpty()) {
					txtDireccion.setText("Direccion");
					txtDireccion.setForeground(new Color(255, 182, 193));
				}
				if(txtDni.getText().isEmpty()) {
					txtDni.setText("DNI");
					txtDireccion.setForeground(new Color(255, 182, 193));
				}
				if(txtNumTelefono.getText().isEmpty()) {
					txtNumTelefono.setText("Num. Telefono");
					txtDireccion.setForeground(new Color(255, 182, 193));
				}
				if(txtCodigoPostal.getText().equals("Codigo Postal")) {
					txtCodigoPostal.setText("");
					txtCodigoPostal.setForeground(Color.black);
				}

			}
		});
		txtCodigoPostal.setBackground(new Color(255, 240, 245));
		txtCodigoPostal.setText("Codigo Postal");
		txtCodigoPostal.setForeground(new Color(255, 182, 193));
		txtCodigoPostal.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtCodigoPostal.setColumns(10);
		txtCodigoPostal.setBorder(null);
		txtCodigoPostal.setBounds(606, 449, 141, 37);
		panel.add(txtCodigoPostal);

		JSeparator sep6 = new JSeparator();
		sep6.setForeground(new Color(255, 102, 153));
		sep6.setFont(new Font("Dialog", Font.BOLD, 12));
		sep6.setBounds(606, 486, 142, 2);
		panel.add(sep6);

		JLabel lblResultado = new JLabel("");
		lblResultado.setBackground(new Color(255, 255, 224));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.BLACK);
		lblResultado.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		lblResultado.setBounds(99, 161, 366, 37);
		panel.add(lblResultado);

		JLabel lblCodigo = new JLabel("");
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setForeground(Color.BLACK);
		lblCodigo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		lblCodigo.setBackground(new Color(255, 255, 224));
		lblCodigo.setBounds(489, 161, 227, 37);
		panel.add(lblCodigo);

		JButton btnAñadir = new JButton("A\u00D1ADIR");
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtNombre.getText().isEmpty() && !txtApellidos.getText().isEmpty() &&
						!txtDireccion.getText().isEmpty() && !txtDni.getText().isEmpty() && 
						!txtCodigoPostal.getText().isEmpty() && !txtNumTelefono.getText().isEmpty()) {
						String codigo;
						codigo=Empresa.anadirCliente(txtDni.getText(),txtNombre.getText(),txtApellidos.getText(),
								Integer.parseInt(txtNumTelefono.getText()),txtDireccion.getText(),Integer.parseInt(txtCodigoPostal.getText()));
						if(codigo.equals("NoCode")) {
							lblResultado.setText("ERROR AL AÑADIR CLIENTE");
						}
						else {
							lblResultado.setText("¡CLIENTE AÑADIDO CON EXITO!");
							lblCodigo.setText("Codigo Cliente: "+codigo);
							txtNombre.setText("");
							txtApellidos.setText("");
							txtNumTelefono.setText("");
							txtDni.setText("");
							txtDireccion.setText("");
							txtCodigoPostal.setText("");
							txtNombre.requestFocus();
						}

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
		btnAñadir.setBounds(345, 564, 142, 42);
		panel.add(btnAñadir);






	}
}
