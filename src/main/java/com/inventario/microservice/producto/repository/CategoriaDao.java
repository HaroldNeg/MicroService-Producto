package com.inventario.microservice.producto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inventario.microservice.producto.entity.Categoria;

public interface CategoriaDao extends MongoRepository<Categoria, String>{

}
