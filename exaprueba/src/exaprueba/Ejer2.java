package exaprueba;

import java.util.Scanner;

public class Ejer2 {

	public static void main(String[] args) {
		int numDia;
		String[] semana = { "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo" };
		Scanner sc = new Scanner(System.in);
		System.out.println("Que numero del dia de la semana es hoy?");
		numDia = sc.nextInt();
		System.out.println("Hoy es " + semana[numDia - 1]);

	}

}
