package com.gustavohenrique.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gustavohenrique.dominio.Usuario;

@Repository
public interface RepositorioUsuario extends MongoRepository<Usuario, String>{
}