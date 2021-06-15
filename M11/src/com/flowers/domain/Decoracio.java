package com.flowers.domain;

public class Decoracio extends Producte {
	
		public Decoracio(String nom, double preu, Material material) throws Exception {
			super(nom, preu);
			this.material = material;
		}
		
		
		public Material getMaterial() {
			return material;
		}

		public void setMaterial(Material material) {
			this.material = material;
		}

		private Material material;

}
