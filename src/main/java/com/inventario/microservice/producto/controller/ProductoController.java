package com.inventario.microservice.producto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.microservice.producto.service.ProductoService;

@RestController
@RequestMapping("/v0/product")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return service.list();
	}
	
	@PostMapping
	public ResponseEntity<?> crear(RequestEntity<?> entity){
		return service.create(entity);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable String id){
		return service.find(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(RequestEntity<?> entity, @PathVariable String id){
		return service.update(entity, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrar(@PathVariable String id){
		return service.delete(id);
	}
}
