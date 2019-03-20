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

import com.marcelo.aula.DTO.ServerDTO;
import com.marcelo.aula.entity.ServerEntity;
import com.marcelo.aula.service.ServerService;

@RestController
@RequestMapping(value="/servers")//Executado como RAIZ pelo browser
public class ServerResource {
	
	@Autowired
	ServerService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ServerDTO> listar() {
		List<ServerEntity> listaEntity = service.buscar();
		
		List<ServerDTO> listaDTO = listaEntity.stream().map(obj -> new ServerDTO(obj)).collect(Collectors.toList());
	return listaDTO; //listaServer;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<ServerEntity> buscar(@PathVariable Integer id){
		ServerEntity Server = service.buscar(id);
		//if(Server==null) {
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		//}
		return ResponseEntity.ok(Server);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody ServerEntity obj){
		obj = service.salvar(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
	
}
