package com.marcelo.aula.exceptions;

public class ObjNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ObjNaoEncontradoException(String msg) {
		super(msg);
	}
}
