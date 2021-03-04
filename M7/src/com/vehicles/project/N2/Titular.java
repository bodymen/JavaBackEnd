package com.vehicles.project.N2;


public class Titular extends Persona {

	private boolean teAsseguran�a;
    private boolean teGaratge;

	public Titular(String name, String cognom, String data, boolean teAsseguranca, boolean teGaratge) throws Exception {
		super(name, cognom, data);	
		this.teAsseguran�a = teAsseguranca;
		this.teGaratge = teGaratge;
	}

	public boolean isTeAsseguran�a() {
		return teAsseguran�a;
	}

	public void setTeAsseguran�a(boolean teAsseguran�a) {
		this.teAsseguran�a = teAsseguran�a;
	}

	public boolean isTeGaratge() {
		return teGaratge;
	}

	public void setTeGaratge(boolean teGaratge) {
		this.teGaratge = teGaratge;
	}

	
	@Override
	public String toString() {
		return "Titular [name=" + name + ", cognom=" + cognom + ", Naixement=" 
	+ data + ", teAsseguran�a=" + teAsseguran�a + ", teGaratge=" + teGaratge + "]\n";
	}


}
