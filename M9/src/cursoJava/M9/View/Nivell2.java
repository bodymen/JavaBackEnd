package cursoJava.M9.View;

import cursoJava.M9.N1.Coet;

public class Nivell2 {

	static void Process() throws Exception {

		System.out.println("Milestone 2");

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
