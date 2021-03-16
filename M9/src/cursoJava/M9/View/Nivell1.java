package cursoJava.M9.View;

import cursoJava.M9.N1.Coet;

public class Nivell1 {


	static void Fase1() throws Exception {

		System.out.println("Milestone 1 Fase 1");

		try {

			Coet coet = new Coet("X", 3);
			Coet coet2 = new Coet("LDSFJA32", 6);

			System.out.println(coet.toString());
			System.out.println(coet2.toString());

		} catch (

		Exception ex) {
			System.out.println("ERROR " + ex.getMessage());
			System.exit(0);
		}

	}

	static void Fase2() throws Exception {

		System.out.println("Milestone 1 Fase 2");

		try {

			Coet coet = new Coet("32WESSDS", 3);
			Coet coet2 = new Coet("LDSFJA32", 6);

			int[] potencia1 = { 10, 30, 80 };

			coet.setPotencia(potencia1);

			int[] potencia2 = { 30, 40, 50, 50, 30, 10 };

			coet2.setPotencia(potencia2);

			System.out.println(coet.toStringF2());
			System.out.println(coet2.toStringF2());

		} catch (

		Exception ex) {
			System.out.println("ERROR " + ex.getMessage());
			System.exit(0);
		}

	}

	static void Fase3() throws Exception {

		System.out.println("Milestone 1 Fase 3");

		try {

			int[] potencia1 = { 1, 3, 2 };
			int[] potencia2 = { 3, 4, 5, 5, 3, 1 };
			Coet coet = new Coet("32WESSDS", 3, potencia1);
			Coet coet2 = new Coet("LDSFJA32", 6, potencia2);

			Thread c1 = new Thread(coet);
			Thread c2 = new Thread(coet2);
			c1.start();
			c2.start();
			Thread.sleep(2000);
			
			coet.accelerar();
			coet.accelerar();
			
			coet.accelerar();
			coet.accelerar();
			
			coet2.accelerar();
			coet2.accelerar();
			coet2.accelerar();
			
			coet.frenar();
			coet2.frenar();
			coet.frenar();
			coet.frenar();
			coet.frenar();

		} catch (

		Exception ex) {
			System.out.println("ERROR " + ex.getMessage());
			System.exit(0);
		}

	}
}
