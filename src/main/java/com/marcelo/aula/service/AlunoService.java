package com.marcelo.aula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.aula.dao.AlunoDAO;
import com.marcelo.aula.dao.CursoDAO;
import com.marcelo.aula.entity.AlunoEntity;
import com.marcelo.aula.entity.CursoEntity;

@Service
public class AlunoService {

	@Autowired
	private AlunoDAO dao;
	
	public List<AlunoEntity> buscar() {
		return dao.findAll();
	}
	
	public AlunoEntity buscar(Integer id) {
		Optional<AlunoEntity> aluno = dao.findById(id);
		return aluno.orElse(null);
	}
}
