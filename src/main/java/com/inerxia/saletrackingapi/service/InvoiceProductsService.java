package com.inerxia.saletrackingapi.service;

import com.inerxia.saletrackingapi.model.InvoiceProductsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceProductsService {

    private final InvoiceProductsRepository invoiceProductsRepository;

    public InvoiceProductsService(InvoiceProductsRepository invoiceProductsRepository) {
        this.invoiceProductsRepository = invoiceProductsRepository;
    }
}
