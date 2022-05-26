package Milki;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Empresa.conectar();
		
//		Empresa.anadirCliente("51478798N", "Joel", "Narvaez", 642574885, "Calle Ffdrhtdh", 25022);
//		
//		Empresa.borrarCliente(null);
//		
//		Empresa.mostrarPedidosCliente(null);
//		
//		Empresa.anadirProv("A0000003", "JorgeS.A", 661234566, "Merca", 28018);
//		
//		Empresa.borrarProv(null);
//		
//		Empresa.anhadirProductoN("leche 6L Entera", 10, "Asturiana", 4.00);
//		Empresa.anhadirProductoN("leche 6L Semi", 20, "Asturiana", 3.80);
//		
//		Empresa.anhadirProductoE( 0, 0);
		
//		Empresa.altaPedido("PR2");
		
		Empresa.anhadirProducto_Pedido(2, 2, 1);
		
//		Empresa.modificarCantidadProd_Pedido(1, 9, 10);
		
//		Empresa.eliminarProducto_Pedido(1,2);
		
//		Empresa.eliminarPedido(5);
		
//		Empresa.verPedidos("CL1");
//		Empresa.verPedidos("PR2");
		
//		Empresa.verArticulosPedido(5);
//		Empresa.verArticulosPedido(1);
		
//		Empresa.cancelarPedido(1);
	}
	

}
