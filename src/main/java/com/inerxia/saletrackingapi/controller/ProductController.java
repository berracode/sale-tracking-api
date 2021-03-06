package com.inerxia.saletrackingapi.controller;

import com.inerxia.saletrackingapi.dto.ProductDto;
import com.inerxia.saletrackingapi.dto.ProductWrapperDto;
import com.inerxia.saletrackingapi.facade.ProductFacade;
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
    @ApiOperation(value = "Obtener todos", response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<ProductDto>>> findAll(){

        List<ProductDto> productDtoList = productFacade.findAll();
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                productDtoList));
    }

    @PostMapping
    @ApiOperation(value = "Save product", response = ProductWrapperDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProductWrapperDto>> createProduct(
            @Valid @RequestBody ProductWrapperDto productWrapperDto){
        ProductWrapperDto productDto1 = productFacade.createProduct(productWrapperDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                "product.create.ok",
                productDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edit product", response = ProductWrapperDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProductWrapperDto>> editProduct(
            @Valid @RequestBody ProductWrapperDto productWrapperDto){
        ProductWrapperDto productDto1 = productFacade.editProduct(productWrapperDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                "product.create.ok",
                productDto1));
    }

    @GetMapping({"/get-by-name"})
    @ApiOperation(value = "Find products by name", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<ProductWrapperDto>>> findByName(
            @RequestParam(name = "name",defaultValue = "",required = false) String name){

        List<ProductWrapperDto> productWrapperDtos = productFacade.findByName(name);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                productWrapperDtos));
    }


    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete product by id", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<String>> deleteProduct(
            @RequestParam(name = "productId")  Integer productId){

        productFacade.deleteProduct(productId);
        return ResponseEntity.accepted().body(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,"delete.product.ok"));

    }



}
