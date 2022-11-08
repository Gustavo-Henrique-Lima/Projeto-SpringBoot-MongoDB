package com.gustavohenrique;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gustavohenrique.dominio.Usuario;
import com.gustavohenrique.dto.UsuarioDTO;
import com.gustavohenrique.recursos.RecursosUsuario;

@ExtendWith(MockitoExtension.class)
public class RecursosUsuarioTest 
{
	@InjectMocks
	private RecursosUsuario recursosUsu;
	
	private Usuario user;
	private UsuarioDTO userDTO;

	@BeforeEach
	void inicalizar()
	{
		user=new Usuario("1", "Usuário de teste", "teste@gmail.com");
		userDTO=new UsuarioDTO(user);
	}
	
	@Test
	void deveInserirUmNovoUsuario()
	{
		recursosUsu.insert(userDTO);
	}
	
	@Test
	void atualizarUsuario()
	{
		recursosUsu.udpate(userDTO, "1");
	}
}