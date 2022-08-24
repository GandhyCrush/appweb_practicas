package com.cmc.modelos;

import java.sql.Date;

enum Especie
{
    PERRO, GATO, CANGURO;
}

enum Sexo
{
    MACHO, HEMBRA;
}

public class JPAMascotaDAO implements PropietarioDao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "pet_nombre")
	private String nombre;
	
	
	@Column (name = "pet_edad")
	private int edad;
	
	@Column(name = "pet_sexo")
	private String sexo;
	
	
	@Column (name = "pet_especie")
	private int especie;
	
	
	public JPAMascotaDAO () {}

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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEspecie() {
		return especie;
	}

	public void setEspecie(int especie) {
		this.especie = especie;
	}
	
	
	
	

}
