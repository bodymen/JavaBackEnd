package com.curso.m16.model;

import org.springframework.data.mongodb.core.index.*;
import org.springframework.data.mongodb.core.mapping.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Players extends AuditModel {

	@Indexed(unique = true)
	private String name;
	private boolean isAnomin = false;
	private double promedio = 0;

	public String getName() {
		if (isAnomin == true)
			return "ANONYMOUS";
		else
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
		return "Players [id=" + getId() + ", name=" + getName() + 
				", isAnomin=" + isAnomin + ", promedio=" + promedio + "]";
	}

}