package com.gustavohenrique.recursos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavohenrique.dominio.Post;
import com.gustavohenrique.recursos.util.URL;
import com.gustavohenrique.servicos.ServicosPost;

@RestController
@RequestMapping(value="/posts")
public class RecursosPost {
	
		@Autowired
		private ServicosPost postServ;
		
		@GetMapping
		public ResponseEntity<List<Post>> novo()
		{
			List<Post> list=postServ.findall();
			return ResponseEntity.ok().body(list);
		}
		
		@GetMapping(value="/{id}")
		public ResponseEntity<Post> findById(@PathVariable String id)
		{
			Post obj=postServ.findById(id);
			return ResponseEntity.ok().body(obj);
		}
		
		@GetMapping(value="/titulosearch")
		public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value="texto",defaultValue = "") String texto)
		{
			texto=URL.decodeParam(texto);
			List<Post> list=postServ.finByTitulo(texto);
			return ResponseEntity.ok().body(list);
		}
		
		@GetMapping(value="/fullsearch")
		public ResponseEntity<List<Post>> fullSearch(
				@RequestParam(value="texto",defaultValue = "") String texto,
				@RequestParam(value="minData",defaultValue = "") String minData,
				@RequestParam(value="maxData",defaultValue = "") String maxData)
		{
			texto=URL.decodeParam(texto);
			Date min=URL.converterData(minData,new Date(0L));
			Date max=URL.converterData(maxData,new Date(0L));
			List<Post> list=postServ.fullSearch(texto, min, max);
			return ResponseEntity.ok().body(list);
		}	
}