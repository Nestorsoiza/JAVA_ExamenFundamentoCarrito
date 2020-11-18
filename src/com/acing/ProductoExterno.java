package com.acing;

import com.examen.Product3rdParty;

public class ProductoExterno extends Product3rdParty implements ProductoComercializable {



	String descripcion;
	double precio;
	
	public ProductoExterno(String description, double price) {
		super(description, price);
		// TODO Auto-generated constructor stub
	}
	
	public String getDescription() {
		return descripcion;
	}
	
	public double getPrice() {
		return precio;
	}
}
