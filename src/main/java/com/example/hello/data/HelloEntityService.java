package com.example.hello.data;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class HelloEntityService {

	@PersistenceContext(unitName = "helloPU")
	private EntityManager entityManager;

	public Hello store(Hello hello) {
		entityManager.persist(hello);
		return hello;
	}

	public Hello find(Long id) {
		return entityManager.find(Hello.class, id);
	}
}
