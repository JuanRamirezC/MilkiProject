package Swing;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Inicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel FondoInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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

	public Inicio() {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setLocationRelativeTo(null);

		
		FondoInicio = new JPanel();
		FondoInicio.setBackground(new Color(255, 204, 204));
		FondoInicio.setForeground(new Color(255, 255, 255));
		FondoInicio.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(FondoInicio);
		FondoInicio.setLayout(null);

		JLabel MilkiLogo = new JLabel("");
		MilkiLogo.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/MILKI-LOGO-SINFONDO.png")));
		MilkiLogo.setBounds(150, 43, 481, 277);
		FondoInicio.add(MilkiLogo);

		JButton botonIniciar = new JButton("INICIAR");
		botonIniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonIniciar.setBounds(340, 350, 142, 42);
		botonIniciar.setFocusPainted(false);
		botonIniciar.setBorderPainted(false);
		botonIniciar.setBorder(null);
		botonIniciar.setForeground(new Color(255, 255, 255));
		botonIniciar.setBackground(new Color(255, 153, 153));
		botonIniciar.setFont(new Font("Sitka Text", Font.BOLD, 20));
		botonIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonIniciar.setBackground(new Color(255, 130, 130));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonIniciar.setBackground(new Color(255, 153, 153));
			}
		});
		
		botonIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login newFrame=new Login();
				newFrame.setVisible(true);
				dispose();
			}
		});
		
		FondoInicio.add(botonIniciar);
		
		
		
		
	}

}
