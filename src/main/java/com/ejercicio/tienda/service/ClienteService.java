package com.ejercicio.tienda.service;

import java.util.List;

import com.ejercicio.tienda.entities.Cliente;

public interface ClienteService {
	
	//mostrar todos los clientes
	public List<Cliente> mostrarClientes();
			
	//devuelve cliente por id
	public Cliente buscarCliente(long id);
			
	//crear nuevo cliente
	public Cliente guardarCliente(Cliente cliente);
			
	//borrar cliente
	public Cliente borrarCliente(long id);
	
	//actualizar cliente
	public Cliente updateCliente (long id, Cliente c);

}
