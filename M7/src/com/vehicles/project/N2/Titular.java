package com.vehicles.project.N2;


public class Titular extends Persona {

	private boolean teAssegurança;
    private boolean teGaratge;

	public Titular(String name, String cognom, String data, boolean teAsseguranca, boolean teGaratge) throws Exception {
		super(name, cognom, data);	
		this.teAssegurança = teAsseguranca;
		this.teGaratge = teGaratge;
	}

	public boolean isTeAssegurança() {
		return teAssegurança;
	}

	public void setTeAssegurança(boolean teAssegurança) {
		this.teAssegurança = teAssegurança;
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
	+ data + ", teAssegurança=" + teAssegurança + ", teGaratge=" + teGaratge + "]\n";
	}


}
