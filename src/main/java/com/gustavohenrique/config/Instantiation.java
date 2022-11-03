package com.gustavohenrique.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gustavohenrique.dominio.Usuario;
import com.gustavohenrique.repositorios.RepositorioUsuario;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private RepositorioUsuario usuarioRep;
	@Override
	public void run(String... args) throws Exception 
	{
		usuarioRep.deleteAll();
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRep.saveAll(Arrays.asList(maria,alex,bob));
	}
}	