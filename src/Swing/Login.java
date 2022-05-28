package Swing;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Milki.Empresa;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 503);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(211, 11, 377, 427);
		contentPane.add(panel);
		panel.setLayout(null);

		JSeparator sep2 = new JSeparator();
		sep2.setForeground(new Color(255, 153, 153));
		sep2.setFont(new Font("Dialog", Font.PLAIN, 15));
		sep2.setBounds(87, 324, 218, 5);
		panel.add(sep2);

		JSeparator sep1 = new JSeparator();
		sep1.setFont(new Font("Dialog", Font.PLAIN, 15));
		sep1.setForeground(new Color(255, 153, 153));
		sep1.setBounds(87, 243, 218, 5);
		panel.add(sep1);

		name = new JTextField();
		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(name.getText().equals("NOMBRE DE USUARIO")) {
					name.setText("");
					name.setForeground(Color.black);
				}
				if(String.valueOf(password.getPassword()).isEmpty()) {
					password.setText("*********");
					password.setForeground(new Color(255, 130, 130));
				}

			}
		});
		name.setBorder(null);
		name.setDisabledTextColor(new Color(255, 255, 255));
		name.setSelectionColor(new Color(255, 204, 255));
		name.setFont(new Font("Tahoma", Font.ITALIC, 12));
		name.setBounds(87, 206, 218, 32);
		panel.add(name);
		name.setForeground(new Color(255, 153, 153));
		name.setText("NOMBRE DE USUARIO");
		name.setColumns(10);



		password = new JPasswordField();
		password.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(String.valueOf(password.getPassword()).equals("*********")) {
					password.setText("");
					password.setForeground(Color.black);
				}
				if(name.getText().isEmpty()) {
					name.setText("NOMBRE DE USUARIO");
					name.setForeground(new Color(255, 130, 130));
				}

			}
		});
		password.setFont(new Font("Tahoma", Font.ITALIC, 12));
		password.setText("*********");
		password.setBorder(null);
		password.setSelectionColor(new Color(255, 204, 255));
		password.setBackground(new Color(255, 255, 255));
		password.setBounds(87, 287, 218, 32);
		panel.add(password);
		password.setEchoChar('*');
		password.setForeground(new Color(255, 153, 153));



		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresar.setBackground(new Color(255, 130, 130));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresar.setBackground(new Color(255, 153, 153));
			}
		});
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] clave= password.getPassword();
				String claveFinal =new String(clave);


				if(Empresa.conectar(name.getText(), claveFinal)) {
					dispose();
					JOptionPane.showMessageDialog(null, "INICIO DE SESION CORRECTO","BIENVENIDO",
							JOptionPane.PLAIN_MESSAGE);
					Principal p =new Principal();
					p.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"DATOS INCORRECTOS", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					name.setText("");
					password.setText("");
					name.requestFocus();
				}
			}
		});
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setBounds(122, 348, 142, 42);
		btnIngresar.setFocusPainted(false);
		btnIngresar.setBorderPainted(false);
		btnIngresar.setBorder(null);
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new Color(255, 153, 153));
		btnIngresar.setFont(new Font("Sitka Text", Font.BOLD, 20));
		panel.add(btnIngresar);
		JLabel logo_milki = new JLabel("");
		logo_milki.setIcon(new ImageIcon(Login.class.getResource("/imagenes/milki_logopeque\u00F1o.png")));
		logo_milki.setBounds(107, 11, 157, 157);
		panel.add(logo_milki);

		
	}
}
