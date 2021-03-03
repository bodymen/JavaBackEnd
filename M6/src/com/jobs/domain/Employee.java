package com.jobs.domain;

import com.jobs.contract.IPaymentRate;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
			
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salaryPerMonth=" + salaryPerMonth + ", address=" + address + ", phone=" + phone + ", totalPaid=" + totalPaid + "]\n";
	}

	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}

}
