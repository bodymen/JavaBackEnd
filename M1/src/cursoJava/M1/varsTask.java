package cursoJava.M1;

import java.util.Arrays;
import java.util.GregorianCalendar;

public class varsTask {

	public static void main(String[] args) {

		Fase1();
		Fase2();
		Fase3(); 
		Fase4();

		Nivel2();
		Nivel3(); 

	}

	private static void Nivel3() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int i;

		System.out.println(Arrays.toString(nums));

		for (int x = 0; x < nums.length-1; x++) {
			int j = nums[0];
			for (i = 0; i < nums.length - 1; i++) {
				nums[i] = nums[i + 1];
			}
			nums[i] = j;
			System.out.println(Arrays.toString(nums));
		}
	}

	private static void Nivel2() {

		double numero = 9.9999d;
		int numeroInt = (int) numero;
		float numeroFloat = (float) numero;
		String numeroString = Double.toString(numero);

		System.out.println("double " + numero);
		System.out.println("int " + numeroInt);
		System.out.println("float " + numeroFloat);
		System.out.println("String " + numeroString);
	}

	private static void Fase4() {
		String nom = "Antonio";
		String cognom1 = "Infante";
		String cognom2 = "Cabrera";
		int dia = 3;
		int mes = 5;
		int any = 1977;

		String nomComplet = "El meu nom és " + nom + " " + cognom1 + " " + cognom2;
		String dataNaixement = "Vaig néixer el " + dia + "/" + mes + "/" + any;

		System.out.println(nomComplet);
		System.out.println(dataNaixement);
	}

	private static void Fase3() {
		final int any = 1948;
		final int anyBirthday = 1977;
		String anyTrue = "El meu any és de traspàs ";
		String anyFalse = "El meu any NO és de traspàs ";
		boolean isAnyDeTraspas = false;

		GregorianCalendar calendar = new GregorianCalendar();

		for (int i = any; i <= anyBirthday; i++) {
			if (calendar.isLeapYear(i)) {
				System.out.println("Any de Trapàs" + i);
				if (i == (int) anyBirthday)
					isAnyDeTraspas = true;
			}
		}

		if (isAnyDeTraspas)
			System.out.println(anyTrue + anyBirthday);
		else
			System.out.println(anyFalse + anyBirthday);
	}

	private static void Fase2() {
		final int any = 1948;
		final int anyBirthday = 1977;
		int anyTraspas = 0;
		GregorianCalendar calendar = new GregorianCalendar();

		for (int i = any; i <= anyBirthday; i++) {
			if (calendar.isLeapYear(i)) {
				anyTraspas++;
			}
		}

		System.out.println("Anys de diferència " + anyTraspas);
	}

	private static void Fase1() {
		String nom = "Antonio";
		String cognom1 = "Infante";
		String cognom2 = "Cabrera";
		int dia = 3;
		int mes = 5;
		int any = 1977;

		System.out.println("El meu nom: " + cognom1 + " " + cognom2 + " " + nom);
		System.out.println("Data de naixement " + dia + "/" + mes + "/" + any);
	}

}
