package principal.interfaz_usuario;

import java.awt.Color;
import java.awt.Graphics;

public class InterfazUsuario {

	public static void dibujarBarraResistencia(Graphics g, int resistencia) {
		int ancho = 100 * resistencia / 600;
		Color rojoOscuro = new Color(153, 0, 0);

		g.setColor(Color.WHITE);
		g.drawRect(19, 99, 101, 17);

		g.setColor(Color.RED);
		g.fillRect(20, 100, ancho, 5);

		g.setColor(rojoOscuro);
		g.fillRect(20, 105, ancho, 10);

	}
}
