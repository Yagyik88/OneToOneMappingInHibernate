package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Engine {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int e_id;
  String type;
  int cc;
}
