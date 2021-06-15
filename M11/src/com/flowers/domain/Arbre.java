package com.flowers.domain;

public class Arbre extends Producte {

	@Override
	public String toString() {
		return "Arbre [altura=" + altura + ", toString()=" + super.toString() + "]";
	}

	public Arbre(String nom, double preu, double altura) throws Exception {
		super(nom, preu);
		this.altura = altura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	private double altura;
}
