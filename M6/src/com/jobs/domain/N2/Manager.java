package com.jobs.domain.N2;

import com.jobs.contract.IPaymentRate;
import com.jobs.domain.Employee;
import com.jobs.error.SalariMidException;

public class Manager extends Employee {
	

	public Manager(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
		
		if(salaryPerMonth<3000 || salaryPerMonth>5000)
			throw new SalariMidException("Salari ha d'estar entre 3000 i 5000");

	}
	
	@Override
	public String toString() {
		return "Manager [name=" + name + ", address=" + address + ", phone=" + phone
				+ ", salaryPerMonth=" + salaryPerMonth + ",  totalPaid=" + totalPaid + "]\n";
	}
	

}
