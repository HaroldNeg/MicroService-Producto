package com.inventario.microservice.producto.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventario.microservice.producto.entity.Producto;
import com.inventario.microservice.producto.repository.ProductoDao;
import com.inventario.microservice.producto.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ErrorServiceImpl error;
	
	@Autowired
	private ProductoDao dao;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public ResponseEntity<?> create(RequestEntity<?> entity) {
		try {
			Producto producto = mapper.convertValue(entity.getBody(), Producto.class);
			producto.setCreateAt(LocalDate.now());
			try {
				dao.save(producto);
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
			List<Producto> entity = dao.findAll();
			return ResponseEntity.status(200).body(entity);
		} catch (Exception e) {
			return error.error500(e);
		}
	}

	@Override
	public ResponseEntity<?> find(String id) {
		try {
			Producto entity = dao.findById(id).orElse(null);
			if (entity == null) {
				return error.error404("producto");
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
			Producto producto = mapper.convertValue(entity.getBody(), Producto.class);
			try {
				dao.save(producto);
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
