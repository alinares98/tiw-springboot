package com.grupo5.usuario.domains;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	private String usuario;
	private String email;
	private String clave;
	private String nombre;
	private String apellidos;
	private String ciudad;
	private String imagen_perfil;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_usuario")
	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getImagen_perfil() {
		return imagen_perfil;
	}

	public void setImagen_perfil(String imagen_perfil) {
		this.imagen_perfil = imagen_perfil;
	}

}
