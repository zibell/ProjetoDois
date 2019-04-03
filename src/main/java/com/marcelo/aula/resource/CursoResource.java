package com.marcelo.aula.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Void> salvar(@Valid @RequestBody CursoDTO objDTO){
		
		CursoEntity obj = new CursoEntity(null, objDTO.getNome(),objDTO.getNivel(),objDTO.getTurno());
		obj = service.salvar(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody CursoEntity obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.atualizar(obj);
		return ResponseEntity.noContent().build();
	}
	//cursos/paginacao/?nome=Sis&qtd=1
	//cursos/pages/0/10/nome/ASC
	@RequestMapping(value="paginacao", method=RequestMethod.GET)
	public ResponseEntity<Page<CursoDTO>> listarPaginas(
			@RequestParam(value="nome", defaultValue="") String nome,
			@RequestParam(value="pagina", defaultValue="0") Integer pagina,
			@RequestParam(value="qtd", defaultValue="15")  Integer qtdLinhas, 
			@RequestParam(value="ordem", defaultValue="nome")  String orderBy, 
			@RequestParam(value="dir", defaultValue="DESC")  String dir) {
		Page<CursoEntity> listaCursos = service.buscarPagina(nome, pagina, qtdLinhas, orderBy, dir);
		Page<CursoDTO> listaDTO = listaCursos.map(obj -> new CursoDTO(obj));
		
		return ResponseEntity.ok().body(listaDTO);
	}
	
}
