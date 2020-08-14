package com.inventario.microservice.producto.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "products")
@Getter
@Setter
public class Producto implements Serializable {

	private static final long serialVersionUID = 8839208823060153421L;
	
	@Id
	private String id;
	
	private String plu;
	
	private String cod;
	 
	private String nombre;
	
	private double precioCosto;
	
	private double precioVenta;
	
	private int porcentajeIva;
	
	private int stock;
	
	private LocalDate createAt;
	
	private Categoria categoria;

}
