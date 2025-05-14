package com.Dao;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.entity.Engine;
import com.util.DBConnection;

public class EngineDao {

    static Scanner sc = new Scanner(System.in);

    public static void takeIp() {
        System.out.println("Enter the Engine Type");
        String type = sc.next();

        System.out.println("Enter the cc of the Engine");
        int cc = sc.nextInt();

        Engine engine = new Engine();
        engine.setType(type);
        engine.setCc(cc);

        addDetails(engine);
    }

    public static void addDetails(Engine engine) {
        EntityManager em = DBConnection.getConnection();

        em.getTransaction().begin();
        em.persist(engine);
        em.getTransaction().commit();

        System.out.println("Engine details have been added");
    }
}
