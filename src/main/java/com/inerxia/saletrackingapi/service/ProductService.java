package com.inerxia.saletrackingapi.service;

import com.inerxia.saletrackingapi.exception.DataNotFoundException;
import com.inerxia.saletrackingapi.model.Product;
import com.inerxia.saletrackingapi.model.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> findAll(){
        List<Product> salonList = productRepository.findAll();
        if (salonList.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.salon");
        }
        return salonList;
    }

}
