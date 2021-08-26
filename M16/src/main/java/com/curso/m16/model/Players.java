package com.curso.m16.model;

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
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Players extends AuditModel {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, nullable = true)
	private String name;
	@Column
	private boolean isAnomin = false;
	@Column
	private double promedio = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
			return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAnomin() {
		return isAnomin;
	}

	public void setAnomin(boolean isAnomin) {
		this.isAnomin = isAnomin;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double d) {
		this.promedio = d;
	}

	@Override
	public String toString() {
		return "Players [id=" + id + ", name=" + name==null? "ANONYMOUS" : name + ", isAnomin=" + isAnomin + ", promedio=" + promedio + "]";
	}

}