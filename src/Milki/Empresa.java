package Milki;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Esta clase contiene todos los metodos que vamos a usar para dar funcionalidad
 * a la base de datos.
 * 
 * @author Allison Dalia, Juan Esteban, Joel Narvez
 * @version jdk-16.0.1
 *
 */
public class Empresa {

	/**
	 * Esta variable statica nos ofrece poder calcular de forma automatica un
	 * beneficio del 20%
	 */
	public static double BENEFICIO = 1.2;
	/**
	 * La función de esta variable es guardar el último cliente asignado.
	 */
	private static int numCL = 1;
	/**
	 * La función de esta variable es guardar el último proveedor asignado.
	 */
	private static int numPR = 1;
	/**
	 * La función de esta variable es guardar el último numero de producto asignado.
	 */
	private static int codProd = 1;
	/**
	 * La función de esta variable es guardar el último numero de pedido asignado.
	 */
	private static int numPedido = 1;
	/**
	 * Crea un archivo para volcar la información de un pedido y generar el ticket
	 */
	private static File f;

	private static FileWriter fw;

	private static BufferedWriter bw;

	// Creamos las variables necesarias para conectarnos a la base de datos (driver
	// objc11.jar necesario).
	private static String bd = "XE";
	/**
	 * Variable que guarda el usuario de la base de datos.
	 */
	private static String login;
	/**
	 * Varaible que guarda la contraseña de la base de datos.
	 */
	private static String password;
	/**
	 *  Variable que almacena la IP que puede ir cambiando dado que la maquina donde se encuentra la BBDD no tiene una IP estática.
	 */
	private static String ip = "192.168.0.32"; //

	/**
	 * Dirección que nos indica donde se encuentra nuestra base de datos.
	 */
	private static String url = "jdbc:oracle:thin:@" + ip + ":1521/" + bd;

	/**
	 * Variable que indica si estamos conectados a la base de datos.
	 */
	public static Connection connection = null;

	/**
	 * Variable que guarda resultados de una consulta.
	 */
	private static ResultSet rs = null;
	/**
	 * Variable que envia comandos a SQL
	 */
	private static Statement st = null;
	/**
	 * Variable que hereda de Statement permite lanzar comandos SQL precompilados. 
	 */
	private static PreparedStatement ps = null;

	/**
	 * Metodo nos permite conectandonos a nuestra base de datos introduciendo por
	 * parametro los credenciales
	 * 
	 * @param loginB    Nombre de usuario de la base de datos.
	 * @param passwordB Contraseña del usuario de la base de datos.
	 * @throws Exception Lanza esta excepción en caso de no lograr iniciar sesión.
	 * @return correcto Devuelve true si la conexión fue correcta o false en caso contrario
	 */
	public static boolean conectar(String loginB, String passwordB) {
		boolean correcto= false;
		login = loginB;
		password = passwordB;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, login, password);
			if (connection != null) {
				System.out.println("Conexión realizada correctamente");
				return correcto=true;
			}
		} catch (Exception e) {
			System.out.println("Datos incorrectos");
		}
		return correcto;
	}

	// METODOS CLIENTE

	/**
	 * Metodo nos permite añadir a nuestra base de datos un cliente nuevo, haciendo
	 * una query en SQL para introducir los parametros en nuestra base de datos.
	 * 
	 * @see EMPRESA#numCL
	 * @param dni       Indica DNI del cliente.
	 * @param nombre    Indica el nombre del cliente.
	 * @param apellidos Indica el apellido del cliente.
	 * @param number    Indica el numero del cliente.
	 * @param dir       Indica la direccion del cliente.
	 * @param postal    Indica la postal del cliente.
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 * @return codigo Devuelve el codigo generado automaticamente que identifica al Cliente creado.
	 */
	public static String anadirCliente(String dni, String nombre, String apellidos, int number, String dir, int postal)
	{
		String codigo="NoCode";


		try {
			st = connection.createStatement();
			rs = st.executeQuery("select cast(max(ltrim(codigo,'CL')) as int)" + "\"NUMERO_CLIENTE\""
					+ "from persona where codigo like 'CL%'");
			if (rs.next()) {
				numCL = rs.getInt("NUMERO_CLIENTE");
			}
			ps = connection.prepareStatement("insert into PERSONA values ((?),(?),(?),(?),(?),(?),(?))");

			ps.setString(1, "CL" + (numCL + 1));
			ps.setString(2, dni);
			ps.setString(3, nombre);
			ps.setString(4, apellidos);
			ps.setInt(5, number);
			ps.setString(6, dir);
			ps.setInt(7, postal);

			ps.execute();
			ps.close();
			st.close();

			codigo="CL"+(numCL+1);

			System.out.println("Cliente añadido correctamente");

		} catch (SQLException e) {
			return codigo;
		}

		return codigo;
	}

	/**
	 * Metodo borra de nuestra base de datos un cliente o proveedor según los datos
	 * introducidos por parametro.
	 * 
	 * @param codigo Es el codigo del cliente o proveedor para poder buscarlo en la base de datos y borrarlo.
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 * @return res Booleano que devuelve true en caso de haber borrado correctamente y false en caso contrario.
	 */
	public static boolean borrarPersona(String codigo)  {
		boolean res=false;

		try {
			st = connection.createStatement();
			rs = st.executeQuery("select * from persona where upper (codigo)='" + codigo + "'");

			if (rs.next()) {

				ps = connection.prepareStatement("delete from persona where upper (codigo)='" + codigo + "'");
				ps.execute();

				System.out.println("Borrado correctamente");
				res=true;
				return res;
			}
			else {
				System.out.println("No encontrado");
			}
		} catch (SQLException e) {
			res=false;
		}

		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				res=false;
			}
			try {
				st.close();
			} catch (SQLException e) {
				res=false;

			}
		}
		return res;

	}


	/**
	 * Metodo muestra todos los pedidos relacionados a un cliente o un proveedor
	 * especifico.
	 * 
	 * @param codigo Es el codigo del cliente o proveedor para poder buscarlo en la base de datos y hacer una consulta especifica.
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 */
	public static void mostrarPedidos(String codigo)  {
		int num_pedido;
		double importe_total;
		Date fecha;
		String estado;

		try {
			st = connection.createStatement();
			rs = st.executeQuery("select num_pedido, importe_total, fecha_pedido, estado from pedido where cod_persona='"+codigo+"'");
			if (rs.next()) {
				do {
					num_pedido = rs.getInt("num_pedido");
					importe_total = rs.getDouble("importe_total");
					fecha = rs.getDate("fecha_pedido");
					estado = rs.getString("estado");
					System.out.println("Pedido numero: " + num_pedido + "	Importe total: " + importe_total + "	Fecha: "
							+ fecha + "	Estado: " + estado);

				}while (rs.next());	
			}
			else {
				System.out.println("No hay pedidos para el cliente o el proveedor de cliente");
			}
		} catch (SQLException e) {
			System.out.println("Error al acceder a los pedidos.");
		}

		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println("Error en la consulta anidada");
			}
			try {
				st.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexión");

			}
		}

	}

	// METODOS PROVEEDOR

	/**
	 * Metodo nos permite añadir a nuestra base de datos un proveedor nuevo,
	 * haciendo una query en SQL para introducir los parametros en nuestra base de
	 * datos.
	 * 
	 * @param dni    DNI o NIF de la empresa o del autonomo.
	 * @param nombre Nombre de de la empresa o del autonomo.
	 * @param number Numero de de la empresa o del autonomo.
	 * @param dir    Direccion de la empresa o del autonomo.
	 * @param postal Codigo postal de de la empresa o del autonomo.
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 * @return codigo Devuelve el codigo generado automaticamente que identifica al Proveedor creado.
	 * 
	 */
	public static String anadirProv(String dni, String nombre, int number, String dir, int postal) {
		String codigo="NoCode";

		try {
			st = connection.createStatement();
			rs = st.executeQuery("select cast(max(ltrim(codigo,'PR')) as int)" + "\"NUMERO_PROV\""
					+ "from persona where codigo like 'PR%'");
			if (rs.next()) {
				numPR = rs.getInt("NUMERO_PROV");
			}

			ps = connection.prepareStatement("insert into PERSONA values ((?),(?),(?),(?),(?),(?),(?))");

			ps.setString(1, "PR" + (numPR + 1));
			ps.setString(2, dni);
			ps.setString(3, nombre);
			ps.setString(4, "-");
			ps.setInt(5, number);
			ps.setString(6, dir);
			ps.setInt(7, postal);

			ps.execute();
			ps.close();
			st.close();

			codigo="PR"+(numPR+1);
			System.out.println("Proveedor añadido correctamente");


		} catch (SQLException e) {
			return codigo;
		}

		return codigo;
	}

	/**
	 * Metodo que permite conseguir la información de un cliente o proveedor introducido por parámetro.
	 * @param codigo Es el codigo del cliente o proveedor para poder buscarlo en la base de datos y hacer una consulta especifica.
	 * @return res String que devuelve toda la información recibiba por la consulta.
	 */
	public static String mostrarPersona(String codigo) {
		String res="Cliente no encontrado";
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select codigo, dni_nif, nombre, apellidos, numero_telefono, direccion, cod_postal from persona where upper (codigo)='" + codigo + "'");

			if (rs.next()) {
				String cod=rs.getString("codigo");
				String dni_nif=rs.getString("dni_nif");
				String nombre=rs.getString("nombre");
				String apellidos=rs.getString("apellidos");
				int num=rs.getInt("numero_telefono");
				String dir=rs.getString("direccion");
				int postal=rs.getInt("cod_postal");

				System.out.println("CÓDIGO:"+cod+"   DNI/NIF"+dni_nif+"   NOMBRE:"+nombre+"   APELLIDOS:"+apellidos+"   NUMERO DE TELEFONO: "+num+"   DIRECCIÓN: "+dir+"   CÓDIGO POSTAL:"+postal);
				res="CÓDIGO:"+cod+"   DNI/NIF:"+dni_nif+"   NOMBRE:"+nombre+"   APELLIDOS:"+apellidos+"    NUMERO DE TELEFONO: "+num+"   DIRECCIÓN: "+dir+"   CÓDIGO POSTAL:"+postal;
			}

			else {
				System.out.println("No encontrado");
			}
		} catch (SQLException e) {
			return res;
		}

		return res;
	}

	// METODOS ALMACEN

	/**
	 * Metodo que muestra todos los productos que tenemos en el almacen.
	 * 
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 */
	public static void verProductos()  {
		int codigo_producto, cant;
		String nombre, marca;
		Double precio_compra, precio_venta;

		try {
			st = connection.createStatement();

			rs = st.executeQuery(
					"select codigo_prod, nombre, cantidad, marca, precio_compra, precio_venta from producto");
			if (!rs.next()) {
				System.out.println("No hay productos en el almacén");
			}
			do {
				codigo_producto = rs.getInt("codigo_prod");
				nombre = rs.getString("nombre");
				cant = rs.getInt("cantidad");
				marca = rs.getString("descripcion");
				precio_compra = rs.getDouble("precio_compra");
				precio_venta = rs.getDouble("precio_venta");
				System.out.println("Codigo de producto: " + codigo_producto + "	Nombre: " + nombre + "	Cantidad: " + cant
						+ "	Descripcion: " + marca + "\nPrecio de Compra: " + precio_compra + "	Precio de venta: "
						+ precio_venta);
			} while (rs.next());

		} catch (SQLException e) {
			System.out.println("Error en el acceso o consulta a la base de datos.");
		}

	}

	/**
	 * Metodos que muestra todos los productos que tengan un nombre similar al
	 * indicado. Por ejemplo si introduces la palabra leche, mostrará todos los
	 * producto que se llamen así:<b> Leche Entera, Leche Semi, Leche Desnatada
	 * etc... <b>
	 * 
	 * @param nombreProd Nombre de un producto para buscar similitudes en nuestra de
	 *                   base de datos
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 */
	public static void verProductoNombre(String nombreProd) {
		int codigo_producto, cant;
		String nombre, marca;
		Double precio_compra, precio_venta;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(
					"select codigo_prod, nombre, cantidad, marca, precio_compra, precio_venta from producto where nombre='"
							+ nombreProd + "'");
			if (!rs.next()) {
				System.out.println("No hay productos en el almacén");
			}
			do {
				codigo_producto = rs.getInt("codigo_prod");
				nombre = rs.getString("nombre");
				cant = rs.getInt("cantidad");
				marca = rs.getString("descripcion");
				precio_compra = rs.getDouble("precio_compra");
				precio_venta = rs.getDouble("precio_venta");
				System.out.println("Codigo de producto: " + codigo_producto + "	Nombre: " + nombre + "	Cantidad: " + cant
						+ "	Descripcion: " + marca + "\nPrecio de Compra: " + precio_compra + "	Precio de venta: "
						+ precio_venta);

			} while(rs.next());
		} catch (SQLException e) {
			System.out.println("Error al buscar el producto deseado.");
		}

	}

	/**
	 * Metodo que permite añadir un producto <b>nuevo<b> a nuestra base de datos
	 * asignandole un codigo único y calculando el precio que tendrá cara al público
	 * calculado con la variable BENEFICIO.
	 * 
	 * @param nombre      Nombre del producto nuevo.
	 * @param cantidad    Cantidad de producto que desea añadir, por defecto se
	 *                    encuentra en 0
	 * @param descripcion Descripción donde especificamos el proveedor del producto
	 * @param preCo       Es el precio que tendrá cada unidad de producto
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 * @return codigo Devuelve el identificador que se le ha asignado
	 */
	public static int anhadirProductoN(String nombre, int cantidad, String descripcion, double preCo) {
		int codigo = 0;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select max(codigo_prod)" + "\"CODIGOPROD\"" + "from producto");
			if (rs.next()) {
				codProd = rs.getInt("CODIGOPROD");
			}
			ps = connection.prepareStatement("insert into PRODUCTO values ((?),(?),(?),(?),(?),(?))");
			ps.setInt(1, codProd + 1);
			ps.setString(2, nombre);
			ps.setInt(3, cantidad);
			ps.setString(4, descripcion);
			ps.setDouble(5, preCo);
			ps.setDouble(6, preCo * BENEFICIO);

			ps.execute();

			codigo=codProd+1;

			System.out.println("Producto añadido correctamente");
			return codigo;
		} catch (SQLException e) {
			System.out.println("Error al insertar el producto nuevo.");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println("Error en la consulta anidada");
			}
			try {
				st.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexión");

			}
		}
		return codigo;

	}

	public static void borrarProducto(int codigo) {

		try {
			st = connection.createStatement();
			rs = st.executeQuery("select * from producto where codigo_prod=" + codigo);

			if (rs.next()) {
				rs = st.executeQuery("delete from PRODUCTO where codigo_prod=" + codigo);
				System.out.println("Producto modificado");
			} else {
				System.out.println("Codigo de producto no existente");
			}
		} catch (SQLException e) {
			System.out.println("Error al intentar borrar el producto.");
		}


	}

	/**
	 * Metodo que permite añadir un producto <b>existente<b> a nuestra base de datos
	 * actualizando sus cantidades con las cantidades introducidas por parametro.
	 * 
	 * @param codigo Codigo que nos permitirá comprobar si el producto existe ya en
	 *               la base de datos.
	 * @param cant   Es la cantidad del producto que desea añadir.
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 */
	public static void anhadirExistencias(int codigo, int cant)  {
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select * from producto where codigo_prod=" + codigo);

			if (rs.next()) {
				rs = st.executeQuery("update PRODUCTO set cantidad=cantidad+" + cant + " where codigo_prod=" + codigo);
				System.out.println("Producto modificado");
			} else {
				System.out.println("Codigo de producto no existente");
			}
		} catch (SQLException e) {
			System.out.println("Error en el acceso o consulta a la base de datos.");
		}

	}

	public static void modificarExistencias(int codigo, int cant) {
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select * from producto where codigo_prod=" + codigo);

			if (rs.next()) {
				rs = st.executeQuery("update PRODUCTO set cantidad=" + cant + " where codigo_prod=" + codigo);
				System.out.println("Producto modificado");
			} else {
				System.out.println("Codigo de producto no existente");
			}
		} catch (SQLException e) {
			System.out.println("Error al modificar las existencias.");
		}

	}
	// METODOS GENERALES PEDIDOS

	/**
	 * Metodo que nos permitirá crear un pedido al cual después se le podran ir
	 * añadiendo productos. Se generará un número identificativo único de pedido de
	 * forma automatica.
	 * 
	 * @param persona Codigo de cliente o proveedor que nos servirá para identificar quien hace el pedido
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 * @return pedido Devuelve un int con el número que identifica al pedido
	 */
	public static int altaPedido(String persona) { // Pedido
		int pedido = 0;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select max(num_pedido)" + "\"PEDIDO\"" + "from pedido");
			if (rs.next()) {
				numPedido = rs.getInt("PEDIDO");
			}
			ps = connection.prepareStatement("insert into PEDIDO (NUM_PEDIDO, ESTADO, COD_PERSONA)  values ((?),(?),(?)) ");
			ps.setInt(1, numPedido + 1);
			ps.setString(2, "INICIADO");
			ps.setString(3, persona);

			System.out.println("Pedido añadido correctamente");

			rs = st.executeQuery("select max(num_pedido)" + "\"PEDIDO\"" + "from pedido");
			if (rs.next())
				pedido = rs.getInt("PEDIDO");

			System.out.println("Numero de pedido: " + pedido);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Error al dar de alta el nuevo pedido.");
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println("Error en la consulta anidada");
			}
			try {
				st.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexión");

			}
		}


		return pedido ;
	}

	/**
	 * Metodo que permite cancelar un pedido en especifico.
	 * 
	 * @param numeroped Numero de pedido para indicar cuál pedido se desea cancelar.
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 */
	public static void cancelarPedido(int numeroped) {
		try {
			st = connection.createStatement();

			rs = st.executeQuery("select * from pedido where num_pedido=" + numeroped);
			if (rs.next()) {
				rs = st.executeQuery("update PEDIDO set ESTADO='CANCELADO', FINALIZADO=1 where num_pedido=" + numeroped);
				rs = st.executeQuery("delete from pedido_prod where num_pedido=" + numeroped);

				System.out.println("Pedido cancelado correctamente");
			}
		} catch (SQLException e) {
			System.out.println("Error al cancelar pedido.");
		}

	}

	/**
	 * Metodo que permite cambiar el estado de un pedido a CONFIRMADO y genera una
	 * factura de un archivo txt.
	 * 
	 * @param numpedido Número de pedido para indicar que pedido se desea confirmar.
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 * @throws IOException  Lanza esta excepción si hay algun error al crear el txt
	 *                      del ticket.
	 */
	public static String confirmarPedido(int numpedido)  {
		String result;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select * from pedido where num_pedido=" + numpedido);

			if (rs.next()) {
				rs = st.executeQuery("update pedido set estado='CONFIRMADO' where num_pedido=" + numpedido);
				Empresa.generarFactura(numpedido);
				result="El pedido "+ numpedido+" ha sido confirmado";
			} else {
				result="Pedido no existente";
			}
		} catch (SQLException e) {
			result="Error al confirmar pedido";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Metodo que permite cambiar el estado de un pedido a FINALIZADO
	 * 
	 * @param numpedido Número de pedido para indicar que pedido se desea finalizar.
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 */
	public static String finalizarPedido(int numpedido) { // Calcula trigger trigger importe base
		String res="";
		int finali;
		try {
			st = connection.createStatement();

			rs = st.executeQuery("select finalizado from pedido where num_pedido=" + numpedido);
			if (rs.next()) {
				finali = rs.getInt("finalizado");
				if (finali == 0) {
					rs = st.executeQuery(
							"update pedido set finalizado=1, estado='FINALIZADO' where num_pedido=" + numpedido);
					res="Pedido finalizado";
				} else {
					res="Pedido ya se encuentra finalizado";
				}
			} else {
				res="Pedido no existente";
			}
		} catch (SQLException e) {
			System.out.println("Error al finalizar pedido.");
		}
		return res;
	}


	/**
	 * Metodo que nos permite ver todos los articulos que tiene un pedido.
	 * @deprecated este metodo se utilizaba para listar los articulos de un pedido visto por consola.
	 * @param numeroped Número de pedido para indicar que pedido se desea visualizar.
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 */
	public static void verArticulosPedido(int numeroped)  { // revisar error "Nombre de columna no
		// valido"
		String nombre, aux = "";
		int codigo, cantidad;
		double precio, precioTotal;

		try {
			st = connection.createStatement();

			rs = st.executeQuery(
					"select substr(cod_persona,1,2)" + "\"CODIGO\"" + "from pedido where num_pedido=" + numeroped);
			if (rs.next()) {
				aux = rs.getString("CODIGO");

			}
			if (aux.equals("CL")) {
				rs = st.executeQuery(
						"select prd.codigo_prod,nombre, cantidad_prod,precio_venta from pedido_prod prd join producto pd on prd.codigo_prod=pd.codigo_prod where num_pedido="
								+ numeroped);
				System.out.println("-------------------------");
				System.out.println("PRODUCTOS DEL PEDIDO: " + numeroped);
				while (rs.next()) {
					codigo = rs.getInt("codigo_prod");
					nombre = rs.getString("nombre");
					cantidad = rs.getInt("cantidad_prod");
					precio = rs.getDouble("precio_venta");

					precioTotal = cantidad * precio;				

					System.out.println("Codigo producto: " + codigo + "	Nombre del producto: " + nombre + "	Cantidad: "
							+ cantidad + "	Precio del producto: " + precio + "	Precio Total: "
							+ String.format("%.2f", precioTotal));
				}
				System.out.println("-------------------------");
			} else {
				rs = st.executeQuery(
						"select prd.codigo_prod,nombre, cantidad_prod,precio_compra from pedido_prod prd join producto pd on prd.codigo_prod=pd.codigo_prod where num_pedido="
								+ numeroped);
				System.out.println("-------------------------");
				System.out.println("PRODUCTOS DEL PEDIDO: " + numeroped);
				do  {
					codigo = rs.getInt("codigo_prod");
					nombre = rs.getString("nombre");
					cantidad = rs.getInt("cantidad_prod");
					precio = rs.getDouble("precio_compra");

					precioTotal = cantidad * precio;

					System.out.println("Codigo producto: " + codigo + "	Nombre del producto: " + nombre + "	Cantidad: "
							+ cantidad + "	Precio del producto: " + precio + "	Precio Total: "
							+ String.format("%.2f", precioTotal));
				} while (rs.next());
				System.out.println("-------------------------");
			}
		} catch (SQLException e) {
			System.out.println("Error al ver articulos de un pedido.");
		}


	}

	// METODOS DENTRO DE PEDIDOS

	/**
	 * Metodo que permite añadir productos a un pedido. Si el producto ya existe en
	 * nuestro pedido, se modificará la cantidad.
	 * 
	 * @param numpedido  Indica a que pedido se le añadirá el producto.
	 * @param codigoprod Indica el producto que desea añadir.
	 * @param cant       Indica la cantidad del producto que se añadira, si la cantidad es superior a la que poseemos en nuestro almacén, indicará que no hay cantidades suficientes.
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 * @return correcto Devuelve boolean true en caso de poner añadir el producto al pedido y false en el caso contrario.
	 */
	public static String anhadirProducto_Pedido(int numpedido, int codigoprod, int cant)  { // Pedido
		String respuesta="";
		int cantidad;

		try {
			st = connection.createStatement();

			rs = st.executeQuery("select num_pedido from pedido where num_pedido=" + numpedido);
			if (rs.next()) {
				rs = st.executeQuery("select cantidad from producto where codigo_prod=" + codigoprod);
				if (rs.next()) {
					cantidad = rs.getInt("cantidad");
					if (cantidad >= cant) {
						ps = connection.prepareStatement("insert into pedido_prod values ((?),(?),(?)) ");
						ps.setInt(1, numpedido);
						ps.setInt(2, codigoprod);
						ps.setInt(3, cant);

						ps.execute();
						ps.close();

						respuesta="Producto añadido al pedido correctamente";

					} 
					else {
						respuesta="Error al añadir producto. Existencias suficientes en el almacén";
					}

				} 
				else {
					respuesta="Codigo de producto no existente";

				}
			}
		} catch (SQLException e) {
			System.out.println("Error al añadir productos a pedido.");
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexión");
			}
		}


		return respuesta;
	}

	/**
	 * Metodo que permite modificar la cantidad de un producto introducido en un
	 * pedido.
	 * 
	 * @param numpedido  Identificar el pedido que recibirá los cambios.
	 * @param codigoprod Producto al cual le desea modificar la cantidad (si no
	 *                   tiene el producto en el pedido, se le indicará con un
	 *                   mensaje).
	 * @param cant       Cantidad del producto que desea modificar.
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 */
	public static String modificarCantidadProd_Pedido(int numpedido, int codigoprod, int cantNueva) { // Pedido
		String resul="";
		int cantidadAlmacen;

		try {
			st = connection.createStatement();
			rs = st.executeQuery("select num_pedido,codigo_prod from pedido_prod where num_pedido=" + numpedido);
			if (rs.next()) {
				rs = st.executeQuery("select cantidad from producto where codigo_prod=" + codigoprod);
				if (rs.next()) {
					cantidadAlmacen= rs.getInt("cantidad");
					if (cantidadAlmacen >= cantNueva) {
						if(cantNueva==0) {
							ps=connection.prepareStatement("delete from pedido_prod where codigo_prod="+codigoprod); 
							resul="Producto eliminado del pedido correctamente";
						}
						else {
							ps = connection.prepareStatement("update pedido_prod set cantidad_prod=(?) where codigo_prod=" + codigoprod);
							ps.setInt(1, cantNueva);
							ps.execute();
							ps.close();
							resul="Cantidad modficada correctamente";
						}
					}
					else {
						resul="Error al modificar producto, existencias insuficientes";
					}
				} 
				else {
					resul="Codigo de producto no existente";
				}
			}
		} catch (SQLException e) {
			resul="Error al modificar productos de pedido.";
		}
		return resul;
	}
	
	
	/**
	 * 
	 * @param numped Indica el pedido al cual realizaremos el cambio.
	 * @param importe Indica el importe calculado para actualizar en la tabla pedido.
	 */
	public static void fijarTotal(int numped,double importe) {
		try {
			ps = connection.prepareStatement("update pedido set importe_total=(?) where num_pedido=" + numped);
			ps.setDouble(1, importe);
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	/**
	 * Metodo que genera un factura de un pedido. Haciendo una consulta de nuestra
	 * base de datos para comprobar el estado de un pedido, si el pedido está en
	 * estado CONFIRMADO generá el ticket sino muestra un mensaje de que no está
	 * CONFIMADO.
	 * 
	 * @param numpedido Indica el pedido especifico al cual se desea generar el
	 *                  ticket.
	 * @throws SQLException Lanza esta excepción cuando nuestra base de datos tiene algún error.
	 * @throws IOException  Lanza esta excepción si hay algún error al generar el ticket.
	 */
	public static void generarFactura(int numpedido) {
		String finali;

		int numPedido, pedidoProd, cantidad, precioProd, total;
		String cod_persona, iniciales, nombre, apellidos;
		Date fecha;
		double importe;

		try {
			st = connection.createStatement();

			rs = st.executeQuery("select estado from pedido where num_pedido=" + numpedido);
			if (rs.next()) {
				finali = rs.getString("estado");

				if (finali.equals("CONFIRMADO")) {
					f = new File("./Tickets", "Ticket-" + numpedido + ".txt");
					fw = new FileWriter(f);
					bw = new BufferedWriter(fw);
					rs = st.executeQuery("select num_pedido, cod_persona, substr(cod_persona,1,2)" + "\"INICIALES\""
							+ ", nombre, apellidos, fecha_pedido, importe_total from pedido pd join persona ps on pd.cod_persona=ps.codigo where num_pedido="
							+ numpedido);
					if (rs.next()) {
						iniciales = rs.getString("INICIALES");

						if (iniciales.equals("CL")) {
							numPedido = rs.getInt("num_pedido");
							importe = rs.getDouble("importe_total");
							cod_persona = rs.getString("cod_persona");
							nombre = rs.getString("nombre");
							apellidos = rs.getString("apellidos");
							fecha = rs.getDate("fecha_pedido");

							bw.write("***TICKET-" + numPedido + "***");
							bw.newLine();
							bw.write("-------------------------------------------------------");
							bw.newLine();
							bw.write("DATOS DEL PEDIDO:");
							bw.newLine();
							bw.write("PEDIDO Nº=" + numPedido);
							bw.write("           FECHA DEL PEDIDO=" + fecha);
							bw.newLine();
							bw.write("-------------------------------------------------------");
							bw.newLine();
							bw.write("DATOS PERSONALES:");
							bw.newLine();
							bw.write("IDENTIFICADOR=" + cod_persona);
							bw.write("      NOMBRE=" + nombre);
							bw.newLine();
							bw.write("                       APELLIDOS=" + apellidos);
							bw.newLine();
							bw.write("-------------------------------------------------------");
							bw.newLine();
							bw.write("PRODUCTOS:");
							bw.newLine();
							bw.write("-------------------------------------------------------");
							bw.newLine();
							rs = st.executeQuery(
									"select pp.codigo_prod, nombre, cantidad_prod,precio_venta, (precio_venta*cantidad_prod)"
											+ "\"TOTAL\""
											+ " from pedido_prod pp join producto pr on pp.codigo_prod=pr.codigo_prod where pp.num_pedido="
											+ numpedido);
							while (rs.next()) {
								pedidoProd = rs.getInt("codigo_prod");
								nombre = rs.getString("nombre");
								cantidad = rs.getInt("cantidad_prod");
								precioProd = rs.getInt("precio_venta");
								total = rs.getInt("TOTAL");

								bw.write("    IDENTIFICADOR DEL PRODUCTO=" + pedidoProd);
								bw.newLine();
								bw.write("    NOMBRE=" + nombre);
								bw.newLine();
								bw.write("    CANTIDAD=" + cantidad);
								bw.write("    PRECIO UNITARIO=" + precioProd);
								bw.write("    PRECIO TOTAL=" + total);
								bw.newLine();
								bw.write("-------------------------------------------------------");
								bw.newLine();
							}
							bw.write("IMPORTE DEL PEDIDO=" + importe);
							bw.close();
							System.out.println("FACTURA GENERADA");
						}
					}
				} else {
					System.out.println("No se puede generar FACTURA, compruebe ESTADO (FINALIZADO O CONFIRMADO)");
				}
			} else {
				System.out.println("Codigo de producto no existente");
			}
		} catch (SQLException e) {
			System.out.println("Error al acceder a los datos.");
		} catch (IOException e) {
			System.out.println("No se ha podido crear el ticket");
		}

	}



}
