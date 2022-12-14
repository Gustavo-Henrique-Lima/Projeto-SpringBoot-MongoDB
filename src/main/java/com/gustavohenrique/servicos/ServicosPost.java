package com.gustavohenrique.servicos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavohenrique.dominio.Post;
import com.gustavohenrique.exception.ObjectNotFoundException;
import com.gustavohenrique.repositorios.RepositorioPost;

@Service
public class ServicosPost {
	
	@Autowired
	private RepositorioPost postRepo;

	public List<Post> findall()
	{
		return postRepo.findAll();
	}
	
	public Post findById(String id) 
	{
		Optional<Post> obj =postRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> finByTitulo(String texto)
	{
		return postRepo.findByTitle(texto);
	}
	
	public List<Post> fullSearch(String texto, Date minData,Date maxData)
	{
		maxData=new Date(maxData.getTime()+24*60*1000);
		return postRepo.fullSearch(texto, minData, maxData);
	}
}