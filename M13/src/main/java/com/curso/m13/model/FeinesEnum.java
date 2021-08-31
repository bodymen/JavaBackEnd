package com.curso.m13.model;

public enum FeinesEnum {

	CEO (1000),
	CIO (900),
	PM (800),
	CONSULTOR  (700);
	
	private int numVal;

	FeinesEnum(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
