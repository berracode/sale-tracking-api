package com.inerxia.saletrackingapi.facade.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class ProductDto {

    @JsonAlias("id")
    private Integer id;
    @JsonAlias("code")
    private String code;
    @JsonAlias("stock")
    private double stock;
}
