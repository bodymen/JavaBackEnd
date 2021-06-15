package com.flowers.excepcions;

public class EmptyExcepcion extends Exception {
	private static final long serialVersionUID = 1L;

	public EmptyExcepcion() {
		super();
	}
	
	public EmptyExcepcion(String message) {
		super(message);
	}
}
