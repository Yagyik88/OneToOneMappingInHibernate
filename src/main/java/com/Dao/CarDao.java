package com.Dao;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entity.Car;
import com.entity.Engine;
import com.util.DBConnection;
public class CarDao {
    static Scanner scan = new Scanner(System.in);

    public static void addCarInputs() {
        System.out.println("Enter the Brand Name -");
        String brand = scan.next();

        System.out.println("Enter the Car Model -");
        String model = scan.next();

        System.out.println("Enter the Engine Type -");
        String type = scan.next();

        System.out.println("Enter the Engine CC -");
        int cc = scan.nextInt();

        Engine engine = new Engine();
        engine.setType(type);
        engine.setCc(cc);

        Car car = new Car();
        car.setBrand(brand);
        car.setModal(model);
        car.setRegisterDate(LocalDate.now());
        car.setE(engine);

        addCar(car, engine);
        System.out.println("Car has been added.");
    }

    public static void addCar(Car car, Engine engine) {
        EntityManager em = DBConnection.getConnection();

        em.getTransaction().begin();
        em.persist(engine); // persist engine first
        em.persist(car);    // then persist car with the associated engine
        em.getTransaction().commit();
    }

    public static void viewAllCars() {
        EntityManager em = DBConnection.getConnection();
        String hbl = "SELECT c FROM Car c";
        List<Car> li = em.createQuery(hbl, Car.class).getResultList();
        li.forEach(System.out::println);
    }
}
