package Swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class PanelPedidos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelPedidos() {

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
		lblNewLabel.setBounds(227, 28, 363, 51);
		cabecera.add(lblNewLabel);

		JButton btnAñadir = new JButton("CREAR PEDIDO");
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
				PanelAltaPedido p1= new PanelAltaPedido();
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

		JButton btnMod = new JButton("MODIFICAR PEDIDO");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMod.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMod.setBackground(new Color(255, 228, 225));
			}
			public void mouseClicked(MouseEvent e) {
				PanelModificarPed p2= new PanelModificarPed();
				p2.setSize(814,711);
				p2.setLocation(0,0);

				panel.removeAll();
				panel.setLayout(null);
				panel.add(p2);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnMod.setFont(new Font("Verdana", Font.BOLD, 15));
		btnMod.setFocusPainted(false);
		btnMod.setBorderPainted(false);
		btnMod.setBorder(null);
		btnMod.setBackground(new Color(255, 228, 225));
		btnMod.setBounds(157, 409, 520, 62);
		panel.add(btnMod);

		JButton btnConsultar = new JButton("VER PEDIDOS");
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
		btnConsultar.setBounds(157, 505, 520, 62);
		panel.add(btnConsultar);

		JButton btnElim = new JButton("ELIMINAR PEDIDO");
		btnElim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnElim.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnElim.setBackground(new Color(255, 228, 225));
			}
		});
		btnElim.setFont(new Font("Verdana", Font.BOLD, 15));
		btnElim.setFocusPainted(false);
		btnElim.setBorderPainted(false);
		btnElim.setBorder(null);
		btnElim.setBackground(new Color(255, 228, 225));
		btnElim.setBounds(157, 314, 520, 62);
		panel.add(btnElim);


	}

}
