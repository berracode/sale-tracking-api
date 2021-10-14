package com.inerxia.saletrackingapi.model;

import com.inerxia.saletrackingapi.dto.ProductWrapperDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT new com.inerxia.saletrackingapi.dto.ProductWrapperDto(p.id, p.name, p.code,  p.stock, pp.providerId," +
            "p2.name,pp.netPrice,pp.sellPrice, pp.timestamp) FROM Product p " +
            "LEFT JOIN ProviderProducts pp on p.id = pp.productId " +
            "LEFT JOIN Provider p2 on pp.providerId=p2.id " +
            "WHERE p.name LIKE %:name%")
    List<ProductWrapperDto>  findByName(@Param("name") String name);




}
