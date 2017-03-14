package exaprueba;

import java.util.Scanner;

public class Ejer3 {

	public static void main(String[] args) {

		double nota = 0;
		double media = 0;
		int numNotas = 0;
		Scanner sc = new Scanner(System.in);

		while (nota >= 0) {
			System.out.println("Dame una nota: ");
			nota = sc.nextDouble();
			if (nota >= 0 && nota <= 10) {
				media = media + nota;
				numNotas++;
			} else {
				double mediaT = media / numNotas;
				if (mediaT < 5) {
					System.out.println("Tienes un INSUFIECIENTE ya que tu media es de " + mediaT);
				} else if (mediaT < 6) {
					System.out.println("Tienes un SUFIECIENTE ya que tu media es de " + mediaT);
				} else if (mediaT < 7) {
					System.out.println("Tienes un BIEN ya que tu media es de " + mediaT);
				} else if (mediaT < 9) {
					System.out.println("Tienes un NOTABLE ya que tu media es de " + mediaT);
				} else {
					System.out.println("Tienes un SOBRESALIENTE ya que tu media es de " + mediaT);
				}
			}
		}

	}

}
