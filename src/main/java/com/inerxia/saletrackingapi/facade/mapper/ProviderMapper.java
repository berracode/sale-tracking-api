package com.inerxia.saletrackingapi.facade.mapper;

import com.inerxia.saletrackingapi.facade.dto.ProductDto;
import com.inerxia.saletrackingapi.facade.dto.ProviderDto;
import com.inerxia.saletrackingapi.model.Product;
import com.inerxia.saletrackingapi.model.Provider;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProviderMapper extends EntityMapper<ProviderDto, Provider>{
}
