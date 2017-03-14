package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class TableroJuego extends JPanel {

	Pelota pelota = new Pelota(0, 0);// creamos pelota en posicion 0,0
	Raqueta r1 = new Raqueta(10, 200);// creamos la raqueta 1. margen 10,200
	Raqueta r2 = new Raqueta(794 - 10 - Raqueta.ANCHO, 200);// raqueta2

	public TableroJuego() {
		setBackground(Color.BLACK);
	}

	// metodo sobreescrito
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // para ke se ejecute el metodo padre
		Graphics2D g2 = (Graphics2D) g; // hacemos un casting para trabajar con
										// los graficos mejorados Graphics2D
		g2.setColor(Color.WHITE);// color pelota
		dibujar(g2);// dibuja pelota
		actualizar();// actualiza posicion de pelota

	}

	// metodo para dibujar pelota raquetas
	public void dibujar(Graphics2D g) {
		g.fill(pelota.getPelota());// dibuja la pelota
		g.fill(r1.getRaqueta());// dibujar raqueta 1
		g.fill(r2.getRaqueta());// dibujar raqueta 2

	}

	// metodo para actualizar el estado de pelota raquetas
	public void actualizar() {
		// MOVER PELOTA. getBounds devuelve el tamaño del rectangle, o "lamina"
		// (JPanel). Tambien se añaden las colisiones con la pelota.
		pelota.mover(getBounds(), colision(r1.getRaqueta()), colision(r2.getRaqueta()));

		r1.moverR1(getBounds());// MOVER raqueta 1
		r2.moverR2(getBounds());// MOVER raqueta 2
	}

	private boolean colision(Rectangle2D r) {
		return pelota.getPelota().intersects(r);// intersects determina si 2
												// Rectangle se tocan o no
	}

	// metodo de redibujar la pantalla. HILO DE EJECUCION 2
	// public void iterarJuego() {
	// while (true) {
	// repaint();
	// try {
	// Thread.sleep(5);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	// }
}
