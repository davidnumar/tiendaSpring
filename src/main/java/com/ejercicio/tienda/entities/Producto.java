package com.ejercicio.tienda.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clave;
	
	private String nombre;
	
	private String descripcion;
	
	private double precio;
	
	private int existencias;

	public Producto(long clave, String nombre, String descripcion, double precio, int existencias) {
		super();
		this.clave = clave;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.existencias = existencias;
	}

	public long getClave() {
		return clave;
	}

	public void setClave(long clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
	
	
}
