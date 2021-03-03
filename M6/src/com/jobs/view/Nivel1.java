package com.jobs.view;

import com.jobs.application.JobsController;

public class Nivel1 {

	private static JobsController controller = new JobsController();

	static void Process() throws Exception {

		controller.createBossEmployee("Pepe Boss", "Direcci� molona", "666666666", 100.0);
		controller.createEmployee("Pedro Employee", "Direcci� molona 2", "665266666", 40.0);
		controller.createEmployee("Laura Employee", "Direcci� molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Direcci� molona 4", "614266666");
		controller.createManagerEmployee("Pedro Employee", "Direcci� molona 2", "665226666", 80.0);

		controller.payAllEmployeers();

		String allEmployees = controller.getAllEmployees();
		System.out.println("MEMBERS NIVELL1: \n" + allEmployees + " \n");
		
		controller.DeleteAllMember();
	}
}
