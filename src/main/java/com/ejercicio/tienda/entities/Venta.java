package com.ejercicio.tienda.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String folio; //mirar
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JoinColumn(name="id_venta")
	private Cliente num_cliente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JoinColumn(name="id_venta")
	private Producto clave_prod;
	
	private int cantidad;
	
	private double subtotal;
	
	private  int  iva;
	
	private double total;

	public Venta(String folio, Cliente num_cliente, Producto clave_prod, int cantidad, double subtotal, int iva,
			double total) {
		super();
		this.folio = folio;
		this.num_cliente = num_cliente;
		this.clave_prod = clave_prod;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Cliente getNum_cliente() {
		return num_cliente;
	}

	public void setNum_cliente(Cliente num_cliente) {
		this.num_cliente = num_cliente;
	}

	public Producto getClave_prod() {
		return clave_prod;
	}

	public void setClave_prod(Producto clave_prod) {
		this.clave_prod = clave_prod;
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
	
	
	
	
	
	

}
