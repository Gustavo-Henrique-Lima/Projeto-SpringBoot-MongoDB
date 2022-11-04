package com.gustavohenrique.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}