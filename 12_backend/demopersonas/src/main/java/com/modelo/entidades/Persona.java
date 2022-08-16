package com.modelo.entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.modelo.conexion.ConexionBDD;

/**
 * @author CI
 * @version 1.0
 * @created 08-ago-2022 16:26:04
 */
public class Persona {

	private int id;
	private String nombre;
	private String password;

	public Persona() {

	}

	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setId(int newVal) {
		id = newVal;
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNombre(String newVal) {
		nombre = newVal;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPassword(String newVal) {
		password = newVal;
	}

}