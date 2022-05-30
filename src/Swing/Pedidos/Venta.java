package Swing.Pedidos;
/**
 * 
 * @author Juan Esteban y Allison
 * Esta clase fue creada para utilizarse en FramePedido, es como cada articulo dentro de una compra.
 *
 */
public class Venta {

	int codigo_prod;
	String nombre;
	int cantidad;
	double precio;
	double importe;

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public int getCodigo_prod() {
		return codigo_prod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setCodigo_prod(int codigo_prod) {
		this.codigo_prod = codigo_prod;
	}
	
	
	
}
