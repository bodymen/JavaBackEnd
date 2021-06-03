package cursoJava.M10.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import cursoJava.M10.N1.InterficeFuncionalPi;
import cursoJava.M10.N1.InterficeFuncionalReserve;

public class Nivell1 {

	/***** FASE 1 *******/
	static void Fase1() throws Exception {

		System.out.println("Milestone 1 Fase 1");

		// Omple LLista Noms
		List<String> nomsPropis = getNameLIst();

		// Filtra A i 3 lletres. Imprimeixo per pantalla directament al mètode.
		System.out.println("**Lista comença per A Filtrada:");
		getFiltreAiTresLLetres(nomsPropis);

		// Filtra si es parell o senar i concatena e, o al davant
		System.out.println(
				"**Filtra si es parell o senar i concatena e, o al davant \n"  + get_EParell_OSenar().toString());

		// Filtra si conte "O". Retorno el valors
		System.out.println("**Lista O Filtrada: \n" + getLlistaQueConteO(nomsPropis).toString());

		// Filtra si conte "O" i 5 lletres, Retorno el valors
		System.out.println(
				"**Lista O amb 5 lletres Filtrada: \n" + getLlistaQueConteOICincLletres(nomsPropis).toString());

		// Omple LLista Noms
		List<String> mesos = getLlistaMesos();

		// Imprimeix valors.
		mesos.forEach(System.out::println);
		mesos.forEach(m -> System.out.print(m + " "));

	}

	private static String get_EParell_OSenar() {
		List<Integer> numeros = new ArrayList<Integer>();
		numeros = Arrays.asList(2, 3, 6, 7);
		return numeros.stream().map(n -> (n % 2 == 0) ? "e" + n : "o" + n).collect(Collectors.joining(","));
	}

	private static List<String> getLlistaMesos() {
		List<String> mesos = new ArrayList<String>(Arrays.asList("gener", "febre", "març", "abril", "maig", "juny",
				"juliol", "agost", "setembre", "octubre", "novembre", "desembre"));
		return mesos;
	}

	private static ArrayList<String> getNameLIst() {
		return new ArrayList<String>(
				Arrays.asList("Ana", "Pepe", "Juan", "Pedro", "Olga", "Maria", "Joan", "Victor", "Alex"));
	}

	private static List<String> getLlistaQueConteO(List<String> list) {

		return list.stream().filter(s -> s.contains("o")).collect(Collectors.toList());
	}

	private static List<String> getLlistaQueConteOICincLletres(List<String> list) {

		return list.stream().filter(s -> s.contains("o") && s.length() >= 5).collect(Collectors.toList());
	}

	private static void getFiltreAiTresLLetres(List<String> nomsPropis) {

		nomsPropis.stream().filter(s -> s.length() == 3 && s.toUpperCase().startsWith("A"))
				.forEach(System.out::println);
	}

	/***** FASE 2 ******/
	static void Fase2() throws Exception {

		System.out.println("\nMilestone 1 Fase 2");

		InterficeFuncionalPi pi = () -> 3.1415;
		System.out.println(pi.getPiValue());

	}

	/***** FASE 3 ******/
	static void Fase3() throws Exception {

		System.out.println("Milestone 1 Fase 3");

		InterficeFuncionalReserve r = (cadena) -> {
			
			int index = cadena.length();
			char[] result = new char[index];
		
			for (char c : cadena.toCharArray()) {
				index--;
				result[index] = c;
			}

			return String.valueOf(result);
		};
		
		System.out.println(r.reverse("Una masterClass sobre labmdas"));
	}

}
