package com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DBConnection {
	
    public static EntityManager getConnection() {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("yagyik_raghuwanshi");
    	EntityManager em =emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
		return em;
    }
}
