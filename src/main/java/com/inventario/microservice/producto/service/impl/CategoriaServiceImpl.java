package com.inventario.microservice.producto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventario.microservice.producto.entity.Categoria;
import com.inventario.microservice.producto.repository.CategoriaDao;
import com.inventario.microservice.producto.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private ErrorServiceImpl error;
	
	@Autowired
	private CategoriaDao dao;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public ResponseEntity<?> create(RequestEntity<?> entity) {
		try {
			Categoria categoria = mapper.convertValue(entity.getBody(), Categoria.class);
			try {
				dao.save(categoria);
				return ResponseEntity.status(201).build();
			} catch (Exception e) {
				return error.error500(e);
			}
		} catch (Exception e) {
			return error.error400(e);
		}
	}

	@Override
	public ResponseEntity<?> list() {
		try {
			List<Categoria> entity = dao.findAll();
			return ResponseEntity.status(200).body(entity);
		} catch (Exception e) {
			return error.error500(e);
		}
	}

	@Override
	public ResponseEntity<?> find(String id) {
		try {
			Categoria entity = dao.findById(id).orElse(null);
			if (entity == null) {
				return error.error404("categoria");
			} else {
				return ResponseEntity.status(200).body(entity);
			}
		} catch (Exception e) {
			return error.error500(e);
		}
	}

	@Override
	public ResponseEntity<?> update(RequestEntity<?> entity, String id) {
		try {
			Categoria categoria = mapper.convertValue(entity.getBody(), Categoria.class);
			try {
				dao.save(categoria);
				return ResponseEntity.status(204).build();
			} catch (Exception e) {
				return error.error500(e);
			}
		} catch (Exception e) {
			return error.error400(e);
		}
	}

	@Override
	public ResponseEntity<?> delete(String id) {
		try {
			dao.deleteById(id);
			return ResponseEntity.status(204).build();
		} catch (Exception e) {
			return error.error500(e);
		}
	}


}
