package com.grisham.repository;

import com.grisham.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Optional<Product> findByUniqueId(UUID uniqueId);
    public void deleteByUniqueId(UUID uniqueId);
}
