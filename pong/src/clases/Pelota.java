package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Pelota {
	private int x;
	private int y;

	private int dx = 1;// direccion x
	private int dy = 1;// direccion y

	private final int ANCHO = 15;
	private final int ALTO = 15;

	// constructor
	public Pelota(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// metodo que devuelve la pelota
	public Rectangle2D getPelota() {
		return new Rectangle2D.Double(x, y, ANCHO, ALTO);
	}

	// para mover la pelota, debemos saber el tamaño de la superficie donde se
	// va a mover la pelota, para poder hacer los limites
	public void mover(Rectangle limites, boolean colisionR1, boolean colisionR2) {
		x += dx;// para summar la posicion respecto al limite x
		y += dy;// para summar la posicion respecto al limite y

		// si las raquetas tocan la pelota
		if (colisionR1) {
			dx = -dx;// se mueve en direccion contraria
			x = 25;// para arreglar el error de colision (se queda agarrado)
		}
		if (colisionR2) {
			dx = -dx;// se mueve en direccion contraria
			x = 755;// para arreglar el error de colision
		}

		// Si la pelota toca el limite derecho o borde empezara a restar
		// posiciones en x
		if (x > limites.getMaxX()) {
			dx = -dx;
		}

		// Si la pelota toca el limite derecho o borde empezara a restar
		// posiciones en y
		if (y > limites.getMaxY()) {
			dy = -dy;
		}

		// Si la pelota toca el limite izquierdo o borde resta posiciones en x
		if (x < 0) {
			dx = -dx;
		}

		// Si la pelota toca el limite izquierdo o borde resta posiciones en y
		if (y < 0) {
			dy = -dy;
		}

	}

}
