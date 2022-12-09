package com.ejercicio.tienda.service;

import java.util.List;

import com.ejercicio.tienda.entities.Venta;


public interface VentaService {

	//GET ALL
	public List<Venta> mostrarVentas();
	
	//GET
	public Venta buscarVenta(long id);
	
	//CREATE
	public Venta guardarVenta(Venta venta);
	
	//DELETE
	public Venta borrarVenta(long id);
	
	//UPDATE
	public Venta updateVenta(long id, Venta venta);
	
}
