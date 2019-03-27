package com.marcelo.aula.exceptions;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErroHandler {
	
	@ExceptionHandler(ObjNaoEncontradoException.class)
	public ResponseEntity<ErroResource> objectNotFound(ObjNaoEncontradoException e, HttpServletRequest request){
		
		ErroResource erro = new ErroResource(HttpStatus.NOT_FOUND.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroResource> validacao(MethodArgumentNotValidException e, HttpServletRequest request){
		
		ErroValidacao erros = new ErroValidacao(HttpStatus.BAD_REQUEST.value(), "Erro de validação!!");
		
		//recuperando todos os campos que deram excessao, e adicionando na lista personalizada.
		for(FieldError item: e.getBindingResult().getFieldErrors()) {
			erros.addErros(item.getField(), item.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}
	
}
