package com.marcelo.aula.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.marcelo.aula.entity.CursoEntity;

public class CursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//Bean Validation java 7
	@NotEmpty(message="Este campo não pode estar em branco!!")
	@Length(min=1, max=100, message="O nome deve conter entre 1 e 100 caracteres")
	private String nome;
	private String nivel;
	private String turno;
	
	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public CursoDTO() {
		
	}
	
	public CursoDTO(CursoEntity obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.nivel = obj.getNivel();
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

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	
	
}
