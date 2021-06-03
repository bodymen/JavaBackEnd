package cursoJava.M10.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Comparator;

import cursoJava.M10.N2.InterficeFuncionalOperacio;

public class Nivell2 {

	static void Process() throws Exception {

		System.out.println("Milestone 2");

		List<String> list = Arrays.asList(getCadenesTextNumeros());
		System.out.println("ORIGINAL LIST \n" + list);

		// Ordenat longitud de major a menor
		Collections.sort(list, (s1, s2) -> s2.length() - s1.length());
		System.out.println("major a menor \n" + list);

		// Ordenat longitud de menor a major
		Collections.sort(list, (s1, s2) -> s1.length() - s2.length());
		System.out.println("menor a major \n" + list);

		// Ordenat alfabeticament
		// Collections.sort(list);
		list.stream().sorted();
		System.out.println("SORTED \n" + list);

		// Ordenat alfabeticament inversa
		System.out.println("SORTED INVERSE");
		// Collections.reverse(list);
		list.stream().sorted(Comparator.reverseOrder())
				// .forEach(System.out::print);
				.forEach(m -> System.out.print(m + ", "));

		// Les cadenes que contenen "e" primer, tota la resta en segon lloc
		System.out.println("\nLLISTA contenen \"e\" primer, tota la resta en segon lloc");
		GetPriorityE(list, "e");

		// Canviar els caracters “a” a “4”
		System.out.println("\nCanviar els caracters a a 4");
		list.stream().map(v -> v.replace("a", "4")).forEach(m -> System.out.print(m + ", "));
		
		
		// només els elements que siguin 100% numerics
		System.out.println("\nLLISTA només els elements que siguin 100% numerics");
		String exprNumeros = "[0123456789]+";
		list.stream().filter(v -> v.matches(exprNumeros)).forEach(System.out::println);

		// No té parametres???
		System.out.println("\nInterficeFuncionalOperacio ");
		InterficeFuncionalOperacio op;
		op = () -> {
			return (2 + 2.5f);
		};
		System.out.println(op.operacio());

		op = () -> {
			return (2 - 2.5f);
		};
		System.out.println(op.operacio());

		op = () -> {
			return (2 * 2.5f);
		};
		System.out.println(op.operacio());

		op = () -> {
			return (2 / 2.5f);
		};
		System.out.println(op.operacio());

	}

	private static void GetPriorityE(List<String> llista, String priority) {
		llista.stream().sorted(Comparator.comparing((String v) -> v.toLowerCase().contains(priority)).reversed())
				.forEach(System.out::println);

	}

	private static String[] getCadenesTextNumeros() {
		return new String[] { "gener", "1", "febrer", "2", "març", "3", "abril", "4", "maig", "5", "juny", "6",
				"juliol", "7", "agost", "8", "setembre", "9", "octubre", "10", "novembre", "11", "desembre", "12" };
	}
}

/**********************
 * * NOTAS **********************
 * 
 * 
 * // Optional<String> reduced = list.stream().reduce((s1, s2) -> s1 + "#" +
 * s2); // System.out.println(reduced);
 * 
 * // List<Integer> listOfIntegers = //
 * list.stream().map(Integer::valueOf).collect(Collectors.toList());
 * 
 * // list.stream().filter(i -> Integer.parseInt(i) % 2 == 0) //
 * .map(Integer::valueOf) // list.stream().map(Nivell1::FilterNumber);
 * 
 * // .map(String::toUpperCase) // .filter(i -> Integer.parseInt(i) % 2 != 0) //
 * .forEach(m -> System.out.print(m + " ")); // stream.filter(i -> i%2 ==
 * 0).toArray(Integer[]::new); // System.out.println(listOfIntegers);
 * 
 * // Custom comparator // Comparator<? super String> reverseComparator = new
 * Comparator<String>() { // // public String comparar(String i1, String i2) {
 * // // return "null"; // } // // @Override // public int compare(String o1,
 * String o2) { // // TODO Auto-generated method stub // return 0; // } // }; //
 * // List<String> sortedList =
 * list.stream().sorted(reverseComparator).collect(Collectors.toList());
 * //System.out.println(sortedList);
 * 
 * SORT //Por un clase.campo
 * list.stream().sorted(Comparator.comparing(ClassName::getFieldName).reversed()).collect(Collectors.toList());
 * 
 * // sort list.sort(naturalOrder())
 * 
 * // sort (reversed) list.sort(reverseOrder())
 * 
 * // sort by field list.sort(comparing(Type::getField))
 * 
 * // sort by field (reversed) list.sort(comparing(Type::getField).reversed())
 * 
 * // sort by int field list.sort(comparingInt(Type::getIntField))
 * 
 * // sort by double field (reversed)
 * list.sort(comparingDouble(Type::getDoubleField).reversed())
 * 
 * // sort by nullable field (nulls last)
 * list.sort(comparing(Type::getNullableField, nullsLast(naturalOrder())))
 * 
 * // two-level sort
 * list.sort(comparing(Type::getField1).thenComparing(Type::getField2))
 * 
 * 
 * // https://howtodoinjava.com/java8/java-streams-by-examples/ //
 * .map(String::toUpperCase)
 ***************/
