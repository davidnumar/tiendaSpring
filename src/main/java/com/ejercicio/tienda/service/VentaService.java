package com.ejercicio.tienda.service;

import java.util.List;

import com.ejercicio.tienda.entities.Venta;


public interface VentaService {

	public List<Venta> mostrarVentas();
	
	public Venta buscarVenta(long id);
	
	public Venta guardarVenta(Venta venta);
	
	public Venta borrarVenta(long id);
	
}
