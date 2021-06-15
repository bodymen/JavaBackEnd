package com.flowers.view;


import java.util.InputMismatchException;
import java.util.Scanner;

import com.flowers.domain.*;

public class InputCommons {

		private Scanner input;
		
		public InputCommons(Scanner input){
			this.input = input;
		}
		public String askString(String questionMessage) {
			System.out.println(questionMessage);
			String answer = this.input.nextLine();
			return answer;
		}
		public Material askList (String questionMessage) {
			System.out.println(questionMessage);
			return null;
		}
	
		public int askOption(int minInt, int maxInt) {
			return askInt("Selecciona una opció:",minInt,maxInt);
		}
		public int askInt(String questionMessage,int minInt, int maxInt) {
			int option= 0;
			boolean numberFormat = false;
			System.out.println(questionMessage);
			while(numberFormat==false) {
				try {
					option = this.input.nextInt();
					if(option>=minInt && option<=maxInt) {
						numberFormat=true;
					}else {
						System.out.println("Seleciona una opcio, el numero ha d'estar entre  "+minInt+ " i "+maxInt);
					}
				}catch(InputMismatchException e) {
					System.out.println("Seleccina una opcio entre "+minInt+ " i "+maxInt);
				}
				this.input.nextLine();
			}
			return option;
		}
		public double askDouble(String questionMessage) {
			double number = 0;
			boolean numberFormat = false;
			System.out.println(questionMessage);
			while(numberFormat==false) {
				try {
					number = this.input.nextDouble();
					numberFormat=true;
				}catch(InputMismatchException e) {
					
					System.out.println("Valor no vàlid.");
				}
				this.input.nextLine();
			}
			return number;
		}	
		public void pause() {
			System.out.println("Pulsa ENTER per tornar al MENU ");
			this.input.nextLine();
		}
	}




