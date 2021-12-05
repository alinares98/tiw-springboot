package com.grupo5.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grupo5.catalogo.domains.Producto;
import com.grupo5.catalogo.repositories.ProductoDAO;






@Controller
@CrossOrigin
public class CatalogoController {
	
	@Autowired
	ProductoDAO daoProd;

	@RequestMapping(method = RequestMethod.GET, value = "/hola")
	public @ResponseBody String getUsers(){
		return "<h1>HOLAAA</h1>";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/productos")
	public @ResponseBody List <Producto> getAllProductos(){
		return daoProd.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/producto/{titulo}")
	public @ResponseBody List<Producto> getProducto(@PathVariable String titulo){
		return daoProd.findByTitulo(titulo);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/producto/{id}")
	public @ResponseBody void eliminarProducto(@PathVariable @Validated Long id){
		Producto pr = daoProd.findById(id).orElse(null);
		if(pr != null) {
			daoProd.delete(pr);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/producto")
	public @ResponseBody Producto guardarProducto(@RequestBody @Validated Producto pr){
		
		return daoProd.save(pr);
	}
	
	
	

	
	
	

}
