package com.vehicles.project.N2;


public class Conductor extends Persona {

	private Llicencia llicencia;

	public Conductor(String name, String cognom, String data, Llicencia llicencia) throws Exception {
		super(name, cognom, data);	
		
		setLlicencia(llicencia);
	}

	
	@Override
	public String toString() {
		return "Conductor [name=" + name + ", cognom=" + cognom + ", Naixement=" + data + ", llicencia=" + llicencia + "]\n";
	}


	public Llicencia getLlicencia() {
		return llicencia;
	}


	public void setLlicencia(Llicencia llicencia) {
		this.llicencia = llicencia;
	}


}
