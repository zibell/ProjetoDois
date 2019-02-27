package com.marcelo.aula.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.aula.entity.CursoEntity;

@RestController
@RequestMapping(value="/cursos")//Executado como RAIZ pelo browser
public class CursoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CursoEntity> listar() {
		
		CursoEntity curso1 = new CursoEntity(1, "Sistemas", "Superior", "Noturno");
		
		CursoEntity curso2 = new CursoEntity(2, "Biologio", "Superior", "Diurno");
		
	List<CursoEntity> listaCurso = new ArrayList<>();
	
	listaCurso.add(curso1);
	listaCurso.add(curso2);
	
	return listaCurso;
	
	}
	
}
