package com.jobs.domain.N3;

import com.jobs.error.AjutVolunteerException;

public class Volunteer extends com.jobs.domain.N3.AbsStaffMember {

	private double ajut = 0;

	public Volunteer(String name, String address, String phone, double ajut) throws Exception {
		super(name, address, phone);

		if(ajut>300) throw new AjutVolunteerException("L'ajut no pot ser més de 300");

		this.setAjut(ajut);
	}

	@Override
	public String toString() {
		return "Volunteer [name=" + name + ", salaryPerMonth=NO, address=" + address + ", phone=" + phone
				+ ", Ajut=" + ajut + "]\n";
	}

	@Override
	public void pay() {
		// Res, no cobren;
	}
	
	@Override
	public void payFromSalaryBrut() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void payBonus(int bonus) {
		// TODO Auto-generated method stub
		
	}

	public double getAjut() {
		return ajut;
	}

	public void setAjut(double ajut) {
		this.ajut = ajut;
	}

	



}
