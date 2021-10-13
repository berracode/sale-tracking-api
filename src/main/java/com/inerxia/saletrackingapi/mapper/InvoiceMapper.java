package com.inerxia.saletrackingapi.mapper;

import com.inerxia.saletrackingapi.dto.InvoiceDto;
import com.inerxia.saletrackingapi.model.Invoice;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {CustomerMapper.class, EmployeeMapper.class})
public interface InvoiceMapper extends EntityMapper<InvoiceDto, Invoice>{
}
