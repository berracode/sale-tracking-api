package com.inerxia.saletrackingapi.service;

import com.inerxia.saletrackingapi.exception.DataNotFoundException;
import com.inerxia.saletrackingapi.model.ProviderProductRepository;
import com.inerxia.saletrackingapi.model.ProviderProducts;
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
                throw new DataNotFoundException("exception.data_duplicated.servicio");
            }
        }
        return providerProductRepository.save(providerProducts);
    }
}
