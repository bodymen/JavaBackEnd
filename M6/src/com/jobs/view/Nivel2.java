package com.jobs.view;

import com.jobs.application.JobsController;
import com.jobs.error.SalariBossException;
import com.jobs.error.SalariJuniorException;
import com.jobs.error.SalariManagerException;
import com.jobs.error.SalariMidException;
import com.jobs.error.SalariSeniorException;

public class Nivel2 {

	private static JobsController controller = new JobsController();

	static void Process() throws Exception {

		controller.createBossEmployeeN2("Pepe Boss", "Direcció molona", "666666666", 9000);
		controller.createManagerEmployeeN2("Pedro Manager", "Direcció molona 2", "665226666", 3000.0);
		controller.createSeniorEmployee("Pedro Senior", "Direcció molona 2", "665266666", 2700.0);
		controller.createMidEmployee("Laura Mid", "Direcció molona 3", "625266666", 1800.0);
		controller.createJuniorEmployee("Laura Mid", "Direcció molona 3", "625266666", 900.0);
		controller.createVolunteer("Juan Volunteer", "Direcció molona 4", "614266666");

		controller.payAllEmployeers();

		String allEmployees = controller.getAllEmployees();
		System.out.println("MEMBERS NIVELL2: \n" + allEmployees + " \n");

		controller.DeleteAllMember();
	}

	static void ProcessErrors() throws Exception {

		boolean errors = true;
		
		System.out.println("MEMBERS NIVELL2 ERRORS:");

		try {
			controller.createBossEmployeeN2("Pepe Boss", "Direcció molona", "666666666", 7000.0); // 8000
			controller.createManagerEmployeeN2("Pedro Manager", "Direcció molona 2", "665226666", 2900.0); // 3000
			controller.createSeniorEmployee("Pedro Senior", "Direcció molona 2", "665266666", 2600.0); // 2700
			controller.createMidEmployee("Laura Mid", "Direcció molona 3", "625266666", 1700.0); // 1800
			controller.createJuniorEmployee("Laura Mid", "Direcció molona 3", "625266666", 800.0); // 900
			// No necessiten controlar Exception, pq no té ni constructor ni metode que
			// inclogui o calculi salari. Per mi no és un Empleat.
			controller.createVolunteer("Juan Volunteer", "Direcció molona 4", "614266666");

			controller.payAllEmployeers();
		} catch (SalariManagerException ex) {
			System.out.println(ex.getMessage());
			errors = true;
		} catch (SalariBossException ex) {
			System.out.println(ex.getMessage());
			errors = true;
		} catch (SalariJuniorException ex) {
			System.out.println(ex.getMessage());
			errors = true;
		} catch (SalariMidException ex) {
			System.out.println(ex.getMessage());
			errors = true;
		} catch (SalariSeniorException ex) {
			System.out.println(ex.getMessage());
			errors = true;
		}

		if (!errors) {
			String allEmployees = controller.getAllEmployees();
			System.out.println("\n" + allEmployees + " \n");

		controller.DeleteAllMember();
		}
	}
}
