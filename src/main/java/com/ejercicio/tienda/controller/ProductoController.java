package com.ejercicio.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ejercicio.tienda.entities.Producto;
import com.ejercicio.tienda.service.ProductoService;

public class ProductoController {
	
	@Autowired
	private ProductoService servicio;
	
	@PostMapping("productos")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@RequestBody Producto producto){
		return null;
	}
	
	@PutMapping("productos/{id}")
	public ResponseEntity<?> update (@PathVariable long id, @RequestBody Producto producto){
		return null;
	}
	
	
}
