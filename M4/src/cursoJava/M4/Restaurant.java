package cursoJava.M4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

public class Restaurant{ 

	public static void main(String[] args) {

		// nivell1();
		// nivell2();
		nivell3();
	}

	private static void nivell3(){
		double total = 0;

		HashMap<Integer, String> carta = new HashMap<Integer, String>();
		HashMap<Integer, Double> preus = new HashMap<Integer, Double>();

		ArrayList<String> menu = new ArrayList<String>();
		ArrayList<Double> preuPlat = new ArrayList<Double>();

		carta = inicialitzarMenu();
		preus = inicialitzarPreus();

		for (int i : carta.keySet()) {

			System.out.println("Plato " + i + ": " + carta.get(i) + "\t................. " + preus.get(i) + "€");
		}

		int plato = 0;
		do {
	        
			try {
				plato = Integer.parseInt(JOptionPane.showInputDialog("Introdueix el número de plat: "));
				if (plato != 0) {
					if (carta.get(plato) != null) {
						menu.add(carta.get(plato));
						preuPlat.add(preus.get(plato));
					}
					else 
						throw new PlatNoExisteixException(String.valueOf(plato)); 
				}
			}
			catch (PlatNoExisteixException e) {
				//Si el plato no existe
				System.out.println("\nError, aquest plat no existeix: " + e.getMessage());
			}
			catch (Exception e) {
				//Si quiere más platos, e introduce algo que no es un número.
				System.out.println("\nError, no es un nombre " + e.getMessage());
			}

		} while (plato != 0);

		for (Double preu : preuPlat) {
				total = total + preu;
		}

		System.out.println("\n" + "El preu de ticket es: " + total + "€");
		
		CalcularBillets(total);
	}

	private static void nivell2() {
		double total = 0;

		HashMap<Integer, String> carta = new HashMap<Integer, String>();
		HashMap<Integer, Double> preus = new HashMap<Integer, Double>();

		ArrayList<String> menu = new ArrayList<String>();
		ArrayList<Double> preuPlat = new ArrayList<Double>();

		carta = inicialitzarMenu();
		preus = inicialitzarPreus();

		for (int i : carta.keySet()) {

			System.out.println("Plato " + i + ": " + carta.get(i) + "\t................. " + preus.get(i) + "€");
		}

		int plato = 0;
		do {
	        
			try {
				plato = Integer.parseInt(JOptionPane.showInputDialog("Introdueix el número de plat: "));
				if (plato != 0) {
					if (carta.get(plato) != null) {
						menu.add(carta.get(plato));
						preuPlat.add(preus.get(plato));
					}
					else 
						throw new Exception(String.valueOf(plato)); 
				}
			}
			catch (Exception e) {
				//Si quiere más platos, e introduce algo que no es un número o el plato no existe.
				System.out.println("\nError, aquest plat no existeix: " + e.getMessage());
			}

		} while (plato != 0);

		for (Double preu : preuPlat) {
				total = total + preu;
		}

		System.out.println("\n" + "El preu de ticket es: " + total + "€");

		CalcularBillets(total);
	}

	private static void nivell1() {
		double total = 0;

		HashMap<Integer, String> carta = new HashMap<Integer, String>();
		HashMap<Integer, Double> preus = new HashMap<Integer, Double>();

		ArrayList<Integer> menu = new ArrayList<Integer>();

		carta = inicialitzarMenu();
		preus = inicialitzarPreus();

		/*
		 * for (Iterator it = carta.entrySet().iterator(); it.hasNext();) { String
		 * string = (String) it.next();
		 * 
		 * }
		 */

		// for (Map.Entry<Integer, String> entry : datos.entrySet()) {

		// carta.forEach((k, v) -> System.out.println("Key: " + k + ": Value: " + v));

		for (int i : carta.keySet()) {

			System.out.println("Plato " + i + ": " + carta.get(i) + "\t................. " + preus.get(i) + "€");
		}

		int plato = 0;
		do {
			try {
				plato = Integer.parseInt(JOptionPane.showInputDialog("Introdueix el número de plat: "));
				if (plato != 0)
					menu.add(plato);
			} catch (NumberFormatException e) {
				System.out.println("\n" + "Error introduint plats. La data no es un nombre");
			}

		} while (plato != 0);

		for (Integer p : menu) {
			if (carta.get(p) != null) {
				total = total + (preus.get(p));
			} else
				System.out.println("\nError, aquest plat no existeix: " + p);

		}

		System.out.println("\n" + "El preu de ticket es: " + total + "€");

		// prueba total= 520.30;
		CalcularBillets(total);

	}

	private static void CalcularBillets(double total) {

		int billet5 = 5, billet10 = 10, billet20 = 20, billet50 = 50, billet100 = 100, billet200 = 200, billet500 = 500;
		String result = "";
		int numBillets = 0;

		// Empieza por calcular la división entera entre la cantidad y 500 (el valor de
		// la mayor moneda): 434 entre 500 da 0, así que no hay billetes de 500 € en el
		// desglose; divide a continuación la cantidad 434 entre 200, cabe a 2 y sobran
		// 34, así que en el desglose hay 2 billetes de 200 €; dividimos a continuación
		// 34 entre 100 y vemos que no hay ningún billete de 100 € en el desglose (cabe
		// a 0); como el resto de la última división es 34, pasamos a dividir 34 entre
		// 20 y vemos que el desglose incluye un billete de 20 € y aún nos faltan 14 €
		// por desglosar. . . ).
		numBillets = (int) (total / billet500);
		if (numBillets > 0) {
			total = total - (billet500 * numBillets);
			result = "Billets de 50€: " + numBillets + "\n";
		}

		numBillets = (int) (total / billet200);
		if (numBillets > 0) {
			total = total - (billet200 * numBillets);
			result = result + "Billets de 200€: " + numBillets + "\n";
		}

		numBillets = (int) (total / billet100);
		if (numBillets > 0) {
			total = total - (billet100 * numBillets);
			result = result + "Billets de 100€: " + numBillets + "\n";
		}

		numBillets = (int) (total / billet50);
		if (numBillets > 0) {
			total = total - (billet50 * numBillets);
			result = result + "Billets de 50€: " + numBillets + "\n";
		}

		numBillets = (int) (total / billet20);
		if (numBillets > 0) {
			total = total - (billet20 * numBillets);
			result = result + "Billets de 20€: " + numBillets + "\n";
		}

		numBillets = (int) (total / billet10);
		if (numBillets > 0) {
			total = total - (billet10 * numBillets);
			result = result + "Billets de 10€: " + numBillets + "\n";
		}

		numBillets = (int) (total / billet5);
		if (numBillets > 0) {
			total = total - (billet5 * numBillets);
			result = result + "Billets de 5€: " + numBillets + "\n";
		}

		System.out.println(result + "Més " + total + " euros");

	}

	private static HashMap<Integer, String> inicialitzarMenu() {
		HashMap<Integer, String> carta = new HashMap<Integer, String>();

		carta.put(1, "Ensalada mixta");
		carta.put(2, "Gazpacho");
		carta.put(3, "Macarrones bolognesa");
		carta.put(4, "Canalones");
		carta.put(5, "Bistec con patatas");
		carta.put(6, "Dorada al Horno");
		carta.put(7, "Berenjena rellena");
		carta.put(8, "Bacalao a la llauna");
		carta.put(9, "Macedonia");
		carta.put(10, "Manzana al horno");
		carta.put(11, "Panacota");
		carta.put(12, "Flan de la casa");

		return carta;
	}

	private static HashMap<Integer, Double> inicialitzarPreus() {
		HashMap<Integer, Double> preus = new HashMap<Integer, Double>();

		// PRECIOS
		preus.put(1, 6.25);
		preus.put(2, 5.75);
		preus.put(3, 7.90);
		preus.put(4, 7.25);
		preus.put(5, 8.00);
		preus.put(6, 7.80);
		preus.put(7, 6.5);
		preus.put(8, 8.5);
		preus.put(9, 3.00);
		preus.put(10, 3.00);
		preus.put(11, 3.25);
		preus.put(12, 3.40);

		return preus;
	}

}
