package com.ejercicio.tienda.service;

import java.util.List;

import com.ejercicio.tienda.entities.Producto;

public interface ProductoService {
	
	//metodo para mostrar todos los productos
	private List<Producto> mostrarProductos();
	
	//metodo para mostrar un producto por id
	private Producto buscarProducto(long id);

}
