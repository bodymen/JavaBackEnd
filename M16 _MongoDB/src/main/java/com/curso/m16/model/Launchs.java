package com.curso.m16.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Launchs extends AuditModel {

	private int dice1;
	private int dice2;
	private int dice3;
	private int dice4;
	private boolean isWon=false;	
	@DBRef 
	private Players player;
	

	public int getDice1() {
		return dice1;
	}

	public int getDice2() {
		return dice2;
	}

	public boolean isWon() {
		return isWon;
	}

	public Players getPlayer() {
		return player;
	}

 
	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}

	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}

	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}

	public void setPlayer(Players player) {
		this.player = player;
	}
	
	public int getDice3() {
		return dice3;
	}

	public int getDice4() {
		return dice4;
	}

	public void setDice3(int dice3) {
		this.dice3 = dice3;
	}

	public void setDice4(int dice4) {
		this.dice4 = dice4;
	}

	@Override
	public String toString() {
		return "Launchs [id=" + getId() + ", dice1=" + dice1 + ", dice2=" + dice2 + ", isWon=" + isWon + ", player=" + player
				+ "]";
	}

}