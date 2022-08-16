package testbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Persona;
import modelo.conexion.ConexionBDD;

public class TestBdd {

	public static void main(String[] args) {
/*
		String servidor = "localhost";
		String database = "gestorpersonas";
		String url = "jdbc:mysql://" + servidor + "/" + database;
		String usuario = "root";
		String password = "mysql2020";

		// Variables a utilizar
		Connection conexion = null;
		ResultSet resultSet = null;
		PreparedStatement pstm = null;

		// 1.- Crear Conexion y conectarse
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conexion = DriverManager.getConnection(url, usuario, password);

			if (conexion != null) {
				System.out.println("Éxito en la Conexión");
			} else {
				System.out.println("No se pudo conectar a Mysql");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// 2.- CONSULTAR
		String sql = "SELECT * FROM PERSONA";

		try {
			pstm = conexion.prepareStatement(sql);
			resultSet = pstm.executeQuery();

			while (resultSet.next()) {
				System.out.println("DATO: " + resultSet.getInt(1) + " - " + resultSet.getString(2) + " - "
						+ resultSet.getString(3));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				// 3.- Cierro objetos
				resultSet.close();
				pstm.close();
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// =============== INSERTAR =================

		// 1.- Crear Conexion

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conexion = DriverManager.getConnection(url, usuario, password);

			if (conexion != null) {
				System.out.println("Éxito en la Conexión");
			} else {
				System.out.println("No se pudo conectar a Mysql");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 2.- Sentencia INSERT

		String sql = "INSERT INTO persona (nombre, password) VALUES (?,?)";
		
		try {
			pstm = conexion.prepareStatement(sql);
			pstm.setString(1, "Pedro");
			pstm.setString(2, "Pedro123");
			
			int filas=  pstm.executeUpdate();
			System.out.println("Numero de filas ejecutadas: "+ filas);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//3.- Cerrrar objetos
			try {
				pstm.close();
				conexion.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		*/
		
		//1.- Declarar variables y SQL
		String sql = "SELECT * FROM PERSONA";
		Connection cnn = null;
		ResultSet rs = null;
		
		//2.- Conectar a la BDD
		cnn = ConexionBDD.getConexion();
		try {
			rs = cnn.prepareStatement(sql).executeQuery();
			while(rs.next()) {
				Persona p = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3));
				System.out.println(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//3.- Cerrar objetos
			ConexionBDD.cerrar(rs);
		}
		
		

	}

}
