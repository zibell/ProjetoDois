package com.marcelo.aula.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.Servlet;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.aula.DTO.CursoDTO;
import com.marcelo.aula.entity.CursoEntity;
import com.marcelo.aula.service.CursoService;

@RestController
@RequestMapping(value="/cursos")//Executado como RAIZ pelo browser
public class CursoResource {
	
	@Autowired
	CursoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CursoDTO> listar() {
	//	CursoEntity curso1 = new CursoEntity(1, "Sistemas", "Superior", "Noturno");
	//	CursoEntity curso2 = new CursoEntity(2, "Biologio", "Superior", "Diurno");
	//	List<CursoEntity> listaCurso = new ArrayList<>();
	//listaCurso.add(curso1);
	//listaCurso.add(curso2);
		List<CursoEntity> listaEntity = service.buscar();
		
		List<CursoDTO> listaDTO = listaEntity.stream().map(obj -> new CursoDTO(obj)).collect(Collectors.toList());
	return listaDTO; //listaCurso;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<CursoEntity> buscar(@PathVariable Integer id){
		CursoEntity curso = service.buscar(id);
		//if(curso==null) {
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		//}
		return ResponseEntity.ok(curso);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody CursoEntity obj){
		obj = service.salvar(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
	
}
