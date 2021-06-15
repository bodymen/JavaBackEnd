package com.flowers.domain;

import com.flowers.excepcions.EmptyExcepcion;

public class Producte {

	@Override
	public String toString() {
		return "Producte [nom=" + nom + ", preu=" + preu + "]";
	}

	public Producte(String nom, double preu) throws Exception {

		this.nom = nom;
		this.preu = preu;

		if (nom.contentEquals(""))
			throw new EmptyExcepcion("el camp nom esta buit ");

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	private String nom;
	private double preu;

}
