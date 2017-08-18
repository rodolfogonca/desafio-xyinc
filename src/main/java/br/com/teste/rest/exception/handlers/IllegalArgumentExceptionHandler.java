package br.com.teste.rest.exception.handlers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.teste.rest.response.ErrorEntity;

@Provider
public class IllegalArgumentExceptionHandler implements ExceptionMapper<IllegalArgumentException> {

	@Override
	public Response toResponse(IllegalArgumentException e) {
		String internalErroServerCode = String.valueOf(Status.BAD_REQUEST.getStatusCode());

		return Response.status(Status.BAD_REQUEST).entity(new ErrorEntity(internalErroServerCode, e.getMessage()))
				.type(MediaType.APPLICATION_JSON_TYPE).build();
	}
}
