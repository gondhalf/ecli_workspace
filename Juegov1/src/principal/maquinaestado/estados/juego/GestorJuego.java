package principal.maquinaestado.estados.juego;

import java.awt.Color;
import java.awt.Graphics;

import principal.Constantes;
import principal.entes.Jugador;
import principal.herramientas.DibujoDebug;
import principal.interfaz_usuario.InterfazUsuario;
import principal.mapas.Mapa;
import principal.maquinaestado.EstadoJuego;

public class GestorJuego implements EstadoJuego {

	Mapa mapa;
	Jugador jugador;

	public GestorJuego() {
		iniciarMapa(Constantes.RUTA_MAPA);
		iniciarJugador();
	}

	private void recargarJuego() {
		final String ruta = "/texto/" + mapa.obtenerSiguienteMapa();

		iniciarMapa(ruta);
		iniciarJugador();
	}

	private void iniciarMapa(final String ruta) {
		mapa = new Mapa(ruta);
	}

	private void iniciarJugador() {
		jugador = new Jugador(mapa);
	}

	public void actualizar() {
		if (jugador.obtener_LIMITE_ARRIBA().intersects(mapa.obtenerZonaSalida())) {
			recargarJuego();
		}

		jugador.actualizar();
		mapa.actualizar((int) jugador.obtenerPosicionX(), (int) jugador.obtenerPosicionY());
	}

	public void dibujar(Graphics g) {
		mapa.dibujar(g, (int) jugador.obtenerPosicionX(), (int) jugador.obtenerPosicionY());
		jugador.dibujar(g);

		g.setColor(Color.RED);
		DibujoDebug.dibujarString(g, "X = " + jugador.obtenerPosicionX(), 20, 20);

		DibujoDebug.dibujarString(g, "Y = " + jugador.obtenerPosicionY(), 20, 30);

		// para dibujar punto salida
		// DibujoDebug.dibujarRectanguloRelleno(g, (int)
		// mapa.obtenerZonaSalida().getX(),
		// (int) mapa.obtenerZonaSalida().getY(), (int)
		// mapa.obtenerZonaSalida().getWidth(),
		// (int) mapa.obtenerZonaSalida().getHeight());

		DibujoDebug.dibujarString(g, "Siguiente mapa: " + mapa.obtenerSiguienteMapa(), 20, 130);

		DibujoDebug.dibujarString(g, "Coordenadas de salida X = " + (int) mapa.obtenerPosicionSalida().getX() + " Y ="
				+ (int) mapa.obtenerPosicionSalida().getY(), 20, 140);

		InterfazUsuario.dibujarBarraResistencia(g, jugador.resistencia);
	}

}
