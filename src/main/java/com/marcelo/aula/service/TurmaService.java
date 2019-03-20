package com.marcelo.aula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.aula.dao.CursoDAO;
import com.marcelo.aula.dao.TurmaDAO;
import com.marcelo.aula.entity.CursoEntity;
import com.marcelo.aula.entity.TurmaEntity;

@Service
public class TurmaService {

	@Autowired
	private TurmaDAO dao;
	
	public List<TurmaEntity> buscar() {
		return dao.findAll();
	}
	
	public TurmaEntity buscar(Integer id) {
		Optional<TurmaEntity> turma = dao.findById(id);
		return turma.orElse(null);
	}
}
