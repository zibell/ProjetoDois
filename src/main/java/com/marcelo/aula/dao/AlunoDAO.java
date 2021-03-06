package com.marcelo.aula.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.aula.entity.AlunoEntity;
import com.marcelo.aula.entity.CursoEntity;

@Repository
public interface AlunoDAO extends JpaRepository<AlunoEntity, Integer> {
	

}
