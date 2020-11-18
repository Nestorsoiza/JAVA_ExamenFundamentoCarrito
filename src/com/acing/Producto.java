package com.acing;



public class Producto implements Comparable<Producto>, ProductoComercializable {

	private int ID;
	private String marca;
	private String descripcion;
	private double precio;
	private double descuento;
	
	
	public Producto(String descripcion, double precio) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public Producto(int id, String descripcion, double precio) {
		this(descripcion, precio);
		setID(id);
	}
	
	public Producto(int id) {
		super();
		setID(id);
	}

	public int getID() {
		return ID;
	}
	private void setID(int iD) {
		ID = iD;
	}
	public String getDescription() {
		return descripcion;
	}
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrice() {
		return precio;
	}
	private void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	private void setMarca(String marca) {
		this.marca = marca;
	}

	public double getDescuento() {
		return descuento;
	}

	private void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		double precioEur = precio;
		return (descripcion + "[id: " + ID + "] "  + "\t" + precioEur + " eur");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return ID == other.ID;
	}
	
//	@Override
	public int comparable(Producto obj) {
		return (ID - obj.ID);
	}

	@Override
	public int compareTo(Producto obj) {
		Producto otroProd = obj;
		return (ID - otroProd.ID);
	}
}
