package com.inventario.microservice.producto.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "categories")
@Getter
@Setter
public class Categoria implements Serializable {

	private static final long serialVersionUID = 3549537695547100289L;

	@Id
	private String id;
	
	private String nombre;
	
}
