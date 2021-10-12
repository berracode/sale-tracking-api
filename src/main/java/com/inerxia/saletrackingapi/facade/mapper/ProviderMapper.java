package com.inerxia.saletrackingapi.facade.mapper;

import com.inerxia.saletrackingapi.dto.ProviderDto;
import com.inerxia.saletrackingapi.model.Provider;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProviderMapper extends EntityMapper<ProviderDto, Provider>{
}
