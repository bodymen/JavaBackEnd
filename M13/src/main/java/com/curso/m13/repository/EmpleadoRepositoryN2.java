package com.curso.m13.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.curso.m13.model.Empleado;

@Repository
public class EmpleadoRepositoryN2 implements IEmpleadoRepositoryN2 {

	private Connection connection = null;

	public EmpleadoRepositoryN2() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			String con = "jdbc:mysql://localhost:3306/m13db";
			this.connection = DriverManager.getConnection(con, "toni", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Empleado> findAll() {
		List<Empleado> list = new ArrayList<Empleado>();
		String query = "SELECT * FROM empleado";
		try {
			Statement st = connection.createStatement();
			st.execute(query);
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				Empleado empleado = new Empleado(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getString(3));
				list.add(empleado);
			}

		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return list;
	}

	public Empleado findById(int id) {
		Empleado empleado = null;
		String query = "SELECT * FROM empleado WHERE id=" + id;
		try {
			Statement st = connection.createStatement();
			st.execute(query);
			ResultSet rs = st.getResultSet();
			rs.next();
			empleado = new Empleado(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getString(3));
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return empleado;
	}

	public void deleteById(int id) {
		String query = "DELETE FROM empleado WHERE id=" + id;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}

	public void save(Empleado empleado) {
		String query = "INSERT INTO  empleado (id, nom, puesto, salari)" + "VALUES (?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, empleado.getId());
			ps.setString(2, empleado.getNom());
			ps.setString(3, empleado.getPuesto());
			ps.setInt(4, empleado.getSalari());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}

	public void update(Empleado empleado) {
		String query = "UPDATE empleado SET nom=?, puesto=?, salari=? " + "WHERE id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, empleado.getNom());
			ps.setString(2, empleado.getPuesto());
			ps.setInt(3, empleado.getSalari());
			ps.setInt(4, empleado.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}
}
