package com.jobs.application;

import com.jobs.contract.IPaymentRate;

public class PaymentFactory {

	
	public static IPaymentRate createPaymentRateEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth - ((salaryPerMonth*15)/100);
			}
			@Override
			public double payFromSalaryBrut(double salaryBrut, int irpf) {
				return salaryBrut - ((salaryBrut*irpf)/100);
			}
			@Override
			public double payBonus(double salaryBrutYear, int bonus) {
				return ((salaryBrutYear*bonus)/100);
			}

		};
	}
	
	public static IPaymentRate createPaymentRateManager(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.10;
			}

			@Override
			public double payFromSalaryBrut(double salaryBrut, int irpf) {
				return salaryBrut - ((salaryBrut*irpf)/100);
			}
			
			@Override
			public double payBonus(double salaryBrutYear, int bonus) {
				return ((salaryBrutYear*bonus)/100);
			}
		};
	}
	
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.5;
			}

			@Override
			public double payFromSalaryBrut(double salaryBrut, int irpf) {
				return salaryBrut - ((salaryBrut*irpf)/100);
			}
			
			@Override
			public double payBonus(double salaryBrutYear, int bonus) {
				return ((salaryBrutYear*bonus)/100);
			}
		};
	}

	public static IPaymentRate createPaymentRateSeniorEmployee() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth - ((salaryPerMonth*5)/100);
			}

			@Override
			public double payFromSalaryBrut(double salaryBrut, int irpf) {
				return salaryBrut - ((salaryBrut*irpf)/100);
			}
			
			@Override
			public double payBonus(double salaryBrutYear, int bonus) {
				return ((salaryBrutYear*bonus)/100);
			}
		};
	}

	public static IPaymentRate createPaymentRateMidEmployee() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth - ((salaryPerMonth*10)/100);
			}

			@Override
			public double payFromSalaryBrut(double salaryBrut, int irpf) {
				return salaryBrut - ((salaryBrut*irpf)/100);
			}
			
			@Override
			public double payBonus(double salaryBrutYear, int bonus) {
				return ((salaryBrutYear*bonus)/100);
			}
		};
	}

	public static IPaymentRate createPaymentRateJuniorEmployee() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth - ((salaryPerMonth*15)/100);
			}

			@Override
			public double payFromSalaryBrut(double salaryBrut, int irpf) {
				return salaryBrut - ((salaryBrut*irpf)/100);
			}
			
			@Override
			public double payBonus(double salaryBrutYear, int bonus) {
				return ((salaryBrutYear*bonus)/100);
			}
		};
	}
}
