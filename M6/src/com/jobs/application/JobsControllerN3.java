package com.jobs.application;

import com.jobs.persistence.EmployeeRepositoryN3;

import java.util.List;

import com.jobs.domain.N3.*;

public class JobsControllerN3 {

	private  EmployeeRepositoryN3 repositoryN3;

	public JobsControllerN3() {
		repositoryN3 = new EmployeeRepositoryN3();
	}

	/***** N3 salaryPerMonthBrut **/
	public void createManagerEmployeeN3(String name, String address, String phone, double salaryPerMonthBrut)
			throws Exception {
		Employee manager = new  Manager(name, address, phone, salaryPerMonthBrut,
				PaymentFactory.createPaymentRateManager());
		repositoryN3.addMember(manager);

	}

	public void createBossEmployeeN3(String name, String address, String phone, double salaryPerMonthBrut)
			throws Exception {
		Employee boss = new Boss(name, address, phone, salaryPerMonthBrut,
				PaymentFactory.createPaymentRateBoss());
		repositoryN3.addMember(boss);
	}

	public void createMidEmployeeN3(String name, String address, String phone, double salaryPerMonthBrut)
			throws Exception {
		Employee mid = new Mid(name, address, phone, salaryPerMonthBrut,
				PaymentFactory.createPaymentRateMidEmployee());
		repositoryN3.addMember(mid);

	}

	public void createSeniorEmployeeN3(String name, String address, String phone, double salaryPerMonthBrut)
			throws Exception {
		Employee senior = new Senior(name, address, phone, salaryPerMonthBrut,
				PaymentFactory.createPaymentRateSeniorEmployee());
		repositoryN3.addMember(senior);

	}

	public void createJuniorEmployeeN3(String name, String address, String phone, double salaryPerMonthBrut)
			throws Exception {
		Employee junior = new Junior(name, address, phone, salaryPerMonthBrut,
				PaymentFactory.createPaymentRateJuniorEmployee());
		repositoryN3.addMember(junior);

	}

	public void createVolunteerN3(String name, String address, String phone, double ajut) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone, ajut);
		repositoryN3.addMember(volunteer);

	}

	/***** N3 FIN **/

	public void payAllEmployeers() {
		for (AbsStaffMember m : repositoryN3.getAllMembers()) {
			m.payFromSalaryBrut();
		}
	}

	public String getAllEmployees() {
		return repositoryN3.getAllMembers().toString();
	}
	

	public void DeleteAllMember() throws Exception {
		repositoryN3.Delete();
	}

	public void payBonus(int bonus) {
		for (AbsStaffMember m : repositoryN3.getAllMembers()) {
			m.payBonus(bonus);
		}
	}

}
