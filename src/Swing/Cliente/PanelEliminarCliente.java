package Swing.Cliente;

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

import Milki.Empresa;

public class PanelEliminarCliente extends JPanel {
	
	private JTextField txtNombre;
	/**
	 * Create the panel.
	 */
	public PanelEliminarCliente() {

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 818, 711);
		add(panel);
		panel.setLayout(null);
		
		        JSeparator sep1 = new JSeparator();
		        sep1.setFont(new Font("Dialog", Font.BOLD, 12));
		        sep1.setForeground(new Color(255, 102, 153));
		        sep1.setBounds(267, 409, 264, 2);
		        panel.add(sep1);

		JPanel cabecera = new JPanel();
		cabecera.setBackground(new Color(255, 153, 153));
		cabecera.setBounds(0, 0, 814, 115);
		panel.add(cabecera);
		cabecera.setLayout(null);

		JLabel lblCabecera = new JLabel("BAJA CLIENTE");
		lblCabecera.setFont(new Font("Verdana", Font.BOLD, 30));
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabecera.setForeground(Color.WHITE);
		lblCabecera.setBounds(227, 28, 363, 51);
		cabecera.add(lblCabecera);
		
		JLabel lblResultado = new JLabel();
		lblResultado.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
        lblResultado.setBounds(210, 481, 398, 71);
        panel.add(lblResultado);
        

		JButton btnBaja = new JButton("DAR DE BAJA");
	
		btnBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBaja.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBaja.setBackground(new Color(255, 228, 225));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String codigo;
				codigo=txtNombre.getText();
				if(Empresa.borrarPersona(codigo)==true) {
					lblResultado.setText("¡CLIENTE DADO DE BAJA CON EXITO!");
				}
				else {
					lblResultado.setText("¡CLIENTE DADO DE BAJA CON EXITO!");
				}
				
				txtNombre.setFont(new Font("Verdana", Font.ITALIC, 18));
				txtNombre.setText("Codigo Cliente");
				txtNombre.setForeground(new Color(255, 182, 193));
			
			}
		});
		btnBaja.setFont(new Font("Verdana", Font.BOLD, 15));
		btnBaja.setFocusPainted(false);
		btnBaja.setBorder(null);
		btnBaja.setBackground(new Color(255, 228, 225));
		btnBaja.setBounds(143, 608, 520, 62);
		panel.add(btnBaja);

		txtNombre = new JTextField();
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtNombre.getText().equals("Codigo Cliente")) {
					txtNombre.setText("");
					txtNombre.setForeground(Color.black);
				}
				
			}
		});
        txtNombre.setBackground(new Color(255, 240, 245));
        txtNombre.setFont(new Font("Verdana", Font.ITALIC, 18));
        txtNombre.setText("Codigo Cliente");
        txtNombre.setForeground(new Color(255, 182, 193));
        txtNombre.setBorder(null);
        txtNombre.setBounds(267, 373, 263, 37);
        panel.add(txtNombre);
        txtNombre.setColumns(10);
        
        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(PanelEliminarCliente.class.getResource("/imagenes/Milki-Triste.png")));
        lblLogo.setBounds(311, 199, 163, 163);
        panel.add(lblLogo);
        
      
	}
}
