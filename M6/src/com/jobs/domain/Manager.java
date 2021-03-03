package com.jobs.domain;

import com.jobs.contract.IPaymentRate;

public class Manager extends Employee {
	
	private static int irpf=15;

	public Manager(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
	}
	
	@Override
	public String toString() {
		return "Manager [name=" + name + ", address=" + address + ", phone=" + phone
				+ ", salaryPerMonth=" + salaryPerMonth + ",  totalPaid=" + totalPaid + "]\n";
	}
	
	public static int getIrpf() {
		return irpf;
	}

}
