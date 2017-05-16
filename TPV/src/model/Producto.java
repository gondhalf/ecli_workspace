package model;

import javax.swing.ImageIcon;

public class Producto {

	private String nombre;
	private Double precio;
	private String categoria;
	private ImageIcon icon;

	public Producto(String nombre, Double precio, String categoria) {
		setNombre(nombre);
		setPrecio(precio);
		setCategoria(categoria);
		setIcon(new ImageIcon("images/" + nombre + ".png"));

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

}
