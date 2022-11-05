package com.gustavohenrique.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavohenrique.dominio.Post;
import com.gustavohenrique.dominio.Usuario;
import com.gustavohenrique.dto.UsuarioDTO;
import com.gustavohenrique.servicos.ServicosUsuario;

@RestController
@RequestMapping(value="/usuarios")
public class RecursosUsuario {
	
		@Autowired
		private ServicosUsuario usuarioServ;
		
		@GetMapping
		public ResponseEntity<List<UsuarioDTO>> novo()
		{
			List<Usuario> list=usuarioServ.findall();
			List<UsuarioDTO> listDto=list.stream().map(x->new UsuarioDTO(x)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
		}
		
		@GetMapping(value="/{id}")
		public ResponseEntity<UsuarioDTO> findById(@PathVariable String id)
		{
			Usuario obj=usuarioServ.findById(id);
			return ResponseEntity.ok().body(new UsuarioDTO(obj));
		}
		
		@PostMapping
		public ResponseEntity<Void> insert(@RequestBody UsuarioDTO objDto)
		{
			Usuario obj=usuarioServ.fromDTO(objDto);
			obj=usuarioServ.insert(obj);
			URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		@DeleteMapping(value="/{id}")
		public ResponseEntity<Void> delete(@PathVariable String id)
		{
			usuarioServ.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		@PutMapping(value="/{id}")
		public ResponseEntity<Void> udpate(@RequestBody UsuarioDTO objDto,@PathVariable String id)
		{
			Usuario obj=usuarioServ.fromDTO(objDto);
			obj.setId(id);
			obj=usuarioServ.update(obj);
			return ResponseEntity.noContent().build();
		}
		
		@GetMapping(value="/{id}/posts")
		public ResponseEntity<List<Post>> findPosts(@PathVariable String id)
		{
			Usuario obj=usuarioServ.findById(id);
			return ResponseEntity.ok().body(obj.getPost());
		}
}