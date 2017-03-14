package ejer5;

import java.util.ArrayList;

public class Cancion1 {

	private String titulo;
	private String autor;
	private ArrayList<String> estilo = new ArrayList<String>();
	private int duracion;
	private boolean escuchada;

	public Cancion1(String titulo) {
		this.titulo = titulo;
	}

	public void addEstilo(String estilo) {
		this.estilo.add(estilo);
	}

	public void getEstilo() {
		for (int i = 0; i < estilo.size(); i++) {
			System.out.print(estilo.get(i) + " ");
		}
	}

	public String toString() {
		autor = "";
		String mensaje = "Autor: " + autor + "/ Titulo: " + titulo;
		return mensaje;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public boolean isEscuchada() {
		return escuchada;
	}

	public void setEscuchada(boolean escuchada) {
		this.escuchada = escuchada;
	}
}
