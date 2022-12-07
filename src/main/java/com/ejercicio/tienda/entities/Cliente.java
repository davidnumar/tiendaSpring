package com.ejercicio.tienda.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numero_Cliente;
	
	private String nombre;
	
	private String apellidos;
	
	private String sexo;
	
	private int telefono;

	public Cliente(long numero_Cliente, String nombre, String apellidos, String sexo, int telefono) {
		
		this.numero_Cliente = numero_Cliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.telefono = telefono;
	}

	public long getNumero_Cliente() {
		return numero_Cliente;
	}

	public void setNumero_Cliente(long numero_Cliente) {
		this.numero_Cliente = numero_Cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	
	
}
