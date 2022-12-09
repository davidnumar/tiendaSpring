package com.ejercicio.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository repositorio;

}
