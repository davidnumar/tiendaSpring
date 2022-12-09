package com.ejercicio.tienda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.tienda.entities.Producto;

@Repository
public interface ProductoRepository  extends CrudRepository<Producto, Long>{

}
