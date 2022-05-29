package Swing.Proveedor;

import java.awt.Color;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import Milki.Empresa;
import Swing.Cliente.PanelMostrarCliente;
import javax.swing.JScrollBar;

public class PanelMostrarProv extends JPanel {
	private JTextField txtNombre;
	private JTextField textRes;
	/**
	 * Create the panel.
	 */
	public PanelMostrarProv() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 818, 711);
		add(panel);
		panel.setLayout(null);

		JSeparator sep1 = new JSeparator();
		sep1.setFont(new Font("Dialog", Font.BOLD, 12));
		sep1.setForeground(new Color(255, 102, 153));
		sep1.setBounds(271, 354, 264, 2);
		panel.add(sep1);

		JPanel cabecera = new JPanel();
		cabecera.setBackground(new Color(255, 153, 153));
		cabecera.setBounds(0, 0, 814, 115);
		panel.add(cabecera);
		cabecera.setLayout(null);

		JLabel lblCabecera = new JLabel("DATOS PROVEEDOR");
		lblCabecera.setFont(new Font("Verdana", Font.BOLD, 30));
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabecera.setForeground(Color.WHITE);
		lblCabecera.setBounds(227, 28, 363, 51);
		cabecera.add(lblCabecera);

		JButton btnBuscar = new JButton("BUSCAR");

		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setBackground(new Color(255, 228, 225));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (txtNombre.getText().equals("Codigo Proveedor")) {
					txtNombre.setText("");
					txtNombre.setForeground(Color.black);
				}
				String codigo=txtNombre.getText();
				
					textRes.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
					textRes.setText(Empresa.mostrarPersona(codigo));
				

				txtNombre.setFont(new Font("Verdana", Font.ITALIC, 18));
				txtNombre.setText("Codigo Proveedor");
				txtNombre.setForeground(new Color(255, 182, 193));
				
			}
		});
		btnBuscar.setFont(new Font("Verdana", Font.BOLD, 15));
		btnBuscar.setFocusPainted(false);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(new Color(255, 228, 225));
		btnBuscar.setBounds(143, 608, 520, 62);
		panel.add(btnBuscar);

		txtNombre = new JTextField();
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(txtNombre.getText().equals("Codigo Proveedor")) {
				txtNombre.setText("");
				txtNombre.setForeground(Color.black);
			}
			}
		});
		
		txtNombre.setBackground(new Color(255, 240, 245));
		txtNombre.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtNombre.setText("Codigo Proveedor");
		txtNombre.setForeground(new Color(255, 182, 193));
		txtNombre.setBorder(null);
		txtNombre.setBounds(271, 319, 263, 37);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(PanelMostrarCliente.class.getResource("/imagenes/Buscar.png")));
		lblLogo.setBounds(306, 144, 179, 155);
		panel.add(lblLogo);
				
				JScrollBar scrollBar = new JScrollBar();
				scrollBar.setBounds(754, 398, 17, 160);
				panel.add(scrollBar);
				
				textRes = new JTextField();
				textRes.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
				textRes.setColumns(10);
				textRes.setCaretColor(new Color(255, 204, 255));
				textRes.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 204, 255), null, new Color(255, 102, 204), null));
				textRes.setBounds(40, 398, 731, 160);
				panel.add(textRes);
				textRes.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 204, 255), null, new Color(255, 102, 204), null));
				textRes.setCaretColor(new Color(255, 204, 255));
				textRes.setColumns(10);




	}
}
