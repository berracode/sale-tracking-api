package com.inerxia.saletrackingapi.service;

import com.inerxia.saletrackingapi.dto.ProductWrapperDto;
import com.inerxia.saletrackingapi.exception.DataConstraintViolationException;
import com.inerxia.saletrackingapi.exception.DataNotFoundException;
import com.inerxia.saletrackingapi.exception.ObjectNoEncontradoException;
import com.inerxia.saletrackingapi.model.Product;
import com.inerxia.saletrackingapi.model.ProductRepository;
import com.inerxia.saletrackingapi.model.Provider;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public Product findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return  productRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.product"));
    }

    public List<ProductWrapperDto> findByName(String name){
        if(Objects.isNull(name)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        System.out.println("name: "+name);
        List<ProductWrapperDto> productList = productRepository.findByName(name);
        
        return productList;
    }


    public List<Product> findAll(){
        List<Product> salonList = productRepository.findAll();
        if (salonList.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.product");
        }
        return salonList;
    }

    public Product createProduct(Product product){
        if(Objects.nonNull(product.getId())){
            Optional<Product> productOptional = productRepository.findById(product.getId());
            if(productOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.product");
            }
        }

        try {
            return productRepository.save(product);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.product");
        }
    }

    public Product editProduct(Product product){
        if(Objects.isNull(product.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        Product productTx = productRepository.findById(product.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.product"));
        productTx.setCode(product.getCode());
        productTx.setName(product.getName());
        productTx.setStock(product.getStock());

        return productTx;
    }


}
