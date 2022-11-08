package com.gustavohenrique.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.gustavohenrique.dominio.Post;

public interface RepositorioPost extends MongoRepository<Post, String>{
	
	List<Post> findByTituloContainingIgnoreCase(String texto);
	
	@Query("{'titulo':{$regex:?0,$options:'i'}}")
	List<Post> findByTitle(String texto);
	
	@Query("{ $and: [ { data: {$gte: ?1} }, { data: { $lte: ?2} } , { $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, { 'corpo': { $regex: ?0, $options: 'i' } }, { 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String texto, Date minDate,Date maxDate);
}