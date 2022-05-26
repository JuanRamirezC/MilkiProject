package Milki;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Empresa {
	
	//Variables varias
	private static double BENEFICIO=1.2;
	private static int numCL=1;
	private static int numPR=1;
	private static int codProd=1;
	private static int numPedido=1;
	private static File f;
	private static FileReader fr;
	private static BufferedReader br;
	private static FileWriter fw;
	private static BufferedWriter bw;

	//Conectamos a la base de datos
	private static String bd="XE";
	private static String login="milki";
	private static String password="milki";
	private static String ip="192.168.0.32"; //cambiar IP en cada inicio
	private static String url="jdbc:oracle:thin:@"+ip+":1521/"+bd; 
	static Connection connection=null;

	//Creamos variables para consultas
	private static ResultSet rs=null;
	private static Statement st=null;
	private static PreparedStatement ps=null;

	public static void conectar() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection(url,login,password);
			if(connection!=null){
				System.out.println("Conexión realizada correctamente");
			}
		}
		catch (Exception e) {
			e.printStackTrace();  
		}
	}

	//METODOS CLIENTE

	public static void anadirCliente(String dni, String nombre, String apellidos, int number, String dir, int postal ) throws SQLException {

		st=connection.createStatement();
		rs= st.executeQuery("select cast(max(ltrim(codigo,'CL')) as int)" +"\"NUMERO_CLIENTE\""+ "from persona where codigo like 'CL%'");
		if (rs.next()) {
			numCL= rs.getInt("NUMERO_CLIENTE");
		}
		ps= connection.prepareStatement("insert into PERSONA values ((?),(?),(?),(?),(?),(?),(?))");

		ps.setString(1, "CL"+(numCL+1));
		ps.setString(2, dni);
		ps.setString(3, nombre);
		ps.setString(4, apellidos);
		ps.setInt(5, number);
		ps.setString(6, dir);
		ps.setInt(7, postal);

		ps.execute();
		ps.close();
		st.close();

		System.out.println("Cliente añadido correctamente");

	}

	public static void borrarCliente(String codigo) throws SQLException {

		st= connection.createStatement();
		rs= st.executeQuery("select * from persona where upper (codigo)='"+codigo+"'");

		if(rs.next()) {

			ps= connection.prepareStatement("delete from persona where upper (codigo)='"+codigo+"'");
			ps.execute();
			ps.close();
			st.close();	
			System.out.println("Cliente borrado correctamente");
		}

		else {
			System.out.println("Cliente no encontrado");
		}
	}

	public static void mostrarPedidosCliente(String codigo) throws SQLException {
		int num_pedido;
		double importe_total;
		Date fecha;
		String estado;

		st= connection.createStatement();
		rs= st.executeQuery("select num_pedido, importe_total, fecha_pedido, estado from pedido where cod_persona='"+codigo+"'");
		if (!rs.next()) {
			System.out.println("No hay pedidos para ese codigo de cliente");
		}
		while (rs.next()) {
			num_pedido=rs.getInt("num_pedido");
			importe_total=rs.getDouble("importe_total");
			fecha=rs.getDate("fecha_pedido");
			estado=rs.getString("estado");
			System.out.println("Pedido numero: "+num_pedido+ "	Importe total: "+importe_total+ "	Fecha: "+fecha+ "	Estado: "+estado);
		}
	}


	//METODOS PROVEEDOR

	public static void anadirProv(String dni, String nombre, int number, String dir, int postal) throws SQLException {

		st=connection.createStatement();
		rs= st.executeQuery("select cast(max(ltrim(codigo,'PR')) as int)" +"\"NUMERO_PROV\""+ "from persona where codigo like 'PR%'");
		if (rs.next()) {
			numPR= rs.getInt("NUMERO_PROV");
		}

		ps= connection.prepareStatement("insert into PERSONA values ((?),(?),(?),(?),(?),(?),(?))");

		ps.setString(1, "PR"+(numPR+1));
		ps.setString(2, dni);
		ps.setString(3, nombre);
		ps.setString(4, "-");
		ps.setInt(5, number);
		ps.setString(6, dir);
		ps.setInt(7, postal);

		ps.execute();
		ps.close();
		st.close();

		System.out.println("Proveedor añadido correctamente");

	}


	public static void borrarProv(String codigo) throws SQLException {
		st= connection.createStatement();
		rs= st.executeQuery("select * from persona where upper (codigo)='"+codigo+"'");
		if(rs.next()) {
			ps= connection.prepareStatement("delete from persona where upper (codigo)='"+codigo+"'");
			ps.execute();
			ps.close();
			st.close();	
			System.out.println("Proveedor borrado correctamente");
		}
		else {
			System.out.println("Proveedor no encontrado");
		}
	}
	//METODOS ALMACEN

	public static void verProductos() throws SQLException {
		int codigo_producto, cant;
		String nombre, descripcion;
		Double precio_compra,precio_venta;


		st= connection.createStatement();
		rs= st.executeQuery("select codigo_prod, nombre, cantidad, descripcion, precio_compra, precio_venta from producto");
		if (!rs.next()) {
			System.out.println("No hay productos en el almacén");
		}
		while (rs.next()) {
			codigo_producto=rs.getInt("codigo_prod");
			nombre=rs.getString("nombre");
			cant=rs.getInt("cantidad");
			descripcion=rs.getString("descripcion");
			precio_compra=rs.getDouble("precio_compra");
			precio_venta=rs.getDouble("precio_venta");
			System.out.println("Codigo de producto: "+codigo_producto+ "	Nombre: "+nombre+ "	Cantidad: "+cant+ "	Descripcion: "+descripcion+ "\nPrecio de Compra: "+precio_compra+ "	Precio de venta: "+precio_venta);
		}
	}


	public static void anhadirProductoN(String nombre, int cantidad, String descripcion, double preCo) throws SQLException {

		st= connection.createStatement();
		rs= st.executeQuery("select max(codigo_prod)"+"\"CODIGOPROD\""+ "from producto");
		if (rs.next()) {
			codProd=rs.getInt("CODIGOPROD");
		}
		ps= connection.prepareStatement("insert into PRODUCTO values ((?),(?),(?),(?),(?),(?))");
		ps.setInt(1, codProd+1);
		ps.setString(2, nombre);
		ps.setInt(3, cantidad);
		ps.setString(4, descripcion);
		ps.setDouble(5, preCo);
		ps.setDouble(6, preCo*BENEFICIO);

		ps.execute();
		ps.close();	

		st.close();

		System.out.println("Producto añadido correctamente");
	}

	public static void anhadirProductoE(int codigo, int cant) throws SQLException {
		st= connection.createStatement();
		rs= st.executeQuery("select codigo_prod from producto where codigo_prod="+codigo);

		if(rs.next()) {
			ps= connection.prepareStatement("update PRODUCTO set cantidad=cantidad+"+cant+" where codigo_prod="+codigo);
		}
		else {
			System.out.println("Codigo de producto no existente");
		}
	}



	//METODOS GENERALES PEDIDOS

	public static void altaPedido(String persona) throws SQLException { //Pedido
		int pedido=0;
		st=connection.createStatement();

		rs= st.executeQuery("select max(num_pedido)"+"\"PEDIDO\""+ "from pedido");
		if (rs.next()) {
			numPedido=rs.getInt("PEDIDO");
		}
		ps= connection.prepareStatement("insert into PEDIDO (NUM_PEDIDO, ESTADO, COD_PERSONA)  values ((?),(?),(?)) ");
		ps.setInt(1, numPedido+1);
		ps.setString(2, "INICIADO");
		ps.setString(3, persona);


		ps.execute();
		ps.close();	



		System.out.println("Pedido añadido correctamente");

		rs= st.executeQuery("select max(num_pedido)"+"\"PEDIDO\""+ "from pedido");
		if(rs.next())
			pedido=rs.getInt("PEDIDO");

		System.out.println("Numero de pedido: "+pedido);
		st.close();	
	}

	public static void cancelarPedido (int numeroped) throws SQLException {
		st=connection.createStatement();
		rs= st.executeQuery("select * from pedido where num_pedido="+numeroped);
		if(rs.next()) {
			rs= st.executeQuery("update PEDIDO set ESTADO='CANCELADO', FINALIZADO=1 where num_pedido="+numeroped);
			rs= st.executeQuery("delete from pedido_prod where num_pedido="+numeroped);

			System.out.println("Pedido cancelado correctamente");
		}
	}

	public static void confirmarPedido(int numpedido) throws SQLException {
		st=connection.createStatement();

		rs= st.executeQuery("select * from pedido where num_pedido="+numpedido);
		if(rs.next()) {
			rs= st.executeQuery("update pedido set estado='CONFIRMADO' where num_pedido="+numpedido);
		}
		else {
			System.out.println("Pedido no existente");
		}
	}

	public static void finalizarPedido(int numpedido) throws SQLException { //Calcula trigger trigger importe base
		int finali;
		st=connection.createStatement();

		rs= st.executeQuery("select finalizado from pedido where num_pedido="+numpedido);
		if(rs.next()) {
			finali=rs.getInt("finalizado");
			if(finali==0) {			
				rs= st.executeQuery("update pedido set finalizado=1, estado='FINALIZADO' where num_pedido="+numpedido);
				System.out.println("Pedido finalizado");
			}
			else {
				System.out.println("Pedido ya se encuentra finalizado");
			}
		}
		else {
			System.out.println("Pedido no existente");
		}

	}

	public static void verArticulosPedido(int numeroped) throws SQLException { //revisar error "Nombre de columna no valido"
		String nombre,aux="";
		int codigo,  cantidad;
		double precio, precioTotal;

		st=connection.createStatement();
		rs= st.executeQuery("select substr(cod_persona,1,2)" +"\"CODIGO\""+"from pedido where num_pedido="+numeroped);
		if (rs.next()) {
			aux=rs.getString("CODIGO");

		}
		if (aux.equals("CL")) {
			rs= st.executeQuery("select prd.codigo_prod,nombre, cantidad_prod,precio_venta from pedido_prod prd join producto pd on prd.codigo_prod=pd.codigo_prod where num_pedido="+numeroped);
			System.out.println("-------------------------");
			System.out.println("PRODUCTOS DEL PEDIDO: " +numeroped);
			while(rs.next()) {
				codigo=rs.getInt("codigo_prod");
				nombre=rs.getString("nombre");
				cantidad=rs.getInt("cantidad_prod");
				precio=rs.getDouble("precio_venta");

				precioTotal=cantidad*precio;

				System.out.println("Codigo producto: "+codigo+ "	Nombre del producto: "+nombre+"	Cantidad: "+cantidad+ "	Precio del producto: "+precio+ "	Precio Total: "+String.format("%.2f", precioTotal));
			}
			System.out.println("-------------------------");
		}
		else {
			rs= st.executeQuery("select prd.codigo_prod,nombre, cantidad_prod,precio_compra from pedido_prod prd join producto pd on prd.codigo_prod=pd.codigo_prod where num_pedido="+numeroped);
			System.out.println("-------------------------");
			System.out.println("PRODUCTOS DEL PEDIDO: " +numeroped);	
			while(rs.next()) {
				codigo=rs.getInt("codigo_prod");
				nombre=rs.getString("nombre");
				cantidad=rs.getInt("cantidad_prod");
				precio=rs.getDouble("precio_compra");

				precioTotal=cantidad*precio;

				System.out.println("Codigo producto: "+codigo+ "	Nombre del producto: " +nombre+ "	Cantidad: "+cantidad+ "	Precio del producto: "+precio+ "	Precio Total: "+String.format("%.2f", precioTotal));
			}
			System.out.println("-------------------------");
		}
	}


	// METODOS DENTRO DE PEDIDOS

	public static void anhadirProducto_PedidoCli(int numpedido, int codigoprod, int cant) throws SQLException { //Pedido Prod
		int cantidad;
		int codigo=0;
		int pedido=0;
		st=connection.createStatement();
		rs= st.executeQuery("select num_pedido from pedido where num_pedido="+numpedido);
		if (rs.next()) {

			rs= st.executeQuery("select num_pedido, codigo_prod from pedido_prod where num_pedido="+numpedido+"and codigo_prod="+codigoprod);
			if (rs.next()) { 
				pedido=rs.getInt("num_pedido");
				codigo=rs.getInt("codigo_prod");
			}

			rs= st.executeQuery("select cantidad from producto where codigo_prod="+codigoprod);
			if(rs.next()) {
				cantidad=rs.getInt("cantidad");
				if(cantidad>=cant ) {					
					if (codigo==codigoprod && pedido==numpedido) {
						rs= st.executeQuery("update pedido_prod set cantidad_prod=cantidad_prod +"+cant+"where num_pedido="+numpedido+"and codigo_prod="+codigoprod);
						System.out.println("Producto ya existente, cantidad modificada");
					}
					else {
						ps= connection.prepareStatement("insert into pedido_prod values ((?),(?),(?)) ");
						ps.setInt(1, numpedido);
						ps.setInt(2, codigoprod);
						ps.setInt(3, cant);

						ps.execute();
						ps.close();	
						System.out.println("Producto añadido al pedido correctamente");
					}
				}
				else {
					System.out.println("Error al añadir producto, no hay existencias suficientes");
				}
			}
			else {
				System.out.println("Codigo de producto no existente");
			}
		}
		st.close();
	}
	
	public static void anhadirProducto_PedidoProv(int numpedido, int codigoprod, int cant) throws SQLException { //Pedido Prod
		int codigo=0;
		int pedido=0;
		st=connection.createStatement();
		rs= st.executeQuery("select num_pedido from pedido where num_pedido="+numpedido);
		if (rs.next()) {
			rs= st.executeQuery("select num_pedido, codigo_prod from pedido_prod where num_pedido="+numpedido+"and codigo_prod="+codigoprod);
			if (rs.next()) { 
				pedido=rs.getInt("num_pedido");
				codigo=rs.getInt("codigo_prod");
					if (codigo==codigoprod && pedido==numpedido) {
						rs= st.executeQuery("update pedido_prod set cantidad_prod=cantidad_prod +"+cant+"where num_pedido="+numpedido+"and codigo_prod="+codigoprod);
						System.out.println("Producto ya existente, cantidad modificada");
						//PROCEDICMINETO IMPORTE
					}
					else {
						ps= connection.prepareStatement("insert into pedido_prod values ((?),(?),(?)) ");
						ps.setInt(1, numpedido);
						ps.setInt(2, codigoprod);
						ps.setInt(3, cant);

						ps.execute();
						ps.close();	
						System.out.println("Producto añadido al pedido correctamente");
						//PROCEDICMINETO IMPORTE
					}
				}	
			}
			else {
				System.out.println("Codigo de producto no existente");
			}
		st.close();
	}

	public static void modificarCantidadProd_Pedido(int numpedido, int codigoprod, int cant) throws SQLException { //Pedido Prod
		int cantidad;
		st=connection.createStatement();
		rs= st.executeQuery("select num_pedido,codigo_prod from pedido_prod where num_pedido="+numpedido);
		if (rs.next()) {
			rs= st.executeQuery("select cantidad from producto where codigo_prod="+codigoprod);
			if(rs.next()) {
				cantidad=rs.getInt("cantidad");
				if(cantidad>=cant) {
					ps= connection.prepareStatement("update pedido_prod set cantidad_prod=(?) where codigo_prod="+codigoprod);
					ps.setInt(1, cant);

					ps.execute();
					ps.close();	
					System.out.println("Pedido modificado correctamente");
					
					//PROCEDICMINETO IMPORTE
				}
				else {
					System.out.println("Error al modificar producto, existencias insuficientes");
				}
			}
			else {
				System.out.println("Codigo de producto no existente");
			}
		}
	}

	public static void eliminarProducto_Pedido(int numpedido, int codigoprod) throws SQLException {

		st=connection.createStatement();
		rs= st.executeQuery("select num_pedido,codigo_prod from pedido_prod where codigo_prod="+codigoprod+"and num_pedido="+numpedido);
		if (rs.next()) {
			ps= connection.prepareStatement("delete from pedido_prod where codigo_prod="+codigoprod);
			ps.execute();
			ps.close();	
			System.out.println("Pedido modificado correctamente");
			//PROCEDICMINETO IMPORTE
		}
		else {
			System.out.println("Error al modificar producto, existencias incorrectas");
		}
	}


	//METODOS PARA VISUALIZAR PEDIDOS

	public static void verPedidos(String persona) throws SQLException {
		int importe, codPed;
		String estado; 
		Date fechPedido;

		st=connection.createStatement();
		rs= st.executeQuery("select num_pedido,fecha_pedido,estado,importe_total from pedido where cod_persona='"+persona+"'");
		while(rs.next()) {
			codPed=rs.getInt("num_pedido");
			fechPedido= rs.getDate("fecha_pedido");
			estado=rs.getString("estado");
			importe=rs.getInt("importe_total");

			System.out.println("Codigo pedido: "+codPed+
					"\nFecha: "+fechPedido+ " Estado: "+estado+ " Importe "+importe);
		}
	}

	
	public static void generarFactura(int numpedido) throws SQLException, IOException {
		String finali;
		
		int numPedido;
		double importeTotal;
		String cod_persona;
		Date fecha_pedido;
		
		st=connection.createStatement();
		rs= st.executeQuery("select estado from pedido where num_pedido="+numpedido);
		if(rs.next()) {
			finali=rs.getString("estado");	
			
			if(finali.equals("FINALIZADO") || finali.equals("CONFIRMADO")) {
				f= new File (".","Ticket-"+numpedido);
				fw= new FileWriter (f,true);
				bw= new BufferedWriter (fw);
					rs= st.executeQuery("select num_pedido, cod_persona, substr(cod_persona,1,2)"+ "\"INICIALES\""+", nombre, fecha_pedido, importe_total from pedido pd join persona ps on pd.cod_persona=ps.codigo where num_pedido="+numpedido);
					if(rs.next()) {
							numPedido=1;
							importeTotal=1.0;
							cod_persona="";
						rs= st.executeQuery("select pp.codigo_prod, nombre, cantidad from pedido_prod pp join producto pr on pp.codigo_prod=pr.codigo_prod where pp.num_pedido="+numpedido);
						while(rs.next()) {
							
						}
					}
			}	
			else {
				System.out.println("No se puede generar FACTURA, compruebe ESTADO (FINALIZADO O CONFIRMADO)");
			}
		}
		else {
			System.out.println("Codigo de producto no existente");
		}
	}
}
