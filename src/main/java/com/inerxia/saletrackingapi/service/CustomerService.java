package com.inerxia.saletrackingapi.service;

import com.inerxia.saletrackingapi.dto.ProductWrapperDto;
import com.inerxia.saletrackingapi.exception.ObjectNoEncontradoException;
import com.inerxia.saletrackingapi.model.Customer;
import com.inerxia.saletrackingapi.model.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findByName(String name){
        if(Objects.isNull(name)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        List<Customer> customerList = customerRepository.findByName(name);

        return customerList;
    }
}
