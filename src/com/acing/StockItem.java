package com.acing;

public class StockItem implements Comparable<StockItem> {
	

	private int cantidadItem = 0;
	private Producto item;
	
	public StockItem () {
		super();
	}
	
	public StockItem(int cantidadItem, Producto item) {
		super();
		this.cantidadItem = cantidadItem;
		this.item = item;
	}

	public int getCantidadItem() {
		return cantidadItem;
	}

	public void setCantidadItem(int cantidadItem) {
		this.cantidadItem = cantidadItem;
	}

	public void minorarCantidad () {
		this.cantidadItem = cantidadItem -1;
	}
	public int getID() {
		return item.getID();
	}
	
	
	public int comparable(StockItem obj) {
		return (getID() - obj.getID());
	}
	
	@Override
	public String toString() {
		return cantidadItem + " unidades de " + item.toString();
	}

	@Override
	public int compareTo(StockItem obj) {
		StockItem otroProd = (StockItem) obj;
		return (getID() - otroProd.getID());
	}
	
}
