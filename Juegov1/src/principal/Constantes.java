package principal;

public class Constantes {

	public static final int LADO_SPRITE = 32;

	public static int ANCHO_JUEGO = 640;
	public static int ALTO_JUEGO = 360;

	public static int ANCHO_PANTALLA_COMPLETA = 1920;
	public static int ALTO_PANTALLA_COMPLETA = 1080;

	public static double FACTOR_ESCALADO_X = (double) ANCHO_PANTALLA_COMPLETA / (double) ANCHO_JUEGO;
	public static double FACTOR_ESCALADO_Y = (double) ALTO_PANTALLA_COMPLETA / (double) ALTO_JUEGO;

	public static int CENTRO_VENTANA_X = ANCHO_JUEGO / 2;
	public static int CENTRO_VENTANA_Y = ALTO_JUEGO / 2;

	public static String RUTA_MAPA = "/texto/prueba.map";
	public static String RUTA_MAPA2 = "/texto/prueba2.map";
	public static String RUTA_ICONO_RATON = "/imagenes/icono/iconocursor.png";
	public static String RUTA_PERSONAJE = "/imagenes/hojasPersonajes/goku_mapa.png";
	public static String RUTA_ICONO_VENTANA = "/imagenes/icono/iconoventana.png";

}
