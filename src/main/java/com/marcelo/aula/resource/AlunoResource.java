package com.marcelo.aula.resource;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.aula.entity.AlunoEntity;
import com.marcelo.aula.entity.CursoEntity;
import com.marcelo.aula.service.AlunoService;
import com.marcelo.aula.service.CursoService;

@RestController
@RequestMapping(value="/alunos")//Executado como RAIZ pelo browser
public class AlunoResource {
	
	@Autowired
	AlunoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<AlunoEntity> listar() {
	
		List<AlunoEntity> lista = service.buscar();
	return lista; //listaCurso;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<AlunoEntity> buscar(@PathVariable Integer id){
		AlunoEntity aluno = service.buscar(id);
		if(aluno==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(aluno);
	}
	
}
