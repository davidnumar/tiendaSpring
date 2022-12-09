package com.ejercicio.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.tienda.service.VentaServiceImpl;


@RestController
@RequestMapping("api")
public class VentaController {

	@Autowired
	private VentaServiceImpl servicio; 
}
