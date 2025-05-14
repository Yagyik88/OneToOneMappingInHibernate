package com.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator ="car_id")
    @SequenceGenerator(name="car_id",initialValue = 100, allocationSize =1)
    int id;
    String brand;
    String modal;
    private LocalDate registerDate;
    @OneToOne
    private Engine e;
}
   
    
