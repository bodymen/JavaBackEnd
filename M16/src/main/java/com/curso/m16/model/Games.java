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
public class Games extends AuditModel {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int numPlayers;

	//NO LO USO DE MOMENTO ES PARA CREAR NUEVA PARTIDA CON EL NUMERO DE JUGADORES.
	//Menu al arracar la APP. NuevaPartida(int numeroDeJugadores) y crear los jugadores.

}