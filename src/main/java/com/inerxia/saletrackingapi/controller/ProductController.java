package com.inerxia.saletrackingapi.controller;

import com.inerxia.saletrackingapi.facade.ProductFacade;
import com.inerxia.saletrackingapi.facade.dto.ProductDto;
import com.inerxia.saletrackingapi.facade.dto.ProductWrapperDto;
import com.inerxia.saletrackingapi.model.Product;
import com.inerxia.saletrackingapi.service.ProductService;
import com.inerxia.saletrackingapi.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    @ApiOperation(value = "Crea un producto", response = ProductWrapperDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProductWrapperDto>> createProduct(
            @Valid @RequestBody ProductWrapperDto productDto){
        ProductWrapperDto productDto1 = productFacade.createProduct(productDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "product.create.ok",
                productDto1));
    }
}
