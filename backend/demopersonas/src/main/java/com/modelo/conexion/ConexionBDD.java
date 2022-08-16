package com.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author CI
 * @version 1.0
 * @created 08-ago-2022 16:26:03
 */
public class ConexionBDD {

	private static ConexionBDD instancia = null;
	private Connection cnn;


	private ConexionBDD(){
		String servidor = "localhost";
		String database = "gestorpersonas";
		String url = "jdbc:mysql://" + servidor + "/" + database;
		String usuario = "root";
		String password = "mysql2020";

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			cnn = DriverManager.getConnection(url, usuario, password);
//			System.out.println("Conexion realizada!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ConexionBDD getInstance(){
		if(instancia == null) {
			instancia = new ConexionBDD();
		}
		return instancia;
	}

	public Connection getCnn(){
		return cnn;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCnn(Connection newVal){
		cnn = newVal;
	}

	/**
	 * 
	 * @param rs
	 */
	public void cerrar(ResultSet rs){

	}

	/**
	 * 
	 * @param pstmt
	 */
	public void cerrar(PreparedStatement pstmt){

	}

}