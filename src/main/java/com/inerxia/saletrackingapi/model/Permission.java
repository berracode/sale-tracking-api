package com.inerxia.saletrackingapi.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

}
