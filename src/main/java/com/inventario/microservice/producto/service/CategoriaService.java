package com.inventario.microservice.producto.service;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

public interface CategoriaService {
	
	public abstract ResponseEntity<?> create(RequestEntity<?> entity);

	public abstract ResponseEntity<?> list();
	
	public abstract ResponseEntity<?> find(String id);
	
	public abstract ResponseEntity<?> update(RequestEntity<?> entity, String id);
	
	public abstract ResponseEntity<?> delete(String id);
}
