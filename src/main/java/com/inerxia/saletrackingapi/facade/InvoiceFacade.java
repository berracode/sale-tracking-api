package com.inerxia.saletrackingapi.facade;

import com.inerxia.saletrackingapi.dto.InvoiceDto;
import com.inerxia.saletrackingapi.dto.InvoiceProductsDto;
import com.inerxia.saletrackingapi.dto.InvoiceProductsWrapperDto;
import com.inerxia.saletrackingapi.dto.InvoiceWrapperDto;
import com.inerxia.saletrackingapi.mapper.InvoiceMapper;
import com.inerxia.saletrackingapi.mapper.InvoiceProductsMapper;
import com.inerxia.saletrackingapi.mapper.ProductMapper;
import com.inerxia.saletrackingapi.service.InvoiceProductsService;
import com.inerxia.saletrackingapi.service.InvoiceService;
import com.inerxia.saletrackingapi.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InvoiceFacade {
    private final InvoiceService invoiceService;
    private final InvoiceMapper invoiceMapper;

    private final ProductService productService;
    private final ProductMapper productMapper;

    private final InvoiceProductsService invoiceProductsService;
    private final InvoiceProductsMapper invoiceProductsMapper;

    public InvoiceFacade(InvoiceService invoiceService, InvoiceMapper invoiceMapper, ProductService productService, ProductMapper productMapper, InvoiceProductsService invoiceProductsService, InvoiceProductsMapper invoiceProductsMapper) {
        this.invoiceService = invoiceService;
        this.invoiceMapper = invoiceMapper;
        this.productService = productService;
        this.productMapper = productMapper;
        this.invoiceProductsService = invoiceProductsService;
        this.invoiceProductsMapper = invoiceProductsMapper;
    }

    private void validatedProducts(List<InvoiceProductsWrapperDto> invoiceProductsDtoList){

        for (InvoiceProductsWrapperDto invoiceProductsWrapperDto:invoiceProductsDtoList) {
            productService.findById(invoiceProductsWrapperDto.getProductId());
        }

    }

    public InvoiceWrapperDto createInvoice(InvoiceWrapperDto invoiceWrapperDto){
        validatedProducts(invoiceWrapperDto.getInvoiceProductsWrapperDtoList());

        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setCustomerId(invoiceWrapperDto.getCustomerId());
        invoiceDto.setEmployeeId(invoiceWrapperDto.getEmployeeId());
        invoiceDto.setTax(invoiceWrapperDto.getTax());
        invoiceDto.setSubtotal(invoiceWrapperDto.getSubtotal());
        invoiceDto.setTotal(invoiceWrapperDto.getTotal());
        invoiceDto.setTimestamp(invoiceWrapperDto.getLocalDateTimeInvoice());

        invoiceDto = invoiceMapper.toDto(invoiceService.createInvoice(invoiceMapper.toEntity(invoiceDto)));
        invoiceWrapperDto.setInvoiceId(invoiceDto.getId());
        System.out.println("invoice id: "+invoiceDto.getId());

        InvoiceProductsDto invoiceProductsDto = new InvoiceProductsDto();
        List<InvoiceProductsWrapperDto> invoiceProductsWrapperDtoList = new ArrayList<>();

        invoiceProductsDto.setInvoiceId(invoiceDto.getId());
        for (InvoiceProductsWrapperDto invoiceProductsWrapperDto:invoiceWrapperDto.getInvoiceProductsWrapperDtoList()) {
            invoiceProductsDto.setProductId(invoiceProductsWrapperDto.getProductId());
            invoiceProductsDto.setQuantity(invoiceProductsWrapperDto.getQuantity());
            invoiceProductsDto.setSellPrice(invoiceProductsWrapperDto.getSellPrice());
            invoiceProductsDto.setTimestamp(invoiceProductsWrapperDto.getTimestamp());

            invoiceProductsDto = invoiceProductsMapper.toDto(invoiceProductsService.createInvoiceProducts(invoiceProductsMapper.toEntity(invoiceProductsDto)));
            System.out.println("invoiceProductsDto :::"+invoiceProductsDto.getInvoiceId()+" / "+invoiceProductsDto.getId());

            invoiceProductsWrapperDto.setId(invoiceProductsDto.getId());
            invoiceProductsDto.setId(0);
            invoiceProductsWrapperDtoList.add(invoiceProductsWrapperDto);
        }
        invoiceWrapperDto.setInvoiceProductsWrapperDtoList(invoiceProductsWrapperDtoList);

        return invoiceWrapperDto;

    }


}
