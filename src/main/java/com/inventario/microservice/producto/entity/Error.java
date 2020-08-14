package com.inventario.microservice.producto.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Error implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String error;
	private int status;
	private String message;
	private LocalDateTime datetime;

}
