package com.ejercicio.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejercicio.tienda.entities.Venta;
import com.ejercicio.tienda.repository.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService{

	@Autowired
	private VentaRepository repositorio;
	
	@Override
	@Transactional(readOnly = true)
	public List<Venta> mostrarVentas() {
		// TODO Auto-generated method stub
		return (List<Venta>) repositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Venta buscarVenta(long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Venta guardarVenta(Venta venta) {
		// TODO Auto-generated method stub
		return repositorio.save(venta);
	}

	@Override
	@Transactional
	public Venta borrarVenta(long id) {
		// TODO Auto-generated method stub
		Venta ventaBorrada = buscarVenta(id);
		repositorio.deleteById(id);
		
		return ventaBorrada;
	}

}
