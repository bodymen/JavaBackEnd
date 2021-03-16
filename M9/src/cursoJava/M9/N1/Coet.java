package cursoJava.M9.N1;

import java.util.Arrays;

public class Coet implements Runnable {

	private String codi;
	private int propulsors;
	private int potencia[];
	private int potenciaActual = 0;
	private int max = 0;

	public Coet(String codi, int propulsors) throws Exception {
		if (codi.trim().equals("") || codi.isEmpty()) // || codi.length()<8)
			throw new Exception("Has de ficar un nom de 8 lletres");
		if (propulsors <= 0)
			throw new Exception("Has de ficar un número de propulsors");

		this.setCodi(codi);
		this.setPropulsors(propulsors);
		setPotencia(new int[propulsors]);
	}

	public Coet(String codi, int propulsors, int[] potencia) throws Exception {
		if (codi.trim().equals("") || codi.isEmpty()) // || codi.length()<8)
			throw new Exception("Has de ficar un nom de 8 lletres");
		if (propulsors <= 0)
			throw new Exception("Has de ficar un número de propulsors");

		this.setCodi(codi);
		this.setPropulsors(propulsors);
		this.setPotencia(potencia);
	}

	//Retorna la potencia més grand
	private void potenciaMaxima() {
		int i = 0;

		for (i = 0; i < potencia.length; i++) {
			if (max < this.potencia[i])
				max = potencia[i];
		}

		System.out.println("Potencia màxima: " + max);
	}

	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) {
		this.codi = codi;
	}

	public int getPropulsors() {
		return propulsors;
	}

	public void setPropulsors(int propulsors) {
		this.propulsors = propulsors;
	}

	public String toStringF2() {
		return "Coet [codi=" + codi + ", propulsors=" + propulsors + ", potencia=" + Arrays.toString(potencia) + "]";
	}

	public String toString() {
		return "Coet [codi=" + codi + ", propulsors=" + propulsors + "]";
	}

	public int[] getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia[]) {
		this.potencia = potencia;
	}

	public void run() {
		System.out.println("Start Thread: " +Thread.currentThread().getName());
		potenciaMaxima();
//		try {
//			Thread.sleep(50000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public void accelerar() {
		if (this.potenciaActual < max)
			this.potenciaActual++;

		System.out.println("Acelerar " + Thread.currentThread().getName() + " CODI " + this.codi + " potenicaActual: " + this.potenciaActual);

	}

	public void frenar() {
		if (this.potenciaActual > 0)
			this.potenciaActual--;

		System.out.println("Frenar " + Thread.currentThread().getName()  + " CODI " + this.codi + " potenicaActual: " + this.potenciaActual);

	}
}
