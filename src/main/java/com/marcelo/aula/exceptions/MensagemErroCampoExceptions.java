package com.marcelo.aula.exceptions;

import java.io.Serializable;

public class MensagemErroCampoExceptions implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String campo;
	private String msg;
	
	public MensagemErroCampoExceptions() {
		super();
	}

	public MensagemErroCampoExceptions(String campo, String msg) {
		super();
		this.campo = campo;
		msg = msg;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		msg = msg;
	}
	
	
}
