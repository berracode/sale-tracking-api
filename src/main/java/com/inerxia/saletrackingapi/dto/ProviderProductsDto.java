package com.inerxia.saletrackingapi.dto;

import java.time.LocalDateTime;

public class ProviderProductsDto {

    private Integer id;

    private Integer providerId;

    private Integer productId;

    private double netPrice;

    private double sellPrice;

    private LocalDateTime timestamp;

    private ProviderDto providerFk;
    private ProductDto productFk;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public ProviderDto getProviderFk() {
        return providerFk;
    }

    public void setProviderFk(ProviderDto providerFk) {
        this.providerFk = providerFk;
    }

    public ProductDto getProductFk() {
        return productFk;
    }

    public void setProductFk(ProductDto productFk) {
        this.productFk = productFk;
    }
}
