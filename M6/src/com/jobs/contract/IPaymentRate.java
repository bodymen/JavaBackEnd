package com.jobs.contract;

public interface IPaymentRate {
	
	public double pay(double salaryPerMonth);
	
	public double payFromSalaryBrut(double salaryBrut, int irpf);

	public double payBonus(double salaryPerYearBrut, int bonus);
	
}
