package model;

import java.awt.Color;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class BotonProducto extends JButton {

	private Producto producto;

	public BotonProducto(Producto prod) {
		setBackground(Color.RED);
		setProducto(prod);
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}