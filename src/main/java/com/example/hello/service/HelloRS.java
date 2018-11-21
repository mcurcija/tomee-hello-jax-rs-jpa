package com.example.hello.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.hello.data.Hello;
import com.example.hello.data.HelloEntityService;

@Path("/hello")
public class HelloRS {
	
	private static Logger log = LoggerFactory.getLogger(HelloRS.class);
	
	@Inject
	HelloEntityService helloDAO;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String say() {
		Hello hello = new Hello();
		hello.setDescription("test description");
		hello = helloDAO.store(hello);
		log.info("Stored : {}", hello);
		return "Hello!!: " + hello.getId();
	}
}