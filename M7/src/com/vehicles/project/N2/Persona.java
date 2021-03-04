package com.vehicles.project.N2;

public abstract class Persona {

	public int id;
	public String name;
	public String cognom;
	public String data;

	private static int COUNTER_MEMBERS = 1;

	public Persona(String name, String cognom, String data) throws Exception {
		if (name.trim().equals("") || name.isEmpty() )
			throw new Exception("Has de posat un nom");
		if (cognom.trim().equals("") || name.isEmpty() )
			throw new Exception("Has de posat un cognom");
		if (data.trim().equals("") || name.isEmpty() )
			throw new Exception("Has de posat una data");

		this.name = name;
		this.cognom = cognom;
		this.data = data;
		id = COUNTER_MEMBERS;
		COUNTER_MEMBERS++;
	}

}
