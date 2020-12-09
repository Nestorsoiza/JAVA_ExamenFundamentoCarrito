package com.acing;

import java.util.*;
//import java.util.Collections;

public class ListaProductos {
	
	private Collection<ProductoComercializable> listaProductos = new TreeSet<>();

	public ListaProductos() {
			super();
			
		}
	
	public void addProducto (int id, String descripcion, double precio) {
		listaProductos.add(new Producto(id, descripcion, precio));
	}
	
	public void addProducto (String descripcion, double precio) {
		int id = getIdMax()+1;
		this.addProducto (id, descripcion, precio);
	}
	
	public void addProducto(ProductoComercializable producto) {
		listaProductos.add(producto);
	}
	
	public Producto getProducto(int id) {
		
		Iterator<ProductoComercializable> it =  listaProductos.iterator();
		Producto productoTemp;
		while (it.hasNext()) {
			productoTemp =(Producto) it.next();
			if (id == productoTemp.getID()) {
				return productoTemp;
			}
		}
		return null;
	}
	
	public int getIdMax () {
		int idMax = 0;
		Producto productoTemp;
		Iterator<ProductoComercializable> it =  listaProductos.iterator();
		while (it.hasNext()) {
			productoTemp = (Producto) it.next();
			if (productoTemp.getID() > idMax) {
				idMax = productoTemp.getID();
			}
		}
		return idMax;
		
	}

	@Override
	public String toString() {
		String textoString = "";
		Iterator<ProductoComercializable> it =  listaProductos.iterator();
		while (it.hasNext()) {
			textoString += it.next().toString() + "\n";
			}
		return textoString;
	}

	

}
