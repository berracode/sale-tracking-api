package com.inerxia.saletrackingapi.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "provider_products")
public class ProviderProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "provider_id")
    private Integer providerId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "net_price")
    private double netPrice;

    @Column(name = "sell_price")
    private double sellPrice;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="provider_id", insertable = false, updatable = false, nullable = false)
    private Provider providerFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", insertable = false, updatable = false, nullable = false)
    private Product productFk;

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

    public Provider getProviderFk() {
        return providerFk;
    }

    public void setProviderFk(Provider providerFk) {
        this.providerFk = providerFk;
    }

    public Product getProductFk() {
        return productFk;
    }

    public void setProductFk(Product productFk) {
        this.productFk = productFk;
    }
}
