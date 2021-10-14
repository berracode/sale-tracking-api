package com.inerxia.saletrackingapi.controller;

import com.inerxia.saletrackingapi.dto.InvoiceWrapperDto;
import com.inerxia.saletrackingapi.facade.InvoiceFacade;
import com.inerxia.saletrackingapi.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    private final InvoiceFacade invoiceFacade;

    public InvoiceController(InvoiceFacade invoiceFacade) {
        this.invoiceFacade = invoiceFacade;
    }

    @PostMapping
    @ApiOperation(value = "Save invoice", response = InvoiceWrapperDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<InvoiceWrapperDto>> createInvoice(
            @Valid @RequestBody InvoiceWrapperDto invoiceWrapperDto){
        InvoiceWrapperDto invoiceWrapperDto1 = invoiceFacade.createInvoice(invoiceWrapperDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                "invoice.create.ok",
                invoiceWrapperDto1));
    }
}
