package com.jobs.domain.N3;

import com.jobs.contract.IPaymentRate;
import com.jobs.domain.N3.Employee;
import com.jobs.error.SalariSeniorException;

public class Senior extends com.jobs.domain.N3.Employee {

	public Senior(String name, String address, String phone, double salaryPerMonthBrut, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonthBrut, paymentRate);
		
		if(salaryPerMonthBrut<2700 || salaryPerMonthBrut>4000)
			throw new SalariSeniorException("Salari ha d'estar entre 2700 i 4000");
		
		irpf=24;
	}

	@Override
	public String toString() {
		return "Senior [ name="+ name + ", address=" + address + ", phone=" + phone + "salaryPerMonthBrut=" + salaryPerMonthBrut + ", salaryPerYearBrut=" + salaryPerYearBrut 
				+ ", salaryPerMonth=" + totalPaid + ", salaryPerYear=" + totalPaidYear + ", bonus=" + totalbonus +"]\n";
	}

}
