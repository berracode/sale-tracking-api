package com.inerxia.saletrackingapi.service;

import com.inerxia.saletrackingapi.exception.DataNotFoundException;
import com.inerxia.saletrackingapi.model.Product;
import com.inerxia.saletrackingapi.model.ProductRepository;
import com.inerxia.saletrackingapi.model.Provider;
import com.inerxia.saletrackingapi.model.ProviderRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ProviderService {

    private ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository){
        this.providerRepository=providerRepository;
    }

    public List<Provider> findAll(){
        List<Provider> providers = providerRepository.findAll();
        if (providers.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.provider");
        }
        return providers;
    }

    public Provider findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return providerRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.provider"));
    }

}
