package com.rest.messenger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.rest.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "https://www.youtube.com/watch?v=9oeJc_VkZxo&list=PLqq-6Pq4lTTZh5U8RbdXq0WaYvZBz2rbn&index=27");
		return Response.status(Status.NOT_FOUND)
				       .entity(errorMessage)
				       .build();
	}

}
