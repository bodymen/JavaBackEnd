package com.jobs.domain.N2;

import com.jobs.contract.IPaymentRate;
import com.jobs.domain.Employee;
import com.jobs.error.SalariSeniorException;

public class Senior extends Employee {

	
	public Senior(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
		
		if(salaryPerMonth<2700 || salaryPerMonth>4000)
			throw new SalariSeniorException("Salari ha d'estar entre 2700 i 4000");
	}

	@Override
	public String toString() {
		return "Senior [name=" + name + ", address=" + address + ", phone="
				+ phone + ", salaryPerMonth=" + salaryPerMonth + ", totalPaid=" + totalPaid + "]\n";
	}


}
