package com.inerxia.saletrackingapi.facade.dto;


import lombok.Data;

@Data
public class ProductDto {

    private Integer id;
    private String code;
    private double stock;
}
