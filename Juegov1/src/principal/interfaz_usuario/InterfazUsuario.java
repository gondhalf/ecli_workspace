package principal.interfaz_usuario;

import java.awt.Color;
import java.awt.Graphics;

import principal.herramientas.DibujoDebug;

public class InterfazUsuario {

	public static void dibujarBarraResistencia(Graphics g, int resistencia) {
		int ancho = 100 * resistencia / 600;
		Color rojoOscuro = new Color(153, 0, 0);
		DibujoDebug.dibujarRectanguloContorno(g, 19, 99, 101, 17, Color.WHITE);
		// g.setColor(Color.WHITE);
		// g.drawRect(19, 99, 101, 17);

		DibujoDebug.dibujarRectanguloRelleno(g, 20, 100, ancho, 5, Color.RED);
		// g.setColor(Color.RED);
		// g.fillRect(20, 100, ancho, 5);

		DibujoDebug.dibujarRectanguloRelleno(g, 20, 105, ancho, 10, rojoOscuro);
		// g.setColor(rojoOscuro);
		// g.fillRect(20, 105, ancho, 10);

	}
}
