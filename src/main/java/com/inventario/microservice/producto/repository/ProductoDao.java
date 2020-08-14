package com.inventario.microservice.producto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inventario.microservice.producto.entity.Producto;

public interface ProductoDao extends MongoRepository<Producto, String>{

	
}
