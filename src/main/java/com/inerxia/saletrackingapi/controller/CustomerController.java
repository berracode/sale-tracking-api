package com.inerxia.saletrackingapi.controller;

import com.inerxia.saletrackingapi.dto.CustomerDto;
import com.inerxia.saletrackingapi.dto.ProviderDto;
import com.inerxia.saletrackingapi.facade.CustomerFacade;
import com.inerxia.saletrackingapi.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerFacade customerFacade;

    public CustomerController(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }


    @GetMapping({"/get-by-name"})
    @ApiOperation(value = "Find customer by name", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<CustomerDto>>> findByName(
            @RequestParam(name = "name",defaultValue = "",required = false) String name){

        List<CustomerDto> customerDtoList = customerFacade.findByName(name);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                customerDtoList));
    }
}
