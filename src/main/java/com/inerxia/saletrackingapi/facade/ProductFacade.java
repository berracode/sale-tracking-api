package com.inerxia.saletrackingapi.facade;

import com.inerxia.saletrackingapi.facade.dto.ProductDto;
import com.inerxia.saletrackingapi.facade.mapper.ProductMapper;
import com.inerxia.saletrackingapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductFacade {
    private ProductMapper productMapper;
    private ProductService productService;

    public ProductFacade(ProductMapper productMapper, ProductService productService){
        this.productMapper = productMapper;
        this.productService = productService;

    }

    public List<ProductDto> findAll(){
        return productMapper.toDto(productService.findAll());
    }
}
