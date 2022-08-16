package modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.conexion.ConexionBDD;

public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String nombre;
	private String password;

	// private static List<Persona> personas = null;

	public Persona() {
	}

	public Persona(int id, String nombre, String password) {
		this.id = id;
		this.nombre = nombre;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// ============= métodos de acceso a datos ==========

	public List<Persona> getPersonas() {
		/*
		 * if(personas == null) { personas = new ArrayList<Persona>(); personas.add(new
		 * Persona(1, "Carlos", "carlos123")); personas.add(new Persona(2, "Paula",
		 * "paula123")); personas.add(new Persona(3, "Luis", "luis123")); }
		 * 
		 * return personas;
		 */

		// 1.- Declarar variables y SQL
		String sql = "SELECT * FROM PERSONA";
		Connection cnn = null;
		ResultSet rs = null;
		List<Persona> personas = new ArrayList<Persona>();

		// 2.- Conectar a la BDD
		cnn = ConexionBDD.getConexion();
		try {
			rs = cnn.prepareStatement(sql).executeQuery();
			while (rs.next()) {
				Persona p = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3));
				personas.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3.- Cerrar objetos
			ConexionBDD.cerrar(rs);
		}

		return personas;
	}

	public Persona autorizarPersona(String usuario, String password) {
		Persona personaAutorizada = null;

		/*
		 * List<Persona> personas = this.getPersonas(); for (Persona persona : personas)
		 * { if(persona.getNombre().equals(usuario) &&
		 * persona.getPassword().equals(password)){ personaAutorizada = persona; break;
		 * } }
		 */

		String sql = "SELECT * FROM persona WHERE nombre = ? AND password = ?";
		ResultSet rs = null;
		PreparedStatement pstm = null;

		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, usuario);
			pstm.setString(2, password);

			rs = pstm.executeQuery();

			while (rs.next()) {
				personaAutorizada = new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personaAutorizada;
	}

	public boolean create(Persona p) {

		boolean bandera = false;
		/*
		 * if(p!= null) { this.getPersonas().add(p); bandera = true; } return bandera;
		 */

		// Variables
		String sql = "INSERT INTO persona (nombre, password) VALUES (?,?)";
		PreparedStatement pstm = null;

		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, p.getNombre());
			pstm.setString(2, p.getPassword());
			
			int filas = pstm.executeUpdate();
			System.out.println("Numero de filas afectas: " + filas);
			bandera = true;
		} catch (SQLException e) {
			e.printStackTrace();
			ConexionBDD.cerrar(pstm);
		}
		return bandera;
	}

	@Override
	public String toString() {

		return this.id + " - " + this.nombre + " - " + this.password;
	}

	public Persona getPersona(int idPersona) {
		/*
		 * Persona p = null;
		 * 
		 * List<Persona> listPersonas = this.getPersonas(); for (Persona persona :
		 * listPersonas) { if(persona.getId() == idPersona) { p = persona; break; } }
		 * 
		 * return p;
		 */

		// Variables
		String sql = "SELECT * FROM PERSONA WHERE id = ?";
		ResultSet rs = null;
		PreparedStatement pstm = null;
		Persona persona = null;

		// Conexion a BDD
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setInt(1, idPersona);
			rs = pstm.executeQuery();
			while (rs.next()) {
				persona = new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexionBDD.cerrar(rs);
			ConexionBDD.cerrar(pstm);
		}

		return persona;
	}

	public boolean update(Persona p) {
		boolean respuesta = false;
		/*
		boolean respuesta = false;
		List<Persona> listPersonas = this.getPersonas();
		for (int i = 0; i < listPersonas.size(); i++) {
			if (listPersonas.get(i).getId() == p.getId()) {
				listPersonas.get(i).setNombre(p.getNombre());
				listPersonas.get(i).setPassword(p.getPassword());
				respuesta = true;
				break;
			}
		}
		return respuesta;
		*/
		
		//Variables
		String sql = "UPDATE persona SET nombre = ?, password = ? WHERE id= ?";
		PreparedStatement pstm = null;
		
		//Conetar a BDD
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, p.getNombre());
			pstm.setString(2, p.getPassword());
			pstm.setInt(3, p.getId());
			
			
			
			int filas =  pstm.executeUpdate();
			System.out.println("Numero de filas ejecutadas: " + filas);
			respuesta = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexionBDD.cerrar(pstm);
		}
		
		
		return respuesta;

	}

	public boolean delete(int idPersona) {
		boolean respuesta = false;
		/*
		boolean respuesta = false;
		List<Persona> listPersonas = this.getPersonas();
		for (int i = 0; i < listPersonas.size(); i++) {
			if (listPersonas.get(i).getId() == idPersona) {
				listPersonas.remove(i);
				respuesta = true;
			}
		}
		*/
		
		
		//Variables
		String sql = "DELETE FROM persona WHERE id = ?";
		PreparedStatement pstm = null;
		
		//Conectar a BDD
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setInt(1, idPersona);
			
			int filas = pstm.executeUpdate();
			System.out.println("Numero de filas ejecutas: " + filas);
			respuesta = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexionBDD.cerrar(pstm);
		}
		
		return respuesta;
	}

}
