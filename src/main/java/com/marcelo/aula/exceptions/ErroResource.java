package com.marcelo.aula.exceptions;

import java.io.Serializable;

public class ErroResource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer statHttp;
	private String mensagem;
	
	public ErroResource(Integer statHttp, String mensagem) {
		super();
		this.statHttp = statHttp;
		this.mensagem = mensagem;
	}

	public ErroResource() {
		super();
	}

	public Integer getStatHttp() {
		return statHttp;
	}

	public void setStatHttp(Integer statHttp) {
		this.statHttp = statHttp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
