package br.com.teste.rest.exception.handlers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.teste.rest.response.ErrorEntity;

@Provider
public class RuntimeExceptionHandler implements ExceptionMapper<RuntimeException> {

	@Override
	public Response toResponse(RuntimeException e) {
		String internalErroServerCode = String.valueOf(Status.INTERNAL_SERVER_ERROR.getStatusCode());

		return Response.status(Status.BAD_REQUEST)
				.entity(new ErrorEntity(internalErroServerCode, e.getMessage(), e.getCause().getMessage()))
				.type(MediaType.APPLICATION_JSON_TYPE).build();
	}
}
