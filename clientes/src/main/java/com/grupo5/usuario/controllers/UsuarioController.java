package com.grupo5.usuario.controllers;

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

import com.grupo5.usuario.domains.Usuario;
import com.grupo5.usuario.repositories.UsuarioDAO;


@Controller
@CrossOrigin
public class UsuarioController {

	@Autowired
	UsuarioDAO daoUs;


	@RequestMapping(method = RequestMethod.GET, value = "/usuarios")
	public @ResponseBody List<Usuario> getUsuarios() {
		return daoUs.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/usuarios")
	public @ResponseBody Usuario saveUser(@RequestBody @Validated Usuario puser) {
		return daoUs.save(puser);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/usuarios/{id}")
	public @ResponseBody void deleteUser(@PathVariable @Validated Long id) {
		Usuario us = daoUs.findById(id).orElse(null);
		if (us != null) {
			daoUs.delete(us);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/usuarios/{id}")
	public @ResponseBody Usuario updateUser(@PathVariable @Validated Long id, @RequestBody Usuario pUser) {
		Usuario us = daoUs.findById(id).orElse(null);
		us.setUsuario(pUser.getUsuario());
		us.setEmail(pUser.getEmail());
		us.setClave(pUser.getClave());
		us.setNombre(pUser.getNombre());
		us.setApellidos(pUser.getApellidos());
		us.setCiudad(pUser.getCiudad());
		us.setImagen_perfil(pUser.getImagen_perfil());
		return daoUs.save(us);
	}

}
