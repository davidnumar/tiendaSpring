package com.ejercicio.tienda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

import com.ejercicio.tienda.entities.Cliente;
import com.ejercicio.tienda.service.ClienteService;


@RestController
@RequestMapping("api")
public class ClienteController {
	
	@Autowired
	private ClienteService servicio;
	
	@GetMapping("clientes")
	public List<Cliente> index(){
	
		
		return servicio.mostrarClientes();
		
	}
	
	@GetMapping("clientes/{id}")
	public ResponseEntity<?> search(@PathVariable long id) {
		
		Cliente cliente;
		Map<String,Object> response = new HashMap<>();
		
		try {
			
			cliente = servicio.buscarCliente(id);
			
		} catch (DataAccessException e) {
			//si hay error tipo excepcion
			response.put("mensaje", "Error al realizar la consulta a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(Objects.isNull(cliente)) {
			
			response.put("mensaje", "El cliente con ID: "+id+" no existe");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@PostMapping("clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@RequestBody Cliente cliente) {
		
		Map<String,Object> response = new HashMap<>();
		Cliente nuevoCliente;
		
		try {
			
			nuevoCliente = servicio.guardarCliente(cliente);
			
		} catch (DataAccessException e) {
			//si hay error tipo excepcion
			response.put("mensaje", "Error al realizar insercion en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido creado correctamente");
		response.put("cliente", nuevoCliente);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody Cliente cliente) {
		
		Cliente aux;
		Map<String,Object> response = new HashMap<>();
		
		try {
			
			aux = servicio.buscarCliente(id);
			
		} catch (DataAccessException e) {
			//si hay error tipo excepcion
			response.put("mensaje", "Error al realizar la actualizacion en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		if(Objects.nonNull(aux)) {
			
			aux.setNombre(cliente.getNombre());
			aux.setApellidos(cliente.getApellidos());
			aux.setSexo(cliente.getSexo());
			aux.setTelefono(cliente.getTelefono());
			
			
			
		}else {
			response.put("mensaje", "Error: no se puede editar, el cliente con ID: "+id+" no existe");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		
		try {
			
			aux=servicio.guardarCliente(aux);
			
		} catch (DataAccessException e) {
			//si hay error tipo excepcion
			response.put("mensaje", "Error al realizar la actualizacion en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido modificado correctamente");
		response.put("cliente", aux);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {

		Map<String,Object> response = new HashMap<>();
		Cliente clienteBorrado;
		
		try {
			
			clienteBorrado = servicio.borrarCliente(id);
			
		} catch (DataAccessException e) {
			//si hay error tipo excepcion
			response.put("mensaje", "Error al realizar borrado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido borrado correctamente");
		response.put("cliente", clienteBorrado);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}

}
