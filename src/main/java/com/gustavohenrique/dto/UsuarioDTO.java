package com.gustavohenrique.dto;

import java.io.Serializable;

import com.gustavohenrique.dominio.Usuario;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;

	public UsuarioDTO()
	{
	}
	
	public UsuarioDTO(Usuario obj)
	{
		nome=obj.getNome();
		email=obj.getEmail();
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
}