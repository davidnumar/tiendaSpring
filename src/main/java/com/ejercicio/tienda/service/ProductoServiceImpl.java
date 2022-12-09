package com.ejercicio.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ejercicio.tienda.repository.ProductoRepository;

public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository repositorio;
	
	

}
