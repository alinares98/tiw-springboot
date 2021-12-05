package com.grupo5.usuario.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grupo5.usuario.domains.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Long> {
	public List<Usuario> findAll();
}
