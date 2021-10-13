package com.inerxia.saletrackingapi.mapper;

import com.inerxia.saletrackingapi.dto.ProductDto;
import com.inerxia.saletrackingapi.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDto, Product>{
}
