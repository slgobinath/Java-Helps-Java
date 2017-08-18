package com.javahelps.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/service")
public class HelloService {

	@GET
	@Path("/")
	public String get() {
		System.out.println("GET invoked");
		return "Hello from WSO2 MSF4J";
	}

	@POST
	@Path("/")
	public void post() {
		System.out.println("POST invoked");
	}

	@PUT
	@Path("/")
	public void put() {
		System.out.println("PUT invoked");
	}

	@DELETE
	@Path("/")
	public void delete() {
		System.out.println("DELETE invoked");
	}
}