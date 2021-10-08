package com.inerxia.saletrackingapi.controller;

import com.inerxia.saletrackingapi.facade.ProductFacade;
import com.inerxia.saletrackingapi.facade.dto.ProductDto;
import com.inerxia.saletrackingapi.model.Product;
import com.inerxia.saletrackingapi.service.ProductService;
import com.inerxia.saletrackingapi.util.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductFacade productFacade;

    public ProductController(ProductFacade productFacade){
        this.productFacade=productFacade;
    }

    @GetMapping("/get-all")
    public ResponseEntity<StandardResponse<List<ProductDto>>> findAll(){
        ProductDto productDto = new ProductDto();

        List<ProductDto> productDtoList = productFacade.findAll();
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                productDtoList));
    }
}
