package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	public static void main(String[] args) throws Exception {

	/**Voluteer no extend de Employee, ho fa directament de AbsStaff ja que no es 
	 * un empleat i per tant no tindrá salari**/	
		
    //Aqui és creen les classes de MANAGER i BOSS. I Només es completa el codi.
    Nivel1.Process();
     
	//Aqui es creen 5 classes (senior, mid, junior, boss, manager) domini.N2 per 
    //per posar el throws per condició de salari
    Nivel2.Process();
    Nivel2.ProcessErrors();
     
    
    //Aqui es creen clases noves al domini.N3 per introduir el IRPF
    //per calcular el salari net a partir del brut.
    Nivel3.Process();

	}
}
			