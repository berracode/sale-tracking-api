package com.inerxia.saletrackingapi.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ProductWrapperDto {

    private Integer id;

    @NotBlank(message = "No puede ser vacío el name")
    private String name;

    @NotBlank(message = "No puede ser vacío el code")
    private String code;

    @NotNull(message = "No puede ser vacío el stock")
    private double stock;

    @NotNull
    private Integer providerId;

    @JsonAlias(value = "providerName")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String providerName;

    @NotNull
    private double netPrice;

    @NotNull
    private double sellPrice;

    @NotNull
    private LocalDateTime timestamp;

    public ProductWrapperDto() {
    }

    public ProductWrapperDto(Integer id, String name, String code, double stock, Integer providerId, String providerName, double netPrice, double sellPrice, LocalDateTime timestamp) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.stock = stock;
        this.providerId = providerId;
        this.providerName = providerName;
        this.netPrice = netPrice;
        this.sellPrice = sellPrice;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }



    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
