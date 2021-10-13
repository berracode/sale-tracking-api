package com.inerxia.saletrackingapi.controller;

import com.inerxia.saletrackingapi.facade.InvoiceFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    private final InvoiceFacade invoiceFacade;

    public InvoiceController(InvoiceFacade invoiceFacade) {
        this.invoiceFacade = invoiceFacade;
    }
}
