package com.gustavohenrique.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gustavohenrique.dominio.Post;
import com.gustavohenrique.dominio.Usuario;
import com.gustavohenrique.repositorios.RepositorioPost;
import com.gustavohenrique.repositorios.RepositorioUsuario;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private RepositorioUsuario usuarioRep;	
	@Autowired
	private RepositorioPost postRep;
	@Override
	public void run(String... args) throws Exception 
	{
		SimpleDateFormat fdate=new SimpleDateFormat("dd/MM/yyyy");
		fdate.setTimeZone(TimeZone.getTimeZone("GMT-3"));
		usuarioRep.deleteAll();
		postRep.deleteAll();
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		Post p1=new Post(null,fdate.parse("21/03/2018"),"Partiu viagem","Vou viajar pra São Paulo",maria);
		Post p2=new Post(null,fdate.parse("05/11/2022"),"Choveu bastante ontem","Muita bhuca!!",maria);
		postRep.saveAll(Arrays.asList(p1,p2));
		usuarioRep.saveAll(Arrays.asList(maria,alex,bob));
	}
}	