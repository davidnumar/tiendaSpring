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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.tienda.entities.Cliente;
import com.ejercicio.tienda.entities.Venta;
import com.ejercicio.tienda.service.VentaServiceImpl;


@RestController
@RequestMapping("api")
public class VentaController {

	@Autowired
	private VentaServiceImpl servicio; 
	
	@GetMapping("ventas")
	public List<Venta> index(){
		return servicio.mostrarVentas();
	}
	
	@GetMapping("ventas/{id}")
	public ResponseEntity<?> show(@PathVariable long id) {
		Venta venta = null;
		Map<String,Object> response =new HashMap<>();
		
		try {
			venta = servicio.buscarVenta(id);
			
			if(venta == null) {
				response.put("mensaje", "La venta con Folio: "+id+" no existe en la base de datos");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			response.put("mensaje","Error al realizar consulta en la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		return new ResponseEntity<Venta>(venta,HttpStatus.OK);
	}
	
	@PostMapping("ventas")
	public ResponseEntity<?> save(@RequestBody Venta venta) {
		Venta ventaNew = null;
		Map<String,Object> response =new HashMap<>();
		
		try {
			ventaNew = servicio.guardarVenta(venta);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al realizar insert en la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","¡La venta ha sido creada con éxito!");
		response.put("venta",ventaNew);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("ventas/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {

		Map<String,Object> response = new HashMap<>();
		Venta ventaBorrada;
		
		try {
			
			ventaBorrada = servicio.borrarVenta(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar borrado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La venta ha sido borrado correctamente");
		response.put("venta", ventaBorrada);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
}
