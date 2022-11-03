package com.gustavohenrique.recursos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavohenrique.dominio.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class RecursosUsuario {
	
		@GetMapping(value="/todos")
		public ResponseEntity<List<Usuario>> novo()
		{
			List<Usuario> list=new ArrayList<>();
			Usuario gui= new Usuario("1", "Guilherme", "gui@hotmail.com");
			Usuario gu=new Usuario("2", "Gustavo", "gu@hotmail.com");
			list.addAll(Arrays.asList(gui,gu));
			return ResponseEntity.ok().body(list);
		}
}