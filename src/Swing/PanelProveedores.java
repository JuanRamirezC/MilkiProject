package Swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelProveedores extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelProveedores() {
		

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
		
		JLabel lblNewLabel = new JLabel("ELIJA UNA OPCION");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(220, 28, 363, 51);
		cabecera.add(lblNewLabel);
		
		JButton btnAñadir = new JButton("A\u00D1ADIR PROVEEDOR");
		btnAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAñadir.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAñadir.setBackground(new Color(255, 228, 225));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelAnhadirP p1 =new PanelAnhadirP();
				p1.setSize(814,711);
				p1.setLocation(0,0);
				
				panel.removeAll();
				panel.setLayout(null);
				panel.add(p1);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnAñadir.setFont(new Font("Verdana", Font.BOLD, 15));
		btnAñadir.setFocusPainted(false);
		btnAñadir.setBorder(null);
		btnAñadir.setBackground(new Color(255, 228, 225));
		btnAñadir.setBounds(157, 226, 520, 62);
		panel.add(btnAñadir);
		
		JButton btnEliminar = new JButton("ELIMINAR PROVEEDOR");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEliminar.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEliminar.setBackground(new Color(255, 228, 225));
			}
			
			public void mouseClicked(MouseEvent e) {
				PanelEliminarProv p1 =new PanelEliminarProv();
				p1.setSize(814,711);
				p1.setLocation(0,0);
				
				panel.removeAll();
				panel.setLayout(null);
				panel.add(p1);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnEliminar.setFont(new Font("Verdana", Font.BOLD, 15));
		btnEliminar.setFocusPainted(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(255, 228, 225));
		btnEliminar.setBounds(157, 319, 520, 62);
		panel.add(btnEliminar);
		
		JButton btnConsultar = new JButton("CONSULTAR DATOS PROVEEDOR");
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultar.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultar.setBackground(new Color(255, 228, 225));
			}
		});
		btnConsultar.setFont(new Font("Verdana", Font.BOLD, 15));
		btnConsultar.setFocusPainted(false);
		btnConsultar.setBorderPainted(false);
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(new Color(255, 228, 225));
		btnConsultar.setBounds(157, 411, 520, 62);
		panel.add(btnConsultar);
		

	}

}
