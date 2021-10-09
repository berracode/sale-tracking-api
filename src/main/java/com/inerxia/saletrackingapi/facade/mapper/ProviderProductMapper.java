package com.inerxia.saletrackingapi.facade.mapper;

import com.inerxia.saletrackingapi.facade.dto.ProviderDto;
import com.inerxia.saletrackingapi.facade.dto.ProviderProductsDto;
import com.inerxia.saletrackingapi.model.Provider;
import com.inerxia.saletrackingapi.model.ProviderProducts;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProviderProductMapper extends EntityMapper<ProviderProductsDto, ProviderProducts>{
}
