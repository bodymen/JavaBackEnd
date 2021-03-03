package com.jobs.view;

import com.jobs.application.JobsControllerN3;
import com.jobs.error.SalariJuniorException;
import com.jobs.error.SalariMidException;
import com.jobs.error.SalariSeniorException;

public class Nivel3 {

	private static JobsControllerN3 controller = new JobsControllerN3();

	static void Process() throws Exception {
		
		int bonus=10;

		controller.createBossEmployeeN3("Pepe Boss", "Direcció molona", "666666666", 8000.0);
		controller.createManagerEmployeeN3("Pedro Manager", "Direcció molona 2", "665226666", 3000.0);
		controller.createSeniorEmployeeN3("Pedro Senior", "Direcció molona 2", "665266666", 2700.0);
		controller.createMidEmployeeN3("Laura Mid", "Direcció molona 3", "625266666", 1800.0);
		controller.createJuniorEmployeeN3("Laura Junior", "Direcció molona 3", "625266666", 900.0);
		controller.createVolunteerN3("Juan Volunteer", "Direcció molona 4", "614266666", 200);

		controller.payAllEmployeers();

		String allEmployees = controller.getAllEmployees();
		System.out.println("\nMEMBERS NIVELL3: \n" + allEmployees + " \n");
		
		controller.payBonus(bonus);
		System.out.println("\nMEMBERS NIVELL3 BONUS: \n" + controller.getAllEmployees() + " \n");

	}

}
