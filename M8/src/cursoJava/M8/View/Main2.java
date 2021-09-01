package cursoJava.M8.View;

import javax.swing.JOptionPane;


public class Main2 {

	public static void main(String[] args) throws Exception {
		
		String telefono = JOptionPane.showInputDialog("Introduce un telefono");
		
		
		IsCorrectFormat(telefono);
		
		IsLocalFormat(telefono);
		
		
		//Nivell1.Process();
		
		//Nivell2.Process();
		
		Nivell3.Process();
		
		//Nivell3Thread_.Process();

	}

	private static String IsLocalFormat(String telefono) {
		
	
		if (telefono.substring(1, 1).equals("+") || telefono.substring(1, 2).equals("00"))
			return "Internacional";
		else
			return "Nacional";
		
	}

	private static void IsCorrectFormat(String telefono) {
		// TODO Auto-generated method stub
		
	}

}
