package com.gustavohenrique.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavohenrique.dominio.Usuario;
import com.gustavohenrique.repositorios.RepositorioUsuario;

@Service
public class ServicosUsuario {
	
	@Autowired
	private RepositorioUsuario userRepo;
	
	public List<Usuario> findall()
	{
		return userRepo.findAll();
	}
}