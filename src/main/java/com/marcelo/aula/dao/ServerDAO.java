package com.marcelo.aula.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.aula.entity.CursoEntity;
import com.marcelo.aula.entity.ServerEntity;
import com.marcelo.aula.entity.TurmaEntity;

@Repository
public interface ServerDAO extends JpaRepository<ServerEntity, Integer> {
	

}
