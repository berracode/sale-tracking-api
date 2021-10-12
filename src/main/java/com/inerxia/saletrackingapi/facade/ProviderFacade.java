package com.inerxia.saletrackingapi.facade;


import com.inerxia.saletrackingapi.dto.ProviderDto;
import com.inerxia.saletrackingapi.facade.mapper.ProviderMapper;
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

    public List<ProviderDto> findAll(){
        return providerMapper.toDto(providerService.findAll());
    }

    public ProviderDto createProvider(ProviderDto providerDto){
        return providerMapper.toDto(providerService.createProvider(providerMapper.toEntity(providerDto)));
    }

    public ProviderDto editProvider(ProviderDto providerDto){
        return providerMapper.toDto(providerService.editProvider(providerMapper.toEntity(providerDto)));
    }




}
