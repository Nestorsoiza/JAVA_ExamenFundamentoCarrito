package com.acing;

import com.examen.Product3rdParty;

public class ProductoExterno extends Product3rdParty implements ProductoComercializable {

	String descripcion;
	double precio;
	
	public ProductoExterno(String description, double price) {
		super(description, price);
	}
	
	public String getDescription() {
		return super.getDescription();
	}
	
	public double getPrice() {
		return super.getPrice();
	}
}
