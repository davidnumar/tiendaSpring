package com.ejercicio.tienda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.tienda.entities.Venta;

@Repository
public interface VentaRepository extends CrudRepository<Venta, Long>{
	
	

}
