package com.jobs.domain;

import com.jobs.contract.IPaymentRate;

public class Boss extends Employee {

	private static int irpf=15;
	
	public Boss(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
	}
	
	@Override
	public String toString() {
		return "Boss [name=" + name + ", address=" + address + ", phone=" + phone
				+ ", salaryPerMonth=" + salaryPerMonth + ",  totalPaid=" + totalPaid + "] \n";
	}
	
	public static int getIrpf() {
		return irpf;
	}

}
