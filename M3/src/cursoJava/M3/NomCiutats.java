package cursoJava.M3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class NomCiutats {

	public static void main(String[] args) {

		// nivell1();
		// nivell2();
		nivell3();

	}

	private static void nivell3() {

		Scanner sc = new Scanner(System.in);
		int repes = 0;
		int num1 = 0, num2 = 1, suma =1;
		String cadena = "";
		
		System.out.println("Introdueix un nombre " + "\n");
		repes= sc.nextInt();
		
		cadena = 0 + ", ";
         
        for (int i = 1; i < repes; i++) {
             
        	cadena = cadena + (suma) + ", ";
            //primero sumamos
            suma = num1 + num2;
            //Despues, cambiamos la segunda variable por la primera
            num1 = num2;
            //Por ultimo, cambiamos la suma por la segunda variable
            num2 = suma;
        }
        
        System.out.println("La seqüència Fibonacci és:");
        cadena = cadena.substring(0, cadena.length() - 2);
		System.out.println(cadena);
	}


	private static void nivell2() {

		String[][] alumneNotes = new String[5][3];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.println("Introdueix notes per l'alumne: " + (i + 1) + "\n");

			for (int j = 0; j < 3; j++) {
				System.out.println("Introdueix la nota: " + (j + 1) + "\n");
				alumneNotes[i][j] = sc.nextLine();
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("Alumne: " + (i + 1) + "\n");
			double sum = 0;

			for (int j = 0; j < 3; j++) {
				System.out.println("Nota: " + alumneNotes[i][j] + "\n");

				try {
					sum = sum + Double.parseDouble(alumneNotes[i][j]);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}

			System.out.println("La Nota total és: " + sum + ", i la media és: " + (sum / 3));
			if ((sum / 3) >= 5d)
				System.out.println("L'alumne a aprovat" + "\n");
			else
				System.out.println("L'alumne a suspès" + "\n");
		}

	}

	private static void nivell1() {
		// fase1();
		// fase2();
		// fase3();
		fase4();
	}

	private static void fase4() {

		String ciudad1, ciudad2, ciudad3, ciudad4, ciudad5, ciudad6;

		ciudad1 = (JOptionPane.showInputDialog("Introdueix una ciutat: "));
		ciudad2 = (JOptionPane.showInputDialog("Introdueix una ciutat: "));
		ciudad3 = (JOptionPane.showInputDialog("Introdueix una ciutat: "));
		ciudad4 = (JOptionPane.showInputDialog("Introdueix una ciutat: "));
		ciudad5 = (JOptionPane.showInputDialog("Introdueix una ciutat: "));
		ciudad6 = (JOptionPane.showInputDialog("Introdueix una ciutat: "));

		char[] ciutatsArray1 = omplirArray(ciudad1);
		char[] ciutatsArray2 = omplirArray(ciudad2);
		char[] ciutatsArray3 = omplirArray(ciudad3);
		char[] ciutatsArray4 = omplirArray(ciudad4);
		char[] ciutatsArray5 = omplirArray(ciudad5);
		char[] ciutatsArray6 = omplirArray(ciudad6);

		invertirArray(ciutatsArray1);
		invertirArray(ciutatsArray2);
		invertirArray(ciutatsArray3);
		invertirArray(ciutatsArray4);
		invertirArray(ciutatsArray5);
		invertirArray(ciutatsArray6);

	}

	private static void invertirArray(char[] array) {

		visualitzar(array);

		char[] invertido = new char[array.length];
		for (int i = 0; i < array.length; i++) {
			invertido[i] = array[array.length - 1 - i];
		}
		visualitzar(invertido);

//      char aux;
//      for (int i=0; i<ciutats.length/2; i++) {
//          aux = ciutats[i];
//          ciutats[i] = ciutats[ciutats.length-1-i];
//          ciutats[ciutats.length-1-i] = aux;
//      }
	}

	private static char[] omplirArray(String ciutat) {

		char[] array = new char[ciutat.length()];
		for (int i = 0; i < array.length; i++) {
			array[i] = ciutat.charAt(i);
		}

		return array;
	}

	private static void visualitzar(char[] array) {
		String cadena = "Array: ";
		for (int i = 0; i < array.length; i++) {
			cadena += array[i] + ", ";
		}
		cadena = cadena.substring(0, cadena.length() - 2);
		System.out.println(cadena);
	}

	private static void fase3() {
		ArrayList<String> ciutats = new ArrayList<String>();
		ArrayList<String> arrayCiutatsModificades = new ArrayList<String>();

		ciutats.add((JOptionPane.showInputDialog("Introdueix un ciutat: ")));
		ciutats.add((JOptionPane.showInputDialog("Introdueix un ciutat: ")));
		ciutats.add((JOptionPane.showInputDialog("Introdueix un ciutat: ")));
		ciutats.add((JOptionPane.showInputDialog("Introdueix un ciutat: ")));
		ciutats.add((JOptionPane.showInputDialog("Introdueix un ciutat: ")));
		ciutats.add((JOptionPane.showInputDialog("Introdueix un ciutat: ")));

		for (String i : ciutats) {
			String ciutat = i;
			arrayCiutatsModificades.add(ciutat.replace("a", "4"));
		}

		Collections.sort(arrayCiutatsModificades);

		System.out.println(arrayCiutatsModificades);
	}

	private static void fase2() {
		ArrayList<String> ciutats = new ArrayList<String>();

		ciutats.add((JOptionPane.showInputDialog("Introdueix un ciutat: ")));
		ciutats.add((JOptionPane.showInputDialog("Introdueix un ciutat: ")));
		ciutats.add((JOptionPane.showInputDialog("Introdueix un ciutat: ")));
		ciutats.add((JOptionPane.showInputDialog("Introdueix un ciutat: ")));
		ciutats.add((JOptionPane.showInputDialog("Introdueix un ciutat: ")));
		ciutats.add((JOptionPane.showInputDialog("Introdueix un ciutat: ")));

		for (String i : ciutats) {
			System.out.println(i);
		}

	}

	private static void fase1() {
		String ciudad1, ciudad2, ciudad3, ciudad4, ciudad5, ciudad6;

		ciudad1 = (JOptionPane.showInputDialog("Introdueix un ciutat: "));
		ciudad2 = (JOptionPane.showInputDialog("Introdueix un ciutat: "));
		ciudad3 = (JOptionPane.showInputDialog("Introdueix un ciutat: "));
		ciudad4 = (JOptionPane.showInputDialog("Introdueix un ciutat: "));
		ciudad5 = (JOptionPane.showInputDialog("Introdueix un ciutat: "));
		ciudad6 = (JOptionPane.showInputDialog("Introdueix un ciutat: "));

		System.out.println(ciudad1);
		System.out.println(ciudad2);
		System.out.println(ciudad3);
		System.out.println(ciudad4);
		System.out.println(ciudad5);
		System.out.println(ciudad6);

	}

}
