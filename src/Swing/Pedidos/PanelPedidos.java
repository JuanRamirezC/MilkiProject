package Swing.Pedidos;

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
import javax.swing.ImageIcon;

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

		JButton btnA�adir = new JButton("CREAR PEDIDO");
		btnA�adir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
				PanelCrearPedido p1= new PanelCrearPedido();
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
		btnA�adir.setBounds(157, 156, 520, 62);
		panel.add(btnA�adir);

		JButton btnElim = new JButton("CANCELAR PEDIDO");
		btnElim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnElim.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnElim.setBackground(new Color(255, 228, 225));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelEliminarPedido p1= new PanelEliminarPedido();
				p1.setSize(814,711);
				p1.setLocation(0,0);

				panel.removeAll();
				panel.setLayout(null);
				panel.add(p1);
				panel.revalidate();
				panel.repaint();
			}
			
		});
		btnElim.setFont(new Font("Verdana", Font.BOLD, 15));
		btnElim.setFocusPainted(false);
		btnElim.setBorderPainted(false);
		btnElim.setBorder(null);
		btnElim.setBackground(new Color(255, 228, 225));
		btnElim.setBounds(157, 520, 520, 62);
		panel.add(btnElim);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(PanelPedidos.class.getResource("/imagenes/PAQUETE.PNG.png")));
		lblLogo.setBounds(333, 248, 163, 236);
		panel.add(lblLogo);


	}

}
