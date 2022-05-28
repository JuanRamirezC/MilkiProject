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

public class PanelEliminarProv extends JPanel {
	
	private JTextField txtNombre;
	/**
	 * Create the panel.
	 */
	public PanelEliminarProv() {

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 818, 711);
		add(panel);
		panel.setLayout(null);

		JPanel cabecera = new JPanel();
		cabecera.setBackground(new Color(255, 153, 153));
		cabecera.setBounds(0, 0, 814, 115);
		panel.add(cabecera);
		cabecera.setLayout(null);

		JLabel lblCabecera = new JLabel("ELIMINAR PROVEEDOR");
		lblCabecera.setFont(new Font("Verdana", Font.BOLD, 30));
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabecera.setForeground(Color.WHITE);
		lblCabecera.setBounds(227, 28, 410, 51);
		cabecera.add(lblCabecera);
		
		JLabel lblResultado = new JLabel();
		lblResultado.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
        lblResultado.setBounds(248, 481, 306, 71);
        panel.add(lblResultado);
        

		JButton btnCrear = new JButton("ELIMINAR");
	
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
				lblResultado.setText("¡CLIENTE DADO DE BAJA CON EXITO!");
			
			}
		});
		btnCrear.setFont(new Font("Verdana", Font.BOLD, 15));
		btnCrear.setFocusPainted(false);
		btnCrear.setBorder(null);
		btnCrear.setBackground(new Color(255, 228, 225));
		btnCrear.setBounds(143, 608, 520, 62);
		panel.add(btnCrear);

		txtNombre = new JTextField();
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtNombre.getText().equals("Codigo Cliente/Proveedor")) {
					txtNombre.setText("");
					txtNombre.setForeground(Color.black);
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
        txtNombre.setColumns(10);

        JSeparator sep1 = new JSeparator();
        sep1.setFont(new Font("Dialog", Font.BOLD, 12));
        sep1.setForeground(new Color(255, 102, 153));
        sep1.setBounds(266, 418, 264, 2);
        panel.add(sep1);
        
        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(PanelAltaPedido.class.getResource("/imagenes/PAQUETE.PNG.png")));
        lblLogo.setBounds(312, 126, 163, 236);
        panel.add(lblLogo);
        
      
	}

}
