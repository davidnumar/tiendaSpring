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
	
	//GET ALL
	@Override
	@Transactional(readOnly = true)
	public List<Venta> mostrarVentas() {
		// TODO Auto-generated method stub
		return (List<Venta>) repositorio.findAll();
	}

	//GET
	@Override
	@Transactional(readOnly = true)
	public Venta buscarVenta(long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

	//CREATE
	@Override
	@Transactional
	public Venta guardarVenta(Venta venta) {
		// TODO Auto-generated method stub
		return repositorio.save(venta);
	}

	//BORRAR
	@Override
	@Transactional
	public Venta borrarVenta(long id) {
		// TODO Auto-generated method stub
		Venta ventaBorrada = buscarVenta(id);
		repositorio.deleteById(id);
		
		return ventaBorrada;
	}

	//UPDATE
	@Override
	@Transactional
	public Venta updateVenta(long id, Venta venta) {
		 Venta v = this.buscarVenta(id);
		 v.setCantidad(venta.getCantidad());
		 v.setCliente(venta.getCliente());
		 v.setFolio(venta.getFolio());
		 v.setIva(venta.getIva());
		 v.setProducto(venta.getProducto());
		 v.setSubtotal(venta.getSubtotal());
		 v.setTotal(venta.getSubtotal());
		 this.guardarVenta(v);
		 return v;
	}

}
