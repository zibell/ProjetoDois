package com.marcelo.aula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.aula.dao.CursoDAO;
import com.marcelo.aula.entity.CursoEntity;

@Service
public class CursoService {

	@Autowired
	private CursoDAO dao;
	
	public List<CursoEntity> buscar() {
		return dao.findAll();
	}
	
	public CursoEntity buscar(Integer id) {
		Optional<CursoEntity> curso = dao.findById(id);
		return curso.orElse(null);
	}
}
