package com.inerxia.saletrackingapi.service;

import com.inerxia.saletrackingapi.exception.DataConstraintViolationException;
import com.inerxia.saletrackingapi.exception.DataNotFoundException;
import com.inerxia.saletrackingapi.exception.ObjectNoEncontradoException;
import com.inerxia.saletrackingapi.model.ProviderProductRepository;
import com.inerxia.saletrackingapi.model.ProviderProducts;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ProviderProductService {

    private ProviderProductRepository providerProductRepository;

    public ProviderProductService(ProviderProductRepository providerProductRepository) {
        this.providerProductRepository = providerProductRepository;
    }

    public ProviderProducts createProviderProducts(ProviderProducts providerProducts){
        if(Objects.nonNull(providerProducts.getId())){
            Optional<ProviderProducts> servicioOptional = providerProductRepository.findById(providerProducts.getId());
            if(servicioOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.providerProducts");
            }
        }
        return providerProductRepository.save(providerProducts);
    }

    public ProviderProducts editProviderProducts(ProviderProducts providerProducts){
        if(Objects.isNull(providerProducts.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        ProviderProducts providerProductsTx = providerProductRepository
                .findById(providerProducts.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.providerProducts"));


        try{
            providerProductsTx.setProviderId(providerProducts.getProviderId());
            providerProductsTx.setProductId(providerProducts.getProductId());
            providerProductsTx.setNetPrice(providerProducts.getNetPrice());
            providerProductsTx.setSellPrice(providerProducts.getSellPrice());
            providerProductsTx.setTimestamp(providerProducts.getTimestamp());
            return providerProductsTx;
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.providerProducts");
        }
    }
}
