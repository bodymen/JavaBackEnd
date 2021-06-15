package com.flowers.domain;

public class Flor extends Producte {
	// color es la propietat de flors
		
		public Flor(String nom, double preu, String color) throws Exception {
			super(nom,preu);
			this.color = color;
		}
		
		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

	    private String color;
}
