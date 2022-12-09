package com.ejercicio.tienda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		Producto prod = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			prod = servicio.guardarProducto(producto);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al insertar");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Producto>(prod, HttpStatus.CREATED);
	}
	
	@PutMapping("productos/{id}")
	public ResponseEntity<?> update (@PathVariable long id, @RequestBody Producto productoNuevo){
		Producto producto = null;
		Map<String,Object> response =new HashMap<>();
		
		try {
			
			producto = servicio.mostrarProducto(id);
			if(producto != null) {
				producto.setNombre(productoNuevo.getNombre());
				producto.setDescripcion(productoNuevo.getDescripcion());
				producto.setPrecio(productoNuevo.getPrecio());
				producto.setExistencias(productoNuevo.getExistencias());
			}else {
				response.put("mensaje","Error: no se puede editar, el cliente con ID: "+id+" no existe en la base de datos");	
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			}
			
			servicio.guardarProducto(producto);
			
		} catch (DataAccessException e) {
			//si hay error desde la base de datos
			response.put("mensaje","Error al realizar update en la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje","El producto ha sido actualizado con éxito!");
		response.put("producto",producto);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
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
	
	
	@DeleteMapping("productos/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		Producto prod = null;
		Map<String,Object> response = new HashMap<>();
		
		try {
			//if (servicio.mostrarProducto(id)id == null)
			prod = servicio.borrarProducto(id);
		} catch (DataAccessException e) {
			//si hay error desde la base de datos
			response.put("mensaje","Error al borrar producto con ID -> "+id);
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El producto con ID " + id + " se ha borrado con ÉXITO");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK); 
	}
}
