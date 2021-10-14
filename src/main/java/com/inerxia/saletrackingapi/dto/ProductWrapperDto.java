package com.inerxia.saletrackingapi.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ProductWrapperDto {
    private Integer providerProductId;

    private Integer productId;

    @NotBlank(message = "The name cannot be empty")
    private String name;

    @NotBlank(message = "The code cannot be empty")
    private String code;

    private Double stock;

    @NotNull
    private Integer providerId;

    @JsonAlias(value = "providerName")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String providerName;

    private Double netPrice;

    private Double sellPrice;

    private LocalDateTime timestamp;

    public ProductWrapperDto() {
    }

    public ProductWrapperDto(Integer providerProductId, Integer productId, String name, String code, Double stock, Integer providerId, String providerName, Double netPrice, Double sellPrice, LocalDateTime timestamp) {
        this.providerProductId = providerProductId;
        this.productId = productId;
        this.name = name;
        this.code = code;
        this.stock = stock;
        this.providerId = providerId;
        this.providerName = providerName;
        this.netPrice = netPrice;
        this.sellPrice = sellPrice;
        this.timestamp = timestamp;
    }

    public Integer getProviderProductId() {
        return providerProductId;
    }

    public void setProviderProductId(Integer providerProductId) {
        this.providerProductId = providerProductId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Double netPrice) {
        this.netPrice = netPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
