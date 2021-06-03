package cursoJava.M10.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;

import cursoJava.M10.N2.InterficeFuncionalOperacio;
import cursoJava.M10.N3.Alumne;

public class Nivell3 {

	static void Process() throws Exception {

		System.out.println("Milestone 3");

		List<Alumne> alumnes = getAlumnes();
		System.out.println((alumnes));
		
		System.out.println("Mostra Nom i edat");
		alumnes.forEach(m -> System.out.println(m.getNom() + " edat:" + m.getEdat()));

		System.out.println("Nom comença per A");
		alumnes.stream().filter(m -> m.getNom().toLowerCase().startsWith("a"))
		.forEach(System.out::println);
		
		System.out.println("Mes de un 5");
		alumnes.stream().filter(m -> m.getNota()>5.0).forEach(System.out::println);
		
		System.out.println("Mes de un 5 i no PHP");
		alumnes.stream().filter(m -> m.getNota()>5.0 && !m.getCurs().equals("PHP"))
		.forEach(System.out::println);
		
		
	}
	
	private static List<Alumne> getAlumnes() {
		List<Alumne> list = new ArrayList<Alumne>();
		
		for (int i=1; i<11 ; i++)
		{
			
			//***	FAker API doesnt work!! **//
//			Faker faker= new Faker();
//
//			String name = faker.name().fullName();
//			String firstName = faker.name().firstName();
//			String lastName = faker.name().lastName();

			Alumne a = new Alumne("PEPE"+i, i+20, "Curso"+i, (float) (i+3.5));
			list.add(a);
		}
		
		list.get(2).setNom("ALEJANDRO");
		list.get(6).setNom("ALAIN");
		list.get(8).setNom("ALBERTO");
		list.get(5).setCurs("PHP");
		list.get(9).setCurs("PHP");
		return list;
	}
	

	//RANDOM STRINGS.. NOT FOR REAL NAMES	
	final static String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	final static java.util.Random rand = new java.util.Random();

	final static Set<String> identifiers = new HashSet<String>();

	public static String randomIdentifier() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
}