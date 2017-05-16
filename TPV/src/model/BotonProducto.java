package model;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class BotonProducto extends JButton {

	private Producto producto;
	ImageIcon icono = new ImageIcon("imagenes/lata.png");

	public BotonProducto(Producto prod) {
		setProducto(prod);
		this.setBackground(Color.GRAY);
		this.setIcon(icono);
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
