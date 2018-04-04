package com.rest.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.rest.messenger.model.Message;
import com.rest.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();

	/*
	 * Content Negotiation Demo
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getJsonMessages(@QueryParam("year") int year, 
			                         @QueryParam("start") int start, 
			                         @QueryParam("size") int size) {
		System.out.println("getMessages fired");
		if(year > 0) {
			return messageService.getAllmessagesForYear(year);
		}
		
		/*if(start >= 0 && size >= 0) {
			return messageService.getallMessagesPaginated(start, size);
		}*/
		return messageService.getAllMessages();
	}
	
	/*
	 * Content Negotiation Demo
	 */
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Message> getXmlMessages(@QueryParam("year") int year, 
			                         @QueryParam("start") int start, 
			                         @QueryParam("size") int size) {
		System.out.println("getMessages fired");
		if(year > 0) {
			return messageService.getAllmessagesForYear(year);
		}
		
		/*if(start >= 0 && size >= 0) {
			return messageService.getallMessagesPaginated(start, size);
		}*/
		return messageService.getAllMessages();
	}
	
	/*
	 * HATEOAS Demo
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(id);
		message.addLink(getUriForSelf(message, uriInfo), "self");
		return message;
	}
	
	private String getUriForSelf(Message message, UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(Long.toString(message.getId()))
				.build().toString();
		
		return uri;
	}
	
	/*
	 * Sending status codes and Location Headers demo
	 */
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build(); 
		return Response.created(uri).entity(newMessage).build();
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void removeMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
	
	/*
	 * Implementing Sub Resources demo
	 */
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
