package principal.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import principal.Constantes;
import principal.GestorPrincipal;
import principal.control.GestorControles;
import principal.control.Raton;
import principal.herramientas.DibujoDebug;
import principal.maquinaestado.GestorEstados;

public class SuperficieDibujo extends Canvas {

	private static final long serialVersionUID = -6227038142688953660L;

	private int ancho;
	private int alto;

	private Raton raton;

	public SuperficieDibujo(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		this.raton = new Raton(this);

		// java no intenta forzar el repintado del canvas
		setIgnoreRepaint(true);

		setCursor(raton.obtenerCursor());
		setPreferredSize(new Dimension(ancho, alto));
		addKeyListener(GestorControles.teclado);
		setFocusable(true);
		requestFocus();
	}

	public void actualizar() {
		raton.actualizar(this);
	}

	public void dibujar(final GestorEstados ge) {
		final BufferStrategy buffer = getBufferStrategy();

		if (buffer == null) {
			createBufferStrategy(4);
			return;
		}

		final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();

		DibujoDebug.reiniciarContadorObjetos();

		DibujoDebug.dibujarRectanguloRelleno(g, 0, 0, Constantes.ANCHO_PANTALLA_COMPLETA,
				Constantes.ALTO_PANTALLA_COMPLETA, Color.BLACK);
		// g.setColor(Color.BLACK);
		// g.fillRect(0, 0, Constantes.ANCHO_PANTALLA_COMPLETA,
		// Constantes.ALTO_PANTALLA_COMPLETA);
		// para escalar el juego en pantalla completa
		if (Constantes.FACTOR_ESCALADO_X != 1.0 || Constantes.FACTOR_ESCALADO_Y != 1.0) {
			g.scale(Constantes.FACTOR_ESCALADO_X, Constantes.FACTOR_ESCALADO_Y);
		}

		ge.dibujar(g);

		DibujoDebug.dibujarString(g, "FPS: " + GestorPrincipal.obtenerFPS(), 20, 60, Color.BLUE);
		// g.setColor(Color.BLUE);
		// g.drawString("FPS: " + GestorPrincipal.obtenerFPS(), 20, 60);
		DibujoDebug.dibujarString(g, "APS: " + GestorPrincipal.obtenerAPS(), 20, 50, Color.BLUE);
		// g.drawString("APS: " + GestorPrincipal.obtenerAPS(), 20, 50);
		raton.dibujar(g);

		DibujoDebug.dibujarString(g, "OPF: " + DibujoDebug.obtenerContadorObjetos(), 20, 230);
		// para dibujar de forma sincronizada
		Toolkit.getDefaultToolkit().sync();

		g.dispose();

		buffer.show();
	}

	public int obtenerAncho() {
		return ancho;
	}

	public int obtenerAlto() {
		return alto;
	}
}
