package com.inerxia.saletrackingapi.facade;

import com.inerxia.saletrackingapi.mapper.InvoiceProductsMapper;
import com.inerxia.saletrackingapi.service.InvoiceProductsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceProductsFacade {
    private final InvoiceProductsService invoiceProductsService;
    private final InvoiceProductsMapper invoiceProductsMapper;

    public InvoiceProductsFacade(InvoiceProductsService invoiceProductsService, InvoiceProductsMapper invoiceProductsMapper) {
        this.invoiceProductsService = invoiceProductsService;
        this.invoiceProductsMapper = invoiceProductsMapper;
    }
}
