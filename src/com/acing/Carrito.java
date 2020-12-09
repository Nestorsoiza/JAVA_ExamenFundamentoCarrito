package com.acing;

public class Carrito {
	

	final int tamMax = 50;
	private ProductoComercializable[] itemsCarrito = new ProductoComercializable[tamMax];
	
	
	public boolean addProducto (ProductoComercializable item) {
		int posicion = 0;
		boolean insercionOK = false;
		for (int i = 0; itemsCarrito[i] != null; i++) {
			posicion++;
		}
		itemsCarrito[posicion] = item;
		insercionOK = true;
		return insercionOK;
	}

	public double getValorCarrito() {
		double valorCarrito = 0;
		for (int i = 0; itemsCarrito[i] != null; i++) {
			valorCarrito += itemsCarrito[i].getPrice();
		}
		return valorCarrito;
	}

	public String getInformeCarrito () {
		//Arrays.sort(itemsCarrito[].precio);
		ProductoComercializable auxProductos = new Producto("",0);
		int posicionFinal = 0;
		String informeCarrito = "";
		if (itemsCarrito[0] == null) {
			return "Carrito vacio";
		}
		//Ordenacion por precio.
		for (int i = 1; itemsCarrito[i] != null; i++) {
			if (itemsCarrito[i].getPrice() < itemsCarrito[i-1].getPrice()) {
				auxProductos = itemsCarrito[i-1];
				itemsCarrito[i-1] = itemsCarrito[i];
				itemsCarrito[i] = auxProductos;
				posicionFinal = i;
			}
		}
		for (int j = posicionFinal-1; j != 0; j--) {
			for(int i = 1; i <= j; i++) {
				if (itemsCarrito[i].getPrice() < itemsCarrito[i-1].getPrice()) {
					auxProductos = itemsCarrito[i-1];
					itemsCarrito[i-1] = itemsCarrito[i];
					itemsCarrito[i] = auxProductos;
				}
				posicionFinal = i-1;
			}
		}
		//Generacion del texto
		for (int i = 0; itemsCarrito[i] != null; i++) {
			informeCarrito += itemsCarrito[i].toString() + "\n";
		}
			
		informeCarrito += "\tValor Total: "  + getValorCarrito() + " eur";
		return informeCarrito;
	}

}
