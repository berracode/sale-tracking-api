package com.inerxia.saletrackingapi.service;

import com.inerxia.saletrackingapi.exception.DataConstraintViolationException;
import com.inerxia.saletrackingapi.exception.DataNotFoundException;
import com.inerxia.saletrackingapi.model.Invoice;
import com.inerxia.saletrackingapi.model.InvoiceRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice createInvoice(Invoice invoice){
        if(Objects.nonNull(invoice.getId())){
            Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoice.getId());
            if(invoiceOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.invoice");
            }
        }

        try {
            return invoiceRepository.save(invoice);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.invoice");
        }

    }



}
