package com.grisham.service;

import com.grisham.dto.ProductDto;
import com.grisham.entity.Product;
import com.grisham.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

   @CachePut(value = "PRODUCT_CACHE", key = "#result.uniqueId")
    public ProductDto createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setProductType(productDto.getProductType());
        product.setActive(productDto.getActive());
        product.setSpecification(productDto.getSpecification());
        product.setManufacturer(productDto.getManufacturer());

        Product saved = productRepository.save(product);
        return new ProductDto(saved.getProductName(),saved.getProductCode(),
                        saved.getPrice(),saved.getActive(),saved.getProductType(),
                        saved.getSpecification(),saved.getManufacturer(),saved.getUniqueId());
    }

    @Cacheable(value = "PRODUCT_CACHE", key = "#uniqueId", unless = "#result == null")
    public ProductDto getProduct(UUID uniqueId) {
        Product product = productRepository.findByUniqueId(uniqueId)
                .orElseThrow(() -> new IllegalArgumentException("No product with unique id " + uniqueId));
        return new ProductDto(product.getProductName(),product.getProductCode(),
                product.getPrice(),product.getActive(),product.getProductType(),
                product.getSpecification(),product.getManufacturer(),product.getUniqueId());
    }

    @CachePut(value = "PRODUCT_CACHE", key = "#result.uniqueId")
    public ProductDto updateProduct(ProductDto productDto) {

        Product product = productRepository.findByUniqueId(productDto.getUniqueId())
                .orElseThrow(() -> new IllegalArgumentException("No product with unique id " + productDto.getUniqueId()));

        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setProductType(productDto.getProductType());
        product.setActive(productDto.getActive());
        product.setSpecification(productDto.getSpecification());
        product.setManufacturer(productDto.getManufacturer());

        Product updated = productRepository.save(product);
        return new ProductDto(updated.getProductName(),updated.getProductCode(),
                updated.getPrice(),updated.getActive(),updated.getProductType(),
                updated.getSpecification(),updated.getManufacturer(),updated.getUniqueId());
    }

    @CacheEvict(value = "PRODUCT_CACHE", key = "#uniqueId")
    public void deleteProduct(UUID uniqueId) {
        productRepository.deleteByUniqueId(uniqueId);
    }
}
