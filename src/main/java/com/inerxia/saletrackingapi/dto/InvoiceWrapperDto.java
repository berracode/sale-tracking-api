package com.inerxia.saletrackingapi.dto;

import java.time.LocalDateTime;
import java.util.List;

public class InvoiceWrapperDto {
    private Integer invoiceId;
    private Integer customerId;
    private Integer employeeId;
    private Double tax;
    private Double subtotal;
    private Double total;
    private LocalDateTime localDateTimeInvoice;

    private List<InvoiceProductsWrapperDto> invoiceProductsWrapperDtoList;

    public InvoiceWrapperDto() {
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

    public List<InvoiceProductsWrapperDto> getInvoiceProductsWrapperDtoList() {
        return invoiceProductsWrapperDtoList;
    }

    public void setInvoiceProductsWrapperDtoList(List<InvoiceProductsWrapperDto> invoiceProductsWrapperDtoList) {
        this.invoiceProductsWrapperDtoList = invoiceProductsWrapperDtoList;
    }
}
