package com.linkedin.learning.otrareunionmas.utiles;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
public class EntityManagerUtil {
	public static EntityManager getEntityManager() {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("OtraReunionMas");
	    EntityManager manager = factory.createEntityManager();
		return manager;
	}
	
	public static void main(String[]args) {
		EntityManager manager = EntityManagerUtil.getEntityManager();
		System.out.println("EntityManager class ==>"+manager.getClass().getCanonicalName());
	}
}
