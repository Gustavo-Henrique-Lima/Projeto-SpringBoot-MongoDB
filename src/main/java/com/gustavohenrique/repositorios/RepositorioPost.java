package com.gustavohenrique.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.gustavohenrique.dominio.Post;

public interface RepositorioPost extends MongoRepository<Post, String>{
	
	List<Post> findByTituloContainingIgnoreCase(String texto);
	
	@Query("{'titulo':{$regex:?0,$options:'i'}}")
	List<Post> findByTitle(String texto);
}