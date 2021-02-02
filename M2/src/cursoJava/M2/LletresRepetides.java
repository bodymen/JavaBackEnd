package cursoJava.M2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class LletresRepetides {

	public static void main(String[] args) {

		Fase1();
		Fase2();
		Fase3();
		Fase4();

		Nivell2();
		Nivell3();

	}

	private static void Nivell3() {
		System.out.println("Nivell 3");

		int hour = 0, minutes = 0, seconds = 0;

		do {

			System.out.println(String.format("%02d", hour) + ':' + String.format("%02d", minutes) + ':'
					+ String.format("%02d", seconds));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (seconds == 59) {
				seconds = -1;
				minutes++;
			}

			//minutos los sumo antes, por tanto:
			if (minutes == 60) {
				minutes = 0;
				seconds=-1;
				hour++;
			}

			if (hour == 24) {
				hour = 0;
				minutes = 0;
				seconds = -1;
			}

			seconds++;

		} while (true);
	}

	private static void Nivell2() {
		System.out.println("Nivell 2");

		List<String> result = new ArrayList<String>();
		int numero = 0;

		// Scanner reader = new Scanner(System.in);
		// System.out.println("Introdueix un numero: " + "\n");
		// numero = reader.nextInt();

		numero = Integer.parseInt(JOptionPane.showInputDialog("Introdueix un numero: "));

		for (int i = 1; i < numero + 1; i++) {
			result.add(String.valueOf(i));
			System.out.println(result);
		}

		int numFilas = 0;
		// System.out.println("Introdueix un numero: " + "\n");
		// numFilas = reader.nextInt();
		numFilas = Integer.parseInt(JOptionPane.showInputDialog("Introdueix un numero de nivells: "));

		for (int numBlancos = 0,
				numAsteriscos = (numFilas * 2) - 1; numAsteriscos > 0; numBlancos++, numAsteriscos -= 2) {
			for (int i = 0; i < numBlancos; i++) {
				System.out.print(" ");
			}

			for (int j = numAsteriscos; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void Fase4() {
		System.out.println("FASE 4");

		List<Character> nom = Arrays.asList('A', 'N', 'T', 'O', 'N', 'I', 'O');

		List<Character> cognom = Arrays.asList('I', 'N', 'F', 'A', 'N', 'T', 'E');

		List<String> result = new ArrayList<String>();
		result.add(nom + "''" + cognom);

		System.out.println(result);
	}

	private static void Fase3() {

		System.out.println("FASE 3");

		List<Character> nomList = Arrays.asList('A', 'N', 'T', 'O', 'N', 'I', 'O');
		HashMap<Character, Integer> nomListAux = new HashMap<Character, Integer>();

		for (int i = 0; i < nomList.size(); i++) {
			var x = nomList.get(i);
			if (nomListAux.containsKey(x)) {
				int valor;
				valor = (int) nomListAux.get(x);
				nomListAux.put(x, valor + 1);
			} else
				nomListAux.put(x, 1);
		}
		System.out.println(nomList + " contiene:");
		System.out.println(nomListAux);

	}

	private static void Fase2() {
		System.out.println("FASE 2");
		List<Character> nomList = Arrays.asList('T', 'O', '3', 'N', 'I', '9');

		System.out.println(nomList + " contiene:");

		for (Character c : nomList) {
			if (Character.isDigit(c))
				System.out.println("Els noms de persones no contenen numeros! " + c);
			else {
				if (isVowel(c))
					System.out.println("LA VOCAL " + c);
				else
					System.out.println("LA CONSONANT " + c);
			}
		}
	}

	public static boolean isVowel(char c) {
		return "AEIOUaeiou".indexOf(c) != -1;
	}

	private static void Fase1() {
		System.out.println("FASE 1");
		char[] nom = { 'T', 'O', 'N', 'I' };
		for (char c : nom)
			System.out.println(c);
	}

}
