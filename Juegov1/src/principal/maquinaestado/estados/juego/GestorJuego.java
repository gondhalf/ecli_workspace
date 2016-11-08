package principal.maquinaestado.estados.juego;

import java.awt.Color;
import java.awt.Graphics;

import principal.Constantes;
import principal.entes.Jugador;
import principal.interfaz_usuario.InterfazUsuario;
import principal.mapas.Mapa;
import principal.maquinaestado.EstadoJuego;

public class GestorJuego implements EstadoJuego {

	Mapa mapa = new Mapa(Constantes.RUTA_MAPA);
	Jugador jugador = new Jugador(0, 0, mapa);

	public void actualizar() {
		jugador.actualizar();
		mapa.actualizar((int) jugador.obtenerPosicionX(), (int) jugador.obtenerPosicionY());
	}

	public void dibujar(Graphics g) {
		mapa.dibujar(g, (int) jugador.obtenerPosicionX(), (int) jugador.obtenerPosicionY());
		jugador.dibujar(g);

		g.setColor(Color.RED);
		g.drawString("X = " + jugador.obtenerPosicionX(), 20, 20);
		g.drawString("Y = " + jugador.obtenerPosicionY(), 20, 30);

		InterfazUsuario.dibujarBarraResistencia(g, jugador.resistencia);
	}

}
