package com.marcelo.aula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.aula.dao.ServerDAO;
import com.marcelo.aula.entity.ServerEntity;
import com.marcelo.aula.entity.ServerEntity;
import com.marcelo.aula.exceptions.ObjNaoEncontradoException;

@Service
public class ServerService {

	@Autowired
	private ServerDAO dao;
	
	public List<ServerEntity> buscar() {
		return dao.findAll();
	}
	public ServerEntity buscar(Integer id) {
		Optional<ServerEntity> Server = dao.findById(id);
		return Server.orElseThrow(()-> new ObjNaoEncontradoException("Pede pro São Longinho, pq eu não to achando nada."));
		//return Server.orElse(null);
	}
	
	
	public ServerEntity salvar(ServerEntity obj) {
		
		obj.setId(null);
		return dao.save(obj);
	}
}
