package com.ejercicio.tienda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.tienda.entities.Producto;
import com.ejercicio.tienda.service.ProductoService;

@RestController
@RequestMapping("api")
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
	
	@GetMapping("productos")
	public List<Producto> index(){
		return servicio.mostrarProductos();
	}
	
	@GetMapping("productos/{id}")
	public ResponseEntity<?> show(@PathVariable long id){
		Producto producto = null;
		Map<String,Object> response = new HashMap<>();
		
		try {
			producto = servicio.mostrarProducto(id);
			
			if(producto == null) {
				response.put("mensaje", "El producto con ID: "+id+" no existe en la base de datos");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			//si hay error desde la base de datos
			response.put("mensaje","Error al realizar consulta en la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}			
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);
	}	
}
