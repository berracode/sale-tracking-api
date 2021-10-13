package com.inerxia.saletrackingapi.facade;

import com.inerxia.saletrackingapi.mapper.InvoiceMapper;
import com.inerxia.saletrackingapi.service.InvoiceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceFacade {
    private final InvoiceService invoiceService;
    private final InvoiceMapper invoiceMapper;

    public InvoiceFacade(InvoiceService invoiceService, InvoiceMapper invoiceMapper) {
        this.invoiceService = invoiceService;
        this.invoiceMapper = invoiceMapper;
    }
}
