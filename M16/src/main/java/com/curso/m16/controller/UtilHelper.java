package com.curso.m16.controller;

 public class UtilHelper {
	
	static final int LOWER = 1;
	static final int UPPER = 7;
	
	public static  int GetNumber() {
		return (int) (Math.random() * (UPPER + 1 - LOWER)) + LOWER;
	}
	 
}
