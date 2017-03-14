package exaprueba;

import java.util.Scanner;

public class Ejer1 {

	public static void main(String[] args) {
		int nacimiento;
		String nombre;
		int añoActual = 2016;

		Scanner sc = new Scanner(System.in);

		System.out.println("Como te llamas?");
		nombre = sc.nextLine();
		System.out.println("En que año nacistes?");
		nacimiento = sc.nextInt();
		System.out.println(nombre + " tienes " + (añoActual - nacimiento) + " años");

	}

}
