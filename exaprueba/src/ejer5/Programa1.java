package ejer5;

public class Programa1 {

	public static void main(String[] args) {
		Cancion1 cancion1 = new Cancion1("Trolorolo");
		Cancion1 cancion2 = new Cancion1("Makarena");
		cancion1.addEstilo("rock");
		cancion1.addEstilo("pop");
		cancion1.getEstilo();

	}

}
