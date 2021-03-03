package com.jobs.domain.N3;

import com.jobs.contract.IPaymentRate;
import com.jobs.domain.N3.Employee;
import com.jobs.error.SalariJuniorException;

public class Junior extends com.jobs.domain.N3.Employee{

	
	public Junior(String name, String address, String phone, double salaryPerMonthBrut, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonthBrut, paymentRate);
		
		if(salaryPerMonthBrut<900 || salaryPerMonthBrut>1600)
			throw new SalariJuniorException("Salari ha d'estar entrer 900 i 1600");
		
		irpf=2;
	}

	@Override
	public String toString() {
		return "Junior [ name="+ name + ", address=" + address + ", phone=" + phone + ", salaryPerMonthBrut=" + salaryPerMonthBrut + ", salaryPerYearBrut=" + salaryPerYearBrut 
				+ ", salaryPerMonth=" + totalPaid + ", salaryPerYear=" + totalPaidYear + ", bonus=" + totalbonus +"]\n";
	}

}
