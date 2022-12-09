package com.ejercicio.tienda.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.tienda.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	
}
