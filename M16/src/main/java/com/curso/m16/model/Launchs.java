package com.curso.m16.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Launchs extends AuditModel {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int dice1;
	@Column
	private int dice2;
	@Column
	private boolean isWon=false;	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "playerId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Players player;

	public int getId() {
		return id;
	}

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

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Launchs [id=" + id + ", dice1=" + dice1 + ", dice2=" + dice2 + ", isWon=" + isWon + ", player=" + player
				+ "]";
	}



}