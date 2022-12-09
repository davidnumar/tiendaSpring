package com.ejercicio.tienda.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ventas")
public class Venta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long folio; 
	
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Cliente cliente;
	
	/*
	@ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Producto producto;
	*/
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Producto> productos;
	
	
	private int cantidad;
	
	private double subtotal;
	
	private  int  iva;
	
	private double total;

	public long getFolio() {
		return folio;
	}

	public void setFolio(long folio) {
		this.folio = folio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Venta() {
		super();
	}

	public Venta(long folio, Cliente cliente, List<Producto> productos, int cantidad, double subtotal, int iva,
			double total) {
		super();
		this.folio = folio;
		this.cliente = cliente;
		this.productos = productos;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}

	
	
	

	
}
