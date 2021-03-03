package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	private String description="";
 
	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		
		this.setDescription(description);
	}

	
	@Override
	public String toString() {
		return "Volunteer [name=" + name + ",salaryPerMonth=NO, address=" + address
				+ ", phone=" + phone + ", totalPaid=" + totalPaid + "]\n";
	}

	@Override
	public void pay() {
		//Res, no cobren;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}
