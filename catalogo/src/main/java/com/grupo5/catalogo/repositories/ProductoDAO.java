package com.grupo5.catalogo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grupo5.catalogo.domains.Producto;


public interface ProductoDAO extends CrudRepository<Producto, Long> {
	public List<Producto> findAll();
	public List<Producto> findByTitulo(String titulo);

	
}
