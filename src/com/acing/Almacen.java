package com.acing;

import java.util.Collection;
import java.util.TreeSet;

//import java.util.Arrays;

public class Almacen {

//	final int tamMax = 10;
//	StockItem[] inventarioItems = new StockItem[tamMax];
	Collection<StockItem> inventarioItems = new TreeSet<>();
	
	public Almacen () {
		super();
	}
	
	public Almacen(ListaProductos listaProductos) {
		super();
		int idMax = listaProductos.getIdMax();
		for (int i = 1; i <= idMax; i++) {

			try {
				if (listaProductos.getProducto(i).equals(new Producto(i))) {
					inventarioItems.add(new StockItem(0, listaProductos.getProducto(i)));

				} else {
				inventarioItems.add(new StockItem(0, new Producto(i, "", 0)));		//Carga de producto en blanco

				}
			} catch (Exception e) {
				inventarioItems.add(new StockItem(0, new Producto(i, "", 0)));		//Carga de producto en blanco

				}
		}
	}
	
	public void cargaStockAlmacen (int id, int cantidad) {
		for (StockItem c : inventarioItems) {
			if (c.getID() == id) {
				c.setCantidadItem(cantidad);
			}
		}
	}
	
	public boolean hayStock (int id) {
		boolean hayStock = false;
		for (StockItem c : inventarioItems) {
			if (c.getID() == id) {
				if (c.getCantidadItem() != 0) {
					hayStock = true;
				}
			}
		}
		return hayStock;
	}
	
	public int getCantidad (int id) {
		int resultado = 0;
		for (StockItem c : inventarioItems) {
			if (c.getID() == id) {
				resultado = c.getCantidadItem();
			}
		}
		return resultado;
	}
	
	public void minorarCantidad(int id) {
		for (StockItem c : inventarioItems) {
			if (c.getID() == id) {
				c.minorarCantidad();
			}
		}
	}
	
	@Override
	public String toString() {
		String textoString = "";
		for (StockItem c : inventarioItems) {
			textoString = textoString + c.toString() + "\n";
		}
		return textoString;
	}
	
	
	
}
