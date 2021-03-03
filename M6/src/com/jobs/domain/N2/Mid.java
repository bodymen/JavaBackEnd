package com.jobs.domain.N2;

import com.jobs.contract.IPaymentRate;
import com.jobs.domain.Employee;
import com.jobs.error.SalariMidException;

public class Mid extends Employee{

	
	public Mid(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
		
		if(salaryPerMonth<1800 || salaryPerMonth>2500)
			throw new SalariMidException("Salari ha d'estar entre 1800 i 2500");
	}

	@Override
	public String toString() {
		return "Mid [name=" + name + ", address=" + address + ", phone=" + phone
				+ ", salaryPerMonth=" + salaryPerMonth + ",  totalPaid=" + totalPaid + "] \n";
	}


}
