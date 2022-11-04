package com.gustavohenrique.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavohenrique.dominio.Usuario;
import com.gustavohenrique.dto.UsuarioDTO;
import com.gustavohenrique.exception.ObjectNotFoundException;
import com.gustavohenrique.repositorios.RepositorioUsuario;

@Service
public class ServicosUsuario {
	
	@Autowired
	private RepositorioUsuario userRepo;
	
	public List<Usuario> findall()
	{
		return userRepo.findAll();
	}
	
	public Usuario findById(String id) 
	{
		Optional<Usuario> obj = userRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Usuario insert (Usuario obj)
	{
		return userRepo.insert(obj);
	}
	
	public Usuario fromDTO(UsuarioDTO obj)
	{
		return new Usuario(obj.getId(), obj.getNome(), obj.getEmail());
	}
}