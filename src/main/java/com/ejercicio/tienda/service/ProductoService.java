package com.ejercicio.tienda.service;

import java.util.List;

import com.ejercicio.tienda.entities.Producto;

public interface ProductoService {

	public List<Producto> mostrarProductos();
	public Producto guardarProducto(Producto producto);
	public Producto mostrarProducto(long id);
	public Producto borrarProducto(long id);
}
