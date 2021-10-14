package com.inerxia.saletrackingapi.service;

import com.inerxia.saletrackingapi.dto.ProductWrapperDto;
import com.inerxia.saletrackingapi.exception.DataConstraintViolationException;
import com.inerxia.saletrackingapi.exception.DataNotFoundException;
import com.inerxia.saletrackingapi.exception.ObjectNoEncontradoException;
import com.inerxia.saletrackingapi.model.Product;
import com.inerxia.saletrackingapi.model.Provider;
import com.inerxia.saletrackingapi.model.ProviderRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ProviderService {

    private ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository){
        this.providerRepository=providerRepository;
    }

    public Provider createProvider(Provider provider){
        if(Objects.nonNull(provider.getId())){
            Optional<Provider> providerOptional = providerRepository.findById(provider.getId());
            if(providerOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.provider");
            }
        }

        try {
            return providerRepository.save(provider);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.provider");
        }
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

    public List<Provider> findByName(String name){
        if(Objects.isNull(name)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        List<Provider> providerList = providerRepository.findByName(name);

        return providerList;
    }

    public Provider editProvider(Provider provider){
        if(Objects.isNull(provider.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        Provider providerTx = providerRepository.findById(provider.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.provider"));

        providerTx.setName(provider.getName());
        providerTx.setAddress(provider.getAddress());
        providerTx.setPhone(provider.getPhone());
        providerTx.setNit(provider.getNit());

        return providerTx;
    }

    public void deleteProvider(Integer id){
        if(Objects.nonNull(id)){
            Optional<Provider> providerOptional = providerRepository.findById(id);
            if(!providerOptional.isPresent()){
                throw new DataNotFoundException("exception.data_not_found.provider");
            }
        }

        providerRepository.deleteById(id);

    }

}
