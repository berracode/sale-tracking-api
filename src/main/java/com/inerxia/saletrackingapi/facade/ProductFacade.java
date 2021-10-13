package com.inerxia.saletrackingapi.facade;

import com.inerxia.saletrackingapi.dto.ProductDto;
import com.inerxia.saletrackingapi.dto.ProductWrapperDto;
import com.inerxia.saletrackingapi.mapper.ProductMapper;
import com.inerxia.saletrackingapi.model.Product;
import com.inerxia.saletrackingapi.model.Provider;
import com.inerxia.saletrackingapi.model.ProviderProducts;
import com.inerxia.saletrackingapi.service.ProductService;
import com.inerxia.saletrackingapi.service.ProviderProductService;
import com.inerxia.saletrackingapi.service.ProviderService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ProductFacade {
    private ProductMapper productMapper;
    private ProductService productService;

    private ProviderService providerService;
    private ProviderProductService providerProductService;

    public ProductFacade(ProductMapper productMapper, ProductService productService, ProviderService providerService, ProviderProductService providerProductService) {
        this.productMapper = productMapper;
        this.productService = productService;
        this.providerService = providerService;
        this.providerProductService = providerProductService;
    }

    public ProductDto findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return productMapper.toDto(productService.findById(id));
    }

    public List<ProductDto> findAll(){
        return productMapper.toDto(productService.findAll());
    }

    public ProductWrapperDto createProduct(ProductWrapperDto productWrapperDto){
        Provider provider = providerService.findById(productWrapperDto.getProviderId());
        Product product = new Product();
        product.setCode(productWrapperDto.getCode());
        product.setName(productWrapperDto.getName());
        product.setStock(productWrapperDto.getStock());

        product= productService.createProduct(product);

        ProviderProducts providerProducts = new ProviderProducts();
        providerProducts.setProductId(product.getId());
        providerProducts.setProviderId(provider.getId());
        providerProducts.setProductFk(product);
        providerProducts.setProviderFk(provider);
        providerProducts.setNetPrice(productWrapperDto.getNetPrice());
        providerProducts.setSellPrice(productWrapperDto.getSellPrice());
        providerProducts.setTimestamp(productWrapperDto.getTimestamp());

       providerProducts = providerProductService.createProviderProducts(providerProducts);


        return productWrapperDto;

    }

    public List<ProductWrapperDto> findByName(String name){

        return productService.findByName(name);

    }


}
