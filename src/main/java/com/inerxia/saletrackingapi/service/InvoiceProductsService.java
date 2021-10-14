package com.inerxia.saletrackingapi.service;

import com.inerxia.saletrackingapi.exception.DataConstraintViolationException;
import com.inerxia.saletrackingapi.exception.DataNotFoundException;
import com.inerxia.saletrackingapi.exception.ObjectNoEncontradoException;
import com.inerxia.saletrackingapi.model.InvoiceProducts;
import com.inerxia.saletrackingapi.model.InvoiceProductsRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class InvoiceProductsService {

    private final InvoiceProductsRepository invoiceProductsRepository;

    public InvoiceProductsService(InvoiceProductsRepository invoiceProductsRepository) {
        this.invoiceProductsRepository = invoiceProductsRepository;
    }

    public InvoiceProducts createInvoiceProducts(InvoiceProducts invoiceProducts){
        if(Objects.nonNull(invoiceProducts.getId())){
            Optional<InvoiceProducts> invoiceProductsOptional = invoiceProductsRepository.findById(invoiceProducts.getId());
            if(invoiceProductsOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.invoiceProducts");
            }
        }
        return invoiceProductsRepository.save(invoiceProducts);
    }

    public InvoiceProducts editInvoiceProducts(InvoiceProducts invoiceProducts){
        if(Objects.isNull(invoiceProducts.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        InvoiceProducts invoiceProductsTx = invoiceProductsRepository
                .findById(invoiceProducts.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.invoiceProducts"));


        try{
            invoiceProductsTx.setProductId(invoiceProducts.getProductId());
            invoiceProductsTx.setInvoiceId(invoiceProducts.getInvoiceId());
            invoiceProductsTx.setQuantity(invoiceProducts.getQuantity());
            invoiceProductsTx.setSellPrice(invoiceProducts.getSellPrice());
            invoiceProductsTx.setTimestamp(invoiceProducts.getTimestamp());

            return invoiceProductsTx;
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.invoiceProducts");
        }
    }
}
