package com.grupo5.catalogo.domains;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto;
	private String titulo;
	private String categoria;
	private String descripcion;
	private String imagen;
	private int precio;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario",  nullable = false)
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private Long getIdUsuario() {
		return usuario.getId_usuario();
	}

	private String getNombreUsuario() {
		return usuario.getNombre();
	}

	public Producto() {
	}
 
	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
