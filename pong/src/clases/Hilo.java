package clases;

//clase encargada de mover la pelota y las raquetas. HILO DE EJECUCION 1
public class Hilo extends Thread {
	TableroJuego lamina;

	public Hilo(TableroJuego lamina) {
		this.lamina = lamina;
	}

	// sobreescribimos el metodo run
	public void run() {
		// mientras sea verdad redibujara en el tablero de juego o JPanel
		while (true) {
			// utilizamos sleep() para controlar la velocidad de redibujado a 2
			// milisegundos. Nos obliga a rodearlo de un try/catch
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lamina.repaint();// redibujar lamina
		}
	}
}
