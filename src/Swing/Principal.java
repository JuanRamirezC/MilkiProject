package Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 750);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel barra = new JPanel();
		barra.setBackground(new Color(255, 204, 204));
		barra.setBounds(0, 0, 220, 711);
		contentPane.add(barra);
		barra.setLayout(null);
		
		JPanel contenido = new JPanel();
		contenido.setBackground(new Color(255, 255, 255));
		contenido.setBounds(220, 0, 814, 711);
		contentPane.add(contenido);
		contenido.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/MILKI-LOGO-SINFONDO.png")));
		lblNewLabel.setBounds(157, 183, 509, 269);
		contenido.add(lblNewLabel);
		
		JButton btnClientes = new JButton("CLIENTES");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelClientes p1 =new PanelClientes();
				p1.setSize(814,711);
				p1.setLocation(0,0);
				
				contenido.removeAll();
				contenido.setLayout(null);
				contenido.add(p1);
				contenido.revalidate();
				contenido.repaint();
			}
		});
		btnClientes.setFocusPainted(false);
		btnClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClientes.setBackground(new Color(255, 153, 153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClientes.setBackground(new Color(255, 204, 204));
			}
		});
		btnClientes.setForeground(new Color(255, 255, 255));
		btnClientes.setFont(new Font("Verdana", Font.BOLD, 15));
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setBorder(null);
		btnClientes.setBackground(new Color(255, 204, 204));
		btnClientes.setBounds(0, 128, 220, 85);
		barra.add(btnClientes);
		
		JButton btnProv = new JButton("PROVEEDORES");
		btnProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelProveedores p1 =new PanelProveedores();
				p1.setSize(814,711);
				p1.setLocation(0,0);
				
				contenido.removeAll();
				contenido.setLayout(null);
				contenido.add(p1);
				contenido.revalidate();
				contenido.repaint();
			}
		});
		btnProv.setFocusPainted(false);
		btnProv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnProv.setBackground(new Color(255, 153, 153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnProv.setBackground(new Color(255, 204, 204));
			}
		});
		btnProv.setForeground(new Color(255, 255, 255));
		btnProv.setFont(new Font("Verdana", Font.BOLD, 15));
		btnProv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProv.setBorder(null);
		btnProv.setBackground(new Color(255, 204, 204));
		btnProv.setBounds(0, 213, 220, 85);
		barra.add(btnProv);
		
		JButton btnPedidos = new JButton("PEDIDOS");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPedidos p1 =new PanelPedidos();
				p1.setSize(814,711);
				p1.setLocation(0,0);
				
				contenido.removeAll();
				contenido.setLayout(null);
				contenido.add(p1);
				contenido.revalidate();
				contenido.repaint();
			}
		});
		btnPedidos.setFocusPainted(false);
		btnPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPedidos.setBackground(new Color(255, 153, 153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPedidos.setBackground(new Color(255, 204, 204));
			}
		});
		btnPedidos.setForeground(new Color(255, 255, 255));
		btnPedidos.setFont(new Font("Verdana", Font.BOLD, 15));
		btnPedidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPedidos.setBorder(null);
		btnPedidos.setBackground(new Color(255, 204, 204));
		btnPedidos.setBounds(0, 298, 220, 85);
		barra.add(btnPedidos);
		
		JButton btnAlmacen = new JButton("ALMACEN");
		btnAlmacen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelAlmacen p1 =new PanelAlmacen();
				p1.setSize(814,711);
				p1.setLocation(0,0);
				
				contenido.removeAll();
				contenido.setLayout(null);
				contenido.add(p1);
				contenido.revalidate();
				contenido.repaint();
			}
		});
		btnAlmacen.setFocusPainted(false);
		btnAlmacen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAlmacen.setBackground(new Color(255, 153, 153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAlmacen.setBackground(new Color(255, 204, 204));
			}
			
		});
		btnAlmacen.setForeground(new Color(255, 255, 255));
		btnAlmacen.setFont(new Font("Verdana", Font.BOLD, 15));
		btnAlmacen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlmacen.setBorder(null);
		btnAlmacen.setBackground(new Color(255, 204, 204));
		btnAlmacen.setBounds(0, 385, 220, 85);
		barra.add(btnAlmacen);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/milki_logopeque\u00F1o-removebg-preview.png")));
		lblNewLabel_1.setBounds(33, 11, 156, 170);
		barra.add(lblNewLabel_1);
		
		
		
	}
}
