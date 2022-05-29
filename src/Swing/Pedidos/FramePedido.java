package Swing.Pedidos;

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
import java.util.List;

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
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class FramePedido extends JFrame {


	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table;
	private String per=PanelCrearPedido.codpers; 
	DefaultTableModel modelo=new DefaultTableModel();
	private String[] prod_peds = new String[5];
	private static double preciov;
	private int numero=PanelCrearPedido.num;

	private static int cantidad;

	private double subTotal = 0;

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


		setResizable(false);
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

		JLabel lbldate = new JLabel("11/11/1111");
		lbldate.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbldate.setHorizontalAlignment(SwingConstants.CENTER);
		lbldate.setBackground(new Color(255, 204, 255));
		lbldate.setOpaque(true);
		lbldate.setBounds(551, 24, 87, 26);
		contentPane.add(lbldate);

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

		JLabel lblNumPedido = new JLabel("New label");
		lblNumPedido.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNumPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPedido.setBackground(new Color(255, 204, 255));
		lblNumPedido.setOpaque(true);
		lblNumPedido.setBounds(380, 24, 104, 26);
		contentPane.add(lblNumPedido);

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

		JLabel lblPersona = new JLabel("New label");
		lblPersona.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersona.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblPersona.setBackground(new Color(255, 204, 255));
		lblPersona.setOpaque(true);
		lblPersona.setBounds(551, 58, 87, 26);
		contentPane.add(lblPersona);
		lblPersona.setText(per);

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
		btnConfirmar.setFocusPainted(false);
		btnConfirmar.setFocusable(false);
		btnConfirmar.setFont(new Font("Verdana", Font.BOLD, 15));
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setBorder(null);
		btnConfirmar.setBackground(new Color(255, 153, 153));
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setBounds(10, 532, 193, 46);
		contentPane.add(btnConfirmar);



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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 153, 153));
		scrollPane.setBounds(10, 222, 628, 227);
		contentPane.add(scrollPane);



		table = new JTable();
		table.setUpdateSelectionOnSort(false);
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setSelectionBackground(new Color(255, 255, 153));
		table.setIntercellSpacing(new Dimension(10, 5));
		table.setGridColor(new Color(255, 204, 255));
		table.setBackground(new Color(255, 255, 224));


		JLabel lblresultado = new JLabel("");
		lblresultado.setOpaque(true);
		lblresultado.setHorizontalTextPosition(SwingConstants.LEADING);
		lblresultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblresultado.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblresultado.setBackground(Color.WHITE);
		lblresultado.setBounds(85, 471, 304, 46);
		contentPane.add(lblresultado);

		JSpinner spinner = new JSpinner();

		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(null);
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 10));
		comboBox.setBackground(new Color(255, 255, 224));
		comboBox.setBounds(103, 139, 155, 22);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularPrecio(comboBox,per,spinner,lblPrecio2,lblImporte2);
			}
		});


		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calcularPrecio(comboBox,per,spinner,lblPrecio2,lblImporte2);
			}
		});
		spinner.setModel(new SpinnerNumberModel(1, 1, 9999, 1));
		spinner.setBackground(new Color(255, 255, 224));
		spinner.setFont(new Font("Verdana", Font.PLAIN, 11));
		spinner.setBounds(103, 174, 64, 26);
		contentPane.add(spinner);

		JButton btnAgregar = new JButton("+");
		btnAgregar.setFocusable(false);
		btnAgregar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAgregar.setBackground(new Color(54, 220, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAgregar.setBackground(new Color(51, 204, 153));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombreProd=comboBox.getSelectedItem().toString();
				String[]codigos=nombreProd.split("-");
				String codigo=codigos[0];
				String nombreP=codigos[1];
				prod_peds[0]=codigo;
				prod_peds[1]=nombreP;
				prod_peds[2]=String.valueOf(cantidad) ;
				prod_peds[3]=String.valueOf(preciov+" €") ;
				prod_peds[4]=String.valueOf((preciov*cantidad)+" €");
				actualizarTabla();
				try {
					calcularTotal(subtotal,total,iva);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				Empresa.anhadirProducto_Pedido(numero, Integer.parseInt(codigo), cantidad);
				
			}
		});
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setBorder(null);
		btnAgregar.setBackground(new Color(51, 204, 153));
		btnAgregar.setFont(new Font("Verdana", Font.BOLD, 30));
		btnAgregar.setBounds(508, 136, 52, 46);
		contentPane.add(btnAgregar);


		lblNumPedido.setText(String.valueOf(PanelCrearPedido.num));
		generarListaProd(comboBox);


		modelo.addColumn("CODIGO PRODUCTO");
		modelo.addColumn("NOMBRE PRODUCTO");
		modelo.addColumn("CANTIDAD");
		modelo.addColumn("PRECIO UNIT");
		modelo.addColumn("IMPORTE");
		calcularPrecio(comboBox,per,spinner,lblPrecio2,lblImporte2);
		calcularTotal(subtotal,total,iva);
	}

	public void borrarVenta() {
		preciov=0;
		cantidad=0;
	}

	public void actualizarTabla() {
		modelo.addRow(prod_peds);
		table.setModel(modelo);
	}

	
	public void calcularTotal(JLabel subtotal, JLabel total, JLabel iva) throws SQLException {
		double importe;
		Statement st = Empresa.connection.createStatement();
		ResultSet rs;
		
		rs = st.executeQuery(
				"select importe_total from pedido where num_pedido="+numero);
		if (rs.next()) {
			importe=rs.getDouble("importe_total");
			subtotal.setText(String.valueOf(importe+" €"));
			iva.setText("--");
			total.setText(String.valueOf(importe+" €"));
		}
		
//		Empresa.calcularImporte();
	}
	//Allison
	@SuppressWarnings("rawtypes")
	public static void calcularPrecio(JComboBox cbox, String cod, JSpinner spinner, JLabel precio, JLabel importe ) {

		if(Empresa.conectar("milki", "milki")==true) {

			String nombreProd;
			String codigo;
			String substr="CL";
			nombreProd=cbox.getSelectedItem().toString();
			String[]codigos=nombreProd.split("-");
			codigo=codigos[0];
			Integer.parseInt(codigo);
			try {
				if(cod.contains(substr)) {
					Statement st = Empresa.connection.createStatement();
					ResultSet rs;

					rs = st.executeQuery(
							"select precio_venta from producto where codigo_prod='"
									+ codigo+ "'");

					if (rs.next()) {
						preciov=rs.getDouble("precio_venta");
						cantidad=Integer.parseInt(spinner.getValue().toString()) ;

						precio.setText(String.valueOf(preciov+" € "));
						importe.setText(String.valueOf((preciov*cantidad)+" € ") );

					}


				}
				else {
					Statement st = Empresa.connection.createStatement();
					ResultSet rs;

					rs = st.executeQuery(
							"select precio_compra from producto where codigo_prod='"
									+ codigo+ "'");

					if (rs.next()) {
						preciov=rs.getDouble("precio_compra");
						cantidad=Integer.parseInt(spinner.getValue().toString()) ;

						precio.setText(String.valueOf(preciov+" € "));
						importe.setText(String.valueOf((preciov*cantidad)+" € ") );

					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void generarListaProd(JComboBox cbox) throws SQLException {
		String cod;
		String pro;
		if(Empresa.conectar("milki", "milki")==true) {
			try {

				Statement st=Empresa.connection.createStatement();
				ResultSet rs = st.executeQuery("select codigo_prod, nombre from producto order by codigo_prod");
				while (rs.next()){
					cod=rs.getString("codigo_prod");
					pro=rs.getString("nombre");
					cbox.addItem(cod + "-"+pro);
				}
				rs.close();
				st.close();

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"ERROR AL CONSULTAR DATOS", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		};

	}
}
