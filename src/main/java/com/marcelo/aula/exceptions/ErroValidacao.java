package com.marcelo.aula.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErroValidacao extends ErroResource {
	private static final long serialVersionUID = 1L;
	
	private List<MensagemErroCampoExceptions> listaErros = new ArrayList<>();
	
	public ErroValidacao(Integer httpStatus, String msg) {
		super(httpStatus, msg);
	}

	public List<MensagemErroCampoExceptions> getListaErros() {
		return listaErros;
	}

	public void setListaErros(List<MensagemErroCampoExceptions> listaErros) {
		this.listaErros = listaErros;
	}
	
	public void addErros(String campo, String msg) {
		MensagemErroCampoExceptions m = new MensagemErroCampoExceptions(campo, msg);
		this.listaErros.add(m);
	}
}
