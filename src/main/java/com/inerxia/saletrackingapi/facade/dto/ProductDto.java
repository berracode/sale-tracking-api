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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
}
