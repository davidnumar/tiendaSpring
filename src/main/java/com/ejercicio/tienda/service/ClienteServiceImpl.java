package com.ejercicio.tienda.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejercicio.tienda.entities.Cliente;
import com.ejercicio.tienda.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repositorio;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> mostrarClientes() {
		return (List<Cliente>) repositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente buscarCliente(long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		return repositorio.save(cliente);
	}

	@Override
	public Cliente borrarCliente(long id) {
		Cliente borrado = buscarCliente(id);
		repositorio.deleteById(id);
		return borrado;
	}

	@Override
	public Cliente updateCliente(long id, Cliente c) {
		
		Cliente aux = repositorio.findById(id).orElse(null);
		
		if(Objects.isNull(aux)) {
			return null;
		}
		
		aux.setNombre(c.getNombre());
		aux.setApellidos(c.getApellidos());
		aux.setSexo(c.getSexo());
		aux.setTelefono(c.getTelefono());
		
		return repositorio.save(aux);
		
	}
}
