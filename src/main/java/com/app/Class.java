package com.app;

import com.Dao.CarDao;
import com.Dao.CustomerDao;
import com.Dao.EngineDao;

public class Class {
  Scanner scan = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("======= Car Rental System =======");
	            System.out.println("1. Add Customer");
	            System.out.println("2. View All Customers");
	            System.out.println("3. Allocate Car to Customer");
	            System.out.println("4. Deallocate Car from Customer");
	            System.out.println("5. Add Car");
	            System.out.println("6. View All Cars");
	            System.out.println("7. Add Engine");
	            System.out.println("8. Add Customer + Car + Engine (All Details)");
	            System.out.println("9. Exit");
	            System.out.print("Enter your choice: ");

	            choice = scan.nextInt();

	            switch (choice) {
	                case 1:
	                    CustomerDao.takeInputs();
	                    break;

	                case 2:
	                    CustomerDao.viewAllCustomers();
	                    break;

	                case 3:
	                    CustomerDao.allocateCar();
	                    break;

	                case 4:
	                    CustomerDao.deallocateCar();
	                    break;

	                case 5:
	                    CarDao.addCarInputs();
	                    break;

	                case 6:
	                    CarDao.viewAllCars();
	                    break;

	                case 7:
	                    EngineDao.takeIp();
	                    break;

	                case 8:
	                    CustomerDao.addAllDetails();
	                    break;

	                case 9:
	                    System.out.println("Exiting application. Goodbye!");
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }

	        } while (choice != 9);

	        scan.close();
	    }
}
