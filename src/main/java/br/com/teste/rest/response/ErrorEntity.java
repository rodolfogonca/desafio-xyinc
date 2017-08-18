package br.com.teste.rest.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author Rodolfo Goncalves
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class ErrorEntity implements Serializable {

	private static final long serialVersionUID = 3306363750957170366L;

	private String code;
	private String message;
	private String stack;

	public ErrorEntity(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ErrorEntity(String code, String message, String stack) {
		super();
		this.code = code;
		this.message = message;
		this.stack = stack;
	}

	public ErrorEntity() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	@Override
	public String toString() {
		return "ErrorEntity - codigo [" + code + "]; mensagem: [" + message + "]; stack: [" + stack + "]";
	}
}