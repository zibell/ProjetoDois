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

import com.marcelo.aula.entity.CursoEntity;
import com.marcelo.aula.entity.TurmaEntity;
import com.marcelo.aula.service.CursoService;
import com.marcelo.aula.service.TurmaService;

@RestController
@RequestMapping(value="/turmas")//Executado como RAIZ pelo browser
public class TurmaResource {
	
	@Autowired
	TurmaService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<TurmaEntity> listar() {
	
		List<TurmaEntity> lista = service.buscar();
	return lista; //listaCurso;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<TurmaEntity> buscar(@PathVariable Integer id){
		TurmaEntity turma = service.buscar(id);
		if(turma==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(turma);
	}
	
}
