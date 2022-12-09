package com.ejercicio.tienda.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.ejercicio.tienda.entities.Producto;
import com.ejercicio.tienda.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository repositorio;
	
	@Override
	public Producto guardarProducto(Producto producto) {
		return repositorio.save(producto);
	}
	
	
	
	@Transactional(readOnly = true)
	public List<Producto> mostrarProductos() {
		return (List<Producto>) repositorio.findAll();
	
}
	

	@Transactional(readOnly = true)
	public Producto mostrarProducto(long id) {
		return repositorio.findById(id).orElse(null);
	}



	@Override
	public Producto borrarProducto(long id) {
		Producto borrado = mostrarProducto(id);
		repositorio.deleteById(id);
		return borrado;
	}

}
