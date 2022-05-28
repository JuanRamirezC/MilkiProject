package Milki;
import java.io.IOException;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) throws SQLException, IOException {
		Empresa.conectar("milki","milki");
		
//		Empresa.anadirCliente("51478798N", "Joel", "Narvaez", 642574885, "Calle Ffdrhtdh", 25022);
//		Empresa.anadirCliente("51487798N", "Juanl", "Narvaez", 642574885, "Calle Ffdrhtdh", 25022);
////		Empresa.borrarCliente(null);
////		Empresa.mostrarPedidosCliente(null)
//		Empresa.anadirProv("A0000006", "JorgeA", 661234566, "Merca", 28018);
//////		Empresa.borrarProv(null);
////		Empresa.anhadirProductoN("leche 6L Entera", 10, "Asturiana", 4.00);
////		Empresa.anhadirProductoN("leche 6L Semi", 20, "Asturiana", 3.80);	
////		
//		Empresa.altaPedido("CL1");
////		Empresa.altaPedido("PR1");
////		System.out.println("------------------------");
////		Empresa.anhadirProducto_Pedido(1, 1, 5);
//		Empresa.anhadirProducto_Pedido(4, 1, 2);
//		Empresa.anhadirProducto_Pedido(4, 2, 2);
//		Empresa.anhadirProducto_Pedido(2, 2, 10);
//		System.out.println("------------------------");
		Empresa.modificarCantidadProd_Pedido(4, 1, 0);
		Empresa.modificarCantidadProd_Pedido(4, 2, 0);
////		Empresa.eliminarProducto_Pedido(1,2);
//		System.out.println("------------------------");
//		Empresa.anhadirExistencias( 1, 15);
		
//		System.out.println("------------------------");
////		Empresa.cancelarPedido(12);
//		
//		Empresa.mostrarPedidos("PR1");	
//		System.out.println("------------------------");
//		Empresa.verArticulosPedido(1);
		Empresa.verArticulosPedido(4);
//		System.out.println("------------------------");
////		Empresa.verArticulosPedido(1);	
////		Empresa.cancelarPedido(1);	
//		System.out.println("------------------------");
//		Empresa.finalizarPedido(1);
//		System.out.println("------------------------");
//		Empresa.confirmarPedido(1);
////		Empresa.generarFactura(9);
		
//		Empresa.mostrarPedidos("CL1");
		//TODO COMPROBAR METODO AÑADIR EXISTENCIAS Y PROCEDIMIENTO
	}
	

}
