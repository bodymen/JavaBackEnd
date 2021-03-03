package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Boss;
import com.jobs.domain.Employee;
import com.jobs.domain.Manager;
import com.jobs.domain.Volunteer;
import com.jobs.domain.*;
import com.jobs.domain.N2.Junior;
import com.jobs.domain.N2.Mid;
import com.jobs.domain.N2.Senior;
import com.jobs.persistence.EmployeeRepository;
import com.jobs.persistence.EmployeeRepositoryN3;

public class JobsController {

	private EmployeeRepository repository;

	public JobsController() {
		repository = new EmployeeRepository();
	}

	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee boss = new Boss(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}

	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee emploee = new Employee(name, address, phone, salaryPerMonth,
				PaymentFactory.createPaymentRateEmployee());
		repository.addMember(emploee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth)
			throws Exception {
		Employee manager = new Manager(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);

	}

	public void createVolunteer(String name, String address, String phone, String description) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone, description);
		repository.addMember(volunteer);

	}

	public void createVolunteer(String name, String address, String phone) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone, "");
		repository.addMember(volunteer);

	}

	/***** N2 salaryPerMonth **/
	public void createManagerEmployeeN2(String name, String address, String phone, double salaryPerMonth)
			throws Exception {
		Employee manager = new com.jobs.domain.N2.Manager(name, address, phone, salaryPerMonth,
				PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);

	}

	public void createBossEmployeeN2(String name, String address, String phone, double salaryPerMonth)
			throws Exception {
		Employee boss = new com.jobs.domain.N2.Boss(name, address, phone, salaryPerMonth,
				PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}

	public void createMidEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee mid = new Mid(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateMidEmployee());
		repository.addMember(mid);

	}

	public void createSeniorEmployee(String name, String address, String phone, double salaryPerMonth)
			throws Exception {
		Employee senior = new Senior(name, address, phone, salaryPerMonth,
				PaymentFactory.createPaymentRateSeniorEmployee());
		repository.addMember(senior);

	}

	public void createJuniorEmployee(String name, String address, String phone, double salaryPerMonth)
			throws Exception {
		Employee junior = new Junior(name, address, phone, salaryPerMonth,
				PaymentFactory.createPaymentRateJuniorEmployee());
		repository.addMember(junior);

	}

	/***** N2 FIN **/


	public void payAllEmployeers() {
		for (AbsStaffMember m : repository.getAllMembers()) {
			m.pay();
		}

	}

	public String getAllEmployees() {
		return repository.getAllMembers().toString();
	}

	public void DeleteAllMember() throws Exception {
		repository.Delete();
	}

}
