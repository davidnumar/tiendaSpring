package com.ejercicio.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.tienda.entities.Producto;
import com.ejercicio.tienda.repository.ProductoRepository;



@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository repositorio;

	@Override
	public Producto guardarProducto(Producto producto) {
		return repositorio.save(producto);
	}
	
	
	

}
