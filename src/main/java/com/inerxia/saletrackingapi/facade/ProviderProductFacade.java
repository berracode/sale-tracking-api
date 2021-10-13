package com.inerxia.saletrackingapi.facade;

import com.inerxia.saletrackingapi.dto.ProviderProductsDto;
import com.inerxia.saletrackingapi.mapper.ProviderProductMapper;
import com.inerxia.saletrackingapi.service.ProviderProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProviderProductFacade {

    private ProviderProductMapper providerProductMapper;
    private ProviderProductService providerProductService;



    public ProviderProductFacade(ProviderProductMapper providerProductMapper, ProviderProductService providerProductService) {
        this.providerProductMapper = providerProductMapper;
        this.providerProductService = providerProductService;
    }

    public ProviderProductsDto createProviderProduct(ProviderProductsDto providerProductsDto){

        return providerProductMapper.toDto(providerProductService
                .createProviderProducts(providerProductMapper.toEntity(providerProductsDto)));
    }


}
