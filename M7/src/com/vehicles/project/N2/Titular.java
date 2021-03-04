package com.vehicles.project.N2;


public class Titular extends Persona {

	private boolean teAsseguranša;
    private boolean teGaratge;

	public Titular(String name, String cognom, String data, boolean teAsseguranca, boolean teGaratge) throws Exception {
		super(name, cognom, data);	
		this.teAsseguranša = teAsseguranca;
		this.teGaratge = teGaratge;
	}

	public boolean isTeAsseguranša() {
		return teAsseguranša;
	}

	public void setTeAsseguranša(boolean teAsseguranša) {
		this.teAsseguranša = teAsseguranša;
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
	+ data + ", teAsseguranša=" + teAsseguranša + ", teGaratge=" + teGaratge + "]\n";
	}


}
