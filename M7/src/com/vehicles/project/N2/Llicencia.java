package com.vehicles.project.N2;

public class Llicencia {

	protected int id;
	protected String tipusLlicencia;
	

	protected String nomComplet;
	protected String dataCaducitat;

	private static int COUNTER = 1;

	public Llicencia(String tipusLlicencia, String nomComplet, String dataCaducitat) throws Exception {
		if (tipusLlicencia.equals(""))
			throw new Exception();
		if (nomComplet.equals(""))
			throw new Exception();
		if (dataCaducitat.equals(""))
			throw new Exception();

		this.tipusLlicencia = tipusLlicencia;
		this.nomComplet = nomComplet;
		this.dataCaducitat = dataCaducitat;
		id = COUNTER;
		COUNTER++;
	}
	
	@Override
	public String toString() {
		return "Llicencia [id=" + id + ", tipusLlicencia=" + tipusLlicencia + ", nomComplet=" + nomComplet
				+ ", dataCaducitat=" + dataCaducitat + "]";
	}

	/**
	 * @return the tipusLlicencia
	 */
	public String getTipusLlicencia() {
		return tipusLlicencia;
	}

	/**
	 * @return the nomComplet
	 */
	public String getNomComplet() {
		return nomComplet;
	}

	/**
	 * @return the dataCaducitat
	 */
	public String getDataCaducitat() {
		return dataCaducitat;
	}

	/**
	 * @return the cOUNTER
	 */
	public static int getCOUNTER() {
		return COUNTER;
	}

	/**
	 * @param tipusLlicencia the tipusLlicencia to set
	 */
	public void setTipusLlicencia(String tipusLlicencia) {
		this.tipusLlicencia = tipusLlicencia;
	}

	/**
	 * @param nomComplet the nomComplet to set
	 */
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	/**
	 * @param dataCaducitat the dataCaducitat to set
	 */
	public void setDataCaducitat(String dataCaducitat) {
		this.dataCaducitat = dataCaducitat;
	}

	/**
	 * @param cOUNTER the cOUNTER to set
	 */
	public static void setCOUNTER(int cOUNTER) {
		COUNTER = cOUNTER;
	}

}
