package com.ejercicio.tienda.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.ejercicio.tienda.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ejercicio.tienda.entities.Producto;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository repositorio;
	
	@Transactional(readOnly = true)
	public List<Producto> mostrarProductos() {
		return (List<Producto>) repositorio.findAll();
	}
	
	@Transactional(readOnly = true)
	public Producto mostrarProducto(long id) {
		return repositorio.findById(id).orElse(null);
	}

}
