package com.inerxia.saletrackingapi.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {

    @Query("SELECT p FROM Provider p WHERE p.name LIKE %:name%")
    List<Provider> findByName(@Param("name") String name);

}
