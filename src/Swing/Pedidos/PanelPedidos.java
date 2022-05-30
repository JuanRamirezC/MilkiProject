package Swing.Pedidos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class PanelPedidos extends JPanel {

	private static final long serialVersionUID = 1L;


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
		btnAñadir.setFont(new Font("Verdana", Font.BOLD, 15));
		btnAñadir.setFocusPainted(false);
		btnAñadir.setBorder(null);
		btnAñadir.setBackground(new Color(255, 228, 225));
		btnAñadir.setBounds(157, 156, 520, 62);
		panel.add(btnAñadir);

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
		btnElim.setBounds(157, 591, 520, 62);
		panel.add(btnElim);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(PanelPedidos.class.getResource("/imagenes/PAQUETE.PNG.png")));
		lblLogo.setBounds(333, 319, 163, 236);
		panel.add(lblLogo);
		
		JButton btnFinalizarPedido = new JButton("FINALIZAR PEDIDO");
		btnFinalizarPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFinalizarPedido.setBackground(new Color(255, 215, 210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFinalizarPedido.setBackground(new Color(255, 228, 225));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelFinalizarPedido p1= new PanelFinalizarPedido();
				p1.setSize(814,711);
				p1.setLocation(0,0);

				panel.removeAll();
				panel.setLayout(null);
				panel.add(p1);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnFinalizarPedido.setFont(new Font("Verdana", Font.BOLD, 15));
		btnFinalizarPedido.setFocusPainted(false);
		btnFinalizarPedido.setBorder(null);
		btnFinalizarPedido.setBackground(new Color(255, 228, 225));
		btnFinalizarPedido.setBounds(157, 257, 520, 62);
		panel.add(btnFinalizarPedido);


	}
}
