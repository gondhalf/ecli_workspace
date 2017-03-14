package ejer4;

public class Cancion {

	private String titulo;
	private String autor;
	private String estilo;
	private int duracion;
	private boolean escuchada;

	public Cancion(String titulo) {
		this.titulo = titulo;
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

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
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
