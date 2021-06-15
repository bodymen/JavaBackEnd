package com.flowers.main;

import com.flowers.excepcions.EmptyExcepcion;
import com.flowers.view.InputManager;

public class inici {

	public static void main(String[] args) throws EmptyExcepcion {
		// TODO Auto-generated method stub
		InputManager ui = new InputManager();
		ui.showMenu();
		ui.close();
	}

}
