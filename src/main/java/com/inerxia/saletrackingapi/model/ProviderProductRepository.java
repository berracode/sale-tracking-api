package com.inerxia.saletrackingapi.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderProductRepository extends JpaRepository<ProviderProducts, Integer> {

    Optional<ProviderProducts> findByProviderIdAndProductId(Integer providerId, Integer productId);



}
