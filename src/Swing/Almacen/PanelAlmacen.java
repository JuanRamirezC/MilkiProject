package Swing.Almacen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelAlmacen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelAlmacen() {

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
		lblNewLabel.setBounds(228, 28, 363, 51);
		cabecera.add(lblNewLabel);
		
		JButton btnAñadir = new JButton("A\u00D1ADIR PRODUCTO");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
				PanelAñadirProducto p1 =new PanelAñadirProducto();
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
		
		JButton btnEliminar = new JButton("A\u00D1ADIR EXISTENCIAS");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEliminar.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEliminar.setBackground(new Color(255, 228, 225));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelAñadirExistencias p1 =new PanelAñadirExistencias();
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
		
		JButton btnEliminarExistencias = new JButton("RESTABLECER EXISTENCIAS");
		btnEliminarExistencias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEliminarExistencias.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEliminarExistencias.setBackground(new Color(255, 228, 225));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelRestablecerExistencias p1 =new PanelRestablecerExistencias();
				p1.setSize(814,711);
				p1.setLocation(0,0);
				
				panel.removeAll();
				panel.setLayout(null);
				panel.add(p1);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnEliminarExistencias.setFont(new Font("Verdana", Font.BOLD, 15));
		btnEliminarExistencias.setFocusPainted(false);
		btnEliminarExistencias.setBorderPainted(false);
		btnEliminarExistencias.setBorder(null);
		btnEliminarExistencias.setBackground(new Color(255, 228, 225));
		btnEliminarExistencias.setBounds(157, 411, 520, 62);
		panel.add(btnEliminarExistencias);
		
		JButton btnModificar = new JButton("ELIMINAR PRODUCTO");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificar.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnModificar.setBackground(new Color(255, 228, 225));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelEliminarProducto p1 =new PanelEliminarProducto();
				p1.setSize(814,711);
				p1.setLocation(0,0);
				
				panel.removeAll();
				panel.setLayout(null);
				panel.add(p1);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnModificar.setFont(new Font("Verdana", Font.BOLD, 15));
		btnModificar.setFocusPainted(false);
		btnModificar.setBorderPainted(false);
		btnModificar.setBorder(null);
		btnModificar.setBackground(new Color(255, 228, 225));
		btnModificar.setBounds(157, 500, 520, 62);
		panel.add(btnModificar);
		

	}


}
