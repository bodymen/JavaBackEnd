package com.flowers.domain;

public class Flor extends Producte {
	// color es la propietat de flors
		
		@Override
	public String toString() {
		return "Flor [color=" + color + ", toString()=" + super.toString() + "]";
	}

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
