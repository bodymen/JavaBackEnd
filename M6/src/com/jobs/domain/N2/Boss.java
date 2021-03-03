package com.jobs.domain.N2;

import com.jobs.contract.IPaymentRate;
import com.jobs.domain.Employee;
import com.jobs.error.SalariBossException;

public class Boss extends Employee {

	
	public Boss(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
		
		if(salaryPerMonth<8000)
			throw new SalariBossException("Salari ha de ser més de 8000");

	}
	
	@Override
	public String toString() {
		return "Boss [name=" + name + ", address=" + address + ", phone=" + phone
				+ ", salaryPerMonth=" + salaryPerMonth + ",  totalPaid=" + totalPaid + "]\n";
	}
	


}
