package com.jobs.domain.N3;

import com.jobs.contract.IPaymentRate;

public class Employee extends com.jobs.domain.N3.AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	
	
	protected double salaryPerMonthBrut;
	protected double salaryPerYear;
	protected double salaryPerYearBrut;
	
	protected static int irpf;
	protected double totalbonus=0;

	public Employee(String name, String address, String phone, double salaryPerMonthBrut,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		
		if(salaryPerMonthBrut<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
			
		this.salaryPerMonthBrut=salaryPerMonthBrut;
		this.salaryPerYearBrut=salaryPerMonthBrut*12;
		this.paymentRate=paymentRate;
	}

	
	@Override
	public String toString() {
			return "Employee [ name="+ name + ", address=" + address + ", phone=" + phone + ", salaryPerMonthBrut=" + salaryPerMonthBrut + ", salaryPerYearBrut=" + salaryPerYearBrut 
					+ "salaryPerMonth=" + totalPaid + ", salaryPerYear=" + totalPaidYear + "]\n";
		}
		
	@Override
	public void payFromSalaryBrut() {
		totalPaid=paymentRate.payFromSalaryBrut(salaryPerMonthBrut, irpf);
		totalPaidYear=paymentRate.payFromSalaryBrut(salaryPerYearBrut, irpf);
	}


	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}


	/**
	 * Get a bonus from SalariYearBrut
	 */
	@Override
	public void payBonus(int bonus) {
		totalbonus= paymentRate.payBonus(salaryPerYearBrut, bonus);
		
	}

}
