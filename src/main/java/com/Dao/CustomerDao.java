package com.Dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entity.Car;
import com.entity.Customer;
import com.entity.Engine;
import com.util.DBConnection;

public class CustomerDao {
    static Scanner scan = new Scanner(System.in);
    public static void takeInputs() {
        System.out.println("Enter Customer Name:");
        String name = scan.next();

        System.out.println("Enter Rent Amount:");
        double rent = scan.nextDouble();

        System.out.println("Enter Start Date (yyyy-mm-dd):");
        LocalDate startDate = LocalDate.parse(scan.next());

        System.out.println("Enter End Date (yyyy-mm-dd):");
        LocalDate endDate = LocalDate.parse(scan.next());

        addCustomer(name, rent, startDate, endDate);
        System.out.println("Customer has been added.");
    }

    public static void addCustomer(String name, double rent, LocalDate startDate, LocalDate endDate) {
        EntityManager em = DBConnection.getConnection();

        Customer customer = new Customer();
        customer.setName(name);
        customer.setRent(rent);
        customer.setStartDate(startDate);
        customer.setEndDate(endDate);

        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    public static void allocateCar() {
        EntityManager em = DBConnection.getConnection();

        System.out.println("Enter Customer ID:");
        int customerId = scan.nextInt();

        Customer customer = em.find(Customer.class, customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Enter Car ID to allocate:");
        int carId = scan.nextInt();
        Car car = em.find(Car.class, carId);
        if (car == null) {
            System.out.println("Car not found.");
            return;
        }

        em.getTransaction().begin();
        customer.setC(car);
        em.getTransaction().commit();
        System.out.println("Car allocated to customer.");
    }

  
    public static void deallocateCar() {
        EntityManager em = DBConnection.getConnection();

        System.out.println("Enter Customer ID:");
        int customerId = scan.nextInt();

        Customer customer = em.find(Customer.class, customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        em.getTransaction().begin();
        customer.setC(null);
        em.getTransaction().commit();
        System.out.println("Car deallocated from customer.");
    }


    public static void viewAllCustomers() {
        EntityManager em = DBConnection.getConnection();

        String jpql = "SELECT c FROM Customer c";
        Query query = em.createQuery(jpql);

        List<Customer> customers = query.getResultList();
        customers.forEach(System.out::println);
    }
    
    
    public static void addAllDetails() {
        Scanner scan = new Scanner(System.in);

       
        System.out.println("Enter Engine Type:");
        String engineType = scan.next();

        System.out.println("Enter Engine CC:");
        int cc = scan.nextInt();

        Engine engine = new Engine();
        engine.setType(engineType);
        engine.setCc(cc);

        // Car Details
        System.out.println("Enter Car Brand:");
        String brand = scan.next();

        System.out.println("Enter Car Model:");
        String model = scan.next();

        Car car = new Car();
        car.setBrand(brand);
        car.setModal(model);
        car.setRegisterDate(LocalDate.now());
        car.setE(engine);  
        
        // Customer Details
        System.out.println("Enter Customer Name:");
        String name = scan.next();

        System.out.println("Enter Rent Amount:");
        double rent = scan.nextDouble();

        System.out.println("Enter Start Date (yyyy-mm-dd):");
        LocalDate startDate = LocalDate.parse(scan.next());

        System.out.println("Enter End Date (yyyy-mm-dd):");
        LocalDate endDate = LocalDate.parse(scan.next());

        Customer customer = new Customer();
        
        customer.setName(name);
        customer.setRent(rent);
        customer.setStartDate(startDate);
        customer.setEndDate(endDate);
        customer.setC(car); 

        EntityManager em = DBConnection.getConnection();
        em.getTransaction().begin();
        em.persist(engine);
        em.persist(car);
        em.persist(customer); // Thanks to cascading, Car and Engine will also be saved
        em.getTransaction().commit();

        System.out.println("Customer, Car, and Engine details saved successfully.");
    }

}
