package com.inerxia.saletrackingapi.mapper;

import com.inerxia.saletrackingapi.dto.InvoiceProductsDto;
import com.inerxia.saletrackingapi.model.InvoiceProducts;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {ProductMapper.class, InvoiceMapper.class})
public interface InvoiceProductsMapper extends EntityMapper<InvoiceProductsDto, InvoiceProducts>{
}
