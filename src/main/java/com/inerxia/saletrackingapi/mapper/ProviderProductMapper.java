package com.inerxia.saletrackingapi.mapper;

import com.inerxia.saletrackingapi.dto.ProviderProductsDto;
import com.inerxia.saletrackingapi.model.ProviderProducts;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProviderMapper.class,ProductMapper.class})
public interface ProviderProductMapper extends EntityMapper<ProviderProductsDto, ProviderProducts>{
}
