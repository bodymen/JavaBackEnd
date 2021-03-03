package com.jobs.persistence;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.N3.AbsStaffMember;

public class EmployeeRepositoryN3 {

	private static List<AbsStaffMember> members=new ArrayList<>();
	
	public EmployeeRepositoryN3(){
		
	}
	
	public List<AbsStaffMember> getAllMembers(){
		return new ArrayList<>(members);
	}
	
	
	public void addMember(AbsStaffMember member) throws Exception{
		if(member==null) throw new Exception();
		members.add(member);
	}
	
	public void Delete( ) throws Exception{
		if(members==null) throw new Exception();
		members.removeAll(members);
	}
	
	
}
