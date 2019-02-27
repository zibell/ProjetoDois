package com.marcelo.aula.resource;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.aula.entity.CursoEntity;
import com.marcelo.aula.service.CursoService;

@RestController
@RequestMapping(value="/cursos")//Executado como RAIZ pelo browser
public class CursoResource {
	
	@Autowired
	CursoService service;
	
	//@RequestMapping(method=RequestMethod.GET)
	//public List<CursoEntity> listar() {
	//	CursoEntity curso1 = new CursoEntity(1, "Sistemas", "Superior", "Noturno");
	//	CursoEntity curso2 = new CursoEntity(2, "Biologio", "Superior", "Diurno");
	//	List<CursoEntity> listaCurso = new ArrayList<>();
	//listaCurso.add(curso1);
	//listaCurso.add(curso2);
	//return listaCurso;
	//}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<CursoEntity> buscar(@PathVariable Integer id){
		CursoEntity curso = service.buscar(id);
		return ResponseEntity.ok(curso);
	}
	
}
