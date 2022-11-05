package com.gustavohenrique.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gustavohenrique.dominio.Post;

public interface RepositorioPost extends MongoRepository<Post, String>{
}