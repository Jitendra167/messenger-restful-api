package com.rest.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private Date createdDate;
	private String author;
	private List<Link> links = new ArrayList<>();
	
	public Message() {
		
	}
	
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.createdDate = new Date();
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLink(String url, String rel) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
	
}
