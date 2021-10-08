package com.inerxia.saletrackingapi.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "stock")
    private double stock;


}
