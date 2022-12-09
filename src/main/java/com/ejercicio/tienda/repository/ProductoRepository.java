package com.ejercicio.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import com.ejercicio.tienda.entities.Producto;

public interface ProductoRepository  extends CrudRepository<Producto, Long>{

}
