package com.rest.messenger.resources;

import javax.ws.rs.BeanParam;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.rest.messenger.resources.beans.BeanParamDemo;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
			@HeaderParam("customHeaderValue") String header,
			@CookieParam("name") String cookieValue) {
		
		return "Matrix Param: "+matrixParam+", Header param: "+header+", Cookie Param: "+cookieValue;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		
		return "Path : "+ path +", Cookies :"+ cookies;
	}
	
	/*
	 * BeanParam Annotation Demo
	 */
	@GET
	@Path("beanparam")
	public String getParamsUsingBeanParam(@BeanParam BeanParamDemo bean) {
		
		return "Year :" + bean.getYear() +", Name: "+bean.getName();
	}
}
