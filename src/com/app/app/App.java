package com.app.app;

import com.acing.*;

public class App {

	public static void main(String[] args) {
		ListaProductos listaProductos = new ListaProductos();
		listaProductos.addProducto(1, "12 latas Refresco - Coca Cola", 6.01);
		listaProductos.addProducto(2,"Leche Semidesnatada 1 litro - President", 0.72); 
		listaProductos.addProducto(5, "Dentifrico - Oral B", 1.99);
		listaProductos.addProducto(8, "6 botellas 1,5 litro - Font Vella", 2.99);
		ProductoComercializable productoExternoComercializable = new ProductoExterno("Crimen y castigo", 0.46);
		Almacen stockAlmacen = new Almacen(listaProductos);
		stockAlmacen.cargaStockAlmacen(1, 8);
		stockAlmacen.cargaStockAlmacen(2, 3);
		stockAlmacen.cargaStockAlmacen(5, 0);
		stockAlmacen.cargaStockAlmacen(8, 1);
		Carrito carritoUser = new Carrito();
		addToCarrito(carritoUser, listaProductos.getProducto(1), stockAlmacen);		//item 1 - stock 8
   		addToCarrito(carritoUser, listaProductos.getProducto(2), stockAlmacen);		//item 2 - stock 3
 //		addToCarrito(carritoUser, listaProductos.getProducto(5), stockAlmacen);		//item 5 - stock 0
   		addToCarrito(carritoUser, listaProductos.getProducto(8), stockAlmacen);		//item 8 - stock 1
		addToCarrito(carritoUser, productoExternoComercializable, stockAlmacen);	//item 9 - stock 0
		//Impresiones
		System.out.println();
		System.out.println(carritoUser.getInformeCarrito());
		System.out.println();
		System.out.println(stockAlmacen.toString());
	}
	
	public static void addToCarrito (Carrito carritoUser, ProductoComercializable item, Almacen stockAlmacen) {
		if (item instanceof Producto) {
			int id = ((Producto) item).getID();
			if (stockAlmacen.hayStock(id)) {
				carritoUser.addProducto(item);
				stockAlmacen.minorarCantidad(id);
				System.out.println("Quedan " + stockAlmacen.getCantidad(id) + " de " + item.getDescription());
			} else {
				System.out.println("No hay existencias de " + item.getDescription());
			}
		} else {
			carritoUser.addProducto(item);
				System.out.println("Producto externo añadido: " + item.getDescription());
		}
	}

}
