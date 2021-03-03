package com.jobs.domain.N2;

import com.jobs.contract.IPaymentRate;
import com.jobs.domain.Employee;
import com.jobs.error.SalariJuniorException;

public class Junior extends Employee{

	
	public Junior(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
		
		if(salaryPerMonth<900 || salaryPerMonth>1600)
			throw new SalariJuniorException("Salari ha d'estar entrer 900 i 1600");
	}

	@Override
	public String toString() {
		return "Junior [name=" + name + ", address=" + address + ", phone="
				+ phone + ", salaryPerMonth=" + salaryPerMonth + ", totalPaid=" + totalPaid + "]\n";
	}


}
