package com.inerxia.saletrackingapi.facade;

import com.inerxia.saletrackingapi.mapper.CustomerMapper;
import com.inerxia.saletrackingapi.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerFacade {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerFacade(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }
}
