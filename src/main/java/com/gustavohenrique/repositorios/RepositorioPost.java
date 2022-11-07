package com.gustavohenrique.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gustavohenrique.dominio.Post;

public interface RepositorioPost extends MongoRepository<Post, String>{
	
	List<Post> findByTituloContainingIgnoreCase(String texto);
}