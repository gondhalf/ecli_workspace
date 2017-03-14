package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Raqueta {
	private int x;
	private int y;

	static final int ANCHO = 10;
	static final int ALTO = 80;

	public Raqueta(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// metodo que devuelbe la raqueta
	public Rectangle2D getRaqueta() {
		return new Rectangle2D.Double(x, y, ANCHO, ALTO);
	}

	// mover raqueta1
	public void moverR1(Rectangle limites) {
		if (EventoTeclado.w && y > limites.getMinY()) {
			y--;
		}
		if (EventoTeclado.s && y < limites.getMaxY() - ALTO) {
			y++;
		}
	}

	// mover raqueta2
	public void moverR2(Rectangle limites) {
		if (EventoTeclado.up && y > limites.getMinY()) {
			y--;
		}
		if (EventoTeclado.down && y < limites.getMaxY() - ALTO) {
			y++;
		}
	}

}
