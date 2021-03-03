package com.jobs.domain.N3;

import com.jobs.contract.IPaymentRate;
import com.jobs.domain.N3.Employee;
import com.jobs.error.SalariBossException;

public class Boss extends com.jobs.domain.N3.Employee {

	public Boss(String name, String address, String phone, double salaryPerMonthBrut, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonthBrut, paymentRate);
		
		if(salaryPerMonthBrut<8000)
			throw new SalariBossException("Salari ha de ser més de 8000");
		
		irpf=32;

	}
	@Override
	public String toString() {
		return "Boss [ name="+ name + ", address=" + address + ", phone=" + phone + ", salaryPerMonthBrut=" + salaryPerMonthBrut + ", salaryPerYearBrut=" + salaryPerYearBrut 
				+ ", salaryPerMonth=" + totalPaid + ", salaryPerYearBrut=" + totalPaidYear + ", bonus=" + totalbonus +"]\n";
	}
	

}
