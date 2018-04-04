package com.rest.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {

	@GET
	public String getComments() {
		return "This is from comments resource";
	}
	
	@GET
	@Path("/{commentId}")
	public String getComments(@PathParam("messageId") int messageId, @PathParam("commentId") int commentId) {
		return "This is comment: "+commentId+" from message: "+messageId;
	}
}
