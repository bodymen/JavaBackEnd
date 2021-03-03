package com.jobs.domain.N3;

import com.jobs.contract.IPaymentRate;
import com.jobs.domain.N3.Employee;
import com.jobs.error.SalariMidException;

public class Manager extends com.jobs.domain.N3.Employee {
	

	public Manager(String name, String address, String phone, double salaryPerMonthBrut, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonthBrut, paymentRate);
		
		if(salaryPerMonthBrut<3000 || salaryPerMonthBrut>5000)
			throw new SalariMidException("Salari ha d'estar entre 3000 i 5000");
		
		irpf=26;
	}
	
	@Override
	public String toString() {
		return "Manager [ name="+ name + ", address=" + address + ", phone=" + phone + ", salaryPerMonthBrut=" + salaryPerMonthBrut + ", salaryPerYearBrut=" + salaryPerYearBrut 
				+ ", salaryPerMonth=" + totalPaid + ", salaryPerYear=" + totalPaidYear + ", bonus=" + totalbonus +"]\n";
	}
	
}
