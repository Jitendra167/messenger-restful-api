package com.rest.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class BeanParamDemo {

	@QueryParam("year") int year;
    @QueryParam("name") String name;
    
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
