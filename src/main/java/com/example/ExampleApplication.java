package com.example;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.hello.service.HelloRS;

@ApplicationPath("api")
public class ExampleApplication extends Application {
	
	private final Logger log = LoggerFactory.getLogger(ExampleApplication.class);
	
	private static AtomicInteger counter = new AtomicInteger();
	
	public ExampleApplication() {
		log.info("Starting example application: {}", counter.getAndIncrement());
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return Collections.singleton(HelloRS.class);
	}
}
