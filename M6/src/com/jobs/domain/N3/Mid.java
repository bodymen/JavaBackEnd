package com.jobs.domain.N3;

import com.jobs.contract.IPaymentRate;
import com.jobs.domain.N3.Employee;
import com.jobs.error.SalariMidException;

public class Mid extends com.jobs.domain.N3.Employee{

	
	public Mid(String name, String address, String phone, double salaryPerMonthBrut, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonthBrut, paymentRate);
		
		if(salaryPerMonthBrut<1800 || salaryPerMonthBrut>2500)
			throw new SalariMidException("Salari ha d'estar entre 1800 i 2500");
		
		irpf=15;
	}

	@Override
	public String toString() {
		return "Mid [ name="+ name + ", address=" + address + ", phone=" + phone + "salaryPerMonthBrut=" + salaryPerMonthBrut + ", salaryPerYearBrut=" + salaryPerYearBrut 
				+ ", salaryPerMonth=" + totalPaid + ", salaryPerYear=" + totalPaidYear + ", bonus=" + totalbonus +"]\n";
	}

}
