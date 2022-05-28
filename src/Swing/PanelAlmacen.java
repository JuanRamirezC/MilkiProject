package Swing;

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
		
		JButton btnA�adir = new JButton("A\u00D1ADIR PRODUCTO");
		btnA�adir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnA�adir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnA�adir.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnA�adir.setBackground(new Color(255, 228, 225));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelAnhadirC p1 =new PanelAnhadirC();
				p1.setSize(814,711);
				p1.setLocation(0,0);
				
				panel.removeAll();
				panel.setLayout(null);
				panel.add(p1);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnA�adir.setFont(new Font("Verdana", Font.BOLD, 15));
		btnA�adir.setFocusPainted(false);
		btnA�adir.setBorder(null);
		btnA�adir.setBackground(new Color(255, 228, 225));
		btnA�adir.setBounds(157, 226, 520, 62);
		panel.add(btnA�adir);
		
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
		});
		btnEliminar.setFont(new Font("Verdana", Font.BOLD, 15));
		btnEliminar.setFocusPainted(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(255, 228, 225));
		btnEliminar.setBounds(157, 319, 520, 62);
		panel.add(btnEliminar);
		
		JButton btnConsultar = new JButton("VER PRODUCTOS");
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
