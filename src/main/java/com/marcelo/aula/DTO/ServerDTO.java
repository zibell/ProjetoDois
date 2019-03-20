package com.marcelo.aula.DTO;

import java.io.Serializable;

import com.marcelo.aula.entity.CursoEntity;
import com.marcelo.aula.entity.ServerEntity;

public class ServerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String email;
	
	public ServerDTO() {
		
	}
	
	public ServerDTO(ServerEntity obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
