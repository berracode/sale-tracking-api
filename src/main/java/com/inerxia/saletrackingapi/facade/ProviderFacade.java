package com.inerxia.saletrackingapi.facade;

import com.inerxia.saletrackingapi.facade.dto.ProductDto;
import com.inerxia.saletrackingapi.facade.dto.ProductWrapperDto;
import com.inerxia.saletrackingapi.facade.dto.ProviderDto;
import com.inerxia.saletrackingapi.facade.mapper.ProductMapper;
import com.inerxia.saletrackingapi.facade.mapper.ProviderMapper;
import com.inerxia.saletrackingapi.service.ProductService;
import com.inerxia.saletrackingapi.service.ProviderService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ProviderFacade {
    private ProviderMapper providerMapper;
    private ProviderService providerService;

    public ProviderFacade(ProviderMapper providerMapper, ProviderService providerService) {
        this.providerMapper = providerMapper;
        this.providerService = providerService;
    }

    public ProviderDto findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return providerMapper.toDto(providerService.findById(id));
    }

    public List<ProductDto> findAll(){
        return null;//providerMapper.toDto(providerService.findAll());
    }




}
