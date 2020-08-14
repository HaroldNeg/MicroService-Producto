package com.inventario.microservice.producto.service.impl;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventario.microservice.producto.entity.Error;

@Service
public class ErrorServiceImpl {

	public ResponseEntity<Error> error400(Exception e){
		return ResponseEntity.status(400).body(error("Error en la petición", 400, e));
	}
	
	public ResponseEntity<Error> error404(String entity){
		return ResponseEntity.status(400).body(error("No se encontró registro de "+entity, 400, null));
	}
	
	public ResponseEntity<Error> error500(Exception e){
		return ResponseEntity.status(400).body(error("Error en el servidor", 500, e));
	}
	
	private Error error(String error, int status, Exception e) {
		String message = "";
		if (e != null) {
			message = e.getLocalizedMessage()+"\n"+e.getMessage()+"\n"+e.getCause();
		} 
		return Error.builder()
				.error(error)
				.status(status)
				.message(message)
				.datetime(LocalDateTime.now())
				.build();
	}
}
