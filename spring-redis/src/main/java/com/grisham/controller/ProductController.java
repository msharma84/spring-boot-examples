package com.grisham.controller;

import com.grisham.dto.ProductDto;
import com.grisham.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto){
        ProductDto product = productService.createProduct(productDto);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{uniqueId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("uniqueId") String uniqueId){
        ProductDto product = productService.getProduct((UUID.fromString(uniqueId)));
        return ResponseEntity.ok(product);
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto){
        ProductDto product = productService.updateProduct(productDto);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{uniqueId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("uniqueId") UUID uniqueId){
        productService.deleteProduct(uniqueId);
        return ResponseEntity.ok("Product Deleted successfully");
    }
}
