package com.inerxia.saletrackingapi.dto;

import java.time.LocalDateTime;

public class InvoiceWrapperDto {
    private Integer invoiceId;
    private Integer customerId;
    private Integer employeeId;
    private Double tax;
    private Double subtotal;
    private Double total;
    private LocalDateTime localDateTimeInvoice;

    private Integer invoiceProductId;
    private Integer productId;
    private Integer quantity;
    private Double sellPrice;
    private LocalDateTime localDateTimeInvoiceProduct;

    public InvoiceWrapperDto() {
    }

    public InvoiceWrapperDto(Integer invoiceId, Integer customerId, Integer employeeId, Double tax, Double subtotal, Double total, LocalDateTime localDateTimeInvoice, Integer invoiceProductId, Integer productId, Integer quantity, Double sellPrice, LocalDateTime localDateTimeInvoiceProduct) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.tax = tax;
        this.subtotal = subtotal;
        this.total = total;
        this.localDateTimeInvoice = localDateTimeInvoice;
        this.invoiceProductId = invoiceProductId;
        this.productId = productId;
        this.quantity = quantity;
        this.sellPrice = sellPrice;
        this.localDateTimeInvoiceProduct = localDateTimeInvoiceProduct;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getLocalDateTimeInvoice() {
        return localDateTimeInvoice;
    }

    public void setLocalDateTimeInvoice(LocalDateTime localDateTimeInvoice) {
        this.localDateTimeInvoice = localDateTimeInvoice;
    }

    public Integer getInvoiceProductId() {
        return invoiceProductId;
    }

    public void setInvoiceProductId(Integer invoiceProductId) {
        this.invoiceProductId = invoiceProductId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public LocalDateTime getLocalDateTimeInvoiceProduct() {
        return localDateTimeInvoiceProduct;
    }

    public void setLocalDateTimeInvoiceProduct(LocalDateTime localDateTimeInvoiceProduct) {
        this.localDateTimeInvoiceProduct = localDateTimeInvoiceProduct;
    }
}
