package Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Milki.Empresa;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FramePedido extends JFrame {


	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table;

	ArrayList<String> productos;
	ArrayList<Double> precios;
	int cantidad=0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				FramePedido frame;
				try {
					frame = new FramePedido();
					frame.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FramePedido() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 643);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		

		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setHorizontalAlignment(SwingConstants.LEFT);
		lblProducto.setOpaque(true);
		lblProducto.setFont(new Font("Verdana", Font.BOLD, 11));
		lblProducto.setBorder(null);
		lblProducto.setBackground(Color.WHITE);
		lblProducto.setBounds(10, 136, 71, 26);
		contentPane.add(lblProducto);

		JLabel lblNewLabel_2_1 = new JLabel("11/11/1111");
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBackground(new Color(255, 204, 255));
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setBounds(551, 24, 87, 26);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setOpaque(true);
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setHorizontalTextPosition(SwingConstants.LEADING);
		lblFecha.setFont(new Font("Verdana", Font.BOLD, 11));
		lblFecha.setBorder(null);
		lblFecha.setBackground(Color.WHITE);
		lblFecha.setBounds(483, 24, 64, 26);
		contentPane.add(lblFecha);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidad.setOpaque(true);
		lblCantidad.setFont(new Font("Verdana", Font.BOLD, 11));
		lblCantidad.setBorder(null);
		lblCantidad.setBackground(Color.WHITE);
		lblCantidad.setBounds(10, 173, 77, 26);
		contentPane.add(lblCantidad);

		JLabel lblNewLabel_2_2 = new JLabel("Num Pedido ");
		lblNewLabel_2_2.setOpaque(true);
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 11));
		lblNewLabel_2_2.setBorder(null);
		lblNewLabel_2_2.setBackground(Color.WHITE);
		lblNewLabel_2_2.setBounds(277, 24, 93, 26);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setBackground(new Color(255, 204, 255));
		lblNewLabel_2_1_1.setOpaque(true);
		lblNewLabel_2_1_1.setBounds(380, 24, 104, 26);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblImporte = new JLabel("Importe :");
		lblImporte.setHorizontalAlignment(SwingConstants.LEFT);
		lblImporte.setOpaque(true);
		lblImporte.setFont(new Font("Verdana", Font.BOLD, 11));
		lblImporte.setBorder(null);
		lblImporte.setBackground(Color.WHITE);
		lblImporte.setBounds(280, 173, 71, 26);
		contentPane.add(lblImporte);

		JLabel lblPrecio = new JLabel("Precio :");
		lblPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecio.setOpaque(true);
		lblPrecio.setFont(new Font("Verdana", Font.BOLD, 11));
		lblPrecio.setBorder(null);
		lblPrecio.setBackground(Color.WHITE);
		lblPrecio.setBounds(291, 136, 64, 26);
		contentPane.add(lblPrecio);

		JLabel lblNewLabel_4_2 = new JLabel("New label");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_4_2.setBackground(new Color(255, 204, 255));
		lblNewLabel_4_2.setOpaque(true);
		lblNewLabel_4_2.setBounds(551, 58, 87, 26);
		contentPane.add(lblNewLabel_4_2);

		JLabel milki_logo = new JLabel("");
		milki_logo.setIcon(new ImageIcon(FramePedido.class.getResource("/imagenes/MILKI-CHITITO.png")));
		milki_logo.setBounds(10, 11, 175, 84);
		contentPane.add(milki_logo);

		JLabel lblSubtotal = new JLabel("SUBTOTAL  ");
		lblSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotal.setOpaque(true);
		lblSubtotal.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSubtotal.setBorder(null);
		lblSubtotal.setBackground(new Color(255, 255, 255));
		lblSubtotal.setBounds(448, 471, 87, 26);
		contentPane.add(lblSubtotal);

		JLabel lblIva = new JLabel("IVA  ");
		lblIva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIva.setOpaque(true);
		lblIva.setFont(new Font("Verdana", Font.BOLD, 12));
		lblIva.setBorder(null);
		lblIva.setBackground(new Color(255, 255, 255));
		lblIva.setBounds(458, 500, 77, 26);
		contentPane.add(lblIva);

		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setOpaque(true);
		lblTotal.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTotal.setBorder(null);
		lblTotal.setBackground(new Color(255, 255, 255));
		lblTotal.setBounds(483, 552, 52, 26);
		contentPane.add(lblTotal);

		JLabel subtotal = new JLabel("0.00 \u20AC");
		subtotal.setHorizontalAlignment(SwingConstants.CENTER);
		subtotal.setHorizontalTextPosition(SwingConstants.LEADING);
		subtotal.setFont(new Font("Verdana", Font.PLAIN, 11));
		subtotal.setOpaque(true);
		subtotal.setBackground(new Color(255, 240, 245));
		subtotal.setBounds(545, 471, 93, 26);
		contentPane.add(subtotal);

		JLabel iva = new JLabel("0.00 \u20AC");
		iva.setHorizontalAlignment(SwingConstants.CENTER);
		iva.setHorizontalTextPosition(SwingConstants.LEADING);
		iva.setFont(new Font("Verdana", Font.PLAIN, 11));
		iva.setOpaque(true);
		iva.setBackground(new Color(255, 240, 245));
		iva.setBounds(545, 501, 93, 26);
		contentPane.add(iva);

		JLabel total = new JLabel("0.00 \u20AC");
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setHorizontalTextPosition(SwingConstants.LEADING);
		total.setFont(new Font("Verdana", Font.PLAIN, 11));
		total.setOpaque(true);
		total.setBackground(new Color(255, 255, 224));
		total.setBounds(545, 553, 93, 26);
		contentPane.add(total);

		JButton btnConfirmar = new JButton("CONFIRMAR PEDIDO");
		btnConfirmar.setFont(new Font("Verdana", Font.BOLD, 15));
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setBorder(null);
		btnConfirmar.setBackground(new Color(255, 153, 153));
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setBounds(65, 489, 193, 46);
		contentPane.add(btnConfirmar);

		JButton btnAgregar = new JButton("+");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAgregar.setBackground(new Color(54, 220, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAgregar.setBackground(new Color(51, 204, 153));
			}
		});
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setBorder(null);
		btnAgregar.setBackground(new Color(51, 204, 153));
		btnAgregar.setFont(new Font("Verdana", Font.BOLD, 30));
		btnAgregar.setBounds(508, 136, 52, 46);
		contentPane.add(btnAgregar);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(103, 139, 155, 22);
		contentPane.add(comboBox);

		JLabel lblPrecio2 = new JLabel("0.00 \u20AC");
		lblPrecio2.setOpaque(true);
		lblPrecio2.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecio2.setFont(new Font("Verdana", Font.BOLD, 11));
		lblPrecio2.setBorder(null);
		lblPrecio2.setBackground(Color.WHITE);
		lblPrecio2.setBounds(385, 136, 77, 26);
		contentPane.add(lblPrecio2);

		JLabel lblImporte2 = new JLabel("0.00 \u20AC");
		lblImporte2.setOpaque(true);
		lblImporte2.setHorizontalAlignment(SwingConstants.LEFT);
		lblImporte2.setFont(new Font("Verdana", Font.BOLD, 11));
		lblImporte2.setBorder(null);
		lblImporte2.setBackground(Color.WHITE);
		lblImporte2.setBounds(385, 173, 77, 26);
		contentPane.add(lblImporte2);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(103, 174, 64, 26);
		contentPane.add(spinner);

		table = new JTable();
		table.setBackground(new Color(255, 255, 224));
		table.setBounds(10, 222, 628, 227);
		contentPane.add(table);
		
		generarListaProd();
		DefaultComboBoxModel ComboModel=new DefaultComboBoxModel(solve(productos));
		comboBox.setModel(ComboModel);



	}
	public void generarListaProd() throws SQLException {
		Empresa.conectar("milki", "milki");
		if(Empresa.conectar("milki", "milki")==true) {
			ResultSet rs=null;
			Statement st=Empresa.connection.createStatement();
			String prod;
			double precio;

			try {
				rs = st.executeQuery("select nombre from producto");
				do {
					prod=rs.getString("nombre");
					productos.add(prod);
				}while (rs.next());
				rs = st.executeQuery("select precio_venta from producto");
				do {
					precio=rs.getDouble("precio_venta");
					precios.add(0.0);
					precios.add(precio);
				}while (rs.next());

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"ERROR ENCONTRANDO PRODUCTOS", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		};

	}

	public String[]  solve(ArrayList<String> nums){
		String[] arr=new String[nums.size()];
		for(int i=0;i<nums.size();i++) {
			arr[i]=nums.get(i);  
		}
		return arr;
	}
}
