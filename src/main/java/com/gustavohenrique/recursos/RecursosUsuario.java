package com.gustavohenrique.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavohenrique.dominio.Usuario;
import com.gustavohenrique.servicos.ServicosUsuario;

@RestController
@RequestMapping(value="/usuarios")
public class RecursosUsuario {
	
		@Autowired
		private ServicosUsuario usuarioServ;
		
		@GetMapping
		public ResponseEntity<List<Usuario>> novo()
		{
			List<Usuario> list=usuarioServ.findall();
			return ResponseEntity.ok().body(list);
		}
}